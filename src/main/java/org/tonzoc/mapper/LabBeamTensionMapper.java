package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.provider.LabBeamTensionProvider;

import java.util.List;

@Component
public interface LabBeamTensionMapper extends BaseMapper<LabBeamTensionModel> {

    @SelectProvider(type = LabBeamTensionProvider.class, method = "getGroupData")
    List<LabBeamTensionModel> getGroupData(@Param("componentParts") String componentParts, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("tenderGuid") String tenderGuid);
}
