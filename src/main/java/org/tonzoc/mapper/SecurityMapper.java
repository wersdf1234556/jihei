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

}
