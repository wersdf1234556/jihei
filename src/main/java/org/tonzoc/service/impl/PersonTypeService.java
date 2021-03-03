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

    public List<PersonTypeModel> listByParentId(String parentId) {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        sqlQueryParams.add(new SqlQueryParam("parentId", parentId, "eq"));

        List<PersonTypeModel> list = list(sqlQueryParams);

        return list;
    }

    public List<PersonTypeModel> listWithLevel(String parentId) throws Exception {
        List<PersonTypeModel> authorityModels = new ArrayList<>();

        List<PersonTypeModel> allPersonTypes = null;
        if (parentId==null||StringUtils.isEmpty(parentId)) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

            Page page = PageHelper.startPage(1, 0, "mainTable.sortId asc");
            page.setOrderByOnly(true);
            allPersonTypes = this.list(sqlQueryParams);
        }else {
            allPersonTypes=this.listByParentId(parentId).stream().sorted(Comparator.comparing(PersonTypeModel::getSortId)).collect(Collectors.toList());;
            allPersonTypes.add(get(parentId));
        }
        HashMap<String, PersonTypeModel> personTypeModelMap = new HashMap<>();
        while (allPersonTypes.size() != 0) {
            int count = allPersonTypes.size();
            Iterator<PersonTypeModel> iterator = allPersonTypes.iterator();
            while (iterator.hasNext()) {
                PersonTypeModel personTypeModel = iterator.next();

                System.out.println(personTypeModel);

                if (personTypeModel.getParentId().equals("0")) {
                    personTypeModelMap.put(personTypeModel.getGuid(), personTypeModel);
                    iterator.remove();
                } else if (personTypeModelMap.containsKey(personTypeModel.getParentId())) {
                    PersonTypeModel parentPersonTypeModel = personTypeModelMap.get(personTypeModel.getParentId());
                    if (parentPersonTypeModel.getChildren() == null) {
                        parentPersonTypeModel.setChildren(new ArrayList<>());
                    }
                    parentPersonTypeModel.getChildren().add(personTypeModel);
                    personTypeModelMap.put(personTypeModel.getGuid(), personTypeModel);
                    iterator.remove();
                }
            }
            if (count == allPersonTypes.size()) {
                // TODO 需要自定义异常类型
                throw new Exception("进入循环");
            }
        }

        for (PersonTypeModel personTypeModel : personTypeModelMap.values()) {
            if (personTypeModel.getParentId().equals("0")) {
                authorityModels.add(personTypeModel);
            }
        }

        return authorityModels
                .stream()
                .sorted(Comparator.comparing(PersonTypeModel::getSortId))
                .collect(Collectors.toList());
    }


}
