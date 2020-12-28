package org.tonzoc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.common.FileHelper;
import org.tonzoc.common.TimeHelper;
import org.tonzoc.exception.FileTypeErrorException;
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

    public List<NewsModel> listByAttachmentId(String attachmentGuid){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("attachmentGuid", attachmentGuid, "eq"));

        List<NewsModel> list = this.list(sqlQueryParams);
        return list;
    }

    @Transactional
    public void insertStack(NewsModel newsModel,MultipartFile file){
        if (file!=null){
            String[] str = fileHelper.fileUpload(file,"党建",0,"");
            // 获取新的guid命名附件
//            String uuid = UUID.randomUUID().toString().toUpperCase();
            AttachmentModel attachmentModel = new AttachmentModel();
//            attachmentModel.setGuid(uuid);
            attachmentModel.setUrl(str[0]);
            attachmentModel.setName(str[1]);
            attachmentModel.setSubTypeGuid("");
            attachmentModel.setTypeId(0);
            attachmentModel.setSortId(0);
            attachmentService.save(attachmentModel);
            newsModel.setAttachmentGuid(attachmentModel.getGuid());
        }else {
            newsModel.setAttachmentGuid("");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Date date = new Date();//创建一个date对象保存当前时间
        newsModel.setReleaseTime(df.format(date));
        if (newsModel.getTopflag()==null){
            newsModel.setTopflag(1);//不置顶
        }
        this.save(newsModel);

    }

    @Transactional
    public void updateStack(NewsModel newsModel,MultipartFile file){
        if (file!=null){
            String[] str = fileHelper.fileUpload(file,"党建",0,"");
            AttachmentModel attachmentModel = new AttachmentModel();
            attachmentModel.setUrl(str[0]);
            attachmentModel.setName(str[1]);
            attachmentModel.setSubTypeGuid("");
            attachmentModel.setTypeId(0);
            attachmentModel.setSortId(0);
            attachmentService.save(attachmentModel);
            if (newsModel.getAttachmentGuid().isEmpty()){
                AttachmentModel oldAttachment = attachmentService.get(newsModel.getAttachmentGuid());
                if (oldAttachment!=null){
                    String returnData = attachmentService.deleteFile(newsModel.getAttachmentGuid());
                    System.out.println(returnData);
                }
            }
            newsModel.setAttachmentGuid(attachmentModel.getGuid());
        }else {
            newsModel.setAttachmentGuid("");
        }

        this.update(newsModel);

    }

}
