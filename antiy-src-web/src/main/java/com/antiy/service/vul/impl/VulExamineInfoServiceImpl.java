package com.antiy.service.vul.impl;

import com.antiy.base.BaseConverter;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.vul.VulExamineInfoDao;
import com.antiy.dao.vul.VulInfoDao;
import com.antiy.dao.vul.VulIntegralInfoDao;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.entity.vul.VulExamineInfo;
import com.antiy.entity.vul.VulInfo;
import com.antiy.entity.vul.VulIntegralInfo;
import com.antiy.enums.user.VulLevelEnum;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.request.vul.VulExamineInfoRequest;
import com.antiy.response.vul.VulInfoResponse;
import com.antiy.service.vul.IVulExamineInfoService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p> 服务实现类 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
@Service
public class VulExamineInfoServiceImpl implements IVulExamineInfoService {

    private Logger                                       logger        = LogUtils.get(this.getClass());
    @Resource
    private VulExamineInfoDao                            vulExamineInfoDao;
    @Resource
    private VulIntegralInfoDao                           vulIntegralInfoDao;
    @Resource
    private VulInfoDao                                   vulInfoDao;
    BaseConverter<VulExamineInfoRequest, VulExamineInfo> baseConverter = new BaseConverter();

    @Override
    public void saveSingle(VulExamineInfoRequest vulExamineInfoRequest) {
        VulExamineInfo vulExamineInfo = baseConverter.convert(vulExamineInfoRequest, VulExamineInfo.class);
        vulExamineInfo.setExamineDate(System.currentTimeMillis());
        // 保存审批信息
        vulExamineInfoDao.saveSingle(vulExamineInfo);
        // 审批通过,计算积分
        if (vulExamineInfoRequest.getResult() == 2) {
            // 查询漏洞详细信息用于保存至积分表
            VulInfoResponse vulInfo = vulInfoDao.queryDetail(vulExamineInfoRequest.getVulId());
            // 积分详细信息
            VulIntegralInfo vulIntegralInfo = new VulIntegralInfo();
            vulIntegralInfo.setTaskId(vulExamineInfo.getTaskId());
            vulIntegralInfo.setIntergralEvent("提交漏洞");
            vulIntegralInfo.setVulId(vulInfo.getId());
            vulIntegralInfo.setVulName(vulInfo.getVulName());
            vulIntegralInfo.setVulPort(vulInfo.getVulPort());
            vulIntegralInfo.setIp(vulInfo.getIp());
            vulIntegralInfo.setCommitDate(vulInfo.getCommitDate());
            vulIntegralInfo.setCommitUser(vulInfo.getCommitUser());
            vulIntegralInfo.setDepartment(vulInfo.getVulDepartment());
            vulIntegralInfo.setGrade(
                getGrade(vulInfo.getEventLevel(), vulInfo.getVulLevel(), vulExamineInfoRequest.getSystemType()));
            vulIntegralInfoDao.saveSingle(vulIntegralInfo);
        }

    }

    private static Integer getGrade(String eventLevel, String vulLevel, Integer sysType) {
        // 漏洞等级
        Integer vl = VulLevelEnum.getCode(vulLevel);
        Integer result = 0;
        float xishu = 0;
        // 获取最高事件等级
        eventLevel = eventLevel.split("-")[0];
        if ("A".equals(eventLevel)) {
            xishu = 2f;
        } else if ("B".equals(eventLevel)) {
            xishu = 1.5f;
        } else if ("C".equals(eventLevel)) {
            xishu = 1f;
        } else if ("D".equals(eventLevel)) {
            xishu = 0.5f;
        }
        switch (vl) {
            case 1:
                result = sysType == 2 ? (int) (500 * xishu) : (int) (200 * xishu);
                break;
            case 2:
                result = sysType == 2 ? (int) (400 * xishu) : (int) (100 * xishu);
                break;
        }
        return result;
    }
}
