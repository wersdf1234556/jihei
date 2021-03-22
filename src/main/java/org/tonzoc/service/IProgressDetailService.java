package org.tonzoc.service;

import org.tonzoc.exception.NotMatchException;
import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.UserModel;
import org.tonzoc.model.support.ProgressStatModel;

import java.util.List;

public interface IProgressDetailService  extends IBaseService<ProgressDetailModel> {
    List<ProgressStatModel> statCurrentMonth(String tender,String date,Integer flag);
    void insertStack(ProgressDetailModel progressDetailModel);
    void updateStack(ProgressDetailModel progressDetailModel,UserModel userModel) throws Exception;
    void removeStack(String guid,UserModel userModel) throws Exception;
    void batchRemoveStack(String guids,UserModel userModel) throws Exception;

    void submit(String progressGuid);
    void approval(String progressGuid,Integer flag) throws NotMatchException;
    void batchApproval(String progressGuids,Integer flag) throws Exception;
}
