package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.MapInformationModel;

import java.util.List;

public interface MapInformationMapper extends BaseMapper<MapInformationModel> {

    @Select("select top 3 * from mapInformations ORDER BY currentTime desc")
    List<MapInformationModel> three();
}
