package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.TenderScoreModel;

import java.util.List;

public interface TenderScoreMapper extends BaseMapper<TenderScoreModel>{

    @Update("update tenderScores set isEffect = #{isEffect} where guid = #{guid}")
    void updateScore(@Param(value = "isEffect") String isEffect,
                     @Param(value = "guid") String guid);

    @Select("select tenders.name, ISNULL(sum(tenderScores.scores), 0) number from (select * from tenders where tenders.name like '%A%' or name like '%B%') tenders " +
    "LEFT JOIN (select * from tenderScores where isEffect = '1') tenderScores on tenders.guid = tenderScores.tenderGuid " +
    "GROUP BY tenders.name, tenders.sortId ORDER BY tenders.sortId asc")
    List<ReturnModel> tenderScores();

    @Select("select scores number, createdAt proportion, guid name from tenderScores where isEffect = '1'")
    List<ReturnModel> allScores();

}