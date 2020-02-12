package com.antiy.service.vul.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.vul.VulExamineInfoDao;
import com.antiy.dao.vul.VulInfoDao;
import com.antiy.entity.vul.VulInfo;
import com.antiy.enums.user.VulStatusEnum;
import com.antiy.enums.user.VulTypeEnum;
import com.antiy.query.vul.VulInfoQuery;
import com.antiy.request.vul.VulInfoRequest;
import com.antiy.response.vul.VulExamineInfoResponse;
import com.antiy.response.vul.VulInfoResponse;
import com.antiy.service.vul.IVulInfoService;
import com.antiy.util.BusinessExceptionUtils;
import com.antiy.util.LoginUserUtil;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

/**
 * <p> 服务实现类 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
@Service
public class VulInfoServiceImpl implements IVulInfoService {

    private Logger                                 logger        = LogUtils.get(this.getClass());
    @Resource
    private LoginUserUtil                          loginUserUtil;
    @Resource
    private VulInfoDao                             vulInfoDao;
    @Resource
    private VulExamineInfoDao                      vulExamineInfoDao;
    private BaseConverter<VulInfoRequest, VulInfo> baseConverter = new BaseConverter();

    @Override
    public void saveSingle(VulInfoRequest vulInfoRequest) {
        // 检查漏洞是否存在
        Integer count = vulInfoDao.checkRepeat(vulInfoRequest.getVulName(), vulInfoRequest.getVulType(),
            vulInfoRequest.getVulAddress());
        if (count > 0) {
            logger.info("漏洞已存在");
            BusinessExceptionUtils.isTrue(false, "该漏洞已存在");
        }
        VulInfo vulInfo = baseConverter.convert(vulInfoRequest, VulInfo.class);
        vulInfo.setVulStatus(VulStatusEnum.WAIT_EXAMINE.getCode());
        vulInfo.setVulDepartment(loginUserUtil.getUser().getDepartmentId());
        vulInfo.setCreateUser(loginUserUtil.getUser().getBusinessId());
        vulInfo.setGmtCreate(System.currentTimeMillis());
        vulInfo.setModifyUser(loginUserUtil.getUser().getBusinessId());
        vulInfo.setStatus(1);
        vulInfoDao.saveSingle(vulInfo);
        // 更新编号
        vulInfoDao.updateVulNo(getVulNo(vulInfoRequest.getVulType(), vulInfo.getId()), vulInfo.getId());
    }

    @Override
    public PageResult<VulInfoResponse> queryList(VulInfoQuery vulInfoQuery) {
        Integer count = vulInfoDao.queryCount(vulInfoQuery);
        if (count <= 0) {
            return new PageResult<>(vulInfoQuery.getPageSize(), 0, vulInfoQuery.getCurrentPage(), Lists.newArrayList());
        }
        List<VulInfoResponse> vulInfoList = vulInfoDao.queryList(vulInfoQuery);
        return new PageResult<>(vulInfoQuery.getPageSize(), count, vulInfoQuery.getCurrentPage(), vulInfoList);
    }

    @Override
    public Integer updateSingle(VulInfoRequest vulInfoRequest) {
        VulInfo vulInfo = baseConverter.convert(vulInfoRequest, VulInfo.class);
        vulInfo.setGmtModify(System.currentTimeMillis());
        vulInfo.setModifyUser(loginUserUtil.getUser().getBusinessId());
        return vulInfoDao.updateSingle(vulInfo);
    }

    @Override
    public VulInfoResponse queryDetail(Integer id) {
        return vulInfoDao.queryDetail(id);
    }

    @Override
    public List<VulExamineInfoResponse> queryExamineHistory(Integer vulId) {
        List<VulExamineInfoResponse> vulExamineInfoResponseList = vulExamineInfoDao.queryList(vulId);
        return vulExamineInfoResponseList;
    }

    private static String getVulNo(Integer type, Integer id) {
        Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
        return String.join("", year, VulTypeEnum.getType(type), String.valueOf(id));
    }
}
