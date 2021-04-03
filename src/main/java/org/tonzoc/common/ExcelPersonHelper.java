package org.tonzoc.common;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.tonzoc.mapper.PersonMapper;
import org.tonzoc.mapper.PersonTypeMapper;
import org.tonzoc.mapper.TenderMapper;
import org.tonzoc.model.PersonModel;
import org.tonzoc.model.PersonTypeModel;
import org.tonzoc.model.support.ReturnPersonModel;
import org.tonzoc.service.IPersonService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ExcelPersonHelper {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private IPersonService personService;

    @Autowired
    private TenderMapper tenderMapper;

    @Autowired
    private PersonTypeMapper personTypeMapper;

    public List<ReturnPersonModel> excel(MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        Workbook wb = null;
        List<ReturnPersonModel> list1 = new ArrayList<>();

        if ("xlsx".equals(suffix)) {
            wb = new HSSFWorkbook(file.getInputStream());
        }else{
            wb = new XSSFWorkbook(file.getInputStream());
        }

        Sheet sheet = wb.getSheetAt(0); // 获取excel表单
        List<PersonModel> list = new ArrayList<>();
        if (sheet != null) {
            for (int i = 1; i <= sheet.getLastRowNum(); i++){
                Row row = sheet.getRow(i); // 获取行数据

                if (row != null) {
                    Cell cell = row.getCell(3);
                    cell.setCellType(CellType.STRING);
                    String idCard = row.getCell(3).getStringCellValue();

                    try{
                        if (personMapper.countByIdCard(idCard) == 0) {
                            PersonModel personModel = new PersonModel();
                            personModel.setName(row.getCell(0).getStringCellValue()); // 姓名
                            personModel.setTenderGuid(tenderMapper.guidByName(row.getCell(1).getStringCellValue())); // 标段
                            PersonTypeModel personTypeModel = personTypeMapper.guidByName(row.getCell(2).getStringCellValue());
                            personModel.setPersonTypeGuid(personTypeModel.getGuid()); // 人员类型
                            personModel.setCategoryGuid(personTypeModel.getCategoryGuid()); // 人员类别
                            personModel.setIdCard(idCard); // 身份证号
                            personModel.setMobile(row.getCell(4).getStringCellValue()); // 联系电话
                            Date date = row.getCell(5).getDateCellValue(); // 进场时间
                            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setEnterAreaTime(formater.format(date));
                            personModel.setNativePlace(row.getCell(6).getStringCellValue()); // 籍贯
                            personModel.setDeparturePlaceCode(row.getCell(7).getStringCellValue()); // 出发地
                            String isRisk = row.getCell(8).getStringCellValue(); // 是否途经中高风险地区
                            if ("低风险".equals(isRisk)) {
                                personModel.setIsRisk(0);
                            }else if("中风险".equals(isRisk)) {
                                personModel.setIsRisk(1);
                            }else if("高风险".equals(isRisk)){
                                personModel.setIsRisk(2);
                            }
                            personModel.setVehicle(row.getCell(9).getStringCellValue()); // 到达工地方式
                            Date date1 = row.getCell(10).getDateCellValue();
                            DateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setTravelTime(formater1.format(date1)); // 乘车时间
                            personModel.setTrainNumber(row.getCell(11).getStringCellValue()); // 车号或车次
                            personModel.setSamplingOrgan(row.getCell(12).getStringCellValue()); // 采样单位
                            Date date2 = row.getCell(13).getDateCellValue();
                            DateFormat formater2 = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setReportTime(formater2.format(date2)); // 采样时间
                            Cell cell14 = row.getCell(14); // 条码号
                            cell14.setCellType(CellType.STRING);
                            String barCode = cell14.getStringCellValue();
                            personModel.setBarCode(barCode);
                            String sampleType = row.getCell(15).getStringCellValue(); // 样本类型
                            if ("咽拭子".equals(sampleType)) {
                                personModel.setSampleType(0);
                            }else if("鼻拭子".equals(sampleType)) {
                                personModel.setSampleType(1);
                            }else if("肛拭子".equals(sampleType)){
                                personModel.setSampleType(3);
                            }
                            String result = row.getCell(16).getStringCellValue(); // 检测结果
                            if ("阴性".equals(result)) {
                                personModel.setResult(0);
                            }else if("阳性".equals(result)) {
                                personModel.setResult(1);
                            }
                            Date date3 = row.getCell(17).getDateCellValue();
                            DateFormat formater3 = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setReportTime(formater3.format(date3)); // 报告时间
                            personModel.setTestingOrgan(row.getCell(18).getStringCellValue()); // 检测机构
                            personModel.setTestingAddress(row.getCell(19).getStringCellValue()); // 检测机构地址
                            personModel.setRemark(row.getCell(20).getStringCellValue()); // 地址补全
                            personModel.setPassword("123456");
                            personModel.setCertificatePic("");
                            personModel.setCertificateName("");
                            personModel.setPhoto("");

                            list.add(personModel);
                            if (list.size() == 1000) {
                                personService.saveMany(list);
                                list.clear();
                            }
                        }else {
                            ReturnPersonModel returnPersonModel = new ReturnPersonModel();
                            returnPersonModel.setName(row.getCell(0).getStringCellValue());
                            returnPersonModel.setIdCard(idCard);
                            list1.add(returnPersonModel);
                            return list1;
                        }
                    }catch (Exception e){
                        throw new IOException("请检查录入的数据");
                    }
                }
            }
            if (!list.isEmpty()) {
                personService.saveMany(list);
            }
        }
        return list1;
    }
}
