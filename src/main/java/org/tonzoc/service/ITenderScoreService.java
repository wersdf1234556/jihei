package org.tonzoc.service;

import org.tonzoc.model.TenderScoreModel;

public interface ITenderScoreService extends IBaseService<TenderScoreModel> {

    // 添加分数

    // 查询十天内的分数
    TenderScoreModel selectScore();
}