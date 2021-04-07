package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.support.ReturnMachineModel;
import org.tonzoc.provider.MachineProvider;

import java.util.List;

public interface MachineMapper extends BaseMapper<MachineModel>{

    // 机械的数量
    @SelectProvider(type = MachineProvider.class, method = "allNumber")
    Integer allNumber (@Param(value = "tenderGuid") String tenderGuid);

    // 机械概况分组查询
    @SelectProvider(type = MachineProvider.class, method = "selectMachineCategoryNumber")
    List<ReturnModel> selectMachineCategoryNumber(@Param(value = "tenderGuid") String tenderGuid);

    // 重点机械分组查询
    @Select("select * from (select tenderMachineTypes.name, machineTypes.guid proportion, sum(tenderMachineTypes.defaultNum) numberTotal from machineTypes" +
            " LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid" +
            " where machineTypes.highlight != 0 GROUP BY tenderMachineTypes.name, machineTypes.guid) tenderMachineTypes" +
            " LEFT JOIN" +
            " (select tenderMachineTypes.name, count(machines.guid) number from machineTypes" +
            " LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid" +
            " LEFT JOIN machines on machines.tenderMachineTypeGuid = tenderMachineTypes.guid" +
            " where machineTypes.highlight != 0 GROUP BY tenderMachineTypes.name) machines on tenderMachineTypes.name = machines.name")
    List<ReturnMachineModel> selectMachineTypeNumber();

    // 全标段的重点机械
    @SelectProvider(type = MachineProvider.class, method = "allImportantMachine")
    List<ReturnMachineModel> allImportantMachine(@Param(value = "tenderGuid") String tenderGuid);

    // 按照机械类别查询机械类型
    @Select("select * from (select machineTypes.formattedName name, isnull(sum(tenderMachineTypes.defaultNum), 0) numberTotal from (select * from machineTypes where machineCategoryGuid = #{machineCategoryGuid}) machineTypes" +
            " LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid" +
            " GROUP BY machineTypes.formattedName) machineType" +
            " LEFT JOIN" +
            " (select machineTypes.formattedName name, count(machines.guid) number from (select * from machineTypes where machineCategoryGuid = #{machineCategoryGuid}) machineTypes" +
            " LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid" +
            " LEFT JOIN (select * from machines where machineCategoryGuid = #{machineCategoryGuid}) machines on machines.tenderMachineTypeGuid = tenderMachineTypes.guid" +
            " GROUP BY machineTypes.formattedName) machines on machineType.name = machines.name")
    List<ReturnMachineModel> machineTypeAndNumber(String machineCategoryGuid);

    // 查询重点机械
    @SelectProvider(type = MachineProvider.class, method = "importantByMachineType")
    List<MachineModel> importantByMachineType(@Param(value = "machineTypeGuid") String machineTypeGuid);
}
