package com.antiy.service.vul;

import com.antiy.base.PageResult;
import com.antiy.entity.vul.VulInfo;
import com.antiy.query.vul.VulInfoQuery;
import com.antiy.request.vul.VulInfoRequest;
import com.antiy.response.vul.VulExamineInfoResponse;
import com.antiy.response.vul.VulInfoResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p> 服务类 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface IVulInfoService {

    void saveSingle(VulInfoRequest vulInfoRequest);

    PageResult<VulInfoResponse> queryList(VulInfoQuery vulInfoQuery);

    Integer updateSingle(VulInfoRequest vulInfoRequest);

    VulInfoResponse queryDetail(Integer id);

    List<VulExamineInfoResponse> queryExamineHistory(Integer id);

    void exportData(VulInfoQuery vulInfoQuery, HttpServletResponse response, HttpServletRequest request) throws IOException;
}
