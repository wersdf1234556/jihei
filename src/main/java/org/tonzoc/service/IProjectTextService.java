package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.ProjectTextModel;

public interface IProjectTextService extends IBaseService<ProjectTextModel>{
    void insertStack(ProjectTextModel projectTextModel, MultipartFile file) throws Exception;
    void updateStack(ProjectTextModel projectTextModel, MultipartFile file) throws Exception;
}
