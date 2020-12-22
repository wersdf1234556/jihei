package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.NewsModel;
import org.tonzoc.service.INewsService;

@Service("newsService")
public class NewsService extends BaseService<NewsModel> implements INewsService {

}
