package org.tonzoc.common;


import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;

public class ExcelUtil {
    /**
     * @param filePath 需要读取的文件路径
     * @param column   指定需要获取的列数，例如第一列 1
     * @param startRow 指定从第几行开始读取数据
     * @param endRow   指定结束行
     * @return 返回读取列数据的set
     */
    public static HashSet<String> getColumnSet(String filePath, int column, int startRow, int endRow) {
        Workbook wb = readExcel(filePath); //文件
        Sheet sheet = wb.getSheetAt(0); //sheet
        int rownum = sheet.getPhysicalNumberOfRows(); //行数
        Row row = null;
        HashSet<String> result = new HashSet<>();
        String cellData = null;
        if (wb != null) {
            for (int i = startRow - 1; i < endRow; i++) {
                row = sheet.getRow(i);
                if (row != null) {
                    cellData = (String) getCellFormatValue(row.getCell(column - 1));
//                    System.out.println(row.getCell(column-1)+"11");
//                    System.out.println("cellData: "+cellData);
                    result.add(cellData.replaceAll(" ", ""));
                } else {
                    break;
                }

            }
        }
        return result;
    }

    public static String getColumn(String filePath, int column, int row) {
        Workbook wb = readExcel(filePath); //文件
        Sheet sheet = wb.getSheetAt(0); //sheet
        int rownum = sheet.getPhysicalNumberOfRows(); //行数
        Row row1 = null;
        String cellData = null;
        if (wb != null) {
            row1 = sheet.getRow(row);
            if (row1 != null) {
                cellData = (String) getCellFormatValue(row1.getCell(column - 1));
//                    System.out.println("cellData: "+cellData);
            }

        }

        return cellData;
    }

    /**
     * @param filePath 需要读取的文件路径
     * @param column   指定需要获取的列数，例如第一列 1
     * @param startRow 指定从第几行开始读取数据
     * @return 返回读取列数据的set
     */
    public static HashSet<String> getColumnSet(String filePath, int column, int startRow) {
        Workbook wb = readExcel(filePath); //文件
        Sheet sheet = wb.getSheetAt(0); //sheet
        int rownum = sheet.getPhysicalNumberOfRows(); //行数
        System.out.println("sumrows " + rownum);

        return getColumnSet(filePath, column, startRow, rownum - 1);
    }


    //读取excel
    public static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                return wb = new HSSFWorkbook(is);
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(is);
            } else {
                return wb = null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    public static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            //判断cell类型
            switch (cell.getCellType()) {
                //如果是数值类型
                case 0: {
                    cell.setCellType(Cell.CELL_TYPE_STRING);  //将数值型cell设置为string型
                    cellValue = cell.getStringCellValue();
                    break;
                }
                //如果是string类型
                case 1: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                case 2: {
                    //判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }

    /**
     * 设置单元格上提示
     *
     * @param sheet         要设置的sheet.
     * @param promptTitle   标题
     * @param promptContent 内容
     * @param firstRow      开始行
     * @param endRow        结束行
     * @param firstCol      开始列
     * @param endCol        结束列
     * @return 设置好的sheet.
     */
    public static XSSFSheet setXSSFPrompt(XSSFSheet sheet, String promptTitle,
                                          String promptContent, int firstRow, int endRow, int firstCol,
                                          int endCol) {
        // 构造constraint对象
        DVConstraint constraint = DVConstraint
                .createCustomFormulaConstraint("BB1");
        String[] content = {"a", "b", "c"};
        XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper(sheet);
        XSSFDataValidationConstraint dvConstraint = (XSSFDataValidationConstraint) dvHelper
                .createExplicitListConstraint(content);
        // 四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow,
                endRow, firstCol, endCol);
        // 数据有效性对象
        XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvConstraint, regions);
        // 数据有效性对象
//        HSSFDataValidation data_validation_view = new HSSFDataValidation(
//                regions, constraint);
        validation.createPromptBox(promptTitle, promptContent);
        sheet.addValidationData(validation);
        return sheet;
    }

    /* 添加数据有效性检查.
     * @param sheet 要添加此检查的Sheet
     * @param firstRow 开始行
     * @param lastRow 结束行
     * @param firstCol 开始列
     * @param lastCol 结束列
     * @param explicitListValues 有效性检查的下拉列表
     * @throws IllegalArgumentException 如果传入的行或者列小于0(< 0)或者结束行/列比开始行/列小
     */
    public static void setValidationData(Sheet sheet, int firstRow, int lastRow,
                                         int firstCol, int lastCol, String[] explicitListValues) throws IllegalArgumentException {
        System.out.println();
        if (firstRow < 0 || lastRow < 0 || firstCol < 0 || lastCol < 0 || lastRow < firstRow || lastCol < firstCol) {
            throw new IllegalArgumentException("Wrong Row or Column index : " + firstRow + ":" + lastRow + ":" + firstCol + ":" + lastCol);
        }
        if (sheet instanceof XSSFSheet) {
            XSSFDataValidationHelper dvHelper = new XSSFDataValidationHelper((XSSFSheet) sheet);
            DataValidationConstraint dvc = null;
            if (explicitListValues == null) {
                if (lastCol == 15) {
                    dvc = dvHelper.createNumericConstraint(DVConstraint.ValidationType.DECIMAL,
                            DVConstraint.OperatorType.BETWEEN, "-99999999999.99", "9999999999.99");
                } else if (lastCol == 7) {
                    dvc = dvHelper.createNumericConstraint(DVConstraint.ValidationType.DECIMAL,
                            DVConstraint.OperatorType.BETWEEN, "-99999999999.99", "9999999999.99");
                }
            } else {
                dvc = (XSSFDataValidationConstraint) dvHelper
                        .createExplicitListConstraint(explicitListValues);
            }
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
            XSSFDataValidation validation = (XSSFDataValidation) dvHelper.createValidation(dvc, addressList);
            validation.setSuppressDropDownArrow(true);

            if (lastCol == 7) {
                validation.createPromptBox("提示", "余量显示的为下载模板前的剩余量，故余量仅供参考");
                validation.setShowPromptBox(true);
            } else if (lastCol == 15) {
                validation.setErrorStyle(DataValidation.ErrorStyle.STOP);
                validation.createErrorBox("错误", "不能是非数字");
                validation.setShowErrorBox(true);
                validation.createPromptBox("提示", "不能是非数字，且只取该数保留小数点后两位（四舍五入）");
                validation.setShowPromptBox(true);
            }
            sheet.addValidationData(validation);
        } else if (sheet instanceof HSSFSheet) {
            CellRangeAddressList addressList = new CellRangeAddressList(firstRow, lastRow, firstCol, lastCol);
            DVConstraint dvConstraint = DVConstraint.createExplicitListConstraint(explicitListValues);
            DataValidation validation = new HSSFDataValidation(addressList, dvConstraint);
            validation.setSuppressDropDownArrow(true);
            validation.setShowErrorBox(true);
            sheet.addValidationData(validation);
        }
    }
}
