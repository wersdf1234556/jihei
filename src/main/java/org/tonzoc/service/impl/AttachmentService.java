package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IQualityTraceabilityService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service("attachmentService")
@Transactional
public class AttachmentService extends BaseService<AttachmentModel> implements IAttachmentService {

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private IQualityTraceabilityService qualityTraceabilityService;

    // 单文件上传
    public void upFile(MultipartFile file, String qualityTraceabilityGuid) {

        QualityTraceabilityModel qualityTraceabilityModel = qualityTraceabilityService.get(qualityTraceabilityGuid);
        String[] str = fileHelper.fileUpload(file, qualityTraceabilityModel.getSubTypeName(), qualityTraceabilityGuid);

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setGuid(fileHelper.newGUID());
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setQualityTraceabilityGuid(qualityTraceabilityGuid);

        this.save(attachmentModel);
    }

    // 多文件上传
    public void upFiles(MultipartFile[] file, String qualityTraceabilityGuid) {

        if (file.length > 0) {
            QualityTraceabilityModel qualityTraceabilityModel = qualityTraceabilityService.get(qualityTraceabilityGuid);
            List<AttachmentModel> list = new ArrayList<>();

            for (MultipartFile f : file) {
                String[] str = fileHelper.fileUpload(f, qualityTraceabilityModel.getSubTypeName(), qualityTraceabilityGuid);

                AttachmentModel attachmentModel = new AttachmentModel();
                attachmentModel.setGuid(fileHelper.newGUID());
                attachmentModel.setUrl(str[0]);
                attachmentModel.setName(str[1]);
                attachmentModel.setQualityTraceabilityGuid(qualityTraceabilityGuid);
                attachmentModel.setSortId(0);

                list.add(attachmentModel);
            }

            this.saveMany(list);
        }
    }

    // 下载文件
    public void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException {

        AttachmentModel attachmentsModel = this.get(guid);

        fileHelper.downLoad(response, attachmentsModel.getName(), attachmentsModel.getUrl());
    }

    // 预览图片
    public byte[] getImage(String attachmentId) throws IOException {
        AttachmentModel attachmentsModel = get(attachmentId);
        String url = attachmentsModel.getUrl();
        return fileHelper.getImage(url);
    }

    // 预览视频
    public void getVideo(HttpServletResponse response, String attachmentId){

        AttachmentModel attachmentsModel = this.get(attachmentId);
        String url = attachmentsModel.getUrl();
        fileHelper.getVideo(response, url);
    }

    // 预览PDF
    public void PdfPreview (HttpServletResponse response, String guid) throws IOException {

        AttachmentModel attachmentsModel = this.get(guid);
        fileHelper.PdfPreview(response, attachmentsModel.getUrl());
    }

    // 删除物理文件
    @Override
    public String deleteFile(String guid) {
        List<String> list = new ArrayList<>();
        if (guid.contains(",")) {
            String str[] = guid.split(",");
            for (String s:str) {
                list.add(this.get(s).getUrl());
            }
        }else{
            list.add(this.get(guid).getUrl());
        }

      return fileHelper.deleteFile(list);
    }
}
