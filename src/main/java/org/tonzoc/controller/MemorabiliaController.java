package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.MemorabiliaQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.MemorabiliaModel;
import org.tonzoc.service.IMemorabiliaService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("memorabilia")
public class MemorabiliaController extends BaseController {

    @Autowired
    private IMemorabiliaService memorabiliaService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, MemorabiliaQueryParams memorabiliaQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<MemorabiliaModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(memorabiliaQueryParams);
        List<MemorabiliaModel> list = memorabiliaService.list(sqlQueryParams);

        list = memorabiliaService.selected(list);
        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public void add(@RequestBody @Valid MemorabiliaModel memorabiliaModel) throws ParseException {

        memorabiliaModel.setCurrentTime(TimeHelper.stringToDate(memorabiliaModel.getCurrentDate()));
        this.memorabiliaService.save(memorabiliaModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid MemorabiliaModel memorabiliaModel) throws ParseException {

        memorabiliaModel.setCurrentTime(TimeHelper.stringToDate(memorabiliaModel.getCurrentDate()));
        this.memorabiliaService.update(memorabiliaModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.memorabiliaService.remove(guid);
    }

    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, String currentTime) {

        return memorabiliaService.upFile(file, currentTime);
    }
}
