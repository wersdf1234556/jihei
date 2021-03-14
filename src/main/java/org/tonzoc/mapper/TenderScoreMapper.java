package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.TenderScoreModel;

public interface TenderScoreMapper extends BaseMapper<TenderScoreModel>{

    @Update("update tenderScores set isEffect = #{isEffect} where guid = #{guid}")
    void updateScore(String isEffect, String guid);
}