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

        StringBuilder stringBuilder = new StringBuilder("select machineCategories.name, count(machines.guid) number from machineCategories ");
        if ("".equals(tenderGuid) || tenderGuid == null) {
            stringBuilder.append(" LEFT JOIN machines on machineCategories.guid = machines.machineCategoryGuid");
        }else {
            stringBuilder.append(" LEFT JOIN (select machines.guid, machines.machineCategoryGuid from machines" +
                    " where machines.tenderGuid = '" + tenderGuid + "') machines on machineCategories.guid = machines.machineCategoryGuid");
        }

        stringBuilder.append(" GROUP BY machineCategories.name");

        return stringBuilder.toString();
    }

    // 查询重点机械
    public String selectMachineTypeNumber(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machineTypes.name, count(machines.guid) number from machineTypes");
        if ("".equals(tenderGuid) || tenderGuid == null) {
            stringBuilder.append(" LEFT JOIN machines on machineTypes.guid = machines.machineTypeGuid");
        }else {
            stringBuilder.append(" LEFT JOIN (select machines.guid, machines.machineTypeGuid from machines" +
                    " where machines.tenderGuid = '" + tenderGuid + "') machines on machineTypes.guid = machines.machineTypeGuid");
        }

        stringBuilder.append(" where machineTypes.highlight = 1 GROUP BY machineTypes.name");

        return stringBuilder.toString();
    }

    // 查询全部机械
    public String allImportantMachine(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machineTypes.name, count(machines.guid) number from " +
                "(select * from tenderMachineTypes where tenderGuid = '" + tenderGuid + "') tenderMachineTypes " +
                "LEFT JOIN machineTypes on tenderMachineTypes.machineTypeGuid = machineTypes.guid " +
                "LEFT JOIN (select machines.guid, machines.machineTypeGuid from machines " +
                "where machines.tenderGuid = '" + tenderGuid + "') machines on machineTypes.guid = machines.machineTypeGuid " +
                "GROUP BY machineTypes.name");

        return stringBuilder.toString();
    }
}