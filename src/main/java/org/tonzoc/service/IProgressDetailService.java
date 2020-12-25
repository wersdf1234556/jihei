package org.tonzoc.service;

import org.tonzoc.model.ProgressDetailModel;
import org.tonzoc.model.support.ProgressStatModel;

import java.util.List;

public interface IProgressDetailService  extends IBaseService<ProgressDetailModel> {
    List<ProgressStatModel> statCurrentMonth(String tender,String date);
}
