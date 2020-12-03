package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.AerialPhotographyLocationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AerialPhotographyLocationModel;
import org.tonzoc.model.AerialPhotographyModel;
import org.tonzoc.service.IAerialPhotographyLocationService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("aerialPhotographyLocation")
public class AerialPhotographyLocationController extends BaseController {

    @Autowired
    private IAerialPhotographyLocationService aerialPhotographyLocationService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, AerialPhotographyLocationQueryParams aerialPhotographyLocationQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AerialPhotographyModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(aerialPhotographyLocationQueryParams);

        List<AerialPhotographyLocationModel> list = aerialPhotographyLocationService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid AerialPhotographyLocationModel aerialPhotographyLocationModel) {
        this.aerialPhotographyLocationService.save(aerialPhotographyLocationModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid AerialPhotographyLocationModel aerialPhotographyLocationModel) {
        this.aerialPhotographyLocationService.update(aerialPhotographyLocationModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.aerialPhotographyLocationService.remove(guid);
    }

    @PostMapping(value = "import")
    public void importExcel(MultipartFile file, String aerialPhotographyGuid) throws NotFoundException {
        this.aerialPhotographyLocationService.importExcel(file, aerialPhotographyGuid);
    }
}
