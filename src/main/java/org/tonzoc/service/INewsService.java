package org.tonzoc.service;


import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.NewsModel;

import java.util.Map;

public interface INewsService extends IBaseService<NewsModel> {
    void insertStack(NewsModel newsModel);
    Map<String, String> upFile(MultipartFile file);
    void updateStack(NewsModel newsModel);

    
}
