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
import org.tonzoc.service.IPersonService;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void excel(MultipartFile file) throws Exception {

        String fileName = file.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        Workbook wb = null;

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
                            Cell cell4 = row.getCell(4); // 联系电话
                            cell4.setCellType(CellType.STRING);
                            String mobile = cell4.getStringCellValue();
                            personModel.setMobile(mobile);
                            Date date = row.getCell(5).getDateCellValue(); // 进场时间
                            DateFormat formater1 = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setEnterAreaTime(formater1.format(date));
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
                            personModel.setTravelTime(row.getCell(10).getStringCellValue()); // 乘车时间
                            personModel.setTrainNumber(row.getCell(11).getStringCellValue()); // 车号或车次
                            personModel.setSamplingOrgan(row.getCell(12).getStringCellValue()); // 采样单位
                            personModel.setSamplingTime(row.getCell(13).getStringCellValue()); // 采样时间
                            Cell cell14 = row.getCell(14); // 条码号
                            cell14.setCellType(CellType.STRING);
                            String barCode = cell4.getStringCellValue();
                            personModel.setBarCode(barCode);
                            String sampleType = row.getCell(15).getStringCellValue(); // 样本类型
                            if ("咽拭子".equals(sampleType)) {
                                personModel.setSampleType(0);
                            }else if("鼻拭子".equals(sampleType)) {
                                personModel.setSampleType(1);
                            }else if("鼻拭子".equals(sampleType)){
                                personModel.setSampleType(3);
                            }
                            String result = row.getCell(16).getStringCellValue(); // 检测结果
                            if ("阴性".equals(result)) {
                                personModel.setResult(0);
                            }else if("阳性".equals(result)) {
                                personModel.setResult(1);
                            }
                            Date d = row.getCell(17).getDateCellValue();
                            DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
                            personModel.setReportTime(formater.format(d)); // 报告时间
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
    }
}
