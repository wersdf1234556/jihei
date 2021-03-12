package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.annotation.Column;
import org.tonzoc.model.PersonNucleicInfoModel;

import java.util.List;
@Component
public interface PersonNucleicInfoMapper extends BaseMapper<PersonNucleicInfoModel> {

    //获取所有人员的areaCode
    @Select("SELECT DISTINCT departurePlaceCode from personNucleicInfo")
    List<String> listAreaCode();
}
