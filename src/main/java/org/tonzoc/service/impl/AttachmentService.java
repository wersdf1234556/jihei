package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.ISubTypeService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service("attachmentService")
@Transactional
public class AttachmentService extends BaseService<AttachmentModel> implements IAttachmentService {

    @Autowired
    private FileHelper fileHelper;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private ISubTypeService subTypeService;

    // 单文件上传
    public void upFile(MultipartFile file, Integer typeId, String subTypeGuid) {

        SubTypeModel subTypeModel = subTypeService.get(subTypeGuid);
        String[] str = fileHelper.fileUpload(file, subTypeModel.getName(), typeId, subTypeGuid);

        AttachmentModel attachmentModel = new AttachmentModel();
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setSubTypeGuid(subTypeGuid);
        attachmentModel.setTypeId(typeId);

        this.save(attachmentModel);
    }

    // 多文件上传
    public void upFiles(MultipartFile[] file, Integer typeId, String subTypeGuid) {

        if (file.length > 0) {
            SubTypeModel subTypeModel = subTypeService.get(subTypeGuid);
            List<AttachmentModel> list = new ArrayList<>();

            for (MultipartFile f : file) {
                String[] str = fileHelper.fileUpload(f, subTypeModel.getName(), typeId, subTypeGuid);

                AttachmentModel attachmentModel = new AttachmentModel();
                attachmentModel.setUrl(str[0]);
                attachmentModel.setName(str[1]);
                attachmentModel.setTypeId(typeId);
                attachmentModel.setSubTypeGuid(subTypeGuid);
                attachmentModel.setSortId(0);

                list.add(attachmentModel);
            }

            this.saveMany(list);
        }
    }

    public void downLoadFile(HttpServletResponse response, String guid) throws UnsupportedEncodingException {

        AttachmentModel attachmentsModel = this.get(guid);

        fileHelper.downLoad(response, attachmentsModel.getName(), attachmentsModel.getUrl());
    }

    public byte[] getImage(String attachmentId) throws IOException {
        AttachmentModel attachmentsModel =get(attachmentId);
        String url =attachmentsModel.getUrl();
        return fileHelper.getImage(url);
    }

    public void PdfPreview (HttpServletResponse response, String guid) throws IOException {

        AttachmentModel attachmentsModel = this.get(guid);

        fileHelper.PdfPreview(response, attachmentsModel.getUrl());
    }

    public List<ReturnModel> dataCount (String projectId) {

        return attachmentMapper.dataCount(projectId);
    }
}
