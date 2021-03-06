package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ManagementPowerMapper;
import org.tonzoc.model.ManagementPowerModel;
import org.tonzoc.service.IManagementPowerService;

@Service("ManagementPowerService")
public class ManagementPowerService extends BaseService<ManagementPowerModel> implements IManagementPowerService {

    @Autowired
    private ManagementPowerMapper managementPowerMapper;
}
