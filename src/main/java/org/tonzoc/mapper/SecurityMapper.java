package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.SecurityRuleModel;

import java.util.List;


public interface SecurityMapper extends BaseMapper<SecurityModel> {

    @Select("select sum(score) from securitys where documentGuid = #{documentGuid} and tenderGuid = #{tenderGuid}")
    Integer score(String documentGuid, String tenderGuid);

    @Select("select count(guid) from securitys")
    Integer count();

    @Select("select count(guid) from securitys where status = #{statue}")
    Integer countStatus(String status);

    // 安全整治排查
    @Select("select *, tenders.name tenderName from securitys LEFT JOIN tenders on securitys.tenderGuid = tenders.guid " +
            "where documentGuid = (select top 1 guid from documents ORDER BY createdAt desc)")
    List<SecurityModel> unsafeSelect();

}
