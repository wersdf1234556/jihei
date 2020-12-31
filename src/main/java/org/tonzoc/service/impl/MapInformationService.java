package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.mapper.MapInformationMapper;
import org.tonzoc.model.MapInformationModel;
import org.tonzoc.service.IMapInformationService;

import java.text.ParseException;
import java.util.List;

@Service
public class MapInformationService extends BaseService<MapInformationModel> implements IMapInformationService {

    @Autowired
    private MapInformationMapper mapInformationMapper;

    // 查询字符串转时间
    @Override
    public List<MapInformationModel> selected (List<MapInformationModel> list) {
        if (list.size() > 0) {
            for (MapInformationModel m : list) {

                m.setCurrentDate(TimeHelper.dateToString(m.getCurrentTime()));
            }
        }
        return list;
    }

    // 处理时间
    @Override
    public MapInformationModel updateTime(MapInformationModel mapInformationModel) throws ParseException {

        if (!mapInformationModel.getCurrentDate().equals("") && mapInformationModel.getCurrentDate() != null) {

            mapInformationMapper.updateTime(TimeHelper.stringToDate(mapInformationModel.getCurrentDate()), mapInformationModel.getGuid());
        }
        mapInformationModel.setSortId(0);
        mapInformationModel.setCurrentDate("");
        return mapInformationModel;
    }

    // 查询最新三条数据
    @Override
    public List<MapInformationModel> three() {

        return this.selected(mapInformationMapper.three());
    }
}
