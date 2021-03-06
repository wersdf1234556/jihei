package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.BuildLevelMapper;
import org.tonzoc.model.BuildLevelModel;
import org.tonzoc.service.IBuildLevelService;

@Service("BuildLevelService")
public class BuildLevelService extends BaseService<BuildLevelModel> implements IBuildLevelService {

    @Autowired
    private BuildLevelMapper buildLevelMapper;
}
