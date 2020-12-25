package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ProgressDetailMapper;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.ProgressNameModel;
import org.tonzoc.model.support.ProgressStatModel;
import org.tonzoc.service.IProgressDetailService;
import org.tonzoc.service.IProgressNameService;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service("progressDetailService")
public class ProgressDetailService extends BaseService<ProgressDetailModel> implements IProgressDetailService {
    @Autowired
    private IProgressNameService progressNameService;
    @Autowired
    private ProgressDetailMapper progressDetailMapper;


    public List<ProgressDetailModel> listByTender(String tenderGuid,String date,String progressNameGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
        sqlQueryParams.add(new SqlQueryParam("date", date, "eq"));
        sqlQueryParams.add(new SqlQueryParam("progressNameGuid", progressNameGuid, "eq"));

        List<ProgressDetailModel> list = this.list(sqlQueryParams);
        return list;
    }
    //获取当前年月
    public String getMonth(){
        Calendar calendar = Calendar.getInstance();
        java.util.Date todayDate = calendar.getTime();
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        //本月
        String date = df.format(todayDate);
        return date;
    }

    public List<ProgressStatModel> statCurrentMonth(String tender,String date){
        /**
         * create by: fang
         * description:分成A、B标分别统计本月累计完成量
         * create time: 13:38 2020-12-24
         * 
          * @Param: 
         * @return List<ProgressStatModel>
         */
        List<ProgressStatModel> list = new ArrayList<>();
        if (date==null||date.isEmpty()){
            date = getMonth();
        }

        //1、查询所有名称
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<ProgressNameModel> progressNameModels = progressNameService.list(sqlQueryParams);
        progressNameModels=progressNameModels.stream().sorted(Comparator.comparing(ProgressNameModel::getSortId)).collect(Collectors.toList());
        for (ProgressNameModel progressNameModel:progressNameModels){
            ArrayList<String> dates = new ArrayList<String>();
            dates.add(date);
            List<ProgressDetailModel> progressDetailModelList = progressDetailMapper.listByProgressNameAndDate(tender,date,progressNameModel.getGuid());
            BigDecimal cumulantNum = progressDetailModelList
                    .stream()
                    .map(ProgressDetailModel::getNum)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal currentMonthNum = progressDetailModelList
                    .stream()
                    .filter((ProgressDetailModel p)->dates.contains(p.getDate()))
                    .map(ProgressDetailModel::getNum)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.println(progressNameModel.getName());
            System.out.println(date);
            System.out.println(cumulantNum);
            System.out.println(currentMonthNum);
            System.out.println(progressNameModel.getTotalNum());
            BigDecimal currentMonthPercent;
            BigDecimal cumulantPercent;
            if (currentMonthNum.compareTo(BigDecimal.ZERO)==0){
                currentMonthPercent=BigDecimal.ZERO;
            }else {
                currentMonthPercent = currentMonthNum.multiply(BigDecimal.valueOf(100)).divide(progressNameModel.getTotalNum(), 2, BigDecimal.ROUND_HALF_UP);

            }
            if (cumulantNum.compareTo(BigDecimal.ZERO)==0){
                cumulantPercent=BigDecimal.ZERO;
            }else {
                cumulantPercent = cumulantNum.multiply(BigDecimal.valueOf(100)).divide(progressNameModel.getTotalNum(), 2, BigDecimal.ROUND_HALF_UP);
            }

            ProgressStatModel progressStatModel = new ProgressStatModel();
            progressStatModel.setProgressNameGuid(progressNameModel.getGuid());
            progressStatModel.setProgressName(progressNameModel.getName());
            progressStatModel.setCurrentMonth(currentMonthPercent.toString());
            progressStatModel.setCumulant(cumulantPercent.toString());
            progressStatModel.setTotal("100.00");
            list.add(progressStatModel);
        }
        return list;

    }
}
