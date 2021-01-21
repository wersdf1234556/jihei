package org.tonzoc.service;

import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.support.AttDateStatModel;
import org.tonzoc.model.support.AttendanceStatModel;

import java.util.List;

public interface IAttendanceService extends IBaseService<AttendanceModel> {

    void insertStack(AttendanceModel attendanceModel) throws Exception;

    List<Object> statAttendanceData(String date, Integer flag);
    List<AttDateStatModel> statByMonth(String date);

    List<AttendanceStatModel> statByTenderType(String date);
}
