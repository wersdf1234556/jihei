package org.tonzoc.controller;

import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.exception.response.ExceptionResponse;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.LabPmsTesterModel;
import org.tonzoc.service.IAttachmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import static com.google.common.net.HttpHeaders.CONTENT_DISPOSITION;

@RestController
@RequestMapping(value = "wang")
public class WangController {
    @Autowired
    private IAttachmentService attachmentService;

    @PostMapping("uploadImg")
    public Map<String, Object> updateImg(HttpServletRequest request) throws IOException, ServletException {
        Collection<Part> parts = request.getParts();

        List<String> fileNames = new ArrayList<>();
        for (Part part : parts) {
            String uuid = UUID.randomUUID().toString();
            String savePath = "D:/intellisite/jihei/upload/wang/" + uuid + ".png";
            InputStream inputStream = part.getInputStream();
            saveFile(inputStream, savePath);

            AttachmentModel attachmentModel = new AttachmentModel();
            attachmentModel.setGuid(uuid);
            attachmentModel.setUrl(savePath);
            attachmentModel.setName(uuid + ".png");
            attachmentModel.setQualityTraceabilityGuid("");

            attachmentService.save(attachmentModel);
            fileNames.add("http://jihei-api.ljkjkf.com/attachment/image/" + attachmentModel.getGuid());
        }

        Map<String, Object> resultMap = new HashMap();
        resultMap.put("errno", 0);
        resultMap.put("data", fileNames);

        return resultMap;
    }

    void saveFile(InputStream inputStream, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);

        byte[] b = new byte[1024];

        int length;

        while ((length = inputStream.read(b)) > 0) {

            fos.write(b, 0, length);

        }

        inputStream.close();

        fos.close();
    }
}
