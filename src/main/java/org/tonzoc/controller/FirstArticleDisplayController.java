package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.FirstArticleDisplayQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.FirstArticleDisplayModel;
import org.tonzoc.service.IFirstArticleDisplayService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("firstArticleDisplay")
public class FirstArticleDisplayController extends BaseController{

    @Autowired
    private IFirstArticleDisplayService firstArticleDisplayService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, FirstArticleDisplayQueryParams firstArticleDisplayQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<FirstArticleDisplayModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(firstArticleDisplayQueryParams);
        List<FirstArticleDisplayModel> list = firstArticleDisplayService.list(sqlQueryParams);
        list = firstArticleDisplayService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid FirstArticleDisplayModel firstArticleDisplayModel) throws ParseException {

        firstArticleDisplayModel.setCurrentTime(TimeHelper.stringToDate(firstArticleDisplayModel.getCurrentDate()));
        this.firstArticleDisplayService.save(firstArticleDisplayModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid FirstArticleDisplayModel firstArticleDisplayModel) throws ParseException {

        firstArticleDisplayModel = firstArticleDisplayService.updateTime(firstArticleDisplayModel);
        this.firstArticleDisplayService.update(firstArticleDisplayModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.firstArticleDisplayService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        firstArticleDisplayService.removeMany(guids);
    }

    // 上传文件
    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        return firstArticleDisplayService.upFile(file, currentDate);
    }
}
