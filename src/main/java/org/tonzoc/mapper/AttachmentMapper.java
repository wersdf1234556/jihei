package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.AttachmentModel;

public interface AttachmentMapper extends BaseMapper<AttachmentModel> {

    @Select("select guid from attachments where url = #{url} and qualityTraceabilityGuid = #{qualityTraceabilityGuid}")
    String getGuid (String url, String qualityTraceabilityGuid);

    @Select("select guid from attachments where name = #{name}")
    String guid (String name);
}
