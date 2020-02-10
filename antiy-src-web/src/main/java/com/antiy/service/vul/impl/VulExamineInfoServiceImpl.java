package com.antiy.service.vul.impl;

import com.antiy.base.BaseConverter;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.vul.VulExamineInfoDao;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.entity.vul.VulExamineInfo;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.request.vul.VulExamineInfoRequest;
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
    BaseConverter<VulExamineInfoRequest, VulExamineInfo> baseConverter = new BaseConverter();

    @Override
    public void saveSingle(VulExamineInfoRequest vulExamineInfoRequest) {
        VulExamineInfo vulExamineInfo = baseConverter.convert(vulExamineInfoRequest, VulExamineInfo.class);
        vulExamineInfo.setExamineDate(System.currentTimeMillis());
        vulExamineInfoDao.saveSingle(vulExamineInfo);

    }
}
