package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;
import org.tonzoc.annotation.Operator;
import org.tonzoc.model.PersonModel;
import org.tonzoc.provider.MachineProvider;
import org.tonzoc.provider.PersonProvider;

import java.util.List;
@Component
public interface PersonMapper  extends BaseMapper<PersonModel>  {

    @Select("SELECT p.* from persons p LEFT JOIN tenders t on p.tenderGuid=t.guid " +
            "where t.name like '${tenderName}%'")
    List<PersonModel> listByTenderName(@Param(value = "tenderName") String tenderName);

    //获取所有人员的areaCode
    @Select("SELECT DISTINCT departurePlaceCode from persons")
    List<String> listAreaCode();

    @Select("select count(guid) from persons where idCard = #{idCard}")
    Integer countByIdCard(@Param(value = "idCard") String idCard);

    // 查询打卡次数
    @SelectProvider(type = PersonProvider.class, method = "attendanceCount")
    List<PersonModel> attendanceCount(@Param(value = "tenderGuid") String tenderGuid,
                                      @Param(value = "name") String name,
                                      @Param(value = "idCard") String idCard,
                                      @Param(value = "mobile") String mobile,
                                      @Param(value = "personTypeGuid") String personTypeGuid,
                                      @Param(value = "attTime") String attTime,
                                      @Param(value = "count") String count);
}
