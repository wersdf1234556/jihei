package org.tonzoc.service;

import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.support.CostByTpeModel;
import org.tonzoc.model.support.CostModel;
import org.tonzoc.model.support.TypeModel;

import java.util.List;

public interface IInvestmentCostService extends IBaseService<InvestmentCostModel> {
    CostModel statCost();
    List<TypeModel> statByEachItem();
    List<CostByTpeModel> statBySituation();
    List<CostByTpeModel> statByBuildSafety(Integer flag);
    List<CostByTpeModel> statByTender();
}
