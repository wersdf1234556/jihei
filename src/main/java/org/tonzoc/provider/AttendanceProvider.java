package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

// 人员是否打卡
public class AttendanceProvider {

    public String securityPerson (@Param(value = "attTime") String attTime,
                                  @Param(value = "name") String name,
                                  @Param(value = "personTypeGuid") String personTypeGuid,
                                  @Param(value = "tenderGuid") String tenderGuid,
                                  @Param(value = "flag") Integer flag,
                                  @Param(value = "categoryGuid") String categoryGuid) {

        StringBuilder stringBuilder = new StringBuilder("select tenders.name tenderName, personTypes.name typeName, persons.name, persons.mobile, case when attendances.personGuid is null then '0' else '1' end as trainNumber from persons" +
                " LEFT JOIN (select DISTINCT personGuid from attendances where attTime like '%" + attTime + "%') attendances on persons.guid = attendances.personGuid");

        stringBuilder.append(" LEFT JOIN tenders on persons.tenderGuid = tenders.guid" +
                " LEFT JOIN personTypes on persons.personTypeGuid = personTypes.guid where 1 = 1");

        if (flag != null) {

            stringBuilder.append(" and personTypes.flag = " + flag);
        }
        if (categoryGuid != null && !"".equals(categoryGuid)) {

            stringBuilder.append(" and personTypes.categoryGuid = '" + categoryGuid + "'");
        }
        if (name != null && !"".equals(name)) {

            stringBuilder.append(" and persons.name like '%" + name + "%'");
        }
        if (personTypeGuid != null && !"".equals(personTypeGuid)) {

            stringBuilder.append(" and persons.personTypeGuid = '" + personTypeGuid + "'");
        }
        if (tenderGuid != null && !"".equals(tenderGuid)) {

            stringBuilder.append(" and persons.tenderGuid = '" + tenderGuid + "'");
        }

        return stringBuilder.toString();
    }

}
