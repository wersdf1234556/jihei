package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.ReturnModel;

import java.util.List;
@Component
public interface AttachmentMapper extends BaseMapper<AttachmentModel> {

    @Select("select count(attachments.guid) as count, subType.name from attachments " +
            "LEFT JOIN subType on attachments.subTypeId = subType.guid " +
            "where attachments.typesId = '520891F0-1FDE-43EB-A8B2-CB588E31FBBA' and attachments.projectId = #{projectId} GROUP BY subType.name ")
    List<ReturnModel> dataCount(String projectId);

    @Select("select guid from attachments where url = #{url} and qualityTraceabilityGuid = #{qualityTraceabilityGuid}")
    String getGuid(String url, String qualityTraceabilityGuid);

}
