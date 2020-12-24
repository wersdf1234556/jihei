package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AdvertisingVideoModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IAdvertisingVideoService extends IBaseService<AdvertisingVideoModel> {

    // 上传视频文件
    Map<String, String> upFile(MultipartFile file, String currentTime);

    // 查询字符串转时间
    List<AdvertisingVideoModel> selected(List<AdvertisingVideoModel> list);

    // 处理时间
    AdvertisingVideoModel updateTime (AdvertisingVideoModel advertisingVideoModel) throws ParseException;
}
