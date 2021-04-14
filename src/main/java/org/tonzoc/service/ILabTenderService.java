package org.tonzoc.service;

import org.tonzoc.model.LabTenderModel;

public interface ILabTenderService extends IBaseService<LabTenderModel> {
    String getBySectionId(String sectionId);
}
