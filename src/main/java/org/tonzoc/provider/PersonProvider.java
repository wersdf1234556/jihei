package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class PersonProvider {

    // 人员打卡次数
    public String attendanceCount(@Param(value = "tenderGuid") String tenderGuid,
                                  @Param(value = "name") String name,
                                  @Param(value = "idCard") String idCard,
                                  @Param(value = "mobile") String mobile) {

        StringBuilder stringBuilder = new StringBuilder("select * from (select tenders.guid tenderGuid, tenders.name tenderName, persons.guid guid, persons.name name, persons.idCard idCard, persons.mobile mobile, isnull(attendances.pcount, 0) as trainNumber from persons" +
                " left join (select personGuid, count(*) as pcount from attendances where CONVERT(varchar(10), attTime, 23) = CONVERT(varchar(10), getdate(), 23) group by personGuid) attendances on persons.guid = attendances.personGuid" +
                " left join tenders on persons.tenderguid = tenders.guid where 1 = 1");

        if (tenderGuid != null && !"".equals(tenderGuid)) {
            stringBuilder.append(" and tenders.tenderGuid = '" + tenderGuid + "'");

        }
        if (name != null && !"".equals(name)) {
            stringBuilder.append(" and persons.name like '%" + name + "%'");

        }
        if (idCard != null && !"".equals(idCard)) {
            stringBuilder.append(" and persons.idCard = '" + idCard + "'");

        }
        if (mobile != null && !"".equals(mobile)) {
            stringBuilder.append(" and persons.mobile = '" + mobile + "'");

        }

        stringBuilder.append(" ) mainTable");

        return stringBuilder.toString();
    }
}
