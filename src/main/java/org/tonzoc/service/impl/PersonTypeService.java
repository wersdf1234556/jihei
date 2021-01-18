package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("personTypeService")
public class PersonTypeService extends BaseService<PersonTypeModel> implements IPersonTypeService {

    public List<PersonTypeModel> listByFlag(Integer flag) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("flag", flag.toString(), "eq"));

        List<PersonTypeModel> list = this.list(sqlQueryParams);
        return list;
    }

}
