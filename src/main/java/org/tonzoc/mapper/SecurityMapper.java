package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.SecurityModel;

import java.util.Date;

public interface SecurityMapper extends BaseMapper<SecurityModel> {

    @Update("update securitys set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
