package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ProjectTextModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IProjectTextService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("projectTextService")
public class ProjectTextService extends BaseService<ProjectTextModel> implements IProjectTextService{
    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private IntelliSiteProperties intelliSiteProperties;
    @Autowired
    private FileHelper fileHelper;

    public void insertStack(ProjectTextModel projectTextModel, MultipartFile file) throws Exception {
//        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//        sqlQueryParams.add(new SqlQueryParam("projectGuid", projectTextModel.getProjectGuid(), "eq"));
//        sqlQueryParams.add(new SqlQueryParam("typeGuid", projectTextModel.getTypeGuid(), "eq"));
//        List<ProjectTextModel> list = this.list(sqlQueryParams);
//        if (list.size()>0){
//            throw new NotOneResultFoundException("已添加过该项目、该类型的数据");
//        }
        if (projectTextModel.getContent()==null||projectTextModel.getContent().isEmpty()){
            projectTextModel.setContent("");
        }
        projectTextModel.setPictureGuid(upFile(file));
        save(projectTextModel);
    }

    public void updateStack(ProjectTextModel projectTextModel, MultipartFile file) throws Exception {

        if (file!=null){
            projectTextModel.setPictureGuid(upFile(file));
        }
        update(projectTextModel);
    }

    public String upFile( MultipartFile file) {
        String url="/项目图片/";
        intelliSiteProperties.setFileUrl(url);
        String[] str = fileHelper.fileUpload(file, "", "");
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setFileType("0");
        attachmentModel.setQualityTraceabilityGuid("");

        attachmentService.save(attachmentModel);

        intelliSiteProperties.setFileUrl("/");
        return attachmentModel.getGuid();
    }
}
