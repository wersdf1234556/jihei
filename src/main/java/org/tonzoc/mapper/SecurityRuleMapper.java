package org.tonzoc.mapper;

import org.apache.ibatis.annotations.Select;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.SecurityRuleModel;

import java.util.List;

public interface SecurityRuleMapper extends BaseMapper<SecurityRuleModel> {

    // 查询最新的积分情况
    @Select("select securityRules.name, sum(securitys.score) defaultScore from securityRules LEFT JOIN " +
            "(select * from securitys where documentGuid = '99AA019F-5CDA-46CD-AB20-0CC640B8AA74') securitys on securityRules.guid = securitys.securityRuleGuid " +
            "GROUP BY securityRules.name")
    List<SecurityRuleModel> selectByDocument(String documentGuid);

    // 查询积分变化情况
    @Select("select sum(score) score,documentGuid, documents.endTime createPersonGuid from securitys " +
            "LEFT JOIN documents on securitys.documentGuid = documents.guid GROUP BY documentGuid, documents.endTime")
    List<SecurityModel> selectChang();
}
