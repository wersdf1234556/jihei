package org.tonzoc.service;

import org.tonzoc.model.TenderScoreModel;

import java.util.List;

public interface ITenderScoreService extends IBaseService<TenderScoreModel> {

    // 修改分数
    void updateScore(Integer tenderScore, Integer updateScore);
}