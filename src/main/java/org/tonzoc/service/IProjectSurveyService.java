package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.ProjectSurveyModel;

import java.util.Map;

public interface IProjectSurveyService extends IBaseService<ProjectSurveyModel> {

    // 上传安全的文件
    Map<String, String> upFile(MultipartFile file, String projectSurveyGuid);

    // 上传多条安全的文件
    void upFiles(MultipartFile[] file, String projectSurveyGuid);
}
