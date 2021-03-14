package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.AttachmentProjectSurveyQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.AttachmentProjectSurveyModel;
import org.tonzoc.service.IAttachmentProjectSurveyService;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IProjectSurveyService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "attachmentProjectSurvey")
public class AttachmentProjectSurveyController extends BaseController{

    @Autowired
    private IAttachmentProjectSurveyService attachmentProjectSurveyService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AttachmentProjectSurveyQueryParams attachmentProjectSurveyQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Page<AttachmentProjectSurveyModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(attachmentProjectSurveyQueryParams);

        List<AttachmentProjectSurveyModel> list = attachmentProjectSurveyService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AttachmentProjectSurveyModel attachmentProjectSurveyModel) {

        this.attachmentProjectSurveyService.save(attachmentProjectSurveyModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AttachmentProjectSurveyModel attachmentProjectSurveyModel) {
        this.attachmentProjectSurveyService.update(attachmentProjectSurveyModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.attachmentProjectSurveyService.deleteFile(guid);
        this.attachmentProjectSurveyService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        this.attachmentProjectSurveyService.deleteFile(guids);
        this.attachmentProjectSurveyService.removeMany(guids);
    }

    // 预览图片
    @GetMapping(value = "image/{guid}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "guid") String guid) throws IOException {

        return attachmentProjectSurveyService.getImage(guid);
    }
}
