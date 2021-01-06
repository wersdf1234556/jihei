package org.tonzoc.service;


import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.NewsModel;

import java.util.Map;

public interface INewsService extends IBaseService<NewsModel> {
    void insertStack(NewsModel newsModel);
    void upFile(MultipartFile file, String guid);

    
}
