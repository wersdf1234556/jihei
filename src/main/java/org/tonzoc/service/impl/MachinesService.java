package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.MachinesModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.service.IMachinesService;

@Service
public class MachinesService extends BaseService<MachinesModel> implements IMachinesService {

    @Override
    public ReturnModel mechanicsSurvey(String tenderGuid) {
        if ("".equals(tenderGuid) || tenderGuid == null) {

        }
        return null;
    }

    @Override
    public ReturnModel importantMechanics(String tenderGuid) {
        return null;
    }
}
