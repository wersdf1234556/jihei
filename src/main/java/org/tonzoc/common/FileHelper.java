package org.tonzoc.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.mapper.AttachmentMapper;
import org.tonzoc.service.IAttachmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Configuration
public class FileHelper {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;

    @Autowired
    private AttachmentMapper attachmentMapper;

    @Autowired
    private IAttachmentService attachmentService;

    // 上传文件
    public String[] fileUpload(MultipartFile file, String name, String qualityTraceabilityGuid) {
        String[] str = new String[2];

        if (file.isEmpty()) {
            return str;
        }
        String path = intelliSiteProperties.getFilePath(); // 上传路径
        String fileType = intelliSiteProperties.getFileUrl(); // 文件类型
        String fileName = file.getOriginalFilename(); // 文件名称
        String suffix = fileName.substring(fileName.lastIndexOf(".")); // 后缀名
        String newFileName = this.newGUID(); // 随机生成的文件名

        File dest = null;
        String url = "";
        if ("".equals(name) || name == null) {
            url = path + fileType + newFileName + suffix;
            dest = new File(url);
        } else {
            url = path + fileType + name + "/" + newFileName + suffix;
            dest = new File(url);
        }

        if (dest.exists()) { // 如果原先有相同文件，则删除
            dest.delete();
            /*// 删除这个表中关联的这条记录
            String guid = attachmentMapper.getGuid(url, qualityTraceabilityGuid);
            if (!"".equals(guid) && guid != null) {
                attachmentService.remove(guid);
            }*/
        }
        if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest); // 保存文件
            str[0] = url;
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
    public String[] fileUploads(MultipartFile[] file, String subTypeName, String qualityTraceabilityGuid) {
        if (file.length > 0) {
            for (MultipartFile f : file) {
                this.fileUpload(f, subTypeName, qualityTraceabilityGuid);
            }
        }
        return null;
    }

    // 删除文件
    public String deleteFile(List<String> list) {
        for (String li : list) {
            try {
                File file = new File(li);
                if (file.exists()) {
                    file.delete();
                    return "文件已删除";
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "删除文件报错";
            }
        }
        return "文件不存在";
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
        return url;
    }

    // 预览图片
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
        System.out.println("111");
        return bytes;
    }

    // 预览视频
    public void getVideo(HttpServletRequest request, HttpServletResponse response, String url) {

        response.reset();
        //获取从那个字节开始读取文件
        String rangeString = request.getHeader("Range");

        try {
            //获取响应的输出流
            OutputStream outputStream = response.getOutputStream();
            File file = new File(url);
            if(file.exists()){
                RandomAccessFile targetFile = new RandomAccessFile(file, "r");
                long fileLength = targetFile.length();
                //播放
                if(rangeString != null){

                    long range = Long.valueOf(rangeString.substring(rangeString.indexOf("=") + 1, rangeString.indexOf("-")));
                    //设置内容类型
                    response.setHeader("Content-Type", "video/mp4");
                    //设置此次相应返回的数据长度
                    response.setHeader("Content-Length", String.valueOf(fileLength - range));
                    //设置此次相应返回的数据范围
                    response.setHeader("Content-Range", "bytes "+range+"-"+(fileLength-1)+"/"+fileLength);
                    //返回码需要为206，而不是200
                    response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                    //设定文件读取开始位置（以字节为单位）
                    targetFile.seek(range);
                }else {//下载

                    //设置响应头，把文件名字设置好
                    response.setHeader("Content-Disposition", "attachment; filename="+ file.getName());
                    //设置文件长度
                    response.setHeader("Content-Length", String.valueOf(fileLength));
                    //解决编码问题
                    response.setHeader("Content-Type","application/octet-stream");
                }


                byte[] cache = new byte[1024 * 300];
                int flag;
                while ((flag = targetFile.read(cache))!=-1){
                    outputStream.write(cache, 0, flag);
                }
            }else {
                String message = "file:"+file.getName()+" not exists";
                //解决编码问题
                response.setHeader("Content-Type","application/json");
                outputStream.write(message.getBytes(StandardCharsets.UTF_8));
            }

            outputStream.flush();
            outputStream.close();

        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    // 预览PDF
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

    // 生成二维码
    public void generateQRCodeImage(String text, int width, int height, String fileName) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height); // 生成二维码

        String filePath = new IntelliSiteProperties().getFilePath() + "/qrcodeImg/" + fileName;
        Path path = FileSystems.getDefault().getPath(filePath);

        System.out.println("path" + path);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path); // 将二维码存进去
    }

    // 随机生成guid;
    public String newGUID() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    // 上传excel文件
    public String[] excelTemplateUpload(MultipartFile file, String subTypeName,String qualityTraceabilityGuid) {
        String[] str = new String[2];

        if (file.isEmpty()) {
            return str;
        }
        String path = intelliSiteProperties.getFilePath(); // 上传路径
        String fileType = intelliSiteProperties.getFileUrl(); // 文件类型
        String fileName = file.getOriginalFilename(); // 文件名称
//        String suffix = fileName.substring(fileName.lastIndexOf(".")); // 后缀名

        File dest = null;
        String url = "";
        if ("".equals(subTypeName) || subTypeName == null) {
            url = path + fileType + fileName ;
            dest = new File(url);
        } else {
            url = path + fileType + subTypeName + "/" + fileName ;
            dest = new File(url);
        }

        if (dest.exists()) { // 如果原先有相同文件，则删除
            dest.delete();
            // 删除这个表中关联的这条记录
            String guid = attachmentMapper.getGuid(url, qualityTraceabilityGuid);
            if (!"".equals(guid) && guid != null) {
                attachmentService.remove(guid);
            }
        }
        if (!dest.getParentFile().exists()) { // 判断文件父目录是否存在
            dest.getParentFile().mkdirs();
        }

        try {
            file.transferTo(dest); // 保存文件
            str[0] = url;
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
}
