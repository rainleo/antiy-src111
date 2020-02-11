package com.antiy.dao.vul;

import com.antiy.entity.vul.VulInfo;
import com.antiy.query.vul.VulInfoQuery;
import com.antiy.response.vul.VulInfoResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> Mapper 接口 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface VulInfoDao {

    Integer checkRepeat(@Param("vulName") String vulName, @Param("vulType") Integer vulType,
                        @Param("vulAddress") String vulAddress);

    void saveSingle(VulInfo vulInfo);

    Integer queryCount(VulInfoQuery vulInfoQuery);

    List<VulInfoResponse> queryList(VulInfoQuery vulInfoQuery);

    void updateVulNo(@Param("vulNo") String vulNo, @Param("id") Integer id);

    Integer updateSingle(VulInfo vulInfo);

    VulInfoResponse queryDetail(@Param("id") Integer id);

    void updateVulStatus(VulInfo v);
}
