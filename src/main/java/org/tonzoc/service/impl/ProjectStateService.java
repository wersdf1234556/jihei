package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ProjectStateMapper;
import org.tonzoc.model.ProjectStateModel;
import org.tonzoc.service.IProjectStateService;

@Service("ProjectStateService")
public class ProjectStateService extends BaseService<ProjectStateModel> implements IProjectStateService {

    @Autowired
    private ProjectStateMapper projectStateMapper;
}
