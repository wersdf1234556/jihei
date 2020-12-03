package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.ExcelHelper;
import org.tonzoc.exception.NotFoundException;
import org.tonzoc.model.AerialPhotographyLocationModel;
import org.tonzoc.service.IAerialPhotographyLocationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service(value = "aerialPhotographyLocationService")
public class AerialPhotographyLocationService extends BaseService<AerialPhotographyLocationModel> implements IAerialPhotographyLocationService {
    public void importExcel(MultipartFile file, String aerialPhotographyGuid) throws NotFoundException {
        //创建处理EXCEL的类
        ExcelHelper excelHelper = new ExcelHelper();
        //解析excel，获取上传的事件单
        List<Map<String, Object>> rawList = excelHelper.getExcelInfo(file);
        List<AerialPhotographyLocationModel> resultList = new ArrayList<>();

        if (rawList != null && !rawList.isEmpty()) {
            //至此已经将excel中的数据转换到list里面了,接下来就可以操作list,可以进行保存到数据库,或者其他操作,
            for (Map<String, Object> map : rawList) {
                int time = Integer.parseInt(map.get("key0").toString());
                String lng = map.get("key1").toString();
                String lat = map.get("key2").toString();
                String altitude = map.get("key3").toString();

                AerialPhotographyLocationModel aerialPhotographyLocationModel = new AerialPhotographyLocationModel();

                aerialPhotographyLocationModel.setLat(lat);
                aerialPhotographyLocationModel.setLng(lng);
                aerialPhotographyLocationModel.setTime(time);
                aerialPhotographyLocationModel.setAltitude(altitude);
                aerialPhotographyLocationModel.setAerialPhotographyGuid(aerialPhotographyGuid);

                resultList.add(aerialPhotographyLocationModel);
            }

            this.saveMany(resultList);

        } else {
            throw new NotFoundException("未找到数据");
        }
    }

}
