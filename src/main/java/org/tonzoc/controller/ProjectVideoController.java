package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.ProjectVideoQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.ProjectVideoModel;
import org.tonzoc.service.IProjectVideoService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("projectVideo")
public class ProjectVideoController extends BaseController{

    @Autowired
    private IProjectVideoService projectVideoService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, ProjectVideoQueryParams projectVideoQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<ProjectVideoModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(projectVideoQueryParams);
        List<ProjectVideoModel> list = projectVideoService.list(sqlQueryParams);
        list = projectVideoService.selected(list);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid ProjectVideoModel projectVideoModel) throws ParseException {

        projectVideoModel.setCurrentTime(TimeHelper.stringToDate(projectVideoModel.getCurrentDate()));
        this.projectVideoService.save(projectVideoModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid ProjectVideoModel projectVideoModel) throws ParseException {

        projectVideoModel = projectVideoService.updateTime(projectVideoModel);
        this.projectVideoService.update(projectVideoModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.projectVideoService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        projectVideoService.removeMany(guids);
    }

    // 上传文件
    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file, String currentDate) {

        return projectVideoService.upFile(file, currentDate);
    }
}
