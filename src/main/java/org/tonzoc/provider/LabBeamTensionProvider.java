package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

public class LabBeamTensionProvider {

    public String getGroupData(@Param(value = "componentParts") String componentParts,
                               @Param(value = "startDate") String startDate,
                               @Param(value = "endDate") String endDate,
                               @Param(value = "tenderGuid") String tenderGuid) {
        StringBuilder stringBuilder = new StringBuilder("select componentId as guid, tenderGuid, componentParts, componentId, tensioningDate");
        stringBuilder.append("      from (\n")
                .append("         select tenderGuid, componentId, componentParts, substring(max(tensioningDate), 1, 10) as tensioningDate\n")
                .append("         from labBeamTensions\n")
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
        if (tenderGuid != null && !"".equals(tenderGuid)) {
            stringBuilder.append(" and tenderGuid = '").append(tenderGuid).append("'");
        }
        stringBuilder.append(" order by tensioningDate desc");
        return stringBuilder.toString();
    }
}
