package org.tonzoc.service.impl;

import org.apache.commons.io.FileUtils;
import org.apache.http.entity.ContentType;
import org.apache.poi.openxml4j.util.ZipSecureFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.tonzoc.common.ExcelUtil;
import org.tonzoc.common.FileHelper;
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
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import static org.tonzoc.common.ExcelUtil.isExist;

@Service("gradeService")
public class GradeService extends BaseService<GradeModel> implements IGradeService {

    @Autowired
    private IntelliSiteProperties intelliSiteProperties;
    @Autowired
    private IAttachmentService attachmentService;
    @Autowired
    private INewsService newsService;
    @Autowired
    private FileHelper fileHelper;

    public List<GradeModel> listByDate(String date){
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        sqlQueryParams.add(new SqlQueryParam("date", date, "eq"));
        List<GradeModel> list = this.list(sqlQueryParams);

        return list;
    }

    //下载模板
    public void downloadTemplate(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
//            String[] title = {"人名", "成绩"};
//            //创建Excel工作簿
//            XSSFWorkbook workbook = new XSSFWorkbook();
//            //创建一个工作表sheet
//            XSSFSheet sheet = workbook.createSheet("模板");
////        //设置表格列宽度为10个字节
//            sheet.setDefaultColumnWidth(18);
//            //居中
//            XSSFCellStyle style = workbook.createCellStyle();
//            style.setAlignment(HorizontalAlignment.CENTER);
//            //创建第一行表头
//            XSSFRow headrow = sheet.createRow(0);
//            //遍历添加表头
//            for (int i = 0; i < title.length; i++) {
//                //创建一个单元格
//                XSSFCell cell = headrow.createCell(i);
//                //创建一个内容对象
//                XSSFRichTextString text = new XSSFRichTextString(title[i]);
////            sheet.createFreezePane(title[i].length(), 1);//设置冰冻列
//                //将内容对象的文字内容写入到单元格中
//                cell.setCellValue(text);
//                cell.setCellStyle(style);
//            }

            String filePath = intelliSiteProperties.getFilePath()+"/党建/";
//            isExist(filePath);
            String fileName = "学习强国成绩模板"; // 新文件名
//            File file = new File( filePath + fileName + ".xlsx");
//            file.createNewFile();
//            //将Excel内容存盘
//            FileOutputStream stream = FileUtils.openOutputStream(file);
//            workbook.write(stream);
//            stream.close();
            BufferedInputStream br = new BufferedInputStream(new FileInputStream(filePath + fileName + ".xlsx"));
            byte[] buf = new byte[1024];
            int len = 0;
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".xlsx","UTF-8"));
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
            //转成流输出到页面可供下载
//            dowland(fileName, file.getAbsolutePath(), response);
        }catch (Exception e){
            e.printStackTrace();
            throw new FileReadErrorException("文件有问题/文件不存在");
        }

    }

    public String upExcelTemplate(MultipartFile file){
        String[] str = fileHelper.excelTemplateUpload(file,"党建","");
        return str[0];
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
//        System.out.println("totalRows:"+totalRows);
        for (int i = 1; i <= totalRows - 1; i++) {
            row = sheet.getRow(i);
            if (!ExcelUtil.isEmptyRow(row)){
                //cellnum从0开始
                String personName = (String) ExcelUtil.getCellFormatValue(row.getCell(0));
                if (personName!=null&&!personName.isEmpty()){
//                throw new FileReadErrorException("第"+(row.getRowNum()+1)+"行的人名为空，请检查后上传文件");
                    String grade = (String)ExcelUtil.getCellFormatValue(row.getCell(1));
                    Boolean isInteger=ExcelUtil.isInteger(grade);
                    if (isInteger==false){
                        throw new NotMatchException(personName+"的成绩不是纯数字，请检查后将文件重新导入！");
                    }
                    if (grade==null){
                        grade="0";
                    }
                    GradeModel gradeModel = new GradeModel();
                    gradeModel.setDate(date);
                    gradeModel.setName(personName);
                    gradeModel.setGrade(Integer.parseInt(grade));
                    gradeModels.add(gradeModel);
                }
            }
        }

        saveMany(gradeModels);
    }


}
