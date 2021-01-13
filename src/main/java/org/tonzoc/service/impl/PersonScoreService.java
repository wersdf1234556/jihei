package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.PersonScoreMapper;
import org.tonzoc.model.PersonScoreModel;
import org.tonzoc.service.IPersonScoreService;

import java.util.List;

@Service
public class PersonScoreService extends BaseService<PersonScoreModel> implements IPersonScoreService {

    @Autowired
    private PersonScoreMapper personScoreMapper;

    // 大屏展示人员分数
    public List<PersonScoreModel> display(){

        return personScoreMapper.display();
    }
}
