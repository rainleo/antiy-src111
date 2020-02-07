package com.antiy.util.ecel;

import java.util.List;

/**
 * 描述:
 *
 * @author wenhao
 * @create 2019-01-14 14:17
 */

public class UploadVO {

    /**
     * sheet 页面
     */
    private String sheetName;

    /**
     * 当前页数据条数
     */
    private Integer rowNumber;
    /**
     * 上载数据
     */
    private List<List<Object>> uploadList;

    public String getSheetName() {
        return sheetName;
    }

    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<List<Object>> getUploadList() {
        return uploadList;
    }

    public void setUploadList(List<List<Object>> uploadList) {
        this.uploadList = uploadList;
    }
}
