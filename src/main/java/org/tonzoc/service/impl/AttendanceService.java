package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.mapper.AttendanceMapper;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "attendanceService")
public class AttendanceService extends BaseService<AttendanceModel> implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;
    @Autowired
    private IPersonTypeService personTypeService;

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

    public List<Object> statAttendanceData(String date){
        if (date==null||date.isEmpty()){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date= formatter.format( new Date());
        }
        Page page = PageHelper.startPage(1, 0, "sortId asc");
        page.setOrderByOnly(true);
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<PersonTypeModel> personTypeModels = personTypeService.list(sqlQueryParams);
        for (PersonTypeModel personType :personTypeModels){

        }
        return null;

    }

}
