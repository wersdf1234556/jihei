package org.tonzoc.service.impl;

import org.springframework.stereotype.Service;
import org.tonzoc.model.NewsModel;
import org.tonzoc.model.NewsTitleModel;
import org.tonzoc.service.INewsService;
import org.tonzoc.service.INewsTitleService;

@Service("newsTitleService")
public class NewsTitleService extends BaseService<NewsTitleModel> implements INewsTitleService {

}
