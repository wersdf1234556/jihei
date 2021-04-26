package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.model.BeamGroupModel;
import org.tonzoc.model.BeamPersonModel;
import org.tonzoc.service.IBeamGroupService;
import org.tonzoc.service.IBeamPersonService;
import org.tonzoc.support.param.SqlQueryParam;

import java.util.ArrayList;
import java.util.List;

@Service("BeamGroupService")
public class BeamGroupService extends BaseService<BeamGroupModel> implements IBeamGroupService {

    @Autowired
    private IBeamPersonService beamPersonService;

    // 删除
    public void delete(String guid) throws Exception {

        BeamGroupModel beamGroupModel = this.get(guid);

        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("beamGroupGuid", beamGroupModel.getGuid(), "eq"));
        List<BeamPersonModel> list = beamPersonService.list(sqlQueryParams);
        if (list.size() > 0) {

            throw new Exception("该分组已被使用，不可删除");
        }

        this.remove(guid);
    }
}
