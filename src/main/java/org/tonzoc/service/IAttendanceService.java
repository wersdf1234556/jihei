package org.tonzoc.service;

import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.support.AttDateStatModel;
import org.tonzoc.model.support.AttendanceStatModel;
import org.tonzoc.model.support.PersonLocationDataModel;
import org.tonzoc.model.support.StatTotalModel;

import java.util.List;

public interface IAttendanceService extends IBaseService<AttendanceModel> {

//    void insertStack(AttendanceModel attendanceModel) throws Exception;

    Integer insertGateData(AttendanceModel attendanceModel);
    List<Object> statAttendanceData(String date, Integer flag);
    List<AttDateStatModel> statByMonth(String date);

    List<AttendanceStatModel> statByTenderType(String date);

    List<PersonLocationDataModel> listPersonLocationDatas(String categoryGuid,String date);

    StatTotalModel statAll(String categoryGuid, String date);
    List<StatTotalModel> statAllCategory(String date);

    List<AttendanceStatModel> statByPersonCategory(String categoryGuid,String date);

    List<AttendanceStatModel> countPersonByCity();
    List<AttendanceStatModel> countByRisk();
    List<AttendanceStatModel> statBySecurity(String date);
}
