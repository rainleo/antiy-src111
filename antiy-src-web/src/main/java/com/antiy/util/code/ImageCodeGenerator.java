package com.antiy.util.code;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

public class ImageCodeGenerator {
    // 图片宽度
    public static final int WIDTH = 67;

    // 图片高度
    public static final int HEIGHT = 32;

    // 验证码的位数
    public static final int RANDOM_SIZE = 4;

    // 验证码过期秒数
    public static final Long EXPIRE_SECOND = 60*1000L;

    /**
     * 生成图形验证码
     * @param
     * @return
     */
    public static ImageCode generate() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 产生Image对象的Graphics对象,该对象可以在图像上进行各种绘制操作
        Graphics g = image.getGraphics();
        //绘制底纹颜色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setFont(new Font("Times New Roman", Font.ITALIC, 22));
        g.setColor(getRandColor(160, 200));
        //随机生成干扰线条
        for (int i = 0; i < 155; i++) {
            int x = ThreadLocalRandom.current().nextInt(WIDTH);
            int y = ThreadLocalRandom.current().nextInt(HEIGHT);
            int xl = ThreadLocalRandom.current().nextInt(12);
            int yl = ThreadLocalRandom.current().nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
        //生成4位随机数，绘制到图片中
        String randomCode = "";
        for (int i = 0; i < RANDOM_SIZE; i++) {
            String rand = String.valueOf(ThreadLocalRandom.current().nextInt(10));
            randomCode += rand;
            g.setColor(new Color(20 + ThreadLocalRandom.current().nextInt(110), 20 + ThreadLocalRandom.current().nextInt(110), 20 + ThreadLocalRandom.current().nextInt(110)));
            g.drawString(rand, 13 * i + 6, 20);
        }

        g.dispose();

        return new ImageCode(ImageUtil.imgToBase64String(image), randomCode, EXPIRE_SECOND);
    }

    /**
     * 生成随机背景条纹
     *
     * @param fc
     * @param bc
     * @return
     */
    private static Color getRandColor(int fc, int bc) {
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + ThreadLocalRandom.current().nextInt(bc - fc);
        int g = fc + ThreadLocalRandom.current().nextInt(bc - fc);
        int b = fc + ThreadLocalRandom.current().nextInt(bc - fc);
        return new Color(r, g, b);
    }
}
