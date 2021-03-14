package org.tonzoc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tonzoc.model.AreaDataModel;
import org.tonzoc.service.IAreaDataService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.*;
import java.util.stream.Collectors;

@Service(value = "areaDataService")
public class AreaDataService  extends BaseService<AreaDataModel> implements IAreaDataService {
    public List<AreaDataModel> listByParentCode(String parentCode) {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        sqlQueryParams.add(new SqlQueryParam("parentCode", parentCode, "eq"));

        List<AreaDataModel> list = list(sqlQueryParams);

        return list;
    }
    public List<AreaDataModel> listByCode(String code) {

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        sqlQueryParams.add(new SqlQueryParam("code", code, "eq"));

        List<AreaDataModel> list = list(sqlQueryParams);

        return list;
    }

    public List<AreaDataModel> listWithLevel(String parentCode) throws Exception {
        List<AreaDataModel> authorityModels = new ArrayList<>();

        List<AreaDataModel> allAreaDatas = null;
        if (parentCode==null||StringUtils.isEmpty(parentCode)) {
            List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

            Page page = PageHelper.startPage(1, 0, "mainTable.code asc");
            page.setOrderByOnly(true);
            allAreaDatas = this.list(sqlQueryParams);
        }else {
            allAreaDatas=this.listByParentCode(parentCode).stream().sorted(Comparator.comparing(AreaDataModel::getCode)).collect(Collectors.toList());
            allAreaDatas.add(listByParentCode(parentCode).get(0));
        }
        HashMap<String, AreaDataModel> areaDataModelMap = new HashMap<>();
        while (allAreaDatas.size() != 0) {
            int count = allAreaDatas.size();
            Iterator<AreaDataModel> iterator = allAreaDatas.iterator();
            while (iterator.hasNext()) {
                AreaDataModel areaDataModel = iterator.next();

                if (areaDataModel.getParentCode().equals("0")) {
                    areaDataModelMap.put(areaDataModel.getCode(), areaDataModel);
                    iterator.remove();
                } else if (areaDataModelMap.containsKey(areaDataModel.getParentCode())) {
                    AreaDataModel parentAreaDataModel = areaDataModelMap.get(areaDataModel.getParentCode());
                    if (parentAreaDataModel.getChildren() == null) {
                        parentAreaDataModel.setChildren(new ArrayList<>());
                    }
                    parentAreaDataModel.getChildren().add(areaDataModel);
                    areaDataModelMap.put(areaDataModel.getCode(), areaDataModel);
                    iterator.remove();
                }
            }
            System.out.println(areaDataModelMap.toString());
            System.out.println("count="+count);
            System.out.println("allAreaDatas.size()="+allAreaDatas.size());
            if (count == allAreaDatas.size()) {
                // TODO 需要自定义异常类型
                throw new Exception("进入循环");
            }
        }

        for (AreaDataModel areaDataModel : areaDataModelMap.values()) {
            if (areaDataModel.getParentCode().equals("0")) {
                authorityModels.add(areaDataModel);
            }
        }

        return authorityModels
                .stream()
                .sorted(Comparator.comparing(AreaDataModel::getCode))
                .collect(Collectors.toList());
    }

}
