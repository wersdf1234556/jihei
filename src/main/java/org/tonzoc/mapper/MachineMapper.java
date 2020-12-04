package org.tonzoc.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import org.tonzoc.model.MachineModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.provider.MachineProvider;

import java.util.List;

public interface MachineMapper extends BaseMapper<MachineModel>{

    // 机械概况分组查询
    @SelectProvider(type = MachineProvider.class, method = "selectMachineCategoryNumber")
    List<ReturnModel> selectMachineCategoryNumber(String tenderGuid);

    // 机械的数量
    @SelectProvider(type = MachineProvider.class, method = "allNumber")
    Integer allNumber (String tenderGuid);

    // 重点机械分组查询
    @SelectProvider(type = MachineProvider.class, method = "selectMachineTypeNumber")
    List<ReturnModel> selectMachineTypeNumber(String tenderGuid);

    // 查询机械的最新坐标
}
