package org.tonzoc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.controller.params.NewsQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.NewsModel;
import org.tonzoc.model.support.Ueditor;
import org.tonzoc.service.INewsService;
import org.tonzoc.service.IRedisAuthService;
import org.tonzoc.support.param.SqlQueryParam;
import org.tonzoc.ueditor.ActionEnter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("news")
public class NewsController extends BaseController {


    @Autowired
    private INewsService newsService;
    @Autowired
    private IRedisAuthService redisAuthService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, NewsQueryParams newsQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        if (pageQueryParams.getOrder()==null||pageQueryParams.getOrder().isEmpty()){
            pageQueryParams.setOrder("topFlag,mainTable.createdAt");
        }else {
            pageQueryParams.setOrder("topFlag,mainTable."+pageQueryParams.getOrder());
        }
        if (pageQueryParams.getSort()==null||pageQueryParams.getSort().isEmpty()){
            pageQueryParams.setSort("desc");
        }
        Page<NewsModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(newsQueryParams);

        List list = newsService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @PostMapping
    public void add(@RequestBody @Valid NewsModel newsModel) throws Exception {
        newsModel.setCreatorGuid(redisAuthService.getCurrentUser().getGuid());
//        newsModel.setCreatorGuid("");
        this.newsService.insertStack(newsModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid NewsModel newsModel) {
        this.newsService.updateStack(newsModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.newsService.remove(guid);
    }


    @PostMapping(value = "removeMany")
    public void removeMany(String  guids) throws Exception {
        newsService.removeMany(guids);
    }
    // 上传文件
    @PostMapping(value = "upFile")
    public Map<String, String> upFile(MultipartFile file) {
        return newsService.upFile(file);
    }




    @RequestMapping("/ue")
    public void getUEConfig(HttpServletRequest request, HttpServletResponse response) {
        org.springframework.core.io.Resource res = new ClassPathResource("config.json");
        InputStream is = null;
        response.setHeader("Content-Type", "text/html");
        try {
            is = new FileInputStream(res.getFile());
            StringBuffer sb = new StringBuffer();
            byte[] b = new byte[1024];
            int length = 0;
            while (-1 != (length = is.read(b))) {
                sb.append(new String(b, 0, length, "utf-8"));
            }
            String result = sb.toString().replaceAll("/\\*(.|[\\r\\n])*?\\*/", "");
            JSONObject json = JSON.parseObject(result);
            PrintWriter out = response.getWriter();
            out.print(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping(value = "ueditorConfig")
    public String uploadImg(MultipartFile upfile,
                            HttpServletRequest request) throws IOException {
        Ueditor ueditor = new Ueditor();
//        String path = request.getSession().getServletContext()
//                .getRealPath("upload/image");
        String path ="D:/intellisite/jihei/upload/党建/";
        System.out.println(path);
        String ct = upfile.getContentType() ;
        String fileType = "";
        if (ct.indexOf("/")>0) {
            fileType = ct.substring(ct.indexOf("/")+1);
        }
        String fileName = UUID.randomUUID() + "." + fileType;
        File targetFile = new File(path);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        File targetFile2 = new File(path+"/"+fileName);
        if (!targetFile2.exists()) {
            targetFile2.createNewFile();
        }
        // 保存
        try {
            upfile.transferTo(targetFile2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ueditor.setState("SUCCESS");
        ueditor.setTitle(fileName);
        ueditor.setOriginal(fileName);
        ueditor.setUrl("D:/intellisite/jihei/upload/党建"+File.separator+fileName);
        System.out.println( JSON.toJSONString(ueditor));
        return JSON.toJSONString(ueditor);
    }

    @GetMapping(value="/config")
    @CrossOrigin(origins = "*",maxAge = 3600)
    public String config(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("application/json");
        String rootPath = request.getSession().getServletContext().getRealPath("/");
        return new ActionEnter( request, rootPath).exec();
//        String exec="";
//        try {
//            exec= new ActionEnter(request, rootPath).exec();
//            PrintWriter writer = response.getWriter();
//            writer.write(exec);
//            writer.flush();
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(JSON.toJSONString(exec));
//        return JSON.toJSONString(exec);
    }

}

