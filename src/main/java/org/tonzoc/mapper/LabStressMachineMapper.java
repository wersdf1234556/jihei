package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.LabStressMachineModel;
import org.tonzoc.model.support.LabStressMachineStatModel;

import java.util.List;

@Component
public interface LabStressMachineMapper extends BaseMapper<LabStressMachineModel> {

    @Select("select sectionName, count(1) as num from labStressMachines group by sectionName order by sectionName")
    List<LabStressMachineStatModel> listStatistics ();
}
