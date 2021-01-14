package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.DocumentQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.service.IDocumentService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "document")
public class DocumentController extends BaseController {

    @Autowired
    private IDocumentService documentService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, DocumentQueryParams documentQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<DocumentModel> page = parsePage(pageQueryParams);
        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(documentQueryParams);

        List<DocumentModel> list  = documentService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid DocumentModel documentModel) throws ParseException {

        documentModel.setStartTime(TimeHelper.stringToDate(documentModel.getStartDate()));
        documentModel.setEndTime(TimeHelper.stringToDate(documentModel.getEndDate()));
        this.documentService.save(documentModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid DocumentModel documentModel) throws ParseException {

        documentModel = documentService.updateTime(documentModel);
        this.documentService.update(documentModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.documentService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        documentService.removeMany(guids);
    }
}