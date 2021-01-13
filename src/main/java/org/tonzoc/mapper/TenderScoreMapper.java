package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.TenderScoreModel;

import java.util.List;

public interface TenderScoreMapper extends BaseMapper<TenderScoreModel>{

    @Select("select tenderScores.guid, tenderScores.tenderGuid, tenderScores.scores, tenderScores.sortId, tenders.name tenderName, tenders.organization tenderOrganization " +
            "from tenderScores LEFT JOIN tenders on tenderScores.tenderGuid = tenders.guid ORDER BY scores desc, sortId asc")
    List<TenderScoreModel> display ();
}