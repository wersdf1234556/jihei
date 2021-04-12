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
            "LEFT JOIN tenders t ON mainTable.tenderGuid=t.guid " +
            "where t.name LIKE '%${tenderName}%' and mainTable.[date] like '${date}%' " +
            "and mainTable.[date] not like '${neqDate}%' " +
            "and mainTable.progressNameGuid=#{progressNameGuid} " +
            "and mainTable.status='finish'")
    List<ProgressDetailModel> listByProgressNameLikeDate(@Param(value = "tenderName") String tenderName,
                                                         @Param(value = "date") String date,
                                                         @Param(value = "neqDate") String neqDate,
                                                         @Param(value = "progressNameGuid") String progressNameGuid);

    @Select("SELECT mainTable.progressNameGuid,pn.name as progressName, mainTable.num, mainTable.[date] from progressDetails mainTable" +
            " LEFT JOIN progressNames pn on mainTable.progressNameGuid = pn.guid" +
            " LEFT JOIN tenders t ON mainTable.tenderGuid = t.guid" +
            " where t.name LIKE '%${tenderName}%' and mainTable.[date] < #{date}" +
            " and mainTable.progressNameGuid = #{progressNameGuid}" +
            " and mainTable.status = 'finish'")
    List<ProgressDetailModel> listByProgressNameLtDate(@Param(value = "tenderName") String tenderName,
                                                       @Param(value = "date") String date,
                                                       @Param(value = "progressNameGuid") String progressNameGuid);

//    @Select("SELECT mainTable.progressNameGuid,pn.name as progressName,mainTable.num,mainTable.[date] from progressDetails mainTable " +
//            "LEFT JOIN progressNames pn on mainTable.progressNameGuid=pn.guid " +
//            "LEFT JOIN tenders t ON mainTable.tenderGuid=t.guid " +
//            "where t.name LIKE '%${tenderName}%' and Convert(varchar,mainTable.[createdAt],120) like '%${createdAt}%' " +
//            "and mainTable.progressNameGuid=#{progressNameGuid} " +
//            "and mainTable.status='finish'")
//    List<ProgressDetailModel> listByCreatedAt(@Param(value = "tenderName") String tenderName,@Param(value = "createdAt") String createdAt, @Param(value = "progressNameGuid") String progressNameGuid);
}
