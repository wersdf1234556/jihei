package org.tonzoc.service;

import org.tonzoc.model.BuildingSafetyDetailModel;
import org.tonzoc.model.ReturnBuildingModel;

import java.util.List;

public interface IBuildingSafetyDetailService extends IBaseService<BuildingSafetyDetailModel>{

    List<BuildingSafetyDetailModel> listByLtDate(String date, String safetyGuid);

    List<BuildingSafetyDetailModel> listByLikeDate(String date,String safetyGuid);

    // 工作量
    List<ReturnBuildingModel> workload();
}
