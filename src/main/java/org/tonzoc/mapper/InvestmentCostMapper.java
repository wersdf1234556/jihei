package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.InvestmentCostModel;
import org.tonzoc.model.support.CostByTpeModel;

import java.util.List;
@Component
public interface InvestmentCostMapper extends BaseMapper<InvestmentCostModel> {
    @Select("SELECT a.name,\n" +
            "       ROUND(ISNULL(a.totalBalance, 0) / 100000000, 2)     totalBalance,\n" +
            "       ROUND(ISNULL(a.situationBalance, 0) / 100000000, 2) situationBalance,\n" +
            "       (CASE\n" +
            "            WHEN totalBalance > 0 then CAST(\n" +
            "                    ISNULL((CONVERT(DECIMAL(38, 2), situationBalance) / CONVERT(DECIMAL(38, 2), totalBalance)) * 100,\n" +
            "                           0) as NUMERIC(38, 2))\n" +
            "            ELSE 0 end)                                    percentNum\n" +
            "from (SELECT ic.guid,\n" +
            "             ic.name,\n" +
            "             SUM(ic.balance)  totalBalance,\n" +
            "             SUM(ins.balance) situationBalance,\n" +
            "             ic.sortId\n" +
            "      FROM investmentCost ic\n" +
            "               LEFT JOIN (\n" +
            "          select investmentCostGuid, sum(balance) as balance\n" +
            "          from investmentSituation\n" +
            "          group by investmentCostGuid\n" +
            "      ) ins on ic.guid = ins.investmentCostGuid\n" +
            "      WHERE ic.flag = 0\n" +
            "      GROUP By ic.sortId, ic.guid, ic.name\n" +
            "     ) a\n" +
            "ORDER BY a.sortId")
    List<CostByTpeModel> statBySituation();
//    @Select("SELECT a.name,ROUND(ISNULL(a.totalBalance, 0)/100000000, 2) totalBalance,ROUND(ISNULL(a.situationBalance, 0)/100000000,2) situationBalance, " +
//            "(CASE WHEN totalBalance>0 then ISNULL((CONVERT(DECIMAL(38,2),situationBalance)/CONVERT(DECIMAL(38,2),totalBalance)),0)*100  " +
//            "ELSE 0 end) percentNum " +
//            " from (SELECT ic.guid,ic.name,SUM(ic.balance) totalBalance,SUM(ins.balance) situationBalance, " +
//            "ic.sortId " +
//            "FROM investmentCost ic LEFT JOIN investmentSituation ins on ic.guid= ins.investmentCostGuid " +
//            "WHERE ic.flag=0 " +
//            " GROUP By ic.sortId,ic.guid,ic.name " +
//            ") a ORDER BY a.sortId")
}
