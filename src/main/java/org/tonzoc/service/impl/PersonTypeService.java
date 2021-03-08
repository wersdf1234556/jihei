package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.model.AuthorityModel;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.service.IPersonTypeService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.*;
import java.util.stream.Collectors;

@Service("personTypeService")
public class PersonTypeService extends BaseService<PersonTypeModel> implements IPersonTypeService {

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



}
