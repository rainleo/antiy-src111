package com.antiy.dao.vul;


import com.antiy.entity.vul.VulExamineInfo;
import com.antiy.request.BaseRequest;
import com.antiy.response.vul.VulExamineInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface VulExamineInfoDao {

    List<VulExamineInfoResponse> queryList(@Param("vulId") Integer vulId);

    void saveSingle(VulExamineInfo vulExamineInfo);

    Integer checkVulStatus(BaseRequest baseRequest);
}
