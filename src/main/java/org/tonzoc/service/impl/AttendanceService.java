package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.mapper.AttendanceMapper;
import org.tonzoc.mapper.PersonMapper;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.model.TenderModel;
import org.tonzoc.model.support.AttStatTenderModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.service.IPersonService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.service.ITenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "attendanceService")
public class AttendanceService extends BaseService<AttendanceModel> implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private IPersonTypeService personTypeService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private ITenderService tenderService;

    public List<AttendanceModel> listBySignAndDate(String sign,String createdAt){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", sign, "eq"));
        sqlQueryParams.add(new SqlQueryParam("createdAt", createdAt, "dateLike"));
        List<AttendanceModel> list = this.list(sqlQueryParams);

        return list;
    }


    public void insertStack(AttendanceModel attendanceModel) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format( new Date());
        System.out.println(dateString);
        List<AttendanceModel> list = listBySignAndDate(attendanceModel.getIdCard(),dateString);
        System.out.println(list.toString());
        if (list.size()!=0){
            throw new NotOneResultFoundException("今天已经有该人员（"+attendanceModel.getIdCard()+"）的打卡数据了，本次打卡未添加上");
        }
        save(attendanceModel);
    }

    public List<Object> statAttendanceData(String date,Integer flag){
        List<Object> statModels = new ArrayList<>();
        if (flag==0){
            statModels.add(sumAtt(null,date));
        }else if (flag==1){
            List<SqlQueryParam> sqlQueryParams2 = new ArrayList<>();
            List<TenderModel> tenderModels = tenderService.list(sqlQueryParams2).stream().sorted(Comparator.comparing(TenderModel::getSortId)).collect(Collectors.toList());
            for (TenderModel tender : tenderModels){
                AttStatTenderModel statModel = new AttStatTenderModel();
                statModel.setTenderGuid(tender.getGuid());
                statModel.setTenderName(tender.getName());
                statModel.setStatModels(sumAtt(tender.getGuid(),date));
                statModels.add(statModel);
            }
        }
        return statModels;
    }

    public List<AttendanceStatModel> sumAtt(String tenderGuid,String date){
        if (date==null||date.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date= formatter.format( new Date());
        }
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<PersonTypeModel> personTypeModels = personTypeService.list(sqlQueryParams).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());
        List<AttendanceStatModel> statModels = new ArrayList<>();
        for (PersonTypeModel personType :personTypeModels){
            List<SqlQueryParam> sqlQueryParams1 = new ArrayList<>();
            sqlQueryParams1.add(new SqlQueryParam("personTypeGuid", personType.getGuid(), "eq"));
            List<PersonModel> personModels;
            List<AttendanceModel> listByType;
            if (tenderGuid==null){
                //查询所有标段该类型的考勤总数
                listByType = attendanceMapper.listByTypeAndDate(personType.getGuid(),date)
                        .stream().distinct().collect(Collectors.toList());
                personModels = personService.list(sqlQueryParams1);
                AttendanceStatModel statModel = new AttendanceStatModel();
                statModel.setTypeName(personType.getName());
                statModel.setTotal(String.valueOf(personModels.size()));
                statModel.setAttNum(String.valueOf(listByType.size()));
                statModels.add(statModel);
            }else {
                listByType = attendanceMapper.listByTypeAndDate(personType.getGuid(),date)
                        .stream().distinct().filter(s->s.getTenderGuid()==tenderGuid).collect(Collectors.toList());
                sqlQueryParams1.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
                personModels = personService.list(sqlQueryParams1);

                AttendanceStatModel statModel = new AttendanceStatModel();
                statModel.setTypeName(personType.getName());
                statModel.setTotal(String.valueOf(personModels.size()));
                statModel.setAttNum(String.valueOf(listByType.size()));
                statModels.add(statModel);
            }
        }
        return statModels;

    }

}
