package org.tonzoc.service;

import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.support.*;

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

    // 预警信息
    List<AttendanceModel> warningInformation();

    // 测温情况
    List<ReturnMachineModel> temperature();

    // 统计超温的测温人数
    List<String> temperatureNumber();

    // 超温的人员
    List<PersonModel> temperaturePerson();
}
