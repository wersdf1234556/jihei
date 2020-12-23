package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IMemorabiliaService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemorabiliaService extends BaseService<MemorabiliaModel> implements IMemorabiliaService {

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

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

    @Override
    public Date updated(String currentDate) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = simpleDateFormat.parse(currentDate);

        return currentTime;
    }

    @Override
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        intelliSiteProperties.setFileUrl("/大事记/");
        String[] str = fileHelper.fileUpload(file, currentDate, "", "");

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSortId(0);
        attachmentModel.setSubTypeGuid("");
        attachmentModel.setTypeGuid("");

        attachmentService.save(attachmentModel);
        intelliSiteProperties.setFileUrl("/");
        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(str[0], "", ""));
        return map;
    }
}
