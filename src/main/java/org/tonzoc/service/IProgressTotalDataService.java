package org.tonzoc.service;

import org.tonzoc.model.ProgressTotalDataModel;

import java.util.List;


public interface IProgressTotalDataService extends IBaseService<ProgressTotalDataModel> {
    List<ProgressTotalDataModel> listByTenderAndProgressName(String tenderGuid, String progressNameGuid);
}
