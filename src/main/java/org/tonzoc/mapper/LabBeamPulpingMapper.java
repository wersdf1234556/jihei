package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabBeamPulpingModel;
import org.tonzoc.model.LabBeamTensionModel;
import org.tonzoc.provider.LabBeamPulpingProvider;
import org.tonzoc.provider.LabBeamTensionProvider;

import java.util.List;

@Component
public interface LabBeamPulpingMapper extends BaseMapper<LabBeamPulpingModel> {
    @SelectProvider(type = LabBeamPulpingProvider.class, method = "getGroupData")
    List<LabBeamPulpingModel> getGroupData(@Param("componentParts") String componentParts, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
