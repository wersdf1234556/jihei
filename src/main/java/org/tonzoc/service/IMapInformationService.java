package org.tonzoc.service;

import org.tonzoc.model.MapInformationModel;

import java.util.List;

public interface IMapInformationService extends IBaseService<MapInformationModel> {

    // 查询最新三条数据
    List<MapInformationModel> three();
}
