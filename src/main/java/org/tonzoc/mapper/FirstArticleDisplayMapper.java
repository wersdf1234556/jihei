package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.FirstArticleDisplayModel;

import java.util.Date;

@Component
public interface FirstArticleDisplayMapper extends BaseMapper<FirstArticleDisplayModel> {

    @Update("update firstArticleDisplays set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
