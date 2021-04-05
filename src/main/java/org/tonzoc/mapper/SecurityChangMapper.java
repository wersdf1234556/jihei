package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;
import org.tonzoc.model.SecurityChangModel;

import java.util.Date;

public interface SecurityChangMapper extends BaseMapper<SecurityChangModel>{

    // 查询总数
    @Select("select count(guid) from securityChangs")
    Integer count();

    // 修改安全检查表的状态
    @Update("update securityChangs set status = #{status}, approvalTime = #{approvalTime} where guid = #{guid}")
    void updateStatus(@Param("status")String status,
                      @Param("approvalTime")String approvalTime,
                      @Param("guid")String guid);

    // 修改安全检查表的状态
    @Update("update securityChangs set status = #{status}, approvalTime = #{approvalTime}, approvalPersonName = #{approvalPersonName} where guid = #{guid}")
    void updateStatusAndPerson(@Param("status")String status,
                               @Param("approvalTime")String approvalTime,
                               @Param("approvalPersonName")String approvalPersonName,
                               @Param("guid")String guid);

    // 查看是否是最新的
    @Select("select count(guid) from securityChangs where securityGuid = #{securityGuid} and createdAt > #{createdAt}")
    Integer latest (@Param("securityGuid") String securityGuid,
                    @Param("createdAt") Date createdAt);

}
