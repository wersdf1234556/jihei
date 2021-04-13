package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.model.support.CostByTpeModel;

import javax.validation.Valid;
import java.util.List;
@Component
public interface BuildingSafetyDetailMapper extends BaseMapper<BuildingSafetyDetailModel>  {

    @Select("SELECT a.name,ROUND(ISNULL(a.totalBalance, 0)/100000000, 2) totalBalance,ROUND(ISNULL(a.situationBalance, 0)/100000000,2) situationBalance, " +
            "(CASE WHEN totalBalance>0 then ISNULL((CONVERT(DECIMAL(38,2),situationBalance)/CONVERT(DECIMAL(38,2),totalBalance)),0)*100  " +
            "ELSE 0 end) percentNum " +
            "from (SELECT t.guid,t.name,SUM(t.balance) totalBalance,SUM(bd.balance) situationBalance," +
            "t.sortId " +
            "FROM tenders t LEFT JOIN buildingSafetyDetails bd on bd.tenderGuid = t.guid " +
            "where t.name LIKE 'A%' or t.name LIKE 'B%' " +
            "GROUP By t.sortId,t.guid,t.name " +
            ") a ORDER BY a.sortId")
    List<CostByTpeModel> statByTender();

    @Select("SELECT pn.name as safetyName, mainTable.balance from buildingSafetyDetails mainTable" +
            " LEFT JOIN buildingSafety pn on mainTable.safetyGuid = pn.guid" +
            " where mainTable.[date] like '%${likeDate}%' and mainTable.[date] < #{ltDate}" +
            " and pn.guid = #{buildingSafetyGuid}")
    List<BuildingSafetyDetailModel> statByYearMonthSituation(@Param(value = "likeDate") String likeDate,
                                                             @Param(value = "ltDate") String ltDate,
                                                             @Param(value = "buildingSafetyGuid") String buildingSafetyGuid);
}
