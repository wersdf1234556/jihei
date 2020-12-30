package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.QualityTraceabilityModel;

import java.util.Date;
@Component
public interface QualityTraceabilityMapper extends BaseMapper<QualityTraceabilityModel>{

    @Update("update QualityTraceabilitys set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);
}
