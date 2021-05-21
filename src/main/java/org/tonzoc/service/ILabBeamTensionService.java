package org.tonzoc.service;

import org.apache.ibatis.annotations.Param;
import org.tonzoc.model.CameraModel;
import org.tonzoc.model.LabBeamTensionModel;

import java.util.List;

public interface ILabBeamTensionService extends IBaseService<LabBeamTensionModel> {

    List<LabBeamTensionModel> getGroupData(String componentParts, String startDate, String endDate, String tenderGuid);
}
