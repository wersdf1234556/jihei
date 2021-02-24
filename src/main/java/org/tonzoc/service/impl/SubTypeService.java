package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.SubTypeMapper;
import org.tonzoc.model.SubTypeModel;
import org.tonzoc.service.ISubTypeService;

import java.util.List;

@Service("subTypeService")
public class SubTypeService extends BaseService<SubTypeModel> implements ISubTypeService {

    @Autowired
    private SubTypeMapper subTypeMapper;

    // 是否包含
    @Override
    public Boolean contain(String name) {
        List<String> list = subTypeMapper.listName();
        if (list.contains(name)) {
            return true;
        }
        return false;
    }
}
