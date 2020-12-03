package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.ProjectModel;

import java.util.List;


public interface ProjectMapper extends BaseMapper<ProjectModel> {

    @Select("select project_key from project")
    List<String> project_key();

    @Select("SELECT guid, name FROM project")
    List<ProjectModel> selectAll1();

    @Select("SELECT guid from project order by sortId")
    List<String> allProjectId();

}
