package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.AttArtificialDataMapper;
import org.tonzoc.model.AttArtificialDataModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.support.AttStatTenderModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.model.support.StatTotalModel;
import org.tonzoc.service.IAttArtificialDataService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.service.ITenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service("attArtificialDataService")
public class AttArtificialDataService extends BaseService<AttArtificialDataModel> implements IAttArtificialDataService {

    @Autowired
    private ITenderService tenderService;
    @Autowired
    private IPersonTypeService personTypeService;
    @Autowired
    private AttArtificialDataMapper attArtificialDataMapper;

    public List<AttendanceStatModel> statAllByCategoryGuid(String categoryGuid){
        List<AttendanceStatModel> stats = attArtificialDataMapper.statAtt(categoryGuid);
        return stats;
    }

    @Override
    public StatTotalModel statAll(String categoryGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("categoryGuid",categoryGuid,"eq"));
        List<AttArtificialDataModel> list = this.list(sqlQueryParams);

        Integer total=list.stream().mapToInt(AttArtificialDataModel::getPersonNum).sum();
        Integer attNum=list.stream().mapToInt(AttArtificialDataModel::getAttNum).sum();
        Integer noAttNum = total-attNum;
        Object percent=(float) attNum / total * 100;
        StatTotalModel statTotalModel = new StatTotalModel();
        statTotalModel.setTotal(total.toString());
        statTotalModel.setAttNum(attNum.toString());
        statTotalModel.setNoAttNum(noAttNum.toString());
        statTotalModel.setPercent(percent.toString());
        return statTotalModel;
    }


    //flag=0查询技术工种，flag=1查询管理人员
    public List<Object> statByTender(String categoryGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<TenderModel> tenderModels = tenderService.list(sqlQueryParams).stream().sorted(Comparator.comparing(TenderModel::getSortId)).collect(Collectors.toList());
        List<Object> statModels = new ArrayList<>();
        for (TenderModel tender : tenderModels){
            AttStatTenderModel statModel = new AttStatTenderModel();
            statModel.setTenderGuid(tender.getGuid());
            statModel.setTenderName(tender.getName());
            List<AttendanceStatModel> stats = attArtificialDataMapper.statAttByTender(categoryGuid,tender.getGuid());
            statModel.setStatModels(stats);
            statModels.add(statModel) ;
        }
        return statModels;
    }

    //flag=0查询技术工种,首件认可
//    public List<AttendanceStatModel> statArticle(String tenderName){
//        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//        sqlQueryParams.add(new SqlQueryParam("name", tenderName, "eq"));
//        TenderModel tenderModel = tenderService.list(sqlQueryParams).get(0);
//        List<AttendanceStatModel> stats = attArtificialDataMapper.statAttByTender(0,tenderModel.getGuid());
//        return stats;
//    }

    //添加假数据
    public void insertAllArti(String categoryGuid){
        List<PersonTypeModel> personTypes = personTypeService.listByCategoryGuid(categoryGuid).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//        List<TenderModel> tenderModels = tenderService.list(sqlQueryParams).stream().sorted(Comparator.comparing(TenderModel::getSortId)).collect(Collectors.toList());
//        for (TenderModel tenderModel:tenderModels){
        for (PersonTypeModel typeModel:personTypes){
                sqlQueryParams.add(new SqlQueryParam("personTypeGuid", typeModel.getGuid(), "eq"));
//                sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderModel.getGuid(), "eq"));
                List<AttArtificialDataModel> dataModels = list(sqlQueryParams);
                if (dataModels.size()==0){
                    int t=new java.util.Random().nextInt(10)+1;
//                    if (flag==0){
//                        //5~10之间的随机数
//                        t=(int)(Math.random()*6+5);
//                    }else {
//                        int max=4;
//                        int min=1;
//                        Random random = new Random();
//                        t = random.nextInt(max)%(max-min+1) + min;
//                    }
                    AttArtificialDataModel dataModel = new AttArtificialDataModel();
                    dataModel.setPersonTypeGuid(typeModel.getGuid());
                    dataModel.setTenderGuid("");
                    dataModel.setCategoryGuid(typeModel.getCategoryGuid());
                    dataModel.setAttNum(t);
                    dataModel.setPersonNum(t);
                    save(dataModel);
                }

//            }

        }
    }

    //    public List<AttendanceStatModel> statAll(Integer flag){
//        List<PersonTypeModel> personTypes = personTypeService.listByFlag(flag).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
//        List<Object> statModels = new ArrayList<>();
//        for (PersonTypeModel personTypeModel : personTypes){
//            AttendanceStatModel statModel = new AttendanceStatModel();
//            statModel.setTypeName(personTypeModel.getName());
//            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//            sqlQueryParams.add(new SqlQueryParam("personTypeGuid", personTypeModel.getGuid(), "eq"));
//            Integer sumTotal = list(sqlQueryParams).stream()
//                    .map(AttArtificialDataModel::getPersonNum)
//                    .reduce(0, Integer::sum);
//            Integer sumAtt = list(sqlQueryParams).stream()
//                    .map(AttArtificialDataModel::getAttNum)
//                    .reduce(0, Integer::sum);
//            statModel.setTotal(sumTotal.toString());
//            statModel.setAttNum(sumAtt.toString());
//            statModels.add(statModel);
//        }
//        return stats;
//    }

//    public List<Object> statByTender(Integer flag){
//        List<PersonTypeModel> personTypes = personTypeService.listByFlag(flag).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
//        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//        List<TenderModel> tenderModels = tenderService.list(sqlQueryParams).stream().sorted(Comparator.comparing(TenderModel::getSortId)).collect(Collectors.toList());
//        List<Object> statModels = new ArrayList<>();
//        List<AttendanceStatModel> attendanceStatModels = new ArrayList<>();
//        for (TenderModel tender : tenderModels){
//            AttStatTenderModel statModel = new AttStatTenderModel();
//            statModel.setTenderGuid(tender.getGuid());
//            statModel.setTenderName(tender.getName());
//            statModel.setStatModels(personTypes.stream()
//                            .map(typeModel -> {
//                                    AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
//                                    attendanceStatModel.setTypeName(typeModel.getName());
//                                List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
//                                sqlQueryParams2.add(new SqlQueryParam("tenderGuid", tender.getGuid(), "eq"));
//                                sqlQueryParams2.add(new SqlQueryParam("personTypeGuid", typeModel.getGuid(), "eq"));
//                                List<AttArtificialDataModel> dataModels = list(sqlQueryParams2);
//                                System.out.println(dataModels);
//                                if (dataModels.size()==0){
//                                    System.out.println("进这了");
//                                    attendanceStatModel.setTotal(String.valueOf(0));
//                                    attendanceStatModel.setAttNum(String.valueOf(0));
//                                }else if (dataModels.size()==1){
//                                    attendanceStatModel.setTotal(dataModels.get(0).getPersonNum().toString());
//                                    attendanceStatModel.setAttNum(dataModels.get(0).getAttNum().toString());
//                                }
//                                    return attendanceStatModel;
//                            })
//                            .collect(Collectors.toList()));





//            for (PersonTypeModel typeModel :personTypes){
//                List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
//                sqlQueryParams2.add(new SqlQueryParam("tenderGuid", tender.getGuid(), "eq"));
//                sqlQueryParams2.add(new SqlQueryParam("personTypeGuid", typeModel.getGuid(), "eq"));
//                List<AttArtificialDataModel> dataModels = list(sqlQueryParams2);
//
//                AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
//                attendanceStatModel.setTypeName(typeModel.getName());
//                if (dataModels.size()==0){
//                    attendanceStatModel.setAttNum(String.valueOf(0));
//                    attendanceStatModel.setTotal(String.valueOf(0));
//                    attendanceStatModels.add(attendanceStatModel);
//
//                }else {
//                    attendanceStatModel.setAttNum(dataModels.get(0).getAttNum().toString());
//                    attendanceStatModel.setTotal(dataModels.get(0).getPersonNum().toString());
//                    attendanceStatModels.add(attendanceStatModel);
////                    statModel.setStatModels(dataModels.stream()
////                            .map(dataModel -> {
////                                AttendanceStatModel attendanceStatModel = new AttendanceStatModel();
////                                attendanceStatModel.setTypeName(typeModel.getName());
////                                attendanceStatModel.setTotal(dataModel.getPersonNum().toString());
////                                attendanceStatModel.setAttNum(dataModel.getAttNum().toString());
////
////                                return attendanceStatModel;
////                            })
////                            .collect(Collectors.toList()));
//                }
//                }
//            statModels.add(statModel) ;
//        }
//        return statModels;
//    }
}
