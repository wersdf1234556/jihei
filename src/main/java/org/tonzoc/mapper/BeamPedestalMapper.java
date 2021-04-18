package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.support.ReturnListModel;

import java.util.List;

public interface BeamPedestalMapper extends BaseMapper<BeamPedestalModel>{

    @Select("select status name, count(guid) number from beamPedestals" +
            " GROUP BY beamPedestals.status")
    List<ReturnListModel> listByStatus();

    @Select("select * from beamPedestals where name = #{name}")
    BeamPedestalModel selectByName(@Param(value = "name") String name);
}
