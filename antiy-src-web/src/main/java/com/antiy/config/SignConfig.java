package com.antiy.config;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @program gitlab
 * @description 接口验签放行的url
 * @author wangqian
 * created on 2019-06-20
 * @version  1.0.0
 */
@Component
public class SignConfig {
    /**
     * 无需验证requestId和sign的url
     */
    @Value("${request.permit.url:''}")
    private String permitUrl;

    private final static List<Pattern> URL_LIST = new ArrayList<>();

    @PostConstruct
    private void init() {
        constructPattern("/swagger*");
        if (StringUtils.isNotBlank(permitUrl)) {
            constructPattern(permitUrl.split(","));
        }
    }

    /**
     * true:放行的url
     * false:不放行的url
     * @param url
     * @return
     */
    public boolean checkUrl(String url) {
        for (Pattern p : URL_LIST) {
            if (p.matcher(url).find()) {
                return true;
            }
        }
        return false;
    }

    private void constructPattern(String... reg) {
        if (reg != null && reg.length > 0) {
            Stream<String> stream = Arrays.stream(reg);
            stream.forEach(e -> URL_LIST.add(Pattern.compile(e)));
        }
    }

}
