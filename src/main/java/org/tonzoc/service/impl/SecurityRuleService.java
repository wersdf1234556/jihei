package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.DocumentMapper;
import org.tonzoc.mapper.SecurityRuleMapper;
import org.tonzoc.model.DocumentModel;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.SecurityModel;
import org.tonzoc.model.SecurityRuleModel;
import org.tonzoc.service.ISecurityRuleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityRuleService extends BaseService<SecurityRuleModel> implements ISecurityRuleService {

    @Autowired
    private SecurityRuleMapper securityRuleMapper;

    @Autowired
    private DocumentMapper documentMapper;

    // 考核项积分情况
    @Override
    public List<SecurityRuleModel> selectByDocument(){

        DocumentModel documentModel =  documentMapper.selectByCreateAt();
        return securityRuleMapper.selectByDocument(documentModel.getGuid());
    }

    // 积分变化情况
    @Override
    public List<ReturnModel> selectChang(){

        List<ReturnModel> list1 = new ArrayList<>();
        Map<String, Integer> map = new HashMap(); // 存年月
        Map<String, Integer> map1 = new HashMap<>(); // 存数据
        List<SecurityModel> list = securityRuleMapper.selectChang();
        for (SecurityModel li: list){
             String year = li.getCreatePersonGuid().substring(0, 4); // 年
             String month = li.getCreatePersonGuid().substring(5, 7); // 月
             String day = li.getCreatePersonGuid().substring(8, 10); // 日
             String str = Integer.valueOf(year) + "年" + Integer.valueOf(month) + "月"; //年+月
             if (map.containsKey(str)) { //如果map中有年+月
                 if (map.get(str) < Integer.valueOf(day)) { // 如果map的日小于现在日

                     map.remove(str); // 删除之前的年+月 和 日
                     map1.remove(str); // 删除之前的年+月 和 数据
                 }
             }
             map.put(str, Integer.valueOf(day)); // 将年+月 和 日 存进map中
             map1.put(str, li.getScore()); // 将年+月 和 数据 存进map中
         }

        for (Map.Entry<String, Integer> m : map1.entrySet()) {

            ReturnModel returnModel = new ReturnModel();
            returnModel.setName(m.getKey());
            returnModel.setNumber(m.getValue());
            list1.add(returnModel);
        }

         return list1;
    }
}
