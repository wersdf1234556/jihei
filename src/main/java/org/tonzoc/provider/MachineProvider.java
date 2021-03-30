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

        stringBuilder.append(" GROUP BY machineCategories.name, machineCategories.guid");

        return stringBuilder.toString();
    }

    // 查询重点机械数量
    public String selectMachineTypeNumber(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machineTypes.name, machineTypes.guid proportion, count(machines.guid) number from machineTypes" +
                " LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid ");
        if ("".equals(tenderGuid) || tenderGuid == null) {
            stringBuilder.append(" LEFT JOIN machines on tenderMachineTypes.guid = machines.tenderMachineTypeGuid");
        }else {
            stringBuilder.append(" LEFT JOIN (select machines.guid, machines.tenderMachineTypeGuid from machines" +
                    " where machines.tenderGuid = '" + tenderGuid + "') machines on tenderMachineTypes.guid = machines.tenderMachineTypeGuid");
        }

        stringBuilder.append(" where machineTypes.highlight = 1 GROUP BY machineTypes.name, machineTypes.guid");

        return stringBuilder.toString();
    }

    // 查询全部机械
    public String allImportantMachine(@Param(value = "tenderGuid") String tenderGuid) {

        StringBuilder stringBuilder = new StringBuilder("select tenderMachineTypes.name, count(machines.guid) number from " +
                "(select * from tenderMachineTypes where tenderGuid = '" + tenderGuid + "') tenderMachineTypes " +
                "LEFT JOIN (select machines.guid, machines.tenderMachineTypeGuid from machines " +
                "where machines.tenderGuid = '" + tenderGuid + "') machines on tenderMachineTypes.guid = machines.tenderMachineTypeGuid " +
                "GROUP BY tenderMachineTypes.name");

        return stringBuilder.toString();
    }

    // 查询重点机械
    public String importantByMachineType(@Param(value = "machineTypeGuid") String machineTypeGuid) {

        StringBuilder stringBuilder = new StringBuilder("select machines.* from machines LEFT JOIN tenderMachineTypes on machines.tenderMachineTypeGuid = tenderMachineTypes.guid " +
                " LEFT JOIN machineTypes on tenderMachineTypes.machineTypeGuid = machineTypes.guid where machineTypes.highlight = 1");
        if (machineTypeGuid != null && !"".equals(machineTypeGuid)) {

            stringBuilder.append(" and machineTypeGuid + '" + machineTypeGuid + "'");

        }
        return stringBuilder.toString();
    }
}