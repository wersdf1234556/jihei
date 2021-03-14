package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.service.ITenderScoreService;

@Service
@Transactional
public class TenderScoreService extends BaseService<TenderScoreModel> implements ITenderScoreService {

    @Autowired
    private TenderScoreMapper tenderScoreMapper;




    // 查询十天内的分数
    public TenderScoreModel selectScore(){

        return null;
    }

}