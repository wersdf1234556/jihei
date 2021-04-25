package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnBeamCount;
import org.tonzoc.model.support.ReturnBeamModel;

import java.util.List;

public interface BeamMapper extends BaseMapper<BeamModel> {

    @Select("select beams.*, tenders.name tenderName, beamPedestals.name beamPedestalName, beamPedestals.status beamPedestalStatus, beamPrefabrications.name beamPrefabricationName, beamPrefabrications.status beamPrefabricationStatus from beams" +
            " LEFT JOIN beamPedestals on beams.beamPedestalGuid = beamPedestals.guid" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " LEFT JOIN tenders on beams.tenderGuid = tenders.guid" +
            " where beamPedestalGuid = #{beamPedestalGuid}")
    List<BeamModel> listHistory(@Param(value = "beamPedestalGuid") String beamPedestalGuid);

    // 新加台座同时状态是空闲的话1 不空闲是0
    @Select("select count(beams.guid) from beams" +
            " LEFT JOIN beamPedestals on beams.beamPedestalGuid = beamPedestals.guid" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " where beams.beamPedestalGuid = #{beamPedestalGuid} and beamPrefabrications.status != 'unSubmit'")
    Integer selectByBeamPedestal(@Param(value = "beamPedestalGuid") String beamPedestalGuid);

    @Select("select count(beams.guid) from beams" +
            " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
            " where beams.beamPrefabricationGuid = #{beamPrefabricationGuid} and beamPrefabrications.status = 'unSubmit'")
    Integer selectByBeamPrefabrication(@Param(value = "beamPrefabricationGuid") String beamPrefabricationGuid);

    @Select("select count(guid) from beamPedestals where tenderGuid = #{tenderGuid}")
    Integer countByTender(@Param(value = "tenderGuid") String tenderGuid);

    @Select("select CASE pedestalNum" +
            " WHEN #{number}     THEN '1'" +
            " ELSE '0' END AS pedestalNum," +
            " CASE modelNum" +
            " WHEN #{number}     THEN '1'" +
            " ELSE '0' END  AS modelNum," +
            " CASE textNum" +
            " WHEN #{number}     THEN '1'" +
            " ELSE '0' END  AS textNum" +
            " from beamPedestals where tenderGuid = #{tenderGuid} and pedestalNum = #{number} or modelNum = #{number} or textNum = #{number}")
    List<BeamPedestalModel> numberByTender(@Param(value = "tenderGuid") String tenderGuid,
                                           @Param(value = "number") String number);

    @Select("select c.guid, a.modelNum, a.name pedestalName, c.name, c.prefabricationNum, c.concreteStrengthOne, c.concreteStrengthTwo, c.concreteStrengthThree, c.remarks, c.status, c.leftAndRight, c.length from beams as b" +
            " left join beamPedestals as a on a.guid = b.beamPedestalGuid" +
            " left join beamPrefabrications as c on c.guid = b.beamPrefabricationGuid " +
            " where b.beamPedestalGuid = (select guid from beamPedestals where modelNum = #{num})")
    List<ReturnBeamModel> selectByNum(@Param(value = "num") String num);

    @Select("select name + leftAndRight from beamPrefabrications" +
            " where tenderGuid = #{tenderGuid}" +
            " GROUP BY name + leftAndRight ORDER BY name + leftAndRight")
    List<String> selectNameAndLeftAndRight(@Param(value = "tenderGuid") String tenderGuid);

    @Select("select * from beamPrefabrications" +
            " where (name + leftAndRight) = #{nameAndLeftAndRight} and tenderGuid = #{tenderGuid} ORDER BY prefabricationNum")
    List<BeamPrefabricationModel> selectPrefabricationNum(@Param(value = "nameAndLeftAndRight") String nameAndLeftAndRight,
                                                          @Param(value = "tenderGuid") String tenderGuid);

    @Select("select * from beams where beamPedestalGuid = #{beamPedestalGuid}")
    List<BeamModel> listByBeamPedestal(String beamPedestalGuid);


    @Select("select mainTable.*, tenders.name tenderName from (select a.name, a.leftAndRight, a.tenderGuid, ISNULL(a.count1, 0) total, ISNULL(b.count2, 0) finish, ISNULL(c.count3, 0) unFinish, ISNULL(d.count4, 0) unSubmit from" +
            " (select tenderGuid, name, leftAndRight, count(guid) count1 from beamPrefabrications GROUP BY tenderGuid, name, leftAndRight ) a LEFT JOIN" +
            " (select tenderGuid, name, leftAndRight, count(guid) count2 from beamPrefabrications where status = 'finish' GROUP BY tenderGuid, name, leftAndRight ) b on a.name = b.name and a.leftAndRight = b.leftAndRight and a.tenderGuid = b.tenderGuid LEFT JOIN" +
            " (select tenderGuid, name, leftAndRight, count(guid) count3 from beamPrefabrications where status != 'finish' and status != 'unSubmit' GROUP BY tenderGuid, name, leftAndRight ) c on a.name = c.name and a.leftAndRight = c.leftAndRight and a.tenderGuid = c.tenderGuid LEFT JOIN" +
            " (select tenderGuid, name, leftAndRight, count(guid) count4 from beamPrefabrications where status = 'unSubmit' GROUP BY tenderGuid, name, leftAndRight ) d on a.name = d.name and a.leftAndRight = d.leftAndRight and a.tenderGuid = d.tenderGuid) MainTable " +
            " LEFT JOIN tenders on MainTable.tenderGuid = tenders.guid" +
            " where MainTable.tenderGuid = #{tenderGuid} ")
    List<ReturnBeamCount> selectByTender(String tenderGuid);
}
