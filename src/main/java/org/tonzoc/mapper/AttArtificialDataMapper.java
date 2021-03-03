package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AttArtificialDataModel;
import org.tonzoc.model.support.AttendanceStatModel;

import java.util.List;
@Component
public interface AttArtificialDataMapper extends BaseMapper<AttArtificialDataModel> {

    @Select("select py.name typeName, SUM(ISNULL(a.personNum, 0)) total ,SUM(ISNULL(a.attNum, 0)) attNum from " +
            "(select DISTINCT name,guid,parentId,sortId from personTypes WHERE flag=#{flag} ) py " +
            "LEFT JOIN (select personTypeGuid,tenderGuid, attNum ,personNum from attArtificialDatas " +
            ") a on py.guid = a.personTypeGuid " +
            "where py.parentId!='0' " +
            "GROUP BY py.sortId,py.name " +
            "ORDER BY py.sortId asc,py.name asc")
    List<AttendanceStatModel> statAtt(@Param(value = "flag") Integer flag);

    @Select("select py.name typeName, SUM(ISNULL(a.personNum, 0)) total ,SUM(ISNULL(a.attNum, 0)) attNum from " +
            "(select DISTINCT name,guid,parentId,sortId from personTypes WHERE flag=#{flag}) py " +
            "LEFT JOIN (select personTypeGuid,tenderGuid, attNum ,personNum from attArtificialDatas " +
            "where tenderGuid = #{tenderGuid} " +
            ") a on py.guid = a.personTypeGuid  " +
            "where py.parentId!='0' " +
            "GROUP BY py.sortId,py.name " +
            "ORDER BY py.sortId asc,py.name asc")
    List<AttendanceStatModel> statAttByTender(@Param(value = "flag") Integer flag,@Param(value = "tenderGuid") String tenderGuid);
}
