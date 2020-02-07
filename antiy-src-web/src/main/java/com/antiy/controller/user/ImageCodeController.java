package com.antiy.controller.user;

import com.antiy.common.utils.LogUtils;
import com.antiy.util.code.ImageCode;
import com.antiy.util.code.ImageCodeGenerator;
import com.antiy.util.code.ImageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "图片验证")
@RequestMapping("/api/v1/user")
public class ImageCodeController {
    private Logger log = LogUtils.get(this.getClass());
    private static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";


    @ApiOperation("图片验证")
    @GetMapping(value = "/code",produces = MediaType.IMAGE_JPEG_VALUE)
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Type","image/jpeg");
        HttpSession session = request.getSession();
        ImageCode imageCode = ImageCodeGenerator.generate();
        log.debug("生成图片验证码" + imageCode.getCode());
        Map<String, String> map = new HashMap();
        map.put("code",imageCode.getCode());
        map.put("expiredTime", String.valueOf(imageCode.getExpireTime()));
        session.setAttribute(SESSION_KEY, map);
        BufferedImage bufferedImage = ImageUtil.base64StringToImg(imageCode.getImage());
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

}
