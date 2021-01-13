package org.tonzoc.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AttendanceModel;

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
}
