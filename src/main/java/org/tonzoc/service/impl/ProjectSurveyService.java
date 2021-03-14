package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentProjectSurveyMapper;
import org.tonzoc.model.AttachmentProjectSurveyModel;
import org.tonzoc.model.ProjectSurveyModel;
import org.tonzoc.service.IAttachmentProjectSurveyService;
import org.tonzoc.service.IProjectSurveyService;

import java.text.SimpleDateFormat;
import java.util.*;

@Service("ProjectSurveyService")
@Transactional
public class ProjectSurveyService extends BaseService<ProjectSurveyModel> implements IProjectSurveyService {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IAttachmentProjectSurveyService attachmentProjectSurveyService;

    @Autowired
    private AttachmentProjectSurveyMapper attachmentProjectSurveyMapper;

    // 上传安全文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String projectSurveyGuid) {

        Map<String, String> map = new HashMap<>();
        intelliSiteProperties.setFileUrl("/项目图片/");

        // 获取的实际时间
        String[] str = fileHelper.fileUpload(file, new SimpleDateFormat("yyyy-MM-dd").format(new Date()),  "");

        AttachmentProjectSurveyModel attachmentProjectSurveyModel = new AttachmentProjectSurveyModel();
        attachmentProjectSurveyModel.setUrl(str[0]);
        attachmentProjectSurveyModel.setName(str[1]);
        attachmentProjectSurveyModel.setSortId(0);
        attachmentProjectSurveyModel.setProjectSurveyGuid(projectSurveyGuid);
        attachmentProjectSurveyService.save(attachmentProjectSurveyModel);

        intelliSiteProperties.setFileUrl("/");
        if (projectSurveyGuid != null && !projectSurveyGuid.equals("")) {

            map.put("attachmentProjectSurveyGuid", attachmentProjectSurveyMapper.getProjectSurveyGuid(str[0], projectSurveyGuid));
        }


        return map;
    }

    // 上传多条安全的文件
    @Override
    public void upFiles(MultipartFile[] file, String projectSurveyGuid){
        if (file.length > 0) {
            List<AttachmentProjectSurveyModel> list = new ArrayList<>();
            for (MultipartFile f : file) {
                String[] str = fileHelper.fileUpload(f, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "");

                AttachmentProjectSurveyModel attachmentProjectSurveyModel = new AttachmentProjectSurveyModel();
                attachmentProjectSurveyModel.setUrl(str[0]);
                attachmentProjectSurveyModel.setName(str[1]);
                attachmentProjectSurveyModel.setSortId(0);
                attachmentProjectSurveyModel.setProjectSurveyGuid(projectSurveyGuid);

                list.add(attachmentProjectSurveyModel);
            }

            attachmentProjectSurveyService.saveMany(list);
        }
    }
}
