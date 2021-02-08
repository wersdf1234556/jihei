package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.model.NextStepModel;
import org.tonzoc.service.INextStepService;

@Service
public class NextStepService extends BaseService<NextStepModel> implements INextStepService {

    @Autowired
    private INextStepService nextStepService;
}
