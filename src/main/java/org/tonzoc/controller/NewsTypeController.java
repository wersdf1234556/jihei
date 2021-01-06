package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.NewsTypeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.NewsTypeModel;
import org.tonzoc.service.INewsTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("newsType")
public class NewsTypeController extends BaseController {

    @Autowired
    private INewsTypeService newsTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, NewsTypeQueryParams newsTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<NewsTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(newsTypeQueryParams);

        List list = newsTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid NewsTypeModel newsTypeModel ) {
        this.newsTypeService.save(newsTypeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid NewsTypeModel newsTypeModel) {
        this.newsTypeService.update(newsTypeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.newsTypeService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        newsTypeService.removeMany(guids);
    }
}
