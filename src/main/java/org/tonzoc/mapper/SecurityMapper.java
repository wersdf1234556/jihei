package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.SecurityModel;

import java.util.Date;
import java.util.List;

public interface SecurityMapper extends BaseMapper<SecurityModel> {

//    @Select("select sum(score) from securitys where documentGuid = #{documentGuid} and tenderGuid = #{tenderGuid}")
//    Integer score(String documentGuid, String tenderGuid);

    // 处理时间字段
    @Update("update securitys set createTime = #{createTime} where guid = #{guid}")
    void updateTime(@Param("createTime")Date createTime, @Param("guid") String guid);

    // 修改安全检查表的状态
    @Update("update securitys set status = #{status}, approvalTime = #{approvalTime} where guid = #{guid}")
    void updateStatus(@Param("status")String status,
                      @Param("approvalTime")String approvalTime,
                      @Param("guid")String guid);

    // 修改安全检查表的状态和当前审批人
    @Update("update securitys set status = #{status}, approvalTime = #{approvalTime}, currentTenderGuid = #{currentTenderGuid} where guid = #{guid}")
    void updateStatusAndTender(@Param("status")String status,
                               @Param("approvalTime")String approvalTime,
                               @Param("currentTenderGuid") String currentTenderGuid,
                               @Param("guid")String guid);

    // 查询总数
    @Select("select count(guid) from securitys")
    Integer count();

    // 按照状态查数量
    @Select("select ISNULL(count(guid), 0) from securitys where status = #{status}")
    Integer countStatus(@Param("status")String status);

    // 安全整治排查
    @Select("select *, tenders.name tenderName from securitys LEFT JOIN tenders on securitys.tenderGuid = tenders.guid " +
            "where documentGuid = (select top 1 guid from documents ORDER BY createdAt desc)")
    List<SecurityModel> unsafeSelect();

}
