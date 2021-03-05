package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.AttachmentSecurityModel;

public interface AttachmentSecurityMapper extends BaseMapper<AttachmentSecurityModel> {

    @Select("select guid from attachmentSecuritys where name = #{name} and securityGuid = #{securityGuid}")
    String getSecurityGuid (String name, String securityGuid);

    @Select("select guid from attachmentSecuritys where name = #{name} and securityGuid = #{securityChangGuid}")
    String getSecurityChangGuid (String name, String securityChangGuid);
}
