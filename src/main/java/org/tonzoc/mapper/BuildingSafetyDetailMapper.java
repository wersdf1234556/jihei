package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.model.support.CostByTpeModel;

import java.util.List;
@Component
public interface BuildingSafetyDetailMapper extends BaseMapper<BuildingSafetyDetailModel>  {

    @Select("SELECT a.name,ISNULL(a.totalBalance, 0) totalBalance,ISNULL(a.situationBalance, 0) situationBalance, " +
            "ISNULL((CONVERT(DECIMAL(38,2),situationBalance)/CONVERT(DECIMAL(38,2),totalBalance)),0) percentNum " +
            "from (SELECT t.guid,t.name,SUM(t.balance) totalBalance,SUM(bd.balance) situationBalance, " +
            "t.sortId " +
            "FROM tenders t LEFT JOIN buildingSafetyDetails bd on bd.tenderGuid = t.guid " +
            "where t.name LIKE 'A%' or t.name LIKE 'B%' " +
            "GROUP By t.sortId,t.guid,t.name " +
            ") a ORDER BY a.sortId")
    List<CostByTpeModel> statByTender();
}
