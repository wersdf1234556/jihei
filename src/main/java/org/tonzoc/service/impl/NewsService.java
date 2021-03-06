package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.exception.FileTypeErrorException;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.NewsModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IAttendanceService;
import org.tonzoc.service.INewsService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.imageio.ImageIO;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("newsService")
public class NewsService extends BaseService<NewsModel> implements INewsService {
    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private FileHelper fileHelper;
    @Autowired
    private AttachmentMapper attachmentMapper;

    public List<NewsModel> listByAttachmentId(String attachmentGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("attachmentGuid", attachmentGuid, "eq"));

        List<NewsModel> list = this.list(sqlQueryParams);
        return list;
    }

    @Transactional
    public void insertStack(NewsModel newsModel){
        if (newsModel.getAttachmentGuid()==null){
            newsModel.setAttachmentGuid("");
        }if (newsModel.getTopflag()==null){
            newsModel.setTopflag(1);//不置顶
        }if (newsModel.getPublisher()==null){
            newsModel.setPublisher("");
        }if (newsModel.getAbstractContent()==null){
            newsModel.setAbstractContent("");
        }
        this.save(newsModel);

    }
    @Transactional
    public void updateStack(NewsModel newsModel){
        NewsModel oldNews = get(newsModel.getGuid());
        if (!newsModel.getAttachmentGuid().equals(oldNews.getAttachmentGuid())){
            if (!oldNews.getAttachmentGuid().isEmpty()){
                AttachmentModel oldAttachment = attachmentService.get(oldNews.getAttachmentGuid());
                if (oldAttachment!=null){
                    attachmentService.deleteFile(oldNews.getAttachmentGuid());
                    attachmentService.remove(oldNews.getAttachmentGuid());
                }
            }
            newsModel.setAttachmentGuid(newsModel.getAttachmentGuid());
        }
        update(newsModel);
    }

    @Transactional
    public Map<String, String> upFile(MultipartFile file,String subTypeName) {

        String[] str = fileHelper.fileUpload(file,subTypeName,"");
        // 获取新的guid命名附件
//            String uuid = UUID.randomUUID().toString().toUpperCase();
        AttachmentModel attachmentModel = new AttachmentModel();
//            attachmentModel.setGuid(uuid);
        attachmentModel.setUrl(str[0]);
        attachmentModel.setName(str[1]);
        attachmentModel.setQualityTraceabilityGuid("");
        attachmentModel.setSortId(0);
        attachmentService.save(attachmentModel);
        Map<String, String> map = new HashMap<>();
        map.put("attachmentGuid", attachmentModel.getGuid());
        return map;
    }

}
