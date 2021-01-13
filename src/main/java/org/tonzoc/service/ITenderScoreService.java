package org.tonzoc.service;

import org.tonzoc.model.TenderScoreModel;

import java.util.List;

public interface ITenderScoreService extends IBaseService<TenderScoreModel> {

    // 修改分数
    Integer updateScore(Integer tenderScore, Integer updateScore);

    // 大屏展示标段分数
    List<TenderScoreModel> display();
}
