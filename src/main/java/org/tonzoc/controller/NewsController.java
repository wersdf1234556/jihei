package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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
    public void add(MultipartFile file,@Valid NewsModel newsModel){
        this.newsService.insertStack(newsModel,file);
    }

    @PutMapping(value = "{guid}")
    public void update(MultipartFile file, @Valid NewsModel newsModel) {
        this.newsService.updateStack(newsModel,file);
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
