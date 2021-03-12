package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.PersonNucleicInfoMapper;
import org.tonzoc.model.AreaDataModel;
import org.tonzoc.model.PersonNucleicInfoModel;
import org.tonzoc.service.IAreaDataService;
import org.tonzoc.service.IPersonNucleicInfoService;

import java.util.List;

@Service("personNucleicInfoService")
public class PersonNucleicInfoService extends BaseService<PersonNucleicInfoModel> implements IPersonNucleicInfoService {

    @Autowired
    private PersonNucleicInfoMapper personNucleicInfoMapper;
    public List<String> listAreaCode(){
        return personNucleicInfoMapper.listAreaCode();
    }

}
