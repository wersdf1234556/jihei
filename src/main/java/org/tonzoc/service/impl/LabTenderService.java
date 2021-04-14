package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.LabTenderModel;
import org.tonzoc.service.ILabTenderService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service(value = "labTenderService")
public class LabTenderService extends BaseService<LabTenderModel> implements ILabTenderService {

    @Override
    public String getBySectionId(String sectionId) {
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("mappingTenderGuid", sectionId, "eq"));

        List<LabTenderModel> labTenderModels = this.list(sqlQueryParams);
        return labTenderModels.get(0).getTenderGuid();
    }
}
