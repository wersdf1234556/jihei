package org.tonzoc.service;

import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.support.ProgressStatModel;

import java.util.List;

public interface IProgressDetailService  extends IBaseService<ProgressDetailModel> {
    List<ProgressStatModel> statCurrentMonth(String tender,String date);
    void updateStack(ProgressDetailModel progressDetailModel) throws Exception;
    String getNextTender(String tenderGuid);
    void approval(String progressGuid);
}
