package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class PersonProvider {

    // 人员打卡次数
    public String attendanceCount(@Param(value = "tenderGuid") String tenderGuid,
                                  @Param(value = "name") String name,
                                  @Param(value = "idCard") String idCard,
                                  @Param(value = "mobile") String mobile,
                                  @Param(value = "personTypeGuid") String personTypeGuid,
                                  @Param(value = "attTime") String attTime,
                                  @Param(value = "count") String count) {

        StringBuilder stringBuilder = new StringBuilder("select tenders.guid tenderGuid, tenders.name tenderName, persons.guid guid, persons.name name, persons.idCard idCard," +
                " persons.mobile mobile, personTypes.guid personTypeGuid, personTypes.name typeName, case when attendances.pcount is null then 0 else attendances.pcount end as trainNumber," +
                "'" + attTime + "' enterAreaTime from persons left join");

        stringBuilder.append(" (select personGuid, count(*) as pcount from attendances where attTime like '%" + attTime + "%'" +
                    " group by personGuid) attendances on persons.guid = attendances.personGuid");

        stringBuilder.append(" left join tenders on persons.tenderguid = tenders.guid" +
                " left join personTypes on persons.personTypeGuid = personTypes.guid where 1 = 1");

        if (tenderGuid != null && !"".equals(tenderGuid)) {
            stringBuilder.append(" and tenderGuid = '" + tenderGuid + "'");

        }
        if (name != null && !"".equals(name)) {
            stringBuilder.append(" and persons.name like '%" + name + "%'");

        }
        if (idCard != null && !"".equals(idCard)) {
            stringBuilder.append(" and idCard = '" + idCard + "'");

        }
        if (mobile != null && !"".equals(mobile)) {
            stringBuilder.append(" and mobile = '" + mobile + "'");

        }
        if (personTypeGuid != null && !"".equals(personTypeGuid)) {
            stringBuilder.append(" and personTypeGuid = '" + personTypeGuid + "'");

        }
        if (count != null && !"".equals(count)) { // 0没打卡, 1打卡
            if ("0".equals(count)) {
                stringBuilder.append(" and trainNumber = '" + count + "'");

            }
            if ("1".equals(count)) {
                stringBuilder.append(" and trainNumber != '0'");

            }

        }

        return stringBuilder.toString();
    }
}
