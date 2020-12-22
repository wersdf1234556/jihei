package org.tonzoc.service;

import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.MemorabiliaModel;

import java.util.Map;

public interface IMemorabiliaService extends IBaseService<MemorabiliaModel> {

    // 上传文件
    Map<String, String> upFile(MultipartFile file, String currentTime);
}
