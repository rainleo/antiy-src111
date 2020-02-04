package com.antiy.util.ecel;

import com.antiy.common.utils.LogUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 描述: Excel 导入
 *
 * @author wenhao
 * @create 2019-01-14 14:44
 */
@Component
public class ExcelUploadUtil {

    public static final String EXCEL_TYPE_1 = "xlsx";
    public static final String EXCEL_TYPE_2 = "xls";

    private static final Logger logger = LogUtils.get(ExcelUploadUtil.class);

    /**
     * Excel上载:支持多个sheet页
     *
     * @param file
     * @return
     * @throws IOException
     */
    public List<UploadVO> excelUpload(MultipartFile file) throws IOException {
        return excelUpload(file, false);
    }

    /**
     * Excel上载:支持多个sheet页
     *
     * @param file
     * @param loadTitle 是否加载标题栏
     * @return
     * @throws IOException
     */
    public List<UploadVO> excelUpload(MultipartFile file, boolean loadTitle) throws IOException {
        // 检查各种条件
        if (Objects.isNull(file)) {
            logger.info("upload excel is null.");
            return null;
        }

        String fileName = file.getOriginalFilename();
        if (Objects.isNull(fileName)) {
            logger.info("upload excel file is wrong.");
            return null;
        }
        if (!fileName.endsWith(EXCEL_TYPE_1) && !fileName.endsWith(EXCEL_TYPE_2)) {
            logger.info("upload excel file is wrong.");
            return null;
        }

        return getExcelValues(file, loadTitle);
    }

    private List<UploadVO> getExcelValues(MultipartFile file, boolean loadTitle) throws IOException {
        List<UploadVO> list = new ArrayList<>();

        Workbook workbook = getWorkbook(file);
        String fileName = file.getOriginalFilename();

        for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {
            Sheet sheet = workbook.getSheetAt(numSheet);
            if (Objects.isNull(sheet)) {
                continue;
            }

            String sheetName = sheet.getSheetName();

            UploadVO uploadVO = new UploadVO();
            uploadVO.setSheetName(sheetName);
            logger.info("upload excel file {} sheet name is {}", fileName, sheetName);

            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum == 0) {
                continue;
            }

            List<List<Object>> uploadList = getSheetValues(sheet, loadTitle);
            uploadVO.setUploadList(uploadList);

            int uploadNum = uploadList.size();
            uploadVO.setRowNumber(uploadNum);
            logger.info("upload excel file {} sheet number is {}", fileName, uploadNum);

            list.add(uploadVO);
        }
        return list;
    }

    private List<List<Object>> getSheetValues(Sheet sheet, boolean loadTitle) {
        List<List<Object>> uploadList = new ArrayList<>();

        int lastRowNum = sheet.getLastRowNum();
        for (int rowNum = loadTitle ? 0 : 1; rowNum <= lastRowNum; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (Objects.isNull(row)) {
                logger.info("upload excel sheet name {} row {} is null.", sheet.getSheetName(), rowNum);
                continue;
            }

            List<Object> rowList = getRowValues(row);
            uploadList.add(rowList);
        }
        return uploadList;
    }

    private List<Object> getRowValues(Row row) {
        int lastCellNum = row.getLastCellNum();

        List<Object> rowValues = new ArrayList<>(lastCellNum + 1);

        for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
            Cell cell = row.getCell(cellNum);
            Object val = null;
            try {
                if (cell != null) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        val = cell.getNumericCellValue();
                        // 判断是否为科学计数法（包含E、e、+等符号）
                        if (val.toString().indexOf("E") != -1 || val.toString().indexOf("e") != -1
                                || val.toString().indexOf("+") != -1) {
                            BigDecimal bd = new BigDecimal(val + "");
                            val = bd.toPlainString();
                        }
                        //如果是日期格式
                        if(HSSFDateUtil.isCellDateFormatted(cell)){
                            val = cell.getDateCellValue();
                        }
                    } else if (cell.getCellType() == CellType.STRING) {
                        val = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.FORMULA) {
                        val = cell.getCellFormula();
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        val = cell.getBooleanCellValue();
                    } else if (cell.getCellType() == CellType.ERROR) {
                        val = cell.getErrorCellValue();
                    }
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            rowValues.add(val);
        }

        return rowValues;
    }

    /**
     * 创建Excel操作类：Workbook
     *
     * @param file
     * @return
     * @throws IOException
     */
    private Workbook getWorkbook(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Workbook workbook = null;

        String fileName = file.getOriginalFilename();
        if (fileName.endsWith(EXCEL_TYPE_1)) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

}
