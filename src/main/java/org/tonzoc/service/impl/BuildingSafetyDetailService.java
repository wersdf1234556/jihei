package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.service.IBuildingSafetyDetailService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("BuildingSafetyDetailService")
public class BuildingSafetyDetailService extends BaseService<BuildingSafetyDetailModel> implements IBuildingSafetyDetailService {
    public List<BuildingSafetyDetailModel> listByLtDate(String date,String safetyGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        //小于指定日期
        sqlQueryParams.add(new SqlQueryParam("date",date,"lt"));
        sqlQueryParams.add(new SqlQueryParam("safetyGuid",safetyGuid,"eq"));
        List<BuildingSafetyDetailModel> list = list(sqlQueryParams);
        return list;
    }

    public List<BuildingSafetyDetailModel> listByLikeDate(String date,String safetyGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        //模糊查询指定日期
        sqlQueryParams.add(new SqlQueryParam("date",date,"like"));
        sqlQueryParams.add(new SqlQueryParam("safetyGuid",safetyGuid,"eq"));
        List<BuildingSafetyDetailModel> list = list(sqlQueryParams);
        return list;
    }
}
