package com.antiy.service.user.impl;

import com.antiy.base.BaseConverter;
import com.antiy.dao.user.ApiDao;
import com.antiy.entity.user.Api;
import com.antiy.enums.user.ApiMethodEnum;
import com.antiy.response.user.ApiResponse;
import com.antiy.service.user.InterceptorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InterceptorServiceImpl implements InterceptorService {
    @Resource
    private ApiDao apiDao;
    @Resource
    private BaseConverter<Api,ApiResponse> converter;
    @Override
    public List<ApiResponse> getApiByUser(String bh) {
        List<Api> apiList = apiDao.findApiByUser(bh);
        List<ApiResponse> apiResponseList = converter.convert(apiList, ApiResponse.class);
        for (ApiResponse api : apiResponseList) {
            //转换请求方式
            api.setMethodDesc(ApiMethodEnum.getNameByCode(api.getMethod()).getName());
        }
        return apiResponseList;
    }
}
