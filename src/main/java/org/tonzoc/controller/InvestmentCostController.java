package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.InvestmentCostQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.support.CostByTpeModel;
import org.tonzoc.model.support.CostModel;
import org.tonzoc.model.support.TypeModel;
import org.tonzoc.service.IInvestmentCostService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("investmentCost")
public class InvestmentCostController extends BaseController{
    @Autowired
    private IInvestmentCostService investmentCostService;
    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, InvestmentCostQueryParams investmentCostQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<InvestmentCostModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(investmentCostQueryParams);
        List<InvestmentCostModel> list = investmentCostService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid InvestmentCostModel investmentCostModel) {

        this.investmentCostService.save(investmentCostModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid InvestmentCostModel investmentCostModel) {

        this.investmentCostService.update(investmentCostModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {

        this.investmentCostService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {

        investmentCostService.removeMany(guids);
    }

    //进度统计左上角投资总额
    @GetMapping(value = "statCost")
    public CostModel statCost(){
        return investmentCostService.statCost();
    }

    //左上角饼图各投资项占比
    @GetMapping(value = "statByEachItem")
    public List<TypeModel> statByEachItem(){
        return investmentCostService.statByEachItem();
    }

    //左边中间各投资项的累计投资比例
    @GetMapping(value = "statBySituation")
    public List<CostByTpeModel> statBySituation(){
        return investmentCostService.statBySituation();
    }

    //左下角建安费分项统计
    @GetMapping(value = "statByBuildSafety")
    public List<CostByTpeModel> statByBuildSafety(Integer flag){
        return investmentCostService.statByBuildSafety(flag);
    }
    //右侧按标段统计总产值和累计产值
    @GetMapping(value = "statByTender")
    public List<CostByTpeModel> statByTender(){
        return investmentCostService.statByTender();
    }

}
