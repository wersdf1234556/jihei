package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.TenderMachineTypeMapper;
import org.tonzoc.model.TenderMachineTypeModel;
import org.tonzoc.service.ITenderMachineTypeService;

@Service
public class TenderMachineTypeService extends BaseService<TenderMachineTypeModel> implements ITenderMachineTypeService {

    @Autowired
    private TenderMachineTypeMapper tenderMachineTypeMapper;
}
