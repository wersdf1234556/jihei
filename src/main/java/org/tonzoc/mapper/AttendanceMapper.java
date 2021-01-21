package org.tonzoc.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.support.AttDateStatModel;
import org.tonzoc.model.support.AttendanceStatModel;

import java.util.List;
@Component
public interface AttendanceMapper extends BaseMapper<AttendanceModel> {

    @Select("SELECT mainTable.guid,mainTable.idCard,mainTable.createdAt,mainTable.address FROM attendances mainTable \n" +
            "WHERE (mainTable.idCard = #{idCard} AND Convert(varchar,createdAt,120) LIKE '%${createdAt}%') ")
    List<AttendanceModel> listBySignAndDate(@Param(value = "idCard") String idCard, @Param(value = "createdAt") String createdAt);

    @Select("SELECT mainTable.guid,mainTable.idCard,mainTable.createdAt,mainTable.address FROM attendances mainTable " +
            "LEFT JOIN persons p on mainTable.idCard=p.idCard LEFT JOIN personTypes py on p.personTypeGuid = py.guid " +
            "WHERE (py.guid= #{personTypeGuid} AND Convert(varchar,mainTable.createdAt,120) LIKE '%${createdAt}%') ")
    List<AttendanceModel> listByTypeAndDate(@Param(value = "personTypeGuid") String personTypeGuid, @Param(value = "createdAt") String createdAt);

    @Select("SELECT max(temperature) maxTemp,MIN(temperature) minTemp from attendances where Convert(varchar,createdAt,120) LIKE '%${createdAt}%'")
    AttDateStatModel findMaxAndMinTemp(@Param(value = "createdAt") String createdAt);

    @Select("SELECT count(DISTINCT(a.idCard)) attNum from attendances a LEFT JOIN persons p on a.idCard=p.idCard " +
            "LEFT JOIN tenders t on p.tenderGuid=t.guid " +
            "where Convert(varchar,a.createdAt,120) LIKE '${createdAt}%' " +
            "and t.name like '%${tenderName}%'")
    Integer countByTenderType(@Param(value = "createdAt") String createdAt,@Param(value = "tenderName") String tenderName);
}
