package org.tonzoc.service;

import org.tonzoc.model.TenderScoreModel;

public interface ITenderScoreService extends IBaseService<TenderScoreModel> {

    // 添加分数
    void add (String tenderGuid, Integer scores);
}