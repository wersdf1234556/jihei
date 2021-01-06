package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.GradeQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.GradeModel;
import org.tonzoc.model.ProjectModel;
import org.tonzoc.service.IGradeService;
import org.tonzoc.service.IProjectService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("grade")
public class GradeController extends BaseController {

    @Autowired
    private IGradeService gradeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, GradeQueryParams gradeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (pageQueryParams.getOrder()==null||pageQueryParams.getOrder().isEmpty()) {
            pageQueryParams.setOrder("date desc,mainTable.grade desc,mainTable.name");
        }
        if (pageQueryParams.getSort()==null||pageQueryParams.getSort().isEmpty()){
            pageQueryParams.setSort("asc");
        }
        Page<GradeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(gradeQueryParams);

        List list = gradeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid GradeModel gradeModel) {
        this.gradeService.save(gradeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid GradeModel gradeModel) {
        this.gradeService.update(gradeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.gradeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        gradeService.removeMany(guids);
    }
}
