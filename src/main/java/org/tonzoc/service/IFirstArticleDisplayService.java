package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.FirstArticleDisplayModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IFirstArticleDisplayService extends IBaseService<FirstArticleDisplayModel> {

    // 查询字符串转时间
    List<FirstArticleDisplayModel> selected(List<FirstArticleDisplayModel> list);

    // 处理时间
    FirstArticleDisplayModel updateTime (FirstArticleDisplayModel firstArticleDisplayModel) throws ParseException;

    // 上传文件
    Map<String, String> upFile(MultipartFile file, String currentTime);
}
