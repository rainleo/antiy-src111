package com.antiy.service.vul;


import com.antiy.entity.vul.FileInfo;
import com.antiy.request.BaseRequest;
import com.antiy.request.vul.VulExamineInfoRequest;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface IVulExamineInfoService {


    void saveSingle(VulExamineInfoRequest vulExamineInfoRequest);

    boolean checkVulStatus(BaseRequest baseRequest);

    FileInfo queryFilePath(BaseRequest request);
}
