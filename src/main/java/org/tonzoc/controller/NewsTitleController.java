package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.NewsQueryParams;
import org.tonzoc.controller.params.NewsTitleQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.NewsModel;
import org.tonzoc.model.NewsTitleModel;
import org.tonzoc.service.INewsService;
import org.tonzoc.service.INewsTitleService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("newsTitle")
public class NewsTitleController extends BaseController {

    @Autowired
    private INewsTitleService newsTitleService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, NewsTitleQueryParams newsQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<NewsTitleModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(newsQueryParams);

        List list = newsTitleService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid NewsTitleModel newsTitleModel ) {
        this.newsTitleService.save(newsTitleModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid NewsTitleModel newsTitleModel) {
        this.newsTitleService.update(newsTitleModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.newsTitleService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        newsTitleService.removeMany(guids);
    }
}
