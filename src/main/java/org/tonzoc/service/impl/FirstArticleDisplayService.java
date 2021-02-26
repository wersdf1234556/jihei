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
import org.tonzoc.mapper.FirstArticleDisplayMapper;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.FirstArticleDisplayModel;
import org.tonzoc.service.IAdvertisingVideoService;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IFirstArticleDisplayService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "firstArticleDisplayService")
@Transactional
public class FirstArticleDisplayService extends BaseService<FirstArticleDisplayModel> implements IFirstArticleDisplayService {

    @Autowired
    private FirstArticleDisplayMapper firstArticleDisplayMapper;

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
    public List<FirstArticleDisplayModel> selected (List<FirstArticleDisplayModel> list) {
        if (list.size() > 0) {
            for (FirstArticleDisplayModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public FirstArticleDisplayModel updateTime(FirstArticleDisplayModel firstArticleDisplayModel) throws ParseException {

        if (!firstArticleDisplayModel.getCurrentDate().equals("") && firstArticleDisplayModel.getCurrentDate() != null) {

            firstArticleDisplayMapper.updateTime(TimeHelper.stringToDate(firstArticleDisplayModel.getCurrentDate()), firstArticleDisplayModel.getGuid());
        }
        firstArticleDisplayModel.setSortId(0);
        firstArticleDisplayModel.setCurrentDate("");
        return firstArticleDisplayModel;
    }

    // 上传文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/首件验收/");
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
