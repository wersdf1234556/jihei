package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class PersonProvider {

    // 人员打卡次数
    public String attendanceCount(@Param(value = "tenderGuid") String tenderGuid,
                                  @Param(value = "name") String name,
                                  @Param(value = "idCard") String idCard,
                                  @Param(value = "mobile") String mobile,
                                  @Param(value = "personTypeGuid") String personTypeGuid) {

        StringBuilder stringBuilder = new StringBuilder("select * from AttendanceCountView where 1 = 1");

        if (tenderGuid != null && !"".equals(tenderGuid)) {
            stringBuilder.append(" and tenderGuid = '" + tenderGuid + "'");

        }
        if (name != null && !"".equals(name)) {
            stringBuilder.append(" and name like '%" + name + "%'");

        }
        if (idCard != null && !"".equals(idCard)) {
            stringBuilder.append(" and idCard = '" + idCard + "'");

        }
        if (mobile != null && !"".equals(mobile)) {
            stringBuilder.append(" and mobile = '" + mobile + "'");

        }
        if (personTypeGuid != null && !"".equals("personTypeGuid")) {
            stringBuilder.append(" and personTypeGuid = '" + personTypeGuid + "'");

        }

        return stringBuilder.toString();
    }
}
