package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.service.ITenderScoreService;

@Service
public class TenderScoreService extends BaseService<TenderScoreModel> implements ITenderScoreService {

    @Autowired
    private TenderScoreMapper tenderScoreMapper;

    // 修改分数
    public void updateScore(Integer tenderScore, Integer updateScore){

        tenderScoreMapper.updateScore(tenderScore + updateScore);
    }

}