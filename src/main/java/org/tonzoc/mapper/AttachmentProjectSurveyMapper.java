package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.AttachmentProjectSurveyModel;

public interface AttachmentProjectSurveyMapper extends BaseMapper<AttachmentProjectSurveyModel> {

    @Select("select guid from attachmentProjectSurveys where name = #{name} and projectSurveyGuid = #{projectSurveyGuid}")
    String getProjectSurveyGuid (String name, String projectSurveyGuid);
}
