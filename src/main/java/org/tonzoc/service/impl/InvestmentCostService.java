package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BuildingSafetyDetailMapper;
import org.tonzoc.mapper.InvestmentCostMapper;
import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.model.BuildingSafetyModel;
import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.InvestmentSituationModel;
import org.tonzoc.model.support.BuildSafetyStatModel;
import org.tonzoc.model.support.CostByTpeModel;
import org.tonzoc.model.support.CostModel;
import org.tonzoc.model.support.TypeModel;
import org.tonzoc.service.IBuildingSafetyDetailService;
import org.tonzoc.service.IBuildingSafetyService;
import org.tonzoc.service.IInvestmentCostService;
import org.tonzoc.service.IInvestmentSituationService;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("investmentCostService")
public class InvestmentCostService extends BaseService<InvestmentCostModel> implements IInvestmentCostService {

    @Autowired
    private IInvestmentSituationService investmentSituationService;
    @Autowired
    private InvestmentCostMapper investmentCostMapper;
    @Autowired
    private IBuildingSafetyService buildingSafetyService;
    @Autowired
    private IBuildingSafetyDetailService buildingSafetyDetailService;
    @Autowired
    private BuildingSafetyDetailMapper detailMapper;


    //进度统计左上角投资总额
    public CostModel statCost(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM");
        String month= formatter.format( new Date());
        System.out.println("mo="+month);
        String year = month.substring(0,month.indexOf("-"));
        System.out.println("ye="+year);
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        //总投资cost
        BigDecimal cost = list(sqlQueryParams).stream()
                .map(InvestmentCostModel::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //累计投资accumulated
        BigDecimal accumulated =investmentSituationService.list(sqlQueryParams).stream()
                .map(InvestmentSituationModel::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sqlQueryParams.add(new SqlQueryParam("date",year,"like"));
        //本年投资currentYearCost
        BigDecimal currentYearCost =investmentSituationService.list(sqlQueryParams).stream()
                .map(InvestmentSituationModel::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
        sqlQueryParams1.add(new SqlQueryParam("date",month,"like"));
        //本月投资ccurrentMonthCost
        BigDecimal currentMonthCost =investmentSituationService.list(sqlQueryParams1).stream()
                .map(InvestmentSituationModel::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        //完成率
        String percent = accumulated.divide(cost, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).toString();
        CostModel costModel = new CostModel(cost.divide(BigDecimal.valueOf(100000000)),accumulated.divide(BigDecimal.valueOf(100000000)),currentYearCost.divide(BigDecimal.valueOf(100000000)),currentMonthCost.divide(BigDecimal.valueOf(100000000)),percent);
        return costModel;
    }

    //左上角饼图各投资项占比
    public List<TypeModel> statByEachItem(){
        List<TypeModel> list = new ArrayList<>();
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<InvestmentCostModel> costModels = list(sqlQueryParams).stream().sorted(Comparator.comparing(InvestmentCostModel::getSortId)).collect(Collectors.toList());
        //总投资cost
        BigDecimal cost = list(sqlQueryParams).stream()
                .map(InvestmentCostModel::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        for (InvestmentCostModel investmentCostModel:costModels){
            TypeModel typeModel = new TypeModel();
            typeModel.setTypeName(investmentCostModel.getName());
            String percent = investmentCostModel.getBalance().divide(cost, 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100)).toString();
            typeModel.setTypeCount(percent);
            list.add(typeModel);
        }
        return list;
    }

    //左边中间各投资项的累计投资比例
    public List<CostByTpeModel> statBySituation(){
        List<CostByTpeModel> list = new ArrayList<>();
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("flag","1","eq"));
        List<InvestmentCostModel> costModels = list(sqlQueryParams);
        for (InvestmentCostModel costModel:costModels){
            if(costModel.getName().contains("建安费")){
                List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
                BigDecimal buildSafety = buildingSafetyDetailService.list(sqlQueryParams1).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                BigDecimal percent = buildSafety.divide(costModel.getBalance(), 2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
                CostByTpeModel costByTpeModel = new CostByTpeModel(costModel.getName(),costModel.getBalance().divide(BigDecimal.valueOf(100000000)).setScale(2, BigDecimal.ROUND_HALF_UP),buildSafety.divide(BigDecimal.valueOf(100000000)).setScale(2, BigDecimal.ROUND_HALF_UP),String.valueOf(percent));
                list.add(costByTpeModel);
            }
        }
        List<CostByTpeModel> costs = investmentCostMapper.statBySituation();
        list.addAll(costs);
        return list;
    }

    //左下角建安费分项统计
    //按总体：往年、今年 flag=0
    //按年度：今年、本月 flag=1
    //按月份：本月、本日 flag=2
    public List<BuildSafetyStatModel> statByBuildSafety(Integer flag){
        List<BuildSafetyStatModel> list = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        String date= formatter.format( new Date());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
        String month=format.format( new Date());
        String year = month.substring(0,month.indexOf("-"));
        String pastDate = year+"-01-01";
        BigDecimal totalBalance=BigDecimal.ZERO;
        BigDecimal situationBalance=BigDecimal.ZERO;
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<BuildingSafetyModel> safetys = buildingSafetyService.list(sqlQueryParams).stream().sorted(Comparator.comparing(BuildingSafetyModel::getSortId)).collect(Collectors.toList());
        for (BuildingSafetyModel buildingSafetyModel:safetys){
            BuildSafetyStatModel buildSafetyStatModel = new BuildSafetyStatModel();
            buildSafetyStatModel.setName(buildingSafetyModel.getName());
            if (flag==0){
                //往年
                totalBalance = buildingSafetyDetailService.listByLtDate(pastDate,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本年
                situationBalance = buildingSafetyDetailService.listByLikeDate(year,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }else if (flag==1){
                //本年
                totalBalance=buildingSafetyDetailService.listByLikeDate(year,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本月
                situationBalance=buildingSafetyDetailService.listByLikeDate(month,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }else if (flag==2){
                //本月
                totalBalance=buildingSafetyDetailService.listByLikeDate(month,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本日
                situationBalance=buildingSafetyDetailService.listByLikeDate(date,buildingSafetyModel.getGuid()).stream()
                        .map(BuildingSafetyDetailModel::getBalance)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }
            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("name",buildingSafetyModel.getName(),"eq"));
            BigDecimal cost= buildingSafetyService.list(sqlQueryParams1).stream()
                    .map(BuildingSafetyModel::getBalance)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            //百分比
            BigDecimal percentOne=BigDecimal.valueOf((float)0.00);
            BigDecimal percentTwo=BigDecimal.valueOf((float)0.00);
            if (cost.compareTo(BigDecimal.ZERO)>0){
                //.setScale(2,BigDecimal.ROUND_HALF_UP)
                percentOne=totalBalance.divide(cost,2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
                percentTwo=situationBalance.divide(cost,2, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(100));
            }
            System.out.println("cost="+cost);
            System.out.println("totalBalance="+totalBalance);
            System.out.println("situationBalance="+situationBalance);
            System.out.println("percentOne="+percentOne);
            System.out.println("percentTwo="+percentTwo);
            //.divide(BigDecimal.valueOf(100000000))
            buildSafetyStatModel.setPercentOne(String.valueOf(percentOne));
            buildSafetyStatModel.setPercentTwo(String.valueOf(percentTwo));
            list.add(buildSafetyStatModel);
        }
        return list;



    }

    //右侧按标段统计总产值和累计产值
    public List<CostByTpeModel> statByTender(){
        List<CostByTpeModel> statByTender = detailMapper.statByTender();
        return statByTender;
    }
}
