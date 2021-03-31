package org.tonzoc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tonzoc.mapper.UserMapper;

import java.util.List;
@Component
public class ApprovalHelper {

    @Autowired
    private UserMapper userMapper;

    // 查询上级标段
    public String getNextTender(String tenderGuid){
        String allNextTenderGuids = "";
        List<String> tenderGuids = userMapper.listByTenderManage(tenderGuid);
        if(tenderGuids.size() != 0) {

            allNextTenderGuids = String.join(",", tenderGuids);
        }

        return allNextTenderGuids;
    }

    // 查询上级监理或者试验
    public String getNextSupervisor(String tenderGuid, String accounType){
        String allNextTenderGuids = "";
        List<String> tenderGuids = userMapper.listByTenderManageAndAccounType(tenderGuid, accounType);
        if(tenderGuids.size() != 0) {

            allNextTenderGuids = String.join(",", tenderGuids);
        }

        return allNextTenderGuids;
    }
}
