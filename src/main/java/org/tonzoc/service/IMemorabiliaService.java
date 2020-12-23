package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.MemorabiliaModel;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface IMemorabiliaService extends IBaseService<MemorabiliaModel> {

    // 上传大事记文件
    Map<String, String> upFile(MultipartFile file, String currentTime);

    // 字符串转时间
    List<MemorabiliaModel> selected(List<MemorabiliaModel> list);

    // 时间转字符串
    Date updated(String currentDate) throws ParseException;


}
