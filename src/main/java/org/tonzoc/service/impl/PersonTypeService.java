package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.PersonTypeMapper;
import org.tonzoc.model.PersonCategoryModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.service.IPersonCategoryService;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.*;

@Service("personTypeService")
public class PersonTypeService extends BaseService<PersonTypeModel> implements IPersonTypeService {

    @Autowired
    private PersonTypeMapper personTypeMapper;

    @Autowired
    private IPersonCategoryService personCategoryService;

    public List<PersonTypeModel> listByFlag(Integer flag) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("flag", flag.toString(), "eq"));

        List<PersonTypeModel> list = this.list(sqlQueryParams);
        return list;
    }

    public List<PersonTypeModel> listByCategoryGuid(String categoryGuid) {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        sqlQueryParams.add(new SqlQueryParam("categoryGuid", categoryGuid, "eq"));

        List<PersonTypeModel> list = list(sqlQueryParams);

        return list;
    }

    // 按照类型查询数量
    public List<PersonTypeModel> selectByCategory(String PersonCategoryGuid, String tenderGuid) {

        return  personTypeMapper.selectByCategory(PersonCategoryGuid, tenderGuid);
    }

}
