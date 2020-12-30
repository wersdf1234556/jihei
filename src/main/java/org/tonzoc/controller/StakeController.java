package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.params.StakeQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.AerialPhotographyModel;
import org.tonzoc.model.StakeModel;
import org.tonzoc.service.IStakeService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("stake")
public class StakeController extends BaseController {

    @Autowired
    private IStakeService stakeService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, StakeQueryParams stakeQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<AerialPhotographyModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(stakeQueryParams);

        List<StakeModel> list = stakeService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid StakeModel stakeModel) {
        this.stakeService.save(stakeModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid StakeModel stakeModel) {
        this.stakeService.update(stakeModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.stakeService.remove(guid);
    }

    @PostMapping(value = "import")
    public void importExcel(MultipartFile file, String tenderGuid) throws NotFoundException {
        this.stakeService.importExcel(file, tenderGuid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) {
        this.stakeService.removeMany(guids);
    }

}
