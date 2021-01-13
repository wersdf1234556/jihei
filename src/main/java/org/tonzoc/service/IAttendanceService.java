package org.tonzoc.service;

import org.tonzoc.model.AttendanceModel;

import java.util.List;

public interface IAttendanceService extends IBaseService<AttendanceModel> {

    void insertStack(AttendanceModel attendanceModel) throws Exception;

    List<Object> statAttendanceData(String date, Integer flag);
}
