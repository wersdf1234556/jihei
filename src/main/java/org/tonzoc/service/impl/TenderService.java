package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.TenderModel;
import org.tonzoc.service.ITenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class TenderService extends BaseService<TenderModel> implements ITenderService {

    public void insertStack(TenderModel tenderModel) throws Exception {
        String name = tenderModel.getName().replaceAll(" +","");
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("name", name, "eq"));
        List<TenderModel> tenderModels = list(sqlQueryParams);
        if (tenderModels.size()>0){
            throw new Exception("已有该名称数据，未添加成功");
        }
        save(tenderModel);
    }

    public void updateStack(TenderModel tenderModel) throws Exception {
        String name = tenderModel.getName().replaceAll(" +","");
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("name", name, "eq"));
        sqlQueryParams.add(new SqlQueryParam("guid", tenderModel.getGuid(), "neq"));
        List<TenderModel> tenderModels = list(sqlQueryParams);
        if (tenderModels.size()>0){
            throw new Exception("已有该名称数据，未修改成功");
        }
        update(tenderModel);
    }
}
