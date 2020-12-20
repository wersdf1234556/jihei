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
import java.sql.Date;

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
    public String upFile(MultipartFile file, Date currentTime) {

        String urlName = "大事记/" + currentTime;
        System.out.println(urlName);
        String[] str = fileHelper.fileUpload(file, urlName, "", "");

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSortId(0);
        attachmentModel.setSubTypeGuid("");
        attachmentModel.setTypeGuid("");

        attachmentService.save(attachmentModel);
        System.out.println(attachmentMapper.getGuid(str[1], "", "") + 222);
        return attachmentMapper.getGuid(str[1], "", "");
    }

    @Override
    public String qrcode(String guid) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String address = request.getLocalPort() + "";  // 获取端口号

        String payUrl = intelliSiteProperties.getIp() + address + "/attachment/downLoadFile?guid =" + guid; // 二维码存的内容

        try {
            fileHelper.generateQRCodeImage(payUrl, 350, 350,  guid + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String oldGuid =  attachmentMapper.getGuid(guid + ".png", "", "");
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

        return attachmentMapper.getGuid(guid + ".png", "", "");
    }
}
