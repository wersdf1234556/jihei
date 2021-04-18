package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityWarningQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.SecurityWarningModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.service.ISecurityWarningService;
import org.tonzoc.support.param.SqlQueryParam;
import sun.misc.BASE64Decoder;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "securityWarning")
public class SecurityWarningController extends BaseController {

    @Autowired
    private ISecurityWarningService securityWarningService;
    @Autowired
    private IntelliSiteProperties intelliSiteProperties;
    @Autowired
    private IAttachmentService attachmentService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityWarningQueryParams securityWarningQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityWarningModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityWarningQueryParams);
        List<SecurityWarningModel> list = securityWarningService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityWarningModel securityWarningModel) {
        String imageData = securityWarningModel.getImage();
        String filePath = intelliSiteProperties.getFilePath() + "/securityWarningImages/" + UUID.randomUUID().toString() + ".jpg";
        if (GenerateImage(imageData, filePath)) {
            AttachmentModel attachmentModel = new AttachmentModel();
            attachmentModel.setUrl(filePath);
            this.attachmentService.save(attachmentModel);
            securityWarningModel.setImage(attachmentModel.getGuid());
            this.securityWarningService.save(securityWarningModel);
        }

    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityWarningModel securityWarningModel) {
        this.securityWarningService.update(securityWarningModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityWarningService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        securityWarningService.removeMany(guids);
    }

    private static boolean GenerateImage(String imgStr, String filePath) {
        if (imgStr == null) {
            // 图像数据为空
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            String imgFilePath = filePath;// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
