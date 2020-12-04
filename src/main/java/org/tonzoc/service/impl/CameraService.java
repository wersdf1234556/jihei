package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tonzoc.mapper.CameraMapper;
import org.tonzoc.model.CameraModel;
import org.tonzoc.service.ICameraService;

@Service(value = "cameraService")
public class CameraService extends BaseService<CameraModel> implements ICameraService {
    @Autowired
    private CameraMapper cameraMapper;

    public void insertStack(CameraModel cameraModel){
        //1.查询camera表中最大的序号serial，然后加1
        Integer serial = cameraMapper.maxSerial()+1;
        cameraModel.setSerialNum(serial);
        //2.top(置顶)字段默认填写:1(不置顶)
        if (cameraModel.getTopFlag()==null){
            cameraModel.setTopFlag(1);
        }
        save(cameraModel);
    }


}
