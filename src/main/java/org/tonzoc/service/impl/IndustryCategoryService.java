package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.IndustryCategoryMapper;
import org.tonzoc.model.IndustryCategoryModel;
import org.tonzoc.service.IIndustryCategoryService;

@Service("IndustryCategoryService")
public class IndustryCategoryService extends BaseService<IndustryCategoryModel> implements IIndustryCategoryService {

    @Autowired
    private IndustryCategoryMapper industryCategoryMapper;
}
