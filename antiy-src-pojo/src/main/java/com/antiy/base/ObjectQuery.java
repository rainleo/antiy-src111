package com.antiy.base;

import com.antiy.consts.Constants;
import com.google.common.base.CaseFormat;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 批量查询条件，有其他参数集成此类即可 @Author: zhangbing
 * @date: 2018/10/30 14:05
 */
public class ObjectQuery {
  /** 每页显示记录数 */
  private int pageSize = Constants.DEFAULT_PAGESIZE;

  /** 当前页页码 */
  private int currentPage = Constants.DEFAULT_PAGE;

  /** 开始时间,时间戳 */
  private Long beginTime;

  /** 结束时间,时间戳 */
  private Long endTime;

  @ApiModelProperty("排序字段")
  private String sortName;

  @ApiModelProperty("排序方向")
  private String sortOrder;

  public Long getBeginTime() {
    return beginTime;
  }

  public void setBeginTime(Long beginTime) {
    this.beginTime = beginTime;
  }

  public Long getEndTime() {
    return endTime;
  }

  public void setEndTime(Long endTime) {
    this.endTime = endTime;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(int currentPage) {
    this.currentPage = currentPage;
  }

  public int getPageOffset() {
    return (currentPage - 1) * pageSize;
  }

  public String getSortName() {
    return sortName;
  }

  public void setSortName(String sortName) {
    this.sortName = sortName;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }
  @ApiModelProperty(hidden = true)
  public List<String> getSortSql() {
    List<String> sortSql = null;
    if (StringUtils.isNotBlank(sortName)) {
      sortSql = new ArrayList<>();
      String[] sortArray = sortName.split(",");
      String[] orderArray = sortOrder.split(",");
      for (int i = 0; i < sortArray.length; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(camelToUnderLine(sortArray[i])).append(" ").append(orderArray[i]);
        sortSql.add(sb.toString());
      }
    }
    return sortSql;
  }

  /**
   * 驼峰转下划线
   *
   * @param str 属性名
   * @return java.lang.String
   * @author wangqian
   * @date 2019/3/8
   */
  private String camelToUnderLine(String str) {
    return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
  }
}
