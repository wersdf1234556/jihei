package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.tonzoc.model.SecurityModel;

import java.util.Date;
import java.util.List;

public interface SecurityMapper extends BaseMapper<SecurityModel> {

    // 修改安全检查表的状态
    @Update("update securitys set status = #{status}, approvalTime = #{approvalTime} where guid = #{guid}")
    void updateStatus(@Param("status")String status,
                      @Param("approvalTime")String approvalTime,
                      @Param("guid")String guid);

    // 修改安全检查表的状态和当前审批人
    @Update("update securitys set status = #{status}, approvalTime = #{approvalTime} where guid = #{guid}")
    void updateStatusAndTender(@Param("status")String status,
                               @Param("approvalTime")String approvalTime,
                               @Param("guid")String guid);

    // 查询总数
    @Select("select count(guid) from securitys")
    Integer count();

    // 按照年份查询总数
    @Select("select count(guid) from securitys where createdAt like '%${date}%'")
    Integer countByDate(@Param("date") String date);

    // 按照状态查数量
    @Select("select ISNULL(count(guid), 0) from securitys where status = #{status}")
    Integer countStatus(@Param("status")String status);

    // 按照状态和年份查数量
    @Select("select ISNULL(count(guid), 0) from securitys where status = #{status} and createdAt like '%${date}%'")
    Integer countStatusByDate(@Param("status")String status,
                              @Param("date") String date);

    // 安全整治排查
    @Select("select *, tenders.name tenderName from securitys LEFT JOIN tenders on securitys.tenderGuid = tenders.guid " +
            "where documentGuid = (select top 1 guid from documents ORDER BY createdAt desc)")
    List<SecurityModel> unsafeSelect();

    @Update("update securitys set approvalScore = #{approvalScore} where guid = #{guid}")
    void updateApprovalScore(@Param("approvalScore") Integer approvalScore,
                             @Param("guid") String guid);

}
