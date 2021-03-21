package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BuildingSafetyQueryParams;
import org.tonzoc.controller.params.InvestmentSituationQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.InvestmentSituationModel;
import org.tonzoc.service.IInvestmentSituationService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("investmentSituation")
public class InvestmentSituationController extends BaseController{
    @Autowired
    private IInvestmentSituationService investmentSituationService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, InvestmentSituationQueryParams investmentSituationQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<InvestmentSituationModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(investmentSituationQueryParams);
        List<InvestmentSituationModel> list = investmentSituationService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid InvestmentSituationModel investmentSituationModel) {

        this.investmentSituationService.save(investmentSituationModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid InvestmentSituationModel investmentSituationModel) {

        this.investmentSituationService.update(investmentSituationModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.investmentSituationService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        investmentSituationService.removeMany(guids);
    }
}
