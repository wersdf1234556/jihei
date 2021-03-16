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
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.service.IAdvertisingVideoService;
import org.tonzoc.service.IAttachmentService;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "advertisingVideoService")
@Transactional
public class AdvertisingVideoService extends BaseService<AdvertisingVideoModel> implements IAdvertisingVideoService {

    @Autowired
    private AdvertisingVideoMapper advertisingVideoMapper;

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
    public List<AdvertisingVideoModel> selected (List<AdvertisingVideoModel> list) {
        if (list.size() > 0) {
            for (AdvertisingVideoModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public AdvertisingVideoModel updateTime(AdvertisingVideoModel advertisingVideoModel) throws ParseException {

        if (!advertisingVideoModel.getCurrentDate().equals("") && advertisingVideoModel.getCurrentDate() != null) {

            advertisingVideoMapper.updateTime(TimeHelper.stringToDate(advertisingVideoModel.getCurrentDate()), advertisingVideoModel.getGuid());
        }
        advertisingVideoModel.setCurrentDate("");
        return advertisingVideoModel;
    }

    // 上传文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/宣传片/");
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
