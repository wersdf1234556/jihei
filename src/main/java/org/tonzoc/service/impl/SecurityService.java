package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.SecurityMapper;
import org.tonzoc.mapper.TenderScoreMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.TenderScoreModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IDocumentService;
import org.tonzoc.service.ISecurityService;
import org.tonzoc.service.ITenderScoreService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;


@Service
@Transactional
public class SecurityService extends BaseService<SecurityModel> implements ISecurityService {

    @Autowired
    private SecurityMapper securityMapper;

    @Autowired
    private TenderScoreMapper tenderScoreMapper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private IDocumentService documentService;

    @Autowired
    private ITenderScoreService tenderScoreService;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private FileHelper fileHelper;

    // 判断当前时间是否在这个时间内
    @Override
    public String isTimeInside(String documentGuid) {

        Date date = new Date();
        long currentTime = date.getTime();

        DocumentModel documentModel = documentService.get(documentGuid);
        long startTime = documentModel.getStartTime().getTime();
        long endTime = documentModel.getEndTime().getTime();
        if (currentTime >= startTime && currentTime < endTime) {

            return "true";
        }
       // SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return "false";
    }

    // 上传安全文件
    @Override
    public Map<String, String> upFile(MultipartFile file) {

        intelliSiteProperties.setFileUrl("/安全/");

        // 获取的实际时间
        String[] str = fileHelper.fileUpload(file, new SimpleDateFormat("yyyy-MM-dd").format(new Date()),  "");

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

    // 添加多条并修改分数
    public void adds(List<SecurityModel> list) {

        Integer score = securityMapper.score(list.get(0).getDocumentGuid(), list.get(0).getTenderGuid());
        TenderScoreModel tenderScoreModel = tenderScoreMapper.selectByTender(list.get(0).getTenderGuid());
        tenderScoreService.updateScore(tenderScoreModel.getScores(), score);

        this.saveMany(list);
    }
}