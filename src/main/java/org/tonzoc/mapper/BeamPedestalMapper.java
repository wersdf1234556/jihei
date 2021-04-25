package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnListModel;
import org.tonzoc.provider.BeamPedestalProvider;

import java.util.List;

public interface BeamPedestalMapper extends BaseMapper<BeamPedestalModel>{

    @Select("select status name, count(guid) number from beamPedestals" +
            " GROUP BY beamPedestals.status")
    List<ReturnModel> listByStatus();

    @SelectProvider(type = BeamPedestalProvider.class, method = "selectByNum")
    BeamPedestalModel selectByNum(@Param(value = "name") String name,
                                  @Param(value = "num") String num);

}
