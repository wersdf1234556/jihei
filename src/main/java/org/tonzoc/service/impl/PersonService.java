package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.exception.NotOneResultFoundException;
import org.tonzoc.mapper.PersonMapper;
import org.tonzoc.model.PersonModel;
import org.tonzoc.service.IPersonService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("personService")
public class PersonService extends BaseService<PersonModel> implements IPersonService {
    @Autowired
    private PersonMapper personMapper;

    public PersonModel listBySign(String sign) throws Exception {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", sign, "eq"));

        List<PersonModel> list = this.list(sqlQueryParams);
        if (list.size()==0){
            throw new NotFoundException("不存在该人员");
        }else if (list.size()>1){
            throw new NotOneResultFoundException("该人员识别字段不唯一，存在多条");
        }

        return list.get(0);
    }


    @Override
    public List<PersonModel> listByTenderName(String tenderName) {
        return personMapper.listByTenderName(tenderName);
    }

    public PersonModel login(String sign, String password) throws Exception {
        /**
         * create by: fang
         * description:本方法用于人员登录手机端，验证密码是否正确
         * create time: 9:37 2021-1-5
         *
          * @Param: sign  人员的唯一标识
        * @Param: password   传过来的登录密码
         * @return org.tonzoc.model.PersonModel
         */
        PersonModel personModel = listBySign(sign);
        String patchPassword = personModel.getPassword();
        if (!password.equals(patchPassword)){
            throw new NotMatchException("输入的密码（Password: " + password + "）不正确");
        }
        return personModel;
    }

    public void insertStack(PersonModel personModel) throws Exception {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", personModel.getIdCard(), "eq"));
        List<PersonModel> list = this.list(sqlQueryParams);
        if (list.size()>0){
            throw new NotOneResultFoundException("该人员已存在，请检查唯一识别字段是否正确");
        }
        personModel.setPassword("123456");
        save(personModel);
    }

    public void updateStack(PersonModel personModel) throws Exception {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("idCard", personModel.getIdCard(), "eq"));
        sqlQueryParams.add(new SqlQueryParam("guid", personModel.getGuid(), "neq"));
        List<PersonModel> list = this.list(sqlQueryParams);
        if (list.size()>0){
            throw new NotOneResultFoundException("该人员已存在，请检查唯一识别字段是否正确");
        }
        //不修改密码
        personModel.setPassword(null);
        update(personModel);
    }


}
