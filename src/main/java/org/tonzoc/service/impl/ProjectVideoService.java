package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AdvertisingVideoMapper;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.ProjectVideoMapper;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ProjectVideoModel;
import org.tonzoc.service.IAdvertisingVideoService;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IProjectVideoService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "ProjectVideoService")
@Transactional
public class ProjectVideoService extends BaseService<ProjectVideoModel> implements IProjectVideoService {

    @Autowired
    private ProjectVideoMapper projectVideoMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    // 查询字符串转时间
    @Override
    public List<ProjectVideoModel> selected (List<ProjectVideoModel> list) {
        if (list.size() > 0) {
            for (ProjectVideoModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public ProjectVideoModel updateTime(ProjectVideoModel projectVideoModel) throws ParseException {

        if (!projectVideoModel.getCurrentDate().equals("") && projectVideoModel.getCurrentDate() != null) {

            projectVideoMapper.updateTime(TimeHelper.stringToDate(projectVideoModel.getCurrentDate()), projectVideoModel.getGuid());
        }
        projectVideoModel.setSortId(0);
        projectVideoModel.setCurrentDate("");
        return projectVideoModel;
    }

    // 上传文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/项目宣传片/");
        String[] str = fileHelper.fileUpload(file, currentDate,  "");

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(fileHelper.newGUID());
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSortId(0);
        attachmentModel.setQualityTraceabilityGuid("");

        attachmentService.save(attachmentModel);
        intelliSiteProperties.setFileUrl("/");
        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(str[0],  ""));
        return map;
    }
}
