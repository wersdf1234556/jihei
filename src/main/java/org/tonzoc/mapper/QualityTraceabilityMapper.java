package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.tonzoc.model.QualityTraceabilityModel;
import org.tonzoc.model.ReturnModel;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Component
public interface QualityTraceabilityMapper extends BaseMapper<QualityTraceabilityModel>{

    @Update("update QualityTraceabilitys set currentTime = #{currentTime} where guid = #{guid}")
    void updateTime(@Param("currentTime") Date currentTime, @Param("guid")String guid);

    @Update("update qualityTraceabilitys set sortId = (select sortId from subTypes where guid = #{subTypeGuid}) where subTypeGuid = #{subTypeGuid}")
    void updateSortId(@Param("subTypeGuid")String subTypeGuid);

    @Select("select count(guid) from qualityTraceabilitys")
    Integer count();

    @Select("select count(qualityTraceabilitys.guid) number, types.name from qualityTraceabilitys " +
            "LEFT JOIN types on qualityTraceabilitys.typeId = types.id GROUP BY types.name")
    List<ReturnModel> traceabilityCount();

    @Select("select count(qualityTraceabilitys.guid) number, types.name from types " +
            "LEFT JOIN (select * from qualityTraceabilitys where qualityTraceabilitys.tenderGuid = #{tenderGuid}) qualityTraceabilitys on qualityTraceabilitys.typeId = types.id " +
            "GROUP BY types.name")
    List<ReturnModel> tenderCount(@Param("tenderGuid")String tenderGuid);

    // 修改时
    @Select("select name from qualityTraceabilitys where guid != #{guid}")
    List<String> listGuid(@Param("guid")String guid);

    // 添加时
    @Select("select name from qualityTraceabilitys where name != #{name}")
    List<String> listName(@Param("guid")String guid);

    // 修改状态
    @Update("update qualityTraceabilitys set status = #{status}, approvalTime = #{approvalTime}, " +
            "currentTenderGuid = #{currentTenderGuid} where guid = #{guid}")
    void updateStatus(@Param(value = "status") String status,
                      @Param(value = "approvalTime") String approvalTime,
                      @Param(value = "currentTenderGuid") String currentTenderGuid,
                      @Param(value = "guid") String guid);

    @Select("select tenders.name, count(qualityTraceabilitys.guid) number, tenders.guid proportion from (select * from tenders where tenders.name like '%A%' or tenders.name like '%B%' ) tenders " +
            "LEFT JOIN (select * from qualityTraceabilitys where typeId = #{typeId}) qualityTraceabilitys on tenders.guid = qualityTraceabilitys.tenderGuid " +
            "GROUP BY tenders.name, tenders.guid, tenders.sortId ORDER BY tenders.sortId")
    List<ReturnModel> tenderAndNumber(@Param(value = "typeId") Integer typeId);

    @Select("select count(qualityTraceabilitys.guid) from qualityTraceabilitys where tenderGuid = #{tenderGuid} and typeId = #{typeId}")
    Integer countByTenderByType(@Param(value = "tenderGuid") String tenderGuid,
                                @Param(value = "typeId") Integer typeId);

}