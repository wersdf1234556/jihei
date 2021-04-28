package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class LabBeamPulpingProvider {

    public String getGroupData(@Param(value = "componentParts") String componentParts,
                               @Param(value = "startDate") String startDate,
                               @Param(value = "endDate") String endDate) {
        StringBuilder stringBuilder = new StringBuilder("select componentId as guid, tenderGuid, componentParts, componentId, tensioningDate");
        stringBuilder.append("      from (\n")
                .append("         select tenderGuid, componentId, componentParts, substring(max(startDate), 1, 10) as tensioningDate\n")
                .append("         from labBeamPulpings\n")
                .append("         group by tenderGuid, componentId, componentParts) as groupData\n")
                .append("         where 1 = 1");

        if (componentParts != null && !"".equals(componentParts)) {
            stringBuilder.append(" and componentParts like '%").append(componentParts).append("%'");
        }
        if (startDate != null && !"".equals(startDate)) {
            stringBuilder.append(" and tensioningDate >= '").append(startDate).append("'");
        }
        if (endDate != null && !"".equals(endDate)) {
            stringBuilder.append(" and tensioningDate <= '").append(endDate).append("'");
        }
        stringBuilder.append(" order by tensioningDate desc");
        return stringBuilder.toString();
    }
}
