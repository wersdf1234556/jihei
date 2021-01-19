package org.tonzoc.service;

import org.tonzoc.model.TenderModel;

public interface ITenderService extends IBaseService<TenderModel> {
    void insertStack(TenderModel tenderModel) throws Exception;
    void updateStack(TenderModel tenderModel) throws Exception;

}
