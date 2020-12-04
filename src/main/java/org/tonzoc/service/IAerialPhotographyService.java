package org.tonzoc.service;

import org.tonzoc.model.AerialPhotographyModel;

import java.util.List;

public interface IAerialPhotographyService extends IBaseService<AerialPhotographyModel> {

    AerialPhotographyModel getFirstByTender(String tenderGuid) throws Exception;

    List<String> getDistinctMonth(String tenderGuid);
}
