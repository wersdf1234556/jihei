package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.MapInformationMapper;
import org.tonzoc.model.MapInformationModel;
import org.tonzoc.service.IMapInformationService;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class MapInformationService extends BaseService<MapInformationModel> implements IMapInformationService {

    @Autowired
    private MapInformationMapper mapInformationMapper;

    @Override
    public List<MapInformationModel> selected (List<MapInformationModel> list) {
        if (list.size() > 0) {
            for (MapInformationModel m : list) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                m.setCurrentDate(simpleDateFormat.format(m.getCurrentTime()));
            }
        }
        return list;
    }

    @Override
    public List<MapInformationModel> three() {

        return mapInformationMapper.three();
    }

}
