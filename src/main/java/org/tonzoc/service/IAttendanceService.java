package org.tonzoc.service;

import org.tonzoc.model.AttendanceModel;

public interface IAttendanceService extends IBaseService<AttendanceModel> {

    void insertStack(AttendanceModel attendanceModel) throws Exception;
}
