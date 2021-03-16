package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AdvertisingVideoModel;

import java.util.Date;
@Component
public interface AdvertisingVideoMapper extends BaseMapper<AdvertisingVideoModel> {

    @Update("update advertisingVideos set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(@Param("currentTime") Date currentTime,
                    @Param("guid") String guid);
}
