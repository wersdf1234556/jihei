package org.tonzoc.service;

import org.tonzoc.model.MapInformationModel;

import java.text.ParseException;
import java.util.List;

public interface IMapInformationService extends IBaseService<MapInformationModel> {

    // 查询字符串转时间
    List<MapInformationModel> selected(List<MapInformationModel> list);

    // 处理时间
    MapInformationModel updateTime (MapInformationModel mapInformationModel) throws ParseException;

    // 查询最新三条数据
    List<MapInformationModel> three();
}
