package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.StepPersonMapper;
import org.tonzoc.model.StepPersonModel;
import org.tonzoc.service.IStepPersonService;

@Service
public class StepPersonService extends BaseService<StepPersonModel> implements IStepPersonService {

    @Autowired
    private StepPersonMapper stepPersonMapper;
}
