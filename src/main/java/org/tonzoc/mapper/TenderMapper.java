package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.TenderModel;

import java.util.List;
@Component
public interface TenderMapper extends BaseMapper<TenderModel> {

    @Select("select * from tenders where name like '%A%' or name like '%B%' order by sortId asc")
    List<TenderModel> list();

    @Select("select * from tenders where name like '%${tenderName}%' order by sortId asc")
    List<TenderModel> listLikeTender(@Param(value = "tenderName") String tenderName);

}
