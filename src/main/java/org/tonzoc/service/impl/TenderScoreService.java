package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.service.ITenderScoreService;

import java.util.List;

@Service
public class TenderScoreService extends BaseService<TenderScoreModel> implements ITenderScoreService {

    @Autowired
    private TenderScoreMapper tenderScoreMapper;

    // 修改分数
    public Integer updateScore(Integer tenderScore, Integer updateScore){

        return tenderScore + updateScore;
    }

    // 大屏展示标段分数
    public List<TenderScoreModel> display(){

        return tenderScoreMapper.display();
    }
}
