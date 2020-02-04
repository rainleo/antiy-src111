package com.antiy.service.user;

import com.antiy.response.user.ApiResponse;

import java.util.List;

public interface InterceptorService {
    /**
     * 根据用户bh获取用户具有的功能权限对应的接口
     * @param bh
     * @return
     */
    List<ApiResponse> getApiByUser(String bh);
}
