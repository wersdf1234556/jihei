package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.AdvertisingVideoModel;
import org.tonzoc.model.ProjectVideoModel;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface IProjectVideoService extends IBaseService<ProjectVideoModel> {

    // 查询字符串转时间
    List<ProjectVideoModel> selected(List<ProjectVideoModel> list);

    // 处理时间
    ProjectVideoModel updateTime (ProjectVideoModel projectVideoModel) throws ParseException;

    // 上传文件
    Map<String, String> upFile(MultipartFile file, String currentTime);
}
