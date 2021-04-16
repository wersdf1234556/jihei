package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.LabBeamTensionModel;

@Component
public interface LabBeamTensionMapper extends BaseMapper<LabBeamTensionModel> {

}
