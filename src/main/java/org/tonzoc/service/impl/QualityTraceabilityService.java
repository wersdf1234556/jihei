package org.tonzoc.service.impl;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.mapper.QualityTraceabilityMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IQualityTraceabilityService;
import org.tonzoc.service.ISubTypeService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QualityTraceabilityService extends BaseService<QualityTraceabilityModel> implements IQualityTraceabilityService {

    @Autowired
    private QualityTraceabilityMapper qualityTraceabilityMapper;

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private IAttachmentService attachmentService;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private ISubTypeService subTypeService;

    // 上传质量追溯文件
    @Override
    public void upFile(MultipartFile[] file, String qualityTraceabilityGuid) {

        intelliSiteProperties.setFileUrl("/质量追溯/");
        attachmentService.upFiles(file, qualityTraceabilityGuid);
        intelliSiteProperties.setFileUrl("/");
    }

    // 查询字符串转时间
    @Override
    public List<QualityTraceabilityModel> selected (List<QualityTraceabilityModel> list) {
        if (list.size() > 0) {
            for (QualityTraceabilityModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public QualityTraceabilityModel updateTime(QualityTraceabilityModel mapInformationModel) throws ParseException {

        if (!mapInformationModel.getCurrentDate().equals("") && mapInformationModel.getCurrentDate() != null) {

            qualityTraceabilityMapper.updateTime(TimeHelper.stringToDate(mapInformationModel.getCurrentDate()), mapInformationModel.getGuid());
        }
        mapInformationModel.setSortId(0);
        mapInformationModel.setCurrentDate("");
        return mapInformationModel;
    }

    // 生成二维码
    @Override
    public Map<String, String> qrcode(String subTypeGuid) {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String address = request.getLocalPort() + ""; // 获取端口号

        String payUrl = intelliSiteProperties.getIp() + address + "/attachment?subTypeGuid =" + subTypeGuid; // 二维码存的内容

        try {
            fileHelper.generateQRCodeImage(payUrl, 350, 350, subTypeGuid + ".png");
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String oldGuid = attachmentMapper.getGuid(subTypeGuid + ".png", "");
        if (oldGuid != null) {
            attachmentService.remove(oldGuid);
        }
        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + subTypeGuid + ".png");
        attachmentModel.setName(subTypeGuid + ".png");
        attachmentModel.setSortId(0);
        attachmentModel.setQualityTraceabilityGuid("");
        attachmentService.save(attachmentModel);

        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentMapper.getGuid(intelliSiteProperties.getFilePath() + "/qrcodeImg/" + subTypeGuid + ".png",  ""));
        return map;
    }
}
