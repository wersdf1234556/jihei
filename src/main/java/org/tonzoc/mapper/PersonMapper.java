package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.PersonModel;

import java.util.List;
@Component
public interface PersonMapper  extends BaseMapper<PersonModel>  {

    @Select("SELECT * from persons p LEFT JOIN tenders t on p.tenderGuid=t.guid " +
            "where t.name like '${tenderName}%'")
    List<PersonModel> listByTenderName(@Param(value = "tenderName") String tenderName);

    //获取所有人员的areaCode
    @Select("SELECT DISTINCT departurePlaceCode from persons")
    List<String> listAreaCode();

    @Select("select count(guid) from persons where idCard = #{idCard}")
    Integer countByIdCard(@Param(value = "idCard") String idCard);

}
