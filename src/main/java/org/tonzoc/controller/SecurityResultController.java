package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SecurityResultQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.SecurityResultDetailModel;
import org.tonzoc.model.SecurityResultModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.ISecurityResultDetailService;
import org.tonzoc.service.ISecurityResultService;
import org.tonzoc.support.param.SqlQueryParam;
import sun.misc.BASE64Decoder;

import javax.validation.Valid;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "securityResult")
public class SecurityResultController extends BaseController {

    @Autowired
    private ISecurityResultService securityResultService;
    @Autowired
    private ISecurityResultDetailService securityResultDetailService;
    @Autowired
    private IntelliSiteProperties intelliSiteProperties;
    @Autowired
    private IAttachmentService attachmentService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SecurityResultQueryParams securityResultQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SecurityResultModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(securityResultQueryParams);
        List<SecurityResultModel> list = securityResultService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid SecurityResultModel securityResultModel) {
        System.out.println("------------------------------------------------------");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(securityResultModel);
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("------------------------------------------------------");
        String imageData = securityResultModel.getImgData();
        String filePath = intelliSiteProperties.getFilePath() + "/securityResultImages/" + UUID.randomUUID() + ".jpg";
        if (GenerateImage(imageData, filePath)) {
            System.out.println("in if");
            AttachmentModel attachmentModel = new AttachmentModel();
            attachmentModel.setUrl(filePath);
            this.attachmentService.save(attachmentModel);
            securityResultModel.setImageUrl(attachmentModel.getGuid());
            securityResultModel.setImgData("");
            this.securityResultService.save(securityResultModel);

            for (SecurityResultDetailModel detailModel : securityResultModel.getData()) {
                detailModel.setSecurityResultGuid(securityResultModel.getGuid());
            }
            this.securityResultDetailService.saveMany(securityResultModel.getData());
        }

    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid SecurityResultModel securityResultModel) {
        this.securityResultService.update(securityResultModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.securityResultService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        securityResultService.removeMany(guids);
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
