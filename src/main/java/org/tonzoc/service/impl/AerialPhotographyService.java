<<<<<<< HEAD
package org.tonzoc.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.QueryParamNotSupportedException;
import org.tonzoc.model.AerialPhotographyModel;
import org.tonzoc.service.IAerialPhotographyService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "aerialPhotographyService")
public class AerialPhotographyService extends BaseService<AerialPhotographyModel> implements IAerialPhotographyService {

    @Override
    public AerialPhotographyModel getFirstByTender(String tenderGuid) throws Exception {
        if (tenderGuid == null || tenderGuid.equals("")) {
            throw new QueryParamNotSupportedException("为传递有效参数");
        }

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));

        PageHelper.startPage(1, 0, "month desc, sortId desc").setOrderByOnly(true);

        List<AerialPhotographyModel> list = this.list(sqlQueryParams);
        if (list.size() == 0) {
            throw new NotFoundException("结果未找到");
        }

        return list.get(0);
    }

    @Override
    public List<String> getDistinctMonth(String tenderGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        if (tenderGuid != null && !tenderGuid.equals("")) {
            sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
        }

        PageHelper.startPage(1, 0, "month desc").setOrderByOnly(true);

        return this.list(sqlQueryParams).stream()
                .map(AerialPhotographyModel::getMonth)
                .distinct()
                .collect(Collectors.toList());
    }
}
=======
package org.tonzoc.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.exception.QueryParamNotSupportedException;
import org.tonzoc.model.AerialPhotographyModel;
import org.tonzoc.service.IAerialPhotographyService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "aerialPhotographyService")
public class AerialPhotographyService extends BaseService<AerialPhotographyModel> implements IAerialPhotographyService {

    @Override
    public AerialPhotographyModel getFirstByTender(String tenderGuid) throws Exception {
        if (tenderGuid == null || tenderGuid.equals("")) {
            throw new QueryParamNotSupportedException("为传递有效参数");
        }

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));

        PageHelper.startPage(1, 0, "month desc, sortId desc").setOrderByOnly(true);

        List<AerialPhotographyModel> list = this.list(sqlQueryParams);
        if (list.size() == 0) {
            throw new NotFoundException("结果未找到");
        }

        return list.get(0);
    }

    @Override
    public List<String> getDistinctMonth(String tenderGuid) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();

        if (tenderGuid != null && !tenderGuid.equals("")) {
            sqlQueryParams.add(new SqlQueryParam("tenderGuid", tenderGuid, "eq"));
        }

        PageHelper.startPage(1, 0, "month desc").setOrderByOnly(true);

        return this.list(sqlQueryParams).stream()
                .map(AerialPhotographyModel::getMonth)
                .distinct()
                .collect(Collectors.toList());
    }
}
>>>>>>> origin/master
