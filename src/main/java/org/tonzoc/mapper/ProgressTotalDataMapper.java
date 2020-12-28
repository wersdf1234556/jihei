package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.ProgressTotalDataModel;

import java.util.List;


@Component
public interface ProgressTotalDataMapper extends BaseMapper<ProgressTotalDataModel> {
    @Select("SELECT mainTable.guid,mainTable.progressNameGuid,mainTable.tenderGuid,mainTable.totalNum,progressNamesNameprogressNameTable.name as progressName,tendersNametenderNameTable.name as tenderName \n" +
            "FROM progressTotalDatas mainTable LEFT OUTER JOIN progressNames progressNamesNameprogressNameTable ON mainTable.progressNameGuid = progressNamesNameprogressNameTable.guid \n" +
            "LEFT OUTER JOIN tenders tendersNametenderNameTable ON mainTable.tenderGuid = tendersNametenderNameTable.guid \n" +
            "where tendersNametenderNameTable.name LIKE '%${tenderName}%' and mainTable.progressNameGuid=#{progressNameGuid}")
    List<ProgressTotalDataModel> listByProgressNameAndDate(@Param(value = "tenderName") String tenderName, @Param(value = "progressNameGuid") String progressNameGuid);


}
