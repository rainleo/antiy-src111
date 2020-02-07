package com.antiy.util.code;


/**
 *
 * @author wangyajing
 * @date 2019/08/01
 */
public class ImageCode {
    /**
     * 图片验证码
     */
    private String image;

    /**
     * 4位数验证码
     */
    private String code;

    /**
     * 验证码过期时间
     */
    private Long expireTime;

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    /**
     *
     * @param image
     * @param code
     * @param expireIn 验证码有效期限，60秒
     */
    public ImageCode(String image, String code, Long expireIn) {
        this.code = code;
        this.image = image;
        this.expireTime = System.currentTimeMillis()+expireIn;
    }


    @Override
    public String toString() {
        return "ImageCode{" +
                "image='" + image + '\'' +
                ", code='" + code + '\'' +
                ", expireTime=" + expireTime +
                '}';
    }
}
