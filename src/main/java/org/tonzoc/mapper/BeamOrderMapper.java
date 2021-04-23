package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamOrderModel;

public interface BeamOrderMapper extends BaseMapper<BeamOrderModel> {

    @Select("select top 1* from beamOrders where attTime < #{attTime} ORDER BY createdAt desc")
    BeamOrderModel selectByTimeDesc(@Param(value = "attTime") String attTime);
}
