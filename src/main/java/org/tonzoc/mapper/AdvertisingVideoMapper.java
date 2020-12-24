package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.AdvertisingVideoModel;

import java.util.Date;

public interface AdvertisingVideoMapper extends BaseMapper<AdvertisingVideoModel> {

    @Update("update advertisingVideos set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
