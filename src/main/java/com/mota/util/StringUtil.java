package com.mota.util;


import org.apache.commons.lang3.StringUtils;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class StringUtil{

    /**
     * 将字符串转换为数字，为空和异常则返回0<br>
     * shiyl
     *
     * @param String
     *            需判断的字符串
     * @return boolean
     */
    public static int trans2Integer(String value) {

        int val = 0;
        try {
            if (!isEmpty(value)) {
                val = Integer.parseInt(value);
            }
        } catch (NumberFormatException e) {
            val = 0;
        }
        return val;
    }

    /**
     *
     * isEmpty:判断字符串是否为空 <br/>
     *
     * @author geliang
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {

        return StringUtils.isEmpty(str);
    }

    /** 获取异常中的输出 */
    public static String getErrorInfoFromException(Exception e) {

        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String s = sw.toString();
            if (s.length() >= 2000) {
                s = s.substring(0, 2000) + "\r\n......";
            }
            return s;
        } catch (Exception e2) {
            return "bad getErrorInfoFromException";
        }
    }

}