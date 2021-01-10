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

    @Select("select qualityTraceabilitys.*, subTypes.name subTypeName, tenders.name tenderName, types.name typeName from qualityTraceabilitys " +
            "LEFT JOIN subTypes on qualityTraceabilitys.subTypeGuid = subTypes.guid " +
            "LEFT JOIN tenders on qualityTraceabilitys.tenderGuid = tenders.guid " +
            "LEFT JOIN types on qualityTraceabilitys.typeId = types.id " +
            "ORDER BY qualityTraceabilitys.currentTime, subTypes.name asc")
    List<QualityTraceabilityModel> selectSortName ();
}
