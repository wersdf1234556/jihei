package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.tonzoc.model.UserModel;

import java.util.List;
@Component
public interface UserMapper extends BaseMapper<UserModel> {

    @Select("SELECT s.* FROM users s LEFT JOIN roles r on s.roleGuid=r.guid where r.sign=#{sign} and s.tenderManage like CONCAT('%',#{tenderManage},'%')")
    List<UserModel> listByTenderManageAndSign(@Param(value = "sign") Integer sign,@Param(value = "tenderManage") String tenderManage);

    @Select("SELECT DISTINCT tenderGuid FROM users where tenderManage!=tenderGuid and tenderManage like '%${tenderManage}%'")
    List<String> listByTenderManage(@Param(value = "tenderManage") String tenderManage);

    @Select("SELECT DISTINCT tenderGuid FROM users where tenderManage != tenderGuid and tenderManage like '%${tenderManage}%' and accounType = #{accounType}")
    List<String> listByTenderManageAndAccounType(@Param(value = "tenderManage") String tenderManage,
                                                 @Param(value = "accounType") String AccounType);

    @Select("select tenderGuid from users where staffName = #{name}")
    String tenderByName(@Param(value = "name") String name);
}
