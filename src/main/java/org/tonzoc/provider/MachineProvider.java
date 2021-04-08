package org.tonzoc.provider;


import org.apache.ibatis.annotations.Param;

public class MachineProvider {

    // 机械的数量
    public String allNumber(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select count(machines.guid) from machines");
        if ("".equals(tenderGuid) || tenderGuid == null) {

        }else {
            stringBuilder.append(" where machines.tenderGuid = '" + tenderGuid + "'");
        }

        return stringBuilder.toString();
    }

    // 查询机械概况
    public String selectMachineCategoryNumber(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machineCategories.name, count(machines.guid) number, machineCategories.guid proportion from machineCategories ");
        if ("".equals(tenderGuid) || tenderGuid == null) {
            stringBuilder.append(" LEFT JOIN machines on machineCategories.guid = machines.machineCategoryGuid");
        }else {
            stringBuilder.append(" LEFT JOIN (select machines.guid, machines.machineCategoryGuid from machines" +
                    " where machines.tenderGuid = '" + tenderGuid + "') machines on machineCategories.guid = machines.machineCategoryGuid");
        }

        stringBuilder.append(" GROUP BY machineCategories.name, machineCategories.guid, machineCategories.sortId order by machineCategories.sortId");

        return stringBuilder.toString();
    }

    // 查询重点机械
    public String importantByMachineType(@Param(value = "machineTypeGuid") String machineTypeGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machines.*, tenders.name tenderName, tenderMachineTypes.name tenderMachineTypeName, machineCategories.name categoryName from machines " +
                " LEFT JOIN tenderMachineTypes on machines.tenderMachineTypeGuid = tenderMachineTypes.guid " +
                " LEFT JOIN tenders on tenderMachineTypes.tenderGuid = tenders.guid " +
                " LEFT JOIN machineTypes on tenderMachineTypes.machineTypeGuid = machineTypes.guid " +
                " LEFT JOIN machineCategories on machineTypes.machineCategoryGuid = machineCategories.guid where machineTypes.highlight != 0");
        if (machineTypeGuid != null && !"".equals(machineTypeGuid)) {

            stringBuilder.append(" and machineTypeGuid + '" + machineTypeGuid + "'");

        }
        return stringBuilder.toString();
    }
}