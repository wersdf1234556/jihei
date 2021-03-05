package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.SecurityChangModel;

import java.util.Date;

public interface SecurityChangMapper extends BaseMapper<SecurityChangModel>{

    // 处理change时间字段
    @Update("update securityChangs set changTime = #{changTime} where guid = #{guid}")
    void updateChangTime(@Param("changTime") Date changTime, @Param("guid") String guid);

    // 处理check时间字段
    @Update("update securityChangs set checkTime = #{checkTime} where guid = #{guid}")
    void updateCheckTime(@Param("checkTime") Date checkTime, @Param("guid") String guid);

    // 查询总数
    @Select("select count(guid) from securityChangs")
    Integer count();

    // 按照状态查数量
    @Select("select count(guid) from securityChangs where status = #{statue}")
    Integer countStatus(String status);
}
