package com.antiy.query.user;


import com.antiy.base.ObjectQuery;
import com.antiy.consts.Constants;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * Api 查询条件
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class ApiQuery extends ObjectQuery {

    @ApiModelProperty("每页条数")
    private int pageSize = Constants.DEFAULT_PAGESIZE;

    @ApiModelProperty("第几页")
    private int currentPage = Constants.DEFAULT_PAGE;

    @ApiModelProperty("排序字段")
    private String sortName;

    @ApiModelProperty("排序方向")
    private String sortOrder;
}