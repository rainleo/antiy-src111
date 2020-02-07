package com.antiy.util.jwt;


import com.antiy.common.utils.LogUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt工具类
 * @author zhouye
 */
@Component
public class JwtUtil {
    private Logger log = LogUtils.get(this.getClass());
    /**
     * 加密、解析秘钥
     */
    private static final String KEY = "secretkey";

    /**
     *  加密、解析算法
     */
    private static final SignatureAlgorithm MODE = SignatureAlgorithm.HS256;


    /**
     * 生成token
     * @param uuid 用户ID
     * @param username 用户名
     * @return 访问凭证
     */
    public  String getToken(Long userId, String username,String name){
        long time = System.currentTimeMillis();
        return Jwts.builder()
                .claim("userId", userId)
                .claim("name", name)
                .claim("username", username)
                //签发时间
                .setIssuedAt(new Date(time))
                //截止时间
                //           .setExpiration(new Date(time+1000*60*60*2))
                .signWith(MODE, KEY)
                .compact();
    }


    /**
     * 解析token
     * @param token 访问凭证
     * @return 解析失败返回null
     *
     */
    public  Claims getClaims(String token){
        Claims claims=null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            log.warn("token解析失败,token:{}",token);
        }
        return claims;
    }



}
