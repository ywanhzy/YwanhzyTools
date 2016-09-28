package com.ywanhzy.tools.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.ywanhzy.tools.utils.ConstUtils.REGEX_CHZ;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_DATE;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_EMAIL;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_IDCARD15;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_IDCARD18;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_IP;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_MOBILE_EXACT;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_MOBILE_GENERAL;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_POSTCODE;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_QQ;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_TEL;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_URL;
import static com.ywanhzy.tools.utils.ConstUtils.REGEX_USERNAME;

/**
 *  正则相关工具类
 */
public class RegexUtils {

    private RegexUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 验证手机号（一般）
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMobileGeneral(String string) {
        return isMatch(REGEX_MOBILE_GENERAL, string);
    }

    /**
     * 验证手机号（精确）
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMobileExact(String string) {
        return isMatch(REGEX_MOBILE_EXACT, string);
    }

    /**
     * 验证电话号码
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isTel(String string) {
        return isMatch(REGEX_TEL, string);
    }

    /**
     * 验证身份证号码15位
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isIDCard15(String string) {
        return isMatch(REGEX_IDCARD15, string);
    }

    /**
     * 验证身份证号码18位
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isIDCard18(String string) {
        return isMatch(REGEX_IDCARD18, string);
    }

    /**
     * 验证邮箱
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isEmail(String string) {
        return isMatch(REGEX_EMAIL, string);
    }

    /**
     * 验证QQ
     * @param string 待验证文本
     * @return
     */
    public static boolean isQQ(String string) {
        return isMatch(REGEX_QQ, string);
    }

    /**
     * 验证邮编
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isPostCode(String string) {
        return isMatch(REGEX_POSTCODE, string);
    }

    /**
     * 验证URL
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isURL(String string) {
        return isMatch(REGEX_URL, string);
    }

    /**
     * 验证汉字
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isChinese(String string) {
        return isMatch(REGEX_CHZ, string);
    }

    /**
     * 验证字符串是否包含中文
     *
     * @param data 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isContainChinese(String data) {
        if (!StringUtils.isEmpty(data)) {
            for (int i = 0; i < data.length(); i++) {
                String temp = data.substring(i, i + 1);
                boolean flag = isChinese(temp);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 验证用户名
     * <p>取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位</p>
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isUsername(String string) {
        return isMatch(REGEX_USERNAME, string);
    }

    /**
     * 验证yyyy-MM-dd格式的日期校验，已考虑平闰年
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isDate(String string) {
        return isMatch(REGEX_DATE, string);
    }

    /**
     * 验证IP地址
     *
     * @param string 待验证文本
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isIP(String string) {
        return isMatch(REGEX_IP, string);
    }

    /**
     * string是否匹配regex
     *
     * @param regex  正则表达式字符串
     * @param string 要匹配的字符串
     * @return {@code true}: 匹配<br>{@code false}: 不匹配
     */
    public static boolean isMatch(String regex, String string) {
        return !StringUtils.isEmpty(string) && Pattern.matches(regex, string);
    }

    /**
     * 检验用户名
     * 取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾
     * 用户名有最小长度和最大长度限制，比如用户名必须是4-20位
     * */
    public boolean checkUsername(String username,int min,int max)
    {
        String regex="[\\w\u4e00-\u9fa5]{"+min+","+max+"}(?<!_)";
        return startCheck(regex,username);
    }
    /**
     * 检验用户名
     * 取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾
     * 有最小位数限制的用户名，比如：用户名最少为4位字符
     * */
    public boolean checkUsername(String username,int min)
    {
        String regex="[\\w\u4e00-\u9fa5]{"+min+",}(?<!_)";
        return startCheck(regex,username);
    }

    /**
     * 小数点位数
     *
     * @param data   可能包含小数点的字符串
     * @param length 小数点后的长度
     * @return 是否小数点后有length位数字
     */
    public  boolean isDianWeiShu(String data, int length) {
        String regex = "^[1-9][0-9]+\\.[0-9]{" + length + "}$";
        return startCheck(regex,data);
    }

    public  boolean startCheck(String reg,String string)
    {
        boolean tem=false;
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher=pattern.matcher(string);
        tem=matcher.matches();
        return tem;
    }
}