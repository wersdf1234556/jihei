package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.ProgressTotalDataMapper;
import org.tonzoc.model.ProgressTotalDataModel;
import org.tonzoc.service.IProgressTotalDataService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;


@Service("progressTotalDataService")
public class ProgressTotalDataService extends BaseService<ProgressTotalDataModel> implements IProgressTotalDataService {
    @Autowired
    private ProgressTotalDataMapper progressTotalDataMapper;

//    public List<ProgressTotalDataModel> listByTenderAndProgressName(String tenderGuid,String progressNameGuid){
//        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
//        sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "like"));
//        sqlQueryParams.add(new SqlQueryParam("progressNameGuid", progressNameGuid, "eq"));
//
//        List<ProgressTotalDataModel> list = this.list(sqlQueryParams);
//        return list;
//    }

    public List<ProgressTotalDataModel> listByTenderAndProgressName(String tenderName,String progressNameGuid){
        return progressTotalDataMapper.listByProgressNameAndDate(tenderName,progressNameGuid);
    }
}
