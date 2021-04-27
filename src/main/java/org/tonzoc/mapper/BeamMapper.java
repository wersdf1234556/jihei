package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.BeamModel;
import org.tonzoc.model.BeamPedestalModel;
import org.tonzoc.model.BeamPrefabricationModel;
import org.tonzoc.model.ReturnBeamCount;
import org.tonzoc.model.support.ReturnBeamModel;
import org.tonzoc.provider.BeamProvider;

import javax.validation.Valid;
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

    @Select("select * from (select c.guid, a.modelNum, a.name pedestalName, c.name, c.prefabricationNum, c.concreteStrengthOne, c.concreteStrengthTwo, c.concreteStrengthThree, c.remarks, c.status, c.leftAndRight, c.length from beams as b" +
            " left join beamPedestals as a on a.guid = b.beamPedestalGuid" +
            " left join beamPrefabrications as c on c.guid = b.beamPrefabricationGuid " +
            " where b.beamPedestalGuid = (select guid from beamPedestals where modelNum = #{num})) MainTable")
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
    List<BeamModel> listByBeamPedestal(@Param(value = "beamPedestalGuid") String beamPedestalGuid);


    @SelectProvider(type = BeamProvider.class, method = "selectByTender")
    List<ReturnBeamCount> selectByTender(@Param(value = "tenderGuid") String tenderGuid,
                                         @Param(value = "name") String name,
                                         @Param(value = "leftAndRight") String leftAndRight);

    @SelectProvider(type = BeamProvider.class, method = "listHistoryPage")
    List<ReturnBeamModel> listHistoryPage(@Param(value = "name") String name,
                                          @Param(value = "num") String num,
                                          @Param(value = "beamPrefabricationName") String beamPrefabricationName,
                                          @Param(value = "leftAndRight") String leftAndRight);
}
