package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.SubTypeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.ISubTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("subType")
public class SubTypeController extends BaseController {

    @Autowired
    private ISubTypeService subTypeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, SubTypeQueryParams subTypeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<SubTypeModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(subTypeQueryParams);
        List<SubTypeModel> list = subTypeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);

    }

    @PostMapping
    public String add(@RequestBody @Valid SubTypeModel subTypeModel) {
        if (subTypeService.contain(subTypeModel.getName())) {
            return "不可重复添加";
        }
        this.subTypeService.save(subTypeModel);
        return "添加成功";
    }

    @PutMapping(value = "{guid}")
    public String update(@RequestBody @Valid SubTypeModel subTypeModel) {
        if (subTypeModel.getName() != null && !subTypeModel.getName().equals("") && subTypeService.contain(subTypeModel.getName())) {
            return "该名称已存在";
        }
        this.subTypeService.update(subTypeModel);
        return "修改成功";
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.subTypeService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        subTypeService.removeMany(guids);
    }
}
