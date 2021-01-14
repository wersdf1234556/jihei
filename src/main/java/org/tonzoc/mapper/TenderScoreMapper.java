package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.TenderScoreModel;

public interface TenderScoreMapper extends BaseMapper<TenderScoreModel>{

    @Select("select * from tenderScores where tenderGuid = #{tenderGuid}")
    TenderScoreModel selectByTender(String tenderGuid);

    @Update("update from tenderScores set score = #{score}")
    void updateScore(Integer score);
}