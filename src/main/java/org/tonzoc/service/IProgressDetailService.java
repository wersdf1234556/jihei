package org.tonzoc.service;

import org.tonzoc.exception.NotMatchException;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.support.ProgressStatModel;

import java.util.List;

public interface IProgressDetailService  extends IBaseService<ProgressDetailModel> {
    List<ProgressStatModel> statCurrentMonth(String tender,String date);
    void insertStack(ProgressDetailModel progressDetailModel);
    void updateStack(ProgressDetailModel progressDetailModel) throws Exception;
    String getNextTender(String tenderGuid);
    void approval(String progressGuid) throws NotMatchException;
    void batchApproval(String progressGuids) throws Exception;
}
