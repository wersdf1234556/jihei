package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.PersonScoreMapper;
import org.tonzoc.model.PersonTenderModel;
import org.tonzoc.service.IPersonTenderService;

@Service
public class PersonTenderService extends BaseService<PersonTenderModel> implements IPersonTenderService {

    @Autowired
    private PersonScoreMapper personScoreMapper;
}
