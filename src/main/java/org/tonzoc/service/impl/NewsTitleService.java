package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.NewsModel;
import org.tonzoc.model.NewsTitleModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.INewsService;
import org.tonzoc.service.INewsTitleService;

@Service("newsTitleService")
public class NewsTitleService extends BaseService<NewsTitleModel> implements INewsTitleService {
}
