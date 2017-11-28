package com.osc.oscashcommon.utils.common;

import com.baomidou.mybatisplus.toolkit.StringUtils;

/**
 * @description: 常用公共工具类
 * @author: lizhiming
 * @since: 2017/11/27
 */
public class CommonUtil {
    /**
     * 添加对象转字符串处理
     * @param obj
     * @return String or null
     */
    public static String valueOf(Object obj) {
        return (obj == null) ? StringUtils.EMPTY : obj.toString();
    }
    /**
     * 判断字符串是否为空或null
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }
    /**
     * 判断字符串不为空或null
     * <pre>
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = true
     * StringUtils.isNotEmpty("bob")     = true
     * StringUtils.isNotEmpty("  bob  ") = true
     * </pre>
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return (str != null && str.length() > 0);
    }
    /**
     * 判断字符串是否为空或null
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false) ) {
                return false;
            }
        }
        return true;
    }
    /**
     * 判断字符串不为空或null
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return false;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false) ) {
                return true;
            }
        }
        return false;
    }

}
