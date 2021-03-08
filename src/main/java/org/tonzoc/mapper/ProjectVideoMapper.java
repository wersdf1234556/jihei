package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.ProjectVideoModel;

import java.util.Date;

@Component
public interface ProjectVideoMapper extends BaseMapper<ProjectVideoModel> {

    @Update("update projectVideos set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(@Param("currentTime") Date currentTime,
                    @Param("guid") String guid);
}
