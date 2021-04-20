package org.tonzoc.controller;

import com.github.pagehelper.Page;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tonzoc.controller.params.BaidaQueryParams;
import org.tonzoc.controller.params.PageQueryParams;
import org.tonzoc.controller.response.PageResponse;
import org.tonzoc.exception.PageException;
import org.tonzoc.model.BaidaModel;
import org.tonzoc.model.BeamModel;
import org.tonzoc.service.IBaidaService;
import org.tonzoc.support.param.SqlQueryParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("baida")
public class BaidaController extends BaseController {

    @Autowired
    private IBaidaService baidaService;

    @GetMapping
    public PageResponse list(PageQueryParams pageQueryParams, BaidaQueryParams baidaQueryParams)
            throws PageException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Page<BaidaModel> page = parsePage(pageQueryParams);

        List<SqlQueryParam> sqlQueryParams = parseSqlQueryParams(baidaQueryParams);
        List list = baidaService.list(sqlQueryParams);

        return new PageResponse(page.getTotal(), list);
    }

    @GetMapping(value = "{guid}")
    public BaidaModel get(@PathVariable(value = "guid") String guid) {
        return baidaService.get(guid);
    }

    @PostMapping
    public void add(@RequestBody @Valid BaidaModel baidaModel) {
        this.baidaService.save(baidaModel);
    }

    @PutMapping(value = "{guid}")
    public void update(@RequestBody @Valid BaidaModel baidaModel) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.baidaService.update(baidaModel);
    }

    @DeleteMapping(value = "{guid}")
    public void remove(@PathVariable(value = "guid") String guid) {
        this.baidaService.remove(guid);
    }

    @PostMapping(value = "removeMany")
    public void removeMany(String guids) throws Exception {
        baidaService.removeMany(guids);
    }

    @GetMapping(value = "getStat")
    public List<BaidaModel> getStat(String categoryGuid, String projectTypeGuid) {
        return this.baidaService.getStat(categoryGuid, projectTypeGuid);
    }

    @GetMapping(value = "exportExcel")
    public void exportExcel(String categoryGuid, String projectTypeGuid, HttpServletResponse response) throws IOException {
        List<BaidaModel> statList = this.baidaService.getStat("", "");
        List<SqlQueryParam> sqlQueryParams = new ArrayList<>();
        List<BaidaModel> baidaList = this.baidaService.list(sqlQueryParams);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        int i = 0;
        HSSFRow row = sheet.createRow(i);
        row.createCell(0).setCellValue("项目名称");
        row.createCell(1).setCellValue("重要建设内容");
        row.createCell(2).setCellValue("项目类型");
        row.createCell(3).setCellValue("年度计划开工时间");
        row.createCell(4).setCellValue("计划竣工时间");
        row.createCell(5).setCellValue("总投资");
        row.createCell(6).setCellValue("年度计划完成投资");
        row.createCell(7).setCellValue("截止3月底完成投资");
        row.createCell(8).setCellValue("截止4月底完成投资");
        row.createCell(9).setCellValue("截止5月底完成投资");
        row.createCell(10).setCellValue("截止6月底完成投资");
        row.createCell(11).setCellValue("截止7月底完成投资");
        row.createCell(12).setCellValue("截止8月底完成投资");
        row.createCell(13).setCellValue("截止9月底完成投资");
        row.createCell(14).setCellValue("截止10月底完成投资");
        row.createCell(15).setCellValue("截止11月底完成投资");
        row.createCell(16).setCellValue("截止12月底完成投资");
        row.createCell(17).setCellValue("年度完成投资");
        row.createCell(18).setCellValue("年度完成投资比例");
        row.createCell(19).setCellValue("自开工以来完成投资");
        row.createCell(20).setCellValue("自开工以来完成投资比例");
        row.createCell(21).setCellValue("项目进展情况");
        row.createCell(22).setCellValue("存在的主要问题");
        row.createCell(23).setCellValue("项目所在地");
        ++i;
        for (BaidaModel statModel : statList) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(statModel.getCategoryName());
            row.createCell(1).setCellValue(statModel.getConstructionContent());
            row.createCell(2).setCellValue(statModel.getProjectTypeName());
            row.createCell(3).setCellValue(statModel.getPlanStartTime());
            row.createCell(4).setCellValue(statModel.getPlanCompleteTime());
            row.createCell(5).setCellValue(statModel.getTotalInvestment().toString());
            row.createCell(6).setCellValue(statModel.getCurrentYearPlan().toString());
            row.createCell(7).setCellValue(statModel.getComplete3().toString());
            row.createCell(8).setCellValue(statModel.getComplete4().toString());
            row.createCell(9).setCellValue(statModel.getComplete5().toString());
            row.createCell(10).setCellValue(statModel.getComplete6().toString());
            row.createCell(11).setCellValue(statModel.getComplete7().toString());
            row.createCell(12).setCellValue(statModel.getComplete8().toString());
            row.createCell(13).setCellValue(statModel.getComplete9().toString());
            row.createCell(14).setCellValue(statModel.getComplete10().toString());
            row.createCell(15).setCellValue(statModel.getComplete11().toString());
            row.createCell(16).setCellValue(statModel.getComplete12().toString());
            row.createCell(17).setCellValue(statModel.getCurrentYearComplete().toString());
            row.createCell(18).setCellValue(statModel.getCurrentYearComplete().toString());
            row.createCell(19).setCellValue(statModel.getTotalCompleteInvestment().toString());
            row.createCell(20).setCellValue(statModel.getTotalCompleteInvestment().toString());
            row.createCell(21).setCellValue(statModel.getProjectProgress());
            row.createCell(22).setCellValue(statModel.getQuestion());
            row.createCell(23).setCellValue(statModel.getAddress());
            ++i;
            for (BaidaModel baidaModel : baidaList.stream().filter(baidaModel -> baidaModel.getCategoryGuid().equals(statModel.getCategoryGuid())).collect(Collectors.toList())) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(baidaModel.getProjectName());
                row.createCell(1).setCellValue(baidaModel.getConstructionContent());
                row.createCell(2).setCellValue(baidaModel.getProjectTypeName());
                row.createCell(3).setCellValue(baidaModel.getPlanStartTime());
                row.createCell(4).setCellValue(baidaModel.getPlanCompleteTime());
                row.createCell(5).setCellValue(baidaModel.getTotalInvestment().toString());
                row.createCell(6).setCellValue(baidaModel.getCurrentYearPlan().toString());
                row.createCell(7).setCellValue(baidaModel.getComplete3().toString());
                row.createCell(8).setCellValue(baidaModel.getComplete4().toString());
                row.createCell(9).setCellValue(baidaModel.getComplete5().toString());
                row.createCell(10).setCellValue(baidaModel.getComplete6().toString());
                row.createCell(11).setCellValue(baidaModel.getComplete7().toString());
                row.createCell(12).setCellValue(baidaModel.getComplete8().toString());
                row.createCell(13).setCellValue(baidaModel.getComplete9().toString());
                row.createCell(14).setCellValue(baidaModel.getComplete10().toString());
                row.createCell(15).setCellValue(baidaModel.getComplete11().toString());
                row.createCell(16).setCellValue(baidaModel.getComplete12().toString());
                row.createCell(17).setCellValue(baidaModel.getCurrentYearComplete().toString());
                row.createCell(18).setCellValue(baidaModel.getCurrentYearComplete().toString());
                row.createCell(19).setCellValue(baidaModel.getTotalCompleteInvestment().toString());
                row.createCell(20).setCellValue(baidaModel.getTotalCompleteInvestment().toString());
                row.createCell(21).setCellValue(baidaModel.getProjectProgress());
                row.createCell(22).setCellValue(baidaModel.getQuestion());
                row.createCell(23).setCellValue(baidaModel.getAddress());
                ++i;  
            }
        }

        workbook.setSheetName(0, "百大项目表");
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("utf-8");
        //这后面可以设置导出Excel的名称，此例中名为student.xls
        String fileName = "百大项目表";
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gbk"), "iso8859-1") + ".xlsx");

        //刷新缓冲
        response.flushBuffer();
        //workbook将Excel写入到response的输出流中，供页面下载
        workbook.write(response.getOutputStream());
    }

}
