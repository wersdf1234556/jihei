package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
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
    @SelectProvider(type = MachineProvider.class, method = "selectMachineTypeNumber")
    List<ReturnModel> selectMachineTypeNumber(@Param(value = "tenderGuid") String tenderGuid);

    // 全标段的重点机械
    @SelectProvider(type = MachineProvider.class, method = "allImportantMachine")
    List<ReturnModel> allImportantMachine(@Param(value = "tenderGuid") String tenderGuid);

    // 查询机械的最新坐标

    // 按照机械类别查询机械类型
    @Select("select machineTypes.name, count(machines.guid) number from machineTypes " +
            "LEFT JOIN tenderMachineTypes on machineTypes.guid = tenderMachineTypes.machineTypeGuid " +
            "LEFT JOIN (select * from machines where machineCategoryGuid = #{machineCategoryGuid}) machines " +
            "on tenderMachineTypes.guid = machines.tenderMachineTypeGuid " +
            "GROUP BY machineTypes.name")
    List<ReturnModel> machineTypeAndNumber(String machineCategoryGuid);
}
