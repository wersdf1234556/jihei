package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.PersonScoreModel;

import java.util.List;

public interface PersonScoreMapper extends BaseMapper<PersonScoreModel> {

    @Select("select personScores.guid, personScores.personGuid, personScores.tenderGuid, personScores.scores, personScores.sortId, tenders.name tenderName, persons.name personName " +
            "from personScores LEFT JOIN tenders on personScores.tenderGuid = tenders.guid " +
            "LEFT JOIN persons on personScores.personGuid = persons.guid ORDER BY scores desc, sortId asc")
    List<PersonScoreModel> display ();
}
