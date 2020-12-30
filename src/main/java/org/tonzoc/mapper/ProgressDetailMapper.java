package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.ProgressDetailModel;

import java.util.List;
@Component
public interface ProgressDetailMapper extends BaseMapper<ProgressDetailModel> {
    @Select("SELECT mainTable.progressNameGuid,pn.name as progressName,mainTable.num,mainTable.[date] from progressDetails mainTable \n" +
            "LEFT JOIN progressNames pn on mainTable.progressNameGuid=pn.guid \n" +
            "LEFT JOIN tenders t ON mainTable.tenderGuid=t.guid where t.name LIKE '%${tenderName}%' and mainTable.[date]<=#{date} and mainTable.progressNameGuid=#{progressNameGuid}")
    List<ProgressDetailModel> listByProgressNameAndDate(@Param(value = "tenderName") String tenderName,@Param(value = "date") String date, @Param(value = "progressNameGuid") String progressNameGuid);

}