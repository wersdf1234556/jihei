package org.tonzoc.provider;

import org.apache.ibatis.annotations.Param;

public class BeamProvider {

    public String selectByTender(@Param(value = "tenderGuid") String tenderGuid,
                                 @Param(value = "name") String name,
                                 @Param(value = "leftAndRight") String leftAndRight) {

        StringBuilder stringBuilder = new StringBuilder("select mainTable.*, tenders.name tenderName from (select a.name, a.leftAndRight, a.tenderGuid, case when a.count1 is null then 0 else a.count1 end total, case when b.count2 is null then 0 else b.count2 end finish, case when c.count3 is null then 0 else c.count3 end unFinish, case when d.count4 is null then 0 else d.count4 end unSubmit from" +
                " (select tenderGuid, name, leftAndRight, count(guid) count1 from beamPrefabrications GROUP BY tenderGuid, name, leftAndRight ) a LEFT JOIN" +
                " (select tenderGuid, name, leftAndRight, count(guid) count2 from beamPrefabrications where status = 'finish' GROUP BY tenderGuid, name, leftAndRight ) b on a.name = b.name and a.leftAndRight = b.leftAndRight and a.tenderGuid = b.tenderGuid LEFT JOIN" +
                " (select tenderGuid, name, leftAndRight, count(guid) count3 from beamPrefabrications where status != 'finish' and status != 'unSubmit' GROUP BY tenderGuid, name, leftAndRight ) c on a.name = c.name and a.leftAndRight = c.leftAndRight and a.tenderGuid = c.tenderGuid LEFT JOIN" +
                " (select tenderGuid, name, leftAndRight, count(guid) count4 from beamPrefabrications where status = 'unSubmit' GROUP BY tenderGuid, name, leftAndRight ) d on a.name = d.name and a.leftAndRight = d.leftAndRight and a.tenderGuid = d.tenderGuid) MainTable" +
                " LEFT JOIN tenders on MainTable.tenderGuid = tenders.guid where 1 = 1");

        if (tenderGuid != null && !"".equals(tenderGuid)) {

            stringBuilder.append(" and MainTable.tenderGuid = '" + tenderGuid + "'");
        }
        if (name != null && !"".equals(name)) {

            stringBuilder.append(" and MainTable.name like '%" + name + "%'");
        }
        if (leftAndRight != null && !"".equals(leftAndRight)) {

            stringBuilder.append(" and leftAndRight = '" + leftAndRight + "'");
        }

        stringBuilder.append(" order by MainTable.name, leftAndRight asc");

        return stringBuilder.toString();
    }

    public String listHistoryPage(@Param(value = "name") String name,
                                  @Param(value = "num") String num,
                                  @Param(value = "beamPrefabricationName") String beamPrefabricationName,
                                  @Param(value = "leftAndRight") String leftAndRight,
                                  @Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder(" select * from (select beams.guid, beamPedestals.name pedestalName, beamPedestals.modelNum modelNum, beamPedestals.textNum textNum, beamPedestals.pedestalNum pedestalNum, beamPedestals.tenderGuid, tenders.name tenderName," +
                        " beamPedestals.name beamPedestalName, beamPrefabrications.name name, beamPrefabrications.leftAndRight leftAndRight, beamPrefabrications.prefabricationNum prefabricationNum, beamPrefabrications.status status from beams" +
                        " LEFT JOIN beamPedestals on beams.beamPedestalGuid = beamPedestals.guid" +
                        " LEFT JOIN beamPrefabrications on beams.beamPrefabricationGuid = beamPrefabrications.guid" +
                        " LEFT JOIN tenders on beams.tenderGuid = tenders.guid) MainTable");

        stringBuilder.append(" where MainTable." + name + " = '" + num + "'");

        if (beamPrefabricationName != null && !"".equals(beamPrefabricationName)) {

            stringBuilder.append(" and MainTable.name like '%" + beamPrefabricationName + "%'");
        }
        if (leftAndRight != null && !"".equals(leftAndRight)) {

            stringBuilder.append(" and MainTable.leftAndRight = '" + leftAndRight + "'");
        }
        if (tenderGuid != null && !"".equals(tenderGuid)) {

            stringBuilder.append(" and MainTable.tenderGuid = '" + tenderGuid + "'");
        }

        return stringBuilder.toString();
    }
}
