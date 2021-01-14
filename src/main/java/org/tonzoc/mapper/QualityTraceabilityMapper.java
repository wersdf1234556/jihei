package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.QualityTraceabilityModel;

import java.util.Date;
import java.util.List;

@Component
public interface QualityTraceabilityMapper extends BaseMapper<QualityTraceabilityModel>{

    @Update("update QualityTraceabilitys set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(Date currentTime, String guid);

    @Update("update qualityTraceabilitys set sortId = (select sortId from subTypes where guid = #{subTypeGuid}) where subTypeGuid = #{subTypeGuid}")
    void updateSortId(String subTypeGuid);
}
