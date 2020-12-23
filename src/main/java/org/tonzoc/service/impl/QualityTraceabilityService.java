package org.tonzoc.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IQualityTraceabilityService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class QualityTraceabilityService extends BaseService<QualityTraceabilityModel> implements IQualityTraceabilityService {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;


    @Override
    public void upFile(MultipartFile[] file, String typeGuid, String subTypeGuid) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFiles(file, typeGuid, subTypeGuid);
        intelliSiteProperties.setFileUrl("/");
    }

    @Override
    public Map<String, String> qrcode(String guid) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String address = request.getLocalPort() + ""; // 获取端口号

        String payUrl = intelliSiteProperties.getIp() + address + "/attachment/downLoadFile?guid =" + guid; // 二维码存的内容

        try {
            fileHelper.generateQRCodeImage(payUrl, 350, 350, guid + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String oldGuid = attachmentMapper.getGuid(guid + ".png", "", "");
        if (oldGuid != null) {
            attachmentService.remove(oldGuid);
        }
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png");
        attachmentModel.setName(guid + ".png");
        attachmentModel.setSortId(0);
        attachmentModel.setTypeGuid("");
        attachmentModel.setSubTypeGuid("");
        attachmentService.save(attachmentModel);

        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + guid + ".png", "", ""));
        return map;
    }
}
