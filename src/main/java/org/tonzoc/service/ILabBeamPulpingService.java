package org.tonzoc.service;

import org.tonzoc.model.LabBeamPulpingModel;
import org.tonzoc.model.LabBeamTensionModel;

import java.util.List;

public interface ILabBeamPulpingService extends IBaseService<LabBeamPulpingModel> {
    List<LabBeamPulpingModel> getGroupData(String componentParts, String startDate, String endDate, String tenderGuid);
}
