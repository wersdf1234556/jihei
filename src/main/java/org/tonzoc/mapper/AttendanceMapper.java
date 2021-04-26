package org.tonzoc.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.tonzoc.model.AttendanceModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.*;
import org.tonzoc.provider.AttendanceProvider;

import java.util.List;
@Component
public interface AttendanceMapper extends BaseMapper<AttendanceModel> {

    @Select("SELECT mainTable.guid,mainTable.idCard,mainTable.createdAt,mainTable.address FROM attendances mainTable \n" +
            "WHERE (mainTable.personGuid = #{personGuid} AND Convert(varchar,createdAt,120) LIKE '%${createdAt}%') ")
    List<AttendanceModel> listBySignAndDate(@Param(value = "personGuid") String personGuid, @Param(value = "createdAt") String createdAt);

    @Select("SELECT mainTable.guid,p.idCard,mainTable.attTime,mainTable.address FROM attendances mainTable " +
            "LEFT JOIN persons p on mainTable.personGuid=p.guid LEFT JOIN personTypes py on p.personTypeGuid = py.guid " +
            "WHERE (py.guid= #{personTypeGuid} AND mainTable.attTime LIKE '%${attTime}%') ")
    List<AttendanceModel> listByTypeAndDate(@Param(value = "personTypeGuid") String personTypeGuid, @Param(value = "attTime") String attTime);

    @Select("SELECT max(temperature) maxTemp,MIN(temperature) minTemp from attendances where attTime LIKE '%${attTime}%'")
    AttDateStatModel findMaxAndMinTemp(@Param(value = "attTime") String attTime);

    @Select("SELECT count(DISTINCT(a.personGuid)) attNum from attendances a LEFT JOIN persons p on a.personGuid=p.guid " +
            "LEFT JOIN tenders t on p.tenderGuid=t.guid " +
            "where Convert(varchar,a.createdAt,120) LIKE '${createdAt}%' " +
            "and t.name like '%${tenderName}%'")
    Integer countByTenderType(@Param(value = "createdAt") String createdAt,@Param(value = "tenderName") String tenderName);

    //人员定位获取
    @Select("select * from " +
            "(" +
            "select attendances.guid attGuid,persons.guid personGuid,persons.name,persons.categoryGuid,personCategory.name categoryName , " +
            "persons.personTypeGuid personTypeGuid,personTypes.name personTypeName,attendances.lat,attendances.lng,personCategory.colour colour,personTypes.number,attendances.createdAt,personCategory.flag, " +
            "ROW_NUMBER() OVER (PARTITION BY persons.guid ORDER BY attendances.createdAt DESC) rowrId " +
            "from persons LEFT JOIN attendances on persons.guid=attendances.personGuid LEFT JOIN personCategory on persons.categoryGuid=personCategory.guid  " +
            "LEFT JOIN personTypes on persons.personTypeGuid=personTypes.guid " +
            ")b where b.rowrId=1 and b.attGuid is not NULL " +
            "and Convert(varchar, b.createdAt ,120)like '%${createdAt}%' " +
            "and b.categoryGuid=#{categoryGuid}")
    List<PersonLocationDataModel> listPersonLocationDatas(@Param(value = "categoryGuid") String categoryGuid,@Param(value = "createdAt") String createdAt);

    //获取人员类别当日打卡数
    @Select("SELECT * from attendances a LEFT JOIN persons p on a.personGuid = p.guid " +
            "where p.categoryGuid=#{categoryGuid} " +
            "and Convert(VARCHAR,a.createdAt,120)  LIKE  '%${createdAt}%'")
    List<AttendanceModel> listAttByCategory(@Param(value = "categoryGuid") String categoryGuid,@Param(value = "createdAt") String createdAt);

    //获取人员类型当日打卡数
    @Select("select * from (select DISTINCT attendances.personGuid from attendances where attTime like '%${attTime}%') attendances" +
            " LEFT JOIN persons on attendances.personGuid = persons.guid" +
            " where personTypeGuid = #{personTypeGuid}")
    List<AttendanceModel> listAttByType(@Param(value = "personTypeGuid") String personTypeGuid,
                                        @Param(value = "attTime") String attTime);


    // 预警信息
    @Select("select distinct top 50 persons.name as personName, tenders.name as tenderName, attendances.personGuid, attendances.attTime, attendances.temperature, attendances.address" +
            " from attendances inner join (select personGuid, max(attTime) as attTime from attendances" +
            " where CONVERT(varchar(10), attTime, 23) = CONVERT(varchar(10), getdate(), 23)" +
            " group by personGuid) attendances1 on attendances.personGuid = attendances1.personGuid and attendances.attTime = attendances1.attTime" +
            " inner join persons on persons.guid = attendances.personGuid" +
            " inner join tenders on persons.tenderguid = tenders.guid" +
            " order by tenders.name, attTime desc")
    List<AttendanceModel> warningInformation();

    // 测温情况
    @Select("select name, sortId, sum(rencount) as rencount,sum(cewenrencount) as cewenrencount from (" +
            " select tenders.name, tenders.sortId, count(*) as rencount,0 as cewenrencount from persons" +
            " inner join tenders on persons.tenderguid=tenders.guid" +
            " group by tenders.sortId, tenders.name" +
            " union all" +
            " select tenders.name, tenders.sortId, 0 as rencount,count(*) as cewenrencount from persons" +
            " inner join tenders on persons.tenderguid = tenders.guid" +
            " inner join (select personGuid from attendances where CONVERT(varchar(10), attTime, 23) =CONVERT(varchar(100), GETDATE(), 23)) attendances on attendances.personGuid=persons.guid" +
            " group by tenders.sortId, tenders.name) persons group by name, sortId order by sortId")
    List<ReturnPersonModel> temperature();

    // 统计超温的测温人数
    @Select("select distinct personGuid from attendances where attTime like '%${attTime}%' and status = 1")
    List<String> temperatureNumber(@Param(value = "attTime") String attTime);

    // 打卡人数
    @Select("select count(DISTINCT personGuid) from attendances " +
            " LEFT JOIN persons on attendances.personGuid = persons.guid " +
            " where persons.personTypeGuid = #{personGuid} and attTime like '%${attTime}%'")
    Integer arrivePerson(@Param(value = "personGuid") String personGuid,
                         @Param(value = "attTime") String attTime);

    // 按照人员类别查询当天打卡人数
    @Select("select personCategory.name, personCategory.guid proportion, count(DISTINCT attendances.personGuid) number from personCategory" +
            " LEFT JOIN personTypes on personCategory.guid = personTypes.categoryGuid" +
            " LEFT JOIN persons on persons.personTypeGuid = personTypes.guid" +
            " LEFT JOIN (select * from attendances where attTime like '%${attTime}%') attendances on persons.guid = attendances.personGuid" +
            " GROUP BY personCategory.name, personCategory.guid")
    List<ReturnModel> listByAttTime(@Param(value = "attTime") String attTime);

    @SelectProvider(type = AttendanceProvider.class, method = "securityPerson")
    List<PersonModel> securityPerson(@Param(value = "attTime") String attTime,
                                     @Param(value = "name") String name,
                                     @Param(value = "personTypeGuid") String personTypeGuid,
                                     @Param(value = "tenderGuid") String tenderGuid,
                                     @Param(value = "flag") Integer flag,
                                     @Param(value = "categoryGuid") String categoryGuid);

}
