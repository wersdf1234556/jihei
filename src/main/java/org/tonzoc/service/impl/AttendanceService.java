package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.mapper.AttendanceMapper;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.support.param.SqlQueryParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service(value = "attendanceService")
public class AttendanceService extends BaseService<AttendanceModel> implements IAttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    public List<AttendanceModel> listBySignAndDate(String sign,String createdAt){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", sign, "eq"));
        sqlQueryParams.add(new SqlQueryParam("createdAt", createdAt, "like"));
        List<AttendanceModel> list = this.list(sqlQueryParams);

        return list;
    }

    public void insertStack(AttendanceModel attendanceModel) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format( new Date());
        System.out.println(dateString);
        List<AttendanceModel> list = attendanceMapper.listBySignAndDate(attendanceModel.getIdCard(),dateString);
        System.out.println(list.toString());
        if (list.size()!=0){
            throw new NotOneResultFoundException("今天已经有该人员（"+attendanceModel.getIdCard()+"）的打卡数据了，本次打卡未添加上");
        }
        save(attendanceModel);
    }

}
