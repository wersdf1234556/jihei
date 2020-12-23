package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.NewsQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.PersonQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.NewsModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.service.INewsService;
import org.tonzoc.service.IPersonService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController extends BaseController {

    @Autowired
    private INewsService newsService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, NewsQueryParams newsQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<NewsModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(newsQueryParams);

        List list = newsService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid NewsModel newsModel ) {
        this.newsService.save(newsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid NewsModel newsModel) {
        this.newsService.update(newsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.newsService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        newsService.removeMany(guids);
    }
}
