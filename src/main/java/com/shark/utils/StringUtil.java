package com.shark.utils;

/**
 * 字符串工具
 *
 * @Author dage
 * @Date 2020/11/23 0:29
 * @Version 1.0
 */
public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmptyAndNull(String str){
        if(str == null || str.isEmpty()){
            return true;
        }
        return false;
    }
}
