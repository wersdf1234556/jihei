package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.support.CostByTpeModel;

import java.util.List;
@Component
public interface InvestmentCostMapper extends BaseMapper<InvestmentCostModel> {
    @Select("SELECT a.name,ISNULL(a.totalBalance, 0) totalBalance,ISNULL(a.situationBalance, 0) situationBalance, " +
            "ISNULL((CONVERT(DECIMAL(38,2),situationBalance)/CONVERT(DECIMAL(38,2),totalBalance)),0) percentNum " +
            " from (SELECT ic.guid,ic.name,SUM(ic.balance) totalBalance,SUM(ins.balance) situationBalance, " +
            "ic.sortId " +
            "FROM investmentCost ic LEFT JOIN investmentSituation ins on ic.guid= ins.investmentCostGuid " +
            "WHERE ic.flag=0 " +
            " GROUP By ic.sortId,ic.guid,ic.name " +
            ") a ORDER BY a.sortId")
    List<CostByTpeModel> statBySituation();
}
