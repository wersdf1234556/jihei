package org.tonzoc.service;

import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.support.BuildSafetyStatModel;
import org.tonzoc.model.support.CostByTpeModel;
import org.tonzoc.model.support.CostModel;
import org.tonzoc.model.support.TypeModel;

import java.util.List;

public interface IInvestmentCostService extends IBaseService<InvestmentCostModel> {

    CostModel statCost();

    List<TypeModel> statByEachItem();

    List<CostByTpeModel> statBySituation();

    List<BuildSafetyStatModel> statByBuildSafety(Integer flag, String date);

    List<CostByTpeModel> statByTender();
}
