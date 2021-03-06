package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.MemorabiliaMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IMemorabiliaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MemorabiliaService extends BaseService<MemorabiliaModel> implements IMemorabiliaService {

    @Autowired
    private MemorabiliaMapper memorabiliaMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    // 查询字符串转时间
    @Override
    public List<MemorabiliaModel> selected (List<MemorabiliaModel> list) {
        if (list.size() > 0) {
            for (MemorabiliaModel m : list) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
                m.setCurrentDate(simpleDateFormat.format(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public MemorabiliaModel updateTime(MemorabiliaModel memorabiliaModel) throws ParseException {

        if (!"".equals(memorabiliaModel.getCurrentDate()) && memorabiliaModel.getCurrentDate() != null) {

            memorabiliaMapper.updateTime(TimeHelper.stringToDate(memorabiliaModel.getCurrentDate()), memorabiliaModel.getGuid());
        }
        memorabiliaModel.setSortId(0);
        memorabiliaModel.setCurrentDate("");
        return memorabiliaModel;
    }

    // 上传大事记文件
    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/大事记/");
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