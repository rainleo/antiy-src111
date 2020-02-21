package com.antiy.service.vul.impl;

import com.antiy.base.BaseConverter;
import com.antiy.common.utils.LogUtils;
import com.antiy.controller.sse.SseEmitterController;
import com.antiy.dao.user.RoleDao;
import com.antiy.dao.user.UserDao;
import com.antiy.dao.vul.VulExamineInfoDao;
import com.antiy.dao.vul.VulInfoDao;
import com.antiy.dao.vul.VulIntegralInfoDao;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.entity.vul.VulExamineInfo;
import com.antiy.entity.vul.VulInfo;
import com.antiy.entity.vul.VulIntegralInfo;
import com.antiy.enums.user.VulLevelEnum;
import com.antiy.request.BaseRequest;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.request.vul.VulExamineInfoRequest;
import com.antiy.response.vul.SseVulResponse;
import com.antiy.response.vul.VulInfoResponse;
import com.antiy.service.vul.IVulExamineInfoService;
import com.antiy.util.BusinessExceptionUtils;
import com.antiy.util.LoginUserUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

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
    @Resource
    private LoginUserUtil                                loginUserUtil;
    BaseConverter<VulExamineInfoRequest, VulExamineInfo> baseConverter = new BaseConverter();

    @Override
    public void saveSingle(VulExamineInfoRequest vulExamineInfoRequest) {
        // 判断漏洞是否已经被审核
        BaseRequest request = new BaseRequest();
        request.setId(vulExamineInfoRequest.getVulId());
        if (vulExamineInfoDao.checkVulStatus(request) <= 0) {
            BusinessExceptionUtils.isTrue(false, "该漏洞已经被审核");
        }
        VulExamineInfo vulExamineInfo = baseConverter.convert(vulExamineInfoRequest, VulExamineInfo.class);
        vulExamineInfo.setExamineDate(System.currentTimeMillis());
        vulExamineInfo.setExaminer(loginUserUtil.getUser().getBusinessId());
        // 保存审批信息
        vulExamineInfoDao.saveSingle(vulExamineInfo);
        // 获取漏洞详细信息
        VulInfoResponse vulInfo = vulInfoDao.queryDetail(vulExamineInfoRequest.getVulId());
        // 审批通过,计算积分
        if (vulExamineInfoRequest.getResult() == 2) {
            // 查询漏洞详细信息用于保存至积分表
            // 积分详细信息
            VulIntegralInfo vulIntegralInfo = new VulIntegralInfo();
            vulIntegralInfo.setTaskId(vulExamineInfo.getTaskId());
            vulIntegralInfo.setIntergralEvent("提交漏洞");
            vulIntegralInfo.setVulId(vulInfo.getId());
            vulIntegralInfo.setVulName(vulInfo.getVulName());
            vulIntegralInfo.setVulPort(vulInfo.getVulPort());
            vulIntegralInfo.setIp(vulInfo.getIp());
            vulIntegralInfo.setCommitDate(vulInfo.getCommitDate());
            vulIntegralInfo.setCommitUser(vulInfo.getCommitUser() == null ? 1 : vulInfo.getCommitUser());
            vulIntegralInfo.setDepartment(vulInfo.getVulDepartment() == null ? 1 : vulInfo.getVulDepartment());
            vulIntegralInfo.setGrade(
                getGrade(vulInfo.getEventLevel(), vulInfo.getVulLevel(), vulExamineInfoRequest.getSystemType(),
                    vulInfo.getType(), vulInfo.getAddressOwner(), vulInfo.getVulDepartment()));
            // 保存积分
            vulIntegralInfoDao.saveSingle(vulIntegralInfo);
        } else if (vulExamineInfoRequest.getResult() == 3) {
            // 审核不通过,向提交漏洞用户发送通知
            SseVulResponse response = new SseVulResponse();
            SseVulResponse.Item item = new SseVulResponse.Item();
            item.setTaskId(vulInfo.getTaskId());
            item.setTaskType(vulInfo.getType());
            item.setVulId(vulInfo.getId());
            response.setItem(item);
            SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
            StringBuilder sb = new StringBuilder();
            sb.append("您于").append(format.format(vulInfo.getCommitDate())).append("提交的").append(vulInfo.getVulName())
                .append("漏洞审核未通过,请核对后再次提交");
            response.setNotice(sb.toString());
            SseEmitterController.sendByClientID(vulInfo.getCommitUser(), response);
        }
        // 漏洞状态
        VulInfo v = new VulInfo();
        v.setId(vulInfo.getId());
        v.setVulStatus(vulExamineInfoRequest.getResult());
        v.setSystemType(vulExamineInfoRequest.getSystemType());
        v.setGmtModify(System.currentTimeMillis());
        v.setModifyUser(loginUserUtil.getUser().getBusinessId());
        // 更新漏洞状态
        vulInfoDao.updateVulStatus(v);
    }

    @Override
    public boolean checkVulStatus(BaseRequest baseRequest) {
        return vulExamineInfoDao.checkVulStatus(baseRequest) > 0 ? true : false;
    }

    /**
     * 
     * @param eventLevel 事件等级
     * @param vulLevel 漏洞等级
     * @param sysType 系统属性
     * @param type 漏洞类型
     * @param vulDepartment 漏洞归属部门
     * @param commitDepartment 提交人归属部门
     * @return
     */
    private static Integer getGrade(String eventLevel, Integer vulLevel, Integer sysType, Integer type,
                                    Integer vulDepartment, Integer commitDepartment) {
        // 漏洞等级
        Integer vl = vulLevel;
        Integer result = 0;
        // 系数
        float xishu = 0;
        // 获取最高事件等级
        eventLevel = eventLevel.split(",")[0];
        if ("A".equals(eventLevel)) {
            xishu = 2f;
        } else if ("B".equals(eventLevel)) {
            xishu = 1.5f;
        } else if ("C".equals(eventLevel)) {
            xishu = 1f;
        } else if ("D".equals(eventLevel)) {
            xishu = 0.5f;
        }
        // 漏洞挖掘/扫雷
        if (type == 1) {
            switch (vl) {
                // 高危
                case 1:
                    result = sysType == 2 ? (int) (500 * xishu) : (int) (200 * xishu);
                    break;
                // 低危
                case 2:
                    result = sysType == 2 ? (int) (400 * xishu) : (int) (100 * xishu);
                    break;
            }
        }
        // 漏洞整治/排雷
        else if (type == 2) {
            switch (vl) {
                // 高危
                case 1:
                    result = vulDepartment == commitDepartment ? (int) (70 * xishu) : (int) (80 * xishu);
                    break;
                // 低危
                case 2:
                    result = vulDepartment == commitDepartment ? (int) (50 * xishu) : (int) (60 * xishu);
                    break;
            }
        }

        return result;
    }
}
