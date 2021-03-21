package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.SecurityChangModel;

public interface SecurityChangMapper extends BaseMapper<SecurityChangModel>{

    // 查询总数
    @Select("select count(guid) from securityChangs")
    Integer count();

    // 修改安全检查表的状态
    @Update("update securityChangs set status = #{status}, approvalTime = #{approvalTime} where guid = #{guid}")
    void updateStatus(@Param("status")String status,
                      @Param("approvalTime")String approvalTime,
                      @Param("guid")String guid);

}
