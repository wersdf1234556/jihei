package org.tonzoc.service;

import org.tonzoc.model.PersonScoreModel;

import java.util.List;

public interface IPersonScoreService extends IBaseService<PersonScoreModel> {

    // 大屏展示人员分数
    List<PersonScoreModel> display();
}
