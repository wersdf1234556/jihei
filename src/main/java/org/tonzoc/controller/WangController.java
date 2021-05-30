package org.tonzoc.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.models.auth.In;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.service.IAttachmentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping(value = "wang")
public class WangController {
    @Autowired
    private IAttachmentService attachmentService;

    @PostMapping("okhttp")
    public Callable<Map> testOkHttpAsync() {
        return () -> {
            JSONObject json = new JSONObject();
            json.put("openIds", "oJfYQwPjf4dBX8aW43uEa-7kCMfM");
            json.put("title", "测试标题");
            json.put("content", "内容");
            json.put("date", "2021-05-21");
            json.put("remark", "备注");
            json.put("url", "https://www.baidu.com");

            Map<String, Object> result = new ConcurrentHashMap<>();
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = RequestBody.create(json.toJSONString(), MediaType.parse("application/json;charset=utf-8"));
            Request request = new Request.Builder()
                    .url("https://mp.ljkjkf.com/api/templateMessage/warning")
                    .post(requestBody)
                    .build();
            try {
                Response response = okHttpClient.newCall(request).execute();
                JSONObject resultJson = (JSONObject) JSONObject.parse(response.body().string());
                result.put("code", resultJson.getInteger("errcode"));
                result.put("errmsg", resultJson.getString("errmsg"));
            } catch (IOException e) {
                result.put("code", 500);
                result.put("errmsg", "error");
                e.printStackTrace();
            }

            return result;
        };
    }

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
