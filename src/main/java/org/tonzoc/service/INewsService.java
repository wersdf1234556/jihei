package org.tonzoc.service;


import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.model.NewsModel;

public interface INewsService extends IBaseService<NewsModel> {
    void insertStack(NewsModel newsModel,MultipartFile file);
    void updateStack(NewsModel newsModel,MultipartFile file);

    
}
