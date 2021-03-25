package org.tonzoc.service.impl;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.ApprovalHelper;
import org.tonzoc.exception.NotFoundException;
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
    private ApprovalHelper approvalHelper;



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

    public List<ProgressStatModel> statCurrentMonth(String tender,String date,Integer flag){
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
        String year = date.substring(0,date.indexOf("-"));
        String pastDate = year+"-01-01";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        String day= formatter.format( new Date());

        //1、查询所有名称
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        Integer sign=0;
        if (tender.contains("A")||tender.contains("a")){
            sign=0;
        }if (tender.contains("B")||tender.contains("b")){
            sign=1;
        }
        System.out.println(sign);
        sqlQueryParams.add(new SqlQueryParam("flag", sign.toString(), "eq"));
        List<ProgressNameModel> progressNameModels = progressNameService.list(sqlQueryParams);
        progressNameModels=progressNameModels.stream().sorted(Comparator.comparing(ProgressNameModel::getSortId)).collect(Collectors.toList());
        System.out.println(progressNameModels.toString());
        for (ProgressNameModel progressNameModel:progressNameModels){
            ArrayList<String> dates = new ArrayList<String>();
            dates.add(date);
            List<ProgressDetailModel> progressDetailModelList = new ArrayList<>();
            BigDecimal currentMonthNum=BigDecimal.ZERO;
            BigDecimal cumulantNum=BigDecimal.ZERO;
            if (flag==0){
                //往年
                progressDetailModelList=progressDetailMapper.listByProgressNameLtDate(tender,pastDate,progressNameModel.getGuid());
                cumulantNum=progressDetailModelList
                        .stream()
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本年
                progressDetailModelList=progressDetailMapper.listByProgressNameLteDate(tender,date,progressNameModel.getGuid());
                dates.clear();
                dates.add(year);
                currentMonthNum = progressDetailModelList
                        .stream()
                        .filter((ProgressDetailModel p)->dates.contains(p.getDate()))
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }else if (flag==1) {
                //本年
                progressDetailModelList=progressDetailMapper.listByProgressNameLteDate(tender,date,progressNameModel.getGuid());
                dates.clear();
                dates.add(year);
                cumulantNum = progressDetailModelList
                        .stream()
                        .filter((ProgressDetailModel p)->dates.contains(p.getDate()))
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本月
                dates.clear();
                dates.add(date);
                currentMonthNum = progressDetailModelList
                        .stream()
                        .filter((ProgressDetailModel p)->dates.contains(p.getDate()))
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }else if (flag==2) {
                //本月
                cumulantNum = progressDetailModelList
                        .stream()
                        .filter((ProgressDetailModel p)->dates.contains(p.getDate()))
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
                //本日
                progressDetailModelList=progressDetailMapper.listByCreatedAt(tender,day,progressNameModel.getGuid());
                currentMonthNum = progressDetailModelList
                        .stream()
                        .map(ProgressDetailModel::getNum)
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }

            System.out.println(progressNameModel.getName());
            System.out.println(date);
            System.out.println(cumulantNum);
            System.out.println(currentMonthNum);
            System.out.println(progressNameModel.getName());
            BigDecimal totalNum=progressTotalDataService.listByTenderAndProgressName(tender,progressNameModel.getGuid()).stream()
                    .map(ProgressTotalDataModel::getTotalNum)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
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
//        if (progressDetailModel){
//
//        }
        save(progressDetailModel);
    }

    public void updateStack(ProgressDetailModel progressDetailModel,UserModel userModel) throws Exception {
        ProgressDetailModel oldProgressDetail =get(progressDetailModel.getGuid());
        System.out.println(oldProgressDetail.toString());
        System.out.println(userModel.toString());
        //施工方未提交时，监理不可改；
        // 且管理员可随时能改；
        //施工方提交后，施工方、监理都可改
        //结束审批后，施工方、监理都不可改
        if (!userModel.getTenderManage().equals("*")){
            System.out.println(!oldProgressDetail.getCurrentTenderGuid().contains(userModel.getTenderGuid()));
            if (!userModel.getTenderGuid().equals(oldProgressDetail.getTenderGuid())&&oldProgressDetail.getStatus().equals("unSubmit")){
                throw new NotMatchException("该数据未被提交，无法修改");
            }
            if(oldProgressDetail.getStatus().equals("finish")){
                throw new NotMatchException("该数据已结束审批，无法修改");
            }
        }

        update(progressDetailModel);
    }

    public void removeStack(String guid,UserModel userModel) throws Exception{
        ProgressDetailModel oldProgressDetail =get(guid);
        if (!userModel.getTenderManage().equals("*")){
            if (!userModel.getTenderGuid().equals(oldProgressDetail.getTenderGuid())&&oldProgressDetail.getStatus().equals("unSubmit")){
                throw new NotMatchException("该数据未被提交，无法删除");
            }
            if(oldProgressDetail.getStatus().equals("finish")){
                throw new NotMatchException("该数据已结束审批，无法删除");
            }
        }
        remove(guid);
    }

    public void batchRemoveStack(String guids,UserModel userModel) throws Exception{
        if (guids == null){
            throw new NotFoundException("未删除");
        }
        String[] split = guids.split(",");//以逗号分割
        for (String primaryKey:split){
            removeStack(primaryKey,userModel);
        }
    }


    //提交
    public void submit(String progressGuid){
        ProgressDetailModel progressDetailModel = get(progressGuid);
        String nextTenderGuids = approvalHelper.getNextTender(progressDetailModel.getCurrentTenderGuid());
        progressDetailModel.setStatus("submitted");
        progressDetailModel.setCurrentTenderGuid(nextTenderGuids);
        if (progressDetailModel.getStatus().equals("unSubmitted")){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            progressDetailModel.setApprovalTime(df.format(new Date()));
        }
        update(progressDetailModel);
    }

    //审批
    public void approval(String progressGuid,Integer flag) throws NotMatchException {
        /**
         * create by: fang
         * description:审批
         * create time: 15:50 2021-3-5
         * 
          * @Param: progressGuid
         * @return void
         */

        ProgressDetailModel progressDetailModel = get(progressGuid);
//        if (progressDetailModel.getStatus().equals("finish")){
//            throw new NotMatchException("本条已审批结束");
//        }
        String supervisorGuid = approvalHelper.getNextTender(progressDetailModel.getTenderGuid());
        if (flag==1){
            //修改该条状态为已结束
            progressDetailModel.setStatus("finish");
            progressDetailModel.setCurrentTenderGuid("*");
        }else if (flag==2){
            if (progressDetailModel.getCurrentTenderGuid().equals("*")&&progressDetailModel.getStatus().equals("finish")){
                progressDetailModel.setStatus("submitted");
                progressDetailModel.setCurrentTenderGuid(supervisorGuid);
            }
        }

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        progressDetailModel.setApprovalTime(df.format(new Date()));
        update(progressDetailModel);
    }

    public void batchApproval(String progressGuids,Integer flag) throws Exception {
        String[] split = progressGuids.split(",");//以逗号分割
        for (String primaryKey:split){
            if (flag==0){//提交
                submit(primaryKey);
            }else if (flag==1||flag==2){
                approval(primaryKey,flag);
            }

        }
    }
}
