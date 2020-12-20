package org.tonzoc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.service.IAttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Configuration
public class FileHelper {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    // 上传文件
    @Transactional
    public String[] fileUpload(MultipartFile file, String subTypeName, String typeGuid, String subTypeGuid) {
        String[] str = new String[2];

        if (file.isEmpty()) {
            return str;
        }
        String fileName = file.getOriginalFilename();
        String path = intelliSiteProperties.getFilePath(); // 路径

        File dest = null;
        if ("".equals(subTypeName) || subTypeName == null) {
            dest = new File(path + "/" + fileName);
        }else{
            dest = new File(path + "/" + subTypeName + "/" + fileName);
        }

        if (dest.exists()) { // 如果原先有相同文件，则删除
            dest.delete();
            // 删除这个表中关联的这条记录 没做
            String guid = attachmentMapper.getGuid(fileName, typeGuid, subTypeGuid);
            attachmentService.remove(guid);
        }
        if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }

        try {
            file.transferTo(dest); // 保存文件
            str[0] = path + "/" + subTypeName + "/" + fileName;
            str[1] = fileName;
            return str;

        } catch (IllegalStateException e) {
            e.printStackTrace();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return str;
        }

    }

    // 上传多个文件
    public String[] fileUploads(MultipartFile[] file, String subTypeName, String typeGuid, String subTypeGuid) {
        if (file.length > 0) {
            for (MultipartFile f : file) {
                this.fileUpload(f, subTypeName, typeGuid, subTypeGuid);
            }
        }
        return null;
    }

    // 下载文件
    public String downLoad(HttpServletResponse response, String name, String url) throws UnsupportedEncodingException {

        File file = new File(url);

        if (file.exists()) { // 判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(name, "UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; // 文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; // 输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public byte[] getImage(String url) throws IOException {

        File file = new File(url);
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    public void PdfPreview(HttpServletResponse response, String url) throws IOException {

        response.setContentType("application/pdf");
        FileInputStream in = new FileInputStream(new File(url));
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[512];
        while ((in.read(b)) != -1) {
            out.write(b);
        }
        out.flush();
        in.close();
        out.close();
    }
}
