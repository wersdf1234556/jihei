package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.UnsafeMapper;
import org.tonzoc.model.ReturnModel;
import org.tonzoc.model.UnsafeModel;
import org.tonzoc.service.IUnsafeService;

import java.util.List;

@Service("UnsafeService")
public class UnsafeService extends BaseService<UnsafeModel> implements IUnsafeService {

    @Autowired
    private UnsafeMapper unsafeMapper;

    public List<ReturnModel> count(){

        return unsafeMapper.count();
    }
}
