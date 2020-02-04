package com.antiy.util;

import java.text.DecimalFormat;

/**
 * @author liyuke
 * @version 1.0
 * @date 2019/11/9 14:01
 */
public class FormatUtil {

    private static DecimalFormat df = new DecimalFormat("#.0000");

    public static double keep2Decimal(double in) {
        return Double.parseDouble(df.format(in));
    }


    public static void main(String[] args) {
        System.out.println(keep2Decimal(5000.128456789d));
    }

}
