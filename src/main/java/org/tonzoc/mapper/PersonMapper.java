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

    //截取所有人员idcard的前4位
    @Select("SELECT DISTINCT LEFT(idCard, 2)  idCard from persons")
    List<String> listIdCard();
}
