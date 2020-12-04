package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.AerialPhotographyQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AerialPhotographyModel;
import org.tonzoc.service.IAerialPhotographyService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "aerialPhotography")
public class AerialPhotographyController extends BaseController {

    @Autowired
    private IAerialPhotographyService aerialPhotographyService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AerialPhotographyQueryParams aerialPhotographyQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AerialPhotographyModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(aerialPhotographyQueryParams);

        List<AerialPhotographyModel> list = aerialPhotographyService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @GetMapping(value = "getFirst")
    public AerialPhotographyModel getFirstByTender(String tenderGuid) throws Exception {
        return this.aerialPhotographyService.getFirstByTender(tenderGuid);
    }

    @GetMapping(value = "listMonth")
    public List<String> listMonth(String tenderGuid) {
        return this.aerialPhotographyService.getDistinctMonth(tenderGuid);
    }

    @PostMapping
    public void add(@RequestBody @Valid AerialPhotographyModel aerialPhotographyModel) {
        this.aerialPhotographyService.save(aerialPhotographyModel);
    }

}
