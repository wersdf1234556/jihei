package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.CameraModel;

public interface CameraMapper extends BaseMapper<CameraModel> {

    @Select("SELECT MAX(serialNum) FROM cameras")
    Integer maxSerial();
}
