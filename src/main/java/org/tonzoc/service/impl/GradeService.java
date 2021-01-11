package org.tonzoc.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tonzoc.common.ExcelUtil;
import org.tonzoc.configuration.IntelliSiteProperties;
import org.tonzoc.exception.ExistsErrorException;
import org.tonzoc.exception.FileReadErrorException;
import org.tonzoc.exception.FileTypeErrorException;
import org.tonzoc.exception.NotMatchException;
import org.tonzoc.model.AttachmentModel;
import org.tonzoc.model.GradeModel;
import org.tonzoc.service.IAttachmentService;
import org.tonzoc.service.IGradeService;
import org.tonzoc.service.INewsService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Service("gradeService")
public class GradeService extends BaseService<GradeModel> implements IGradeService {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;
    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private INewsService newsService;

    public List<GradeModel> listByDate(String date){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("date", date, "eq"));
        List<GradeModel> list = this.list(sqlQueryParams);

        return list;
    }

    //下载模板
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            String[] title = {"人名", "成绩"};
            //创建Excel工作簿
            XSSFWorkbook workbook = new XSSFWorkbook();
            //创建一个工作表sheet
            XSSFSheet sheet = workbook.createSheet("模板");
//        //设置表格列宽度为10个字节
            sheet.setDefaultColumnWidth(18);
            //居中
            XSSFCellStyle style = workbook.createCellStyle();
            style.setAlignment(HorizontalAlignment.CENTER);
            //创建第一行表头
            XSSFRow headrow = sheet.createRow(0);
            //遍历添加表头
            for (int i = 0; i < title.length; i++) {
                //创建一个单元格
                XSSFCell cell = headrow.createCell(i);
                //创建一个内容对象
                XSSFRichTextString text = new XSSFRichTextString(title[i]);
//            sheet.createFreezePane(title[i].length(), 1);//设置冰冻列
                //将内容对象的文字内容写入到单元格中
                cell.setCellValue(text);
                cell.setCellStyle(style);
            }
            String filePath = intelliSiteProperties.getFilePath()+"/党建/学习强国/";
            isExist(filePath);
            String fileName = "学习强国成绩模板"; // 新文件名

            File file = new File( filePath + fileName + ".xlsx");
            file.createNewFile();
            //将Excel内容存盘
            FileOutputStream stream = FileUtils.openOutputStream(file);
            workbook.write(stream);
            stream.close();
            //转成流输出到页面可供下载
            dowland(fileName, file.getAbsolutePath(), response);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void dowland(String fileName, String url, HttpServletResponse response) throws  FileReadErrorException {
        try {
            // excel文件流输出到浏览器，选择下载路径
            File file = new File(url);
//            String fileName = file.getName();
            //模板导出
            Workbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
            //准备将Excel的输出流通过response输出到页面下载
            //八进制输出流
            response.setContentType("application/octet-stream");
            response.setCharacterEncoding("utf-8");
            //这后面可以设置导出Excel的名称，此例中名为student.xls
            response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xlsx");

            //刷新缓冲
            response.flushBuffer();
            //workbook将Excel写入到response的输出流中，供页面下载
            workbook.write(response.getOutputStream());
        } catch (Exception e) {// 发生不可预知异常，在此截获异常信息，并返回客户操作不成功
            e.printStackTrace();
            throw new FileReadErrorException("导出失败！！！");
        }
    }

    public void uploadTemplate(MultipartFile file, String date) throws Exception {
        if (file == null) {
            throw new FileNotFoundException("文件未找到");
        }
        //获取后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        if (!suffix.equals("xlsx")){
            throw new FileTypeErrorException("该上传文件的后缀名不是xlsx");
        }
        List<GradeModel> oldGrades = listByDate(date);
        if (oldGrades.size()!=0){
            throw new ExistsErrorException(date+"月的数据已存在，若想添加该日期数据，请先删除"+date+"月的数据才可上传");
        }
//        Map<String, String> map =  newsService.upFile(file,"党建/学习强国");
//        String attachmentGuid = map.get("attachmentGuid");
//        AttachmentModel attachmentModel = attachmentService.get(attachmentGuid);
//        String url = attachmentModel.getUrl();
//        String fileName = attachmentModel.getName();
        //需要解析的Excel文件
//        File file = new File(url);

        XSSFWorkbook workbook =
                new XSSFWorkbook(file.getInputStream());
        //读取默认第一个工作表sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取当前工作簿的行数
        int totalRows = sheet.getPhysicalNumberOfRows();
        XSSFRow row = null;
        List<GradeModel> gradeModels = new ArrayList<>();
        System.out.println("totalRows:"+totalRows);
        for (int i = 1; i <= totalRows - 1; i++) {
            row = sheet.getRow(i);
            //cellnum从0开始
            String personName = (String) ExcelUtil.getCellFormatValue(row.getCell(0));
            String grade = (String)ExcelUtil.getCellFormatValue(row.getCell(1));
            Boolean isInteger=isInteger(grade);
            if (isInteger==false){
                throw new NotMatchException(personName+"的成绩不是纯数字，请检查后将文件重新导入！");
            }
            System.out.println(personName);
            System.out.println(grade);
            if (grade==null){
                grade="0";
            }
            GradeModel gradeModel = new GradeModel();
            gradeModel.setDate(date);
            gradeModel.setName(personName);
            gradeModel.setGrade(Integer.parseInt(grade));
            gradeModels.add(gradeModel);
        }
        saveMany(gradeModels);
    }

    //判断一个字符串是否为数字型
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    //不带文件名的Path：如：D:\xml2\2018\04\
    public static boolean isExist(String filePath) {
//        System.out.println("进来了");
        String paths[] = filePath.split("/");
        String dir = paths[0];
        for (int i = 0; i < paths.length - 1; i++) {//注意此处循环的长度
            try {
                dir = dir + "/" + paths[i + 1];
                File dirFile = new File(dir);
                if (!dirFile.exists()) {
                    dirFile.mkdir();
                    System.out.println("创建目录为：" + dir);
                }
            } catch (Exception err) {
                System.err.println("文件夹创建发生异常");
            }
        }
        File fp = new File(filePath);
        if (!fp.exists()) {
            return true; // 文件不存在，执行下载功能
        } else {
            return false; // 文件存在不做处理
        }
    }

}
