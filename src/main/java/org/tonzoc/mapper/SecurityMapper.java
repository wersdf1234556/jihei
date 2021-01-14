package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.SecurityModel;


public interface SecurityMapper extends BaseMapper<SecurityModel> {

    @Select("select sum(score) from securitys where documentGuid = #{documentGuid} and tenderGuid = #{tenderGuid}")
    Integer score(String documentGuid, String tenderGuid);
}
