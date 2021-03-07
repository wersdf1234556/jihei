package org.tonzoc.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.mapper.ProgressDetailMapper;
import org.tonzoc.mapper.UserMapper;
import org.tonzoc.model.*;
import org.tonzoc.model.support.ProgressStatModel;
import org.tonzoc.service.*;
import org.tonzoc.support.param.SqlQueryParam;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service("progressDetailService")
public class ProgressDetailService extends BaseService<ProgressDetailModel> implements IProgressDetailService {
    @Autowired
    private IProgressNameService progressNameService;
    @Autowired
    private ProgressDetailMapper progressDetailMapper;
    @Autowired
    private IProgressTotalDataService progressTotalDataService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IRedisAuthService redisAuthService;


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
          * @Param: String tender,String date
         * @return List<ProgressStatModel>
         */
        List<ProgressStatModel> list = new ArrayList<>();
        if (date==null||date.isEmpty()){
            date = getMonth();
        }

        //1、查询所有名称
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        Integer flag=0;
        if (tender.contains("A")||tender.contains("a")){
            flag=0;
        }if (tender.contains("B")||tender.contains("b")){
            flag=1;
        }
        System.out.println(flag);
        sqlQueryParams.add(new SqlQueryParam("flag", flag.toString(), "eq"));
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
//            System.out.println(progressNameModel.getName());
//            System.out.println(date);
//            System.out.println(cumulantNum);
//            System.out.println(currentMonthNum);
//            System.out.println(progressNameModel.getTotalNum());
//            System.out.println(progressNameModel.getName());
//            System.out.println(progressTotalDataService.listByTenderAndProgressName(tender,progressNameModel.getGuid()).toString());
            BigDecimal totalNum=progressTotalDataService.listByTenderAndProgressName(tender,progressNameModel.getGuid()).stream()
                    .map(ProgressTotalDataModel::getTotalNum)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            System.out.println(totalNum);
            BigDecimal currentMonthPercent=BigDecimal.ZERO;
            BigDecimal cumulantPercent=BigDecimal.ZERO;
            if (currentMonthNum.compareTo(BigDecimal.ZERO)==0){
                currentMonthPercent=BigDecimal.ZERO;
            }else {
                if (totalNum.compareTo(BigDecimal.ZERO)!=0){
                    currentMonthPercent = currentMonthNum.multiply(BigDecimal.valueOf(100)).divide(totalNum, 2, BigDecimal.ROUND_HALF_UP);
                }
            }
            if (cumulantNum.compareTo(BigDecimal.ZERO)==0){
                cumulantPercent=BigDecimal.ZERO;
            }else {
                if (totalNum.compareTo(BigDecimal.ZERO)!=0){
                    cumulantPercent = cumulantNum.multiply(BigDecimal.valueOf(100)).divide(totalNum, 2, BigDecimal.ROUND_HALF_UP);
                }
            }

            ProgressStatModel progressStatModel = new ProgressStatModel();
            progressStatModel.setProgressNameGuid(progressNameModel.getGuid());
            progressStatModel.setProgressName(progressNameModel.getName());
            progressStatModel.setCurrentMonthNum(currentMonthNum.toString());
            progressStatModel.setCurrentMonthPercent(currentMonthPercent.toString());
            progressStatModel.setCumulantNum(cumulantNum.toString());
            progressStatModel.setCumulantPercent(cumulantPercent.toString());
            progressStatModel.setTotalNum(totalNum.toString());
            progressStatModel.setTotalPercent("100.00");
            list.add(progressStatModel);
        }
        return list;

    }
    public void insertStack(ProgressDetailModel progressDetailModel){
        progressDetailModel.setApprovalTime("");
        progressDetailModel.setCurrentTenderGuid(progressDetailModel.getTenderGuid());
        progressDetailModel.setStatus("unSubmit");
        save(progressDetailModel);
    }

    public void updateStack(ProgressDetailModel progressDetailModel) throws Exception {
        UserModel userModel = redisAuthService.getCurrentUser();
        if (userModel.getTenderGuid().equals(progressDetailModel.getTenderGuid())&&!progressDetailModel.getStatus().equals("unSubmit")){
            throw new NotMatchException("该数据已被本标段，无法修改");
        }
        if (!userModel.getTenderGuid().equals(progressDetailModel.getTenderGuid())&&progressDetailModel.getStatus().equals("unSubmit")){
            throw new NotMatchException("该数据未被提交，无法修改");
        }
        update(progressDetailModel);
    }

    //查询上级标段
    public String getNextTender(String tenderGuid){
        String allNextTenderGuids=null;
        List<String> tenderGuids = userMapper.listByTenderManage(tenderGuid);
        if(tenderGuids.size()!=0) {
            allNextTenderGuids=tenderGuids.toString();
        }
        return allNextTenderGuids;
    }

    public void approval(String progressGuid){
        /**
         * create by: fang
         * description:审批
         * create time: 15:50 2021-3-5
         * 
          * @Param: progressGuid
         * @return void
         */
        ProgressDetailModel progressDetailModel = get(progressGuid);
        String nextTenderGuids = getNextTender(progressDetailModel.getTenderGuid());
        if (!nextTenderGuids.equals("")){
            //修改该条状态为已提交
            progressDetailModel.setStatus("submitted");
            progressDetailModel.setCurrentTenderGuid(nextTenderGuids);
        }else {
            //修改该条状态为已结束
            progressDetailModel.setStatus("finish");
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        progressDetailModel.setApprovalTime(df.format(new Date()));
        update(progressDetailModel);
        //根据管理标段查上级
//        List<UserModel> userModels = userMapper.listByTenderManage(1,progressDetailModel.getTenderGuid());


    }
}
