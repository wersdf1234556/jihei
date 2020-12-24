package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.MapInformationModel;

import java.util.Date;
import java.util.List;

public interface MapInformationMapper extends BaseMapper<MapInformationModel> {

    @Select("select top 3 * from mapInformations ORDER BY currentTime desc")
    List<MapInformationModel> three();

    @Update("update mapInformations set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
