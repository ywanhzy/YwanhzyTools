package com.ywanhzy.tools.utils;

/**
 *
 *    常量相关工具类
 */
public class ConstUtils {

    private ConstUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /******************** 存储相关常量 ********************/
    /**
     * Byte与Byte的倍数
     */
    public static final int BYTE = 1;
    /**
     * KB与Byte的倍数
     */
    public static final int KB = 1024;
    /**
     * MB与Byte的倍数
     */
    public static final int MB = 1048576;
    /**
     * GB与Byte的倍数
     */
    public static final int GB = 1073741824;

    public enum MemoryUnit {
        BYTE,
        KB,
        MB,
        GB
    }

    /******************** 时间相关常量 ********************/
    /**
     * 毫秒与毫秒的倍数
     */
    public static final int MSEC = 1;
    /**
     * 秒与毫秒的倍数
     */
    public static final int SEC = 1000;
    /**
     * 分与毫秒的倍数
     */
    public static final int MIN = 60000;
    /**
     * 时与毫秒的倍数
     */
    public static final int HOUR = 3600000;
    /**
     * 天与毫秒的倍数
     */
    public static final int DAY = 86400000;

    public enum TimeUnit {
        MSEC,
        SEC,
        MIN,
        HOUR,
        DAY
    }

    /******************** 正则相关常量 ********************/
    /**
     * 正则：手机号（简单）
     */
    public static final String REGEX_MOBILE_SIMPLE = "^[1]\\d{10}$";
    /**
     * 正则：手机号（一般）
     */
    public static final String REGEX_MOBILE_GENERAL="^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
    /**
     * 正则：手机号（精确）
     * 中国移动：134（不含1349）、135、136、137、138、139、147、150、151、152、157、158、 159、182、183、184、187、188、178
     * 中国联通：130、131、132、145（上网卡）、155、156、185、186、176
     * 中国电信：133、1349（卫星通信）、153、180、181、189、177、173
     * 4G号段：176(联通)、173/177(电信)、178(移动)
     * 虚拟运营商：170[1700/1701/1702(电信)、1703/1705/1706(移动)、1704/1707/1708/1709(联通)]、171（联通）
     * 未知号段：140、141、142、143、144、146、148、149、154
     */
    public static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|(147))\\d{8}$";
    /**
     * 正则：电话号码
     */
    public static final String REGEX_TEL = "^0\\d{2,3}[- ]?\\d{7,8}";
//    Pattern.compile("^[0][1-9]{1}[0-9]{1,2}-[1-9]{1}[0-9]{6,7}$"); // 验证带区号的
//    Pattern.compile("^[1-9]{1}[0-9]{5,8}$"); // 验证没有区号的

    /**
     * 正则：身份证号码15位
     */
    public static final String REGEX_IDCARD15 = "^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$";
    /**
     * 正则：身份证号码18位
     */
    public static final String REGEX_IDCARD18 = "^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9Xx])$";
    /**
     * 正则：邮箱
     */
    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    public static final String REGEX_EMAIL_T = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

    /**
     * 正则：QQ(5-11位)
     */
    public static final String REGEX_QQ = "^[1-9][0-9]{4,10}$";
    /**
     * 正则：邮编(5-11位)
     */
    public static final String REGEX_POSTCODE= "^[1-9][0-9]{5}$";

    /**
     * 正则：只含字母和数字
     */
    public static final String REGEX_NUMBER_LETTER= "^[A-Za-z0-9]+$";
    /**
     * 正则：只含数字
     */
    public static final String REGEX_NUMBER= "^[0-9]+$";
    /**
     * 正则：只含字母
     */
    public static final String REGEX_LETTER= "^[A-Za-z]+$";

    /**
     * 正则：URL
     */
    public static final String REGEX_URL = "http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";
    /**
     * 正则：汉字
     */
    public static final String REGEX_CHZ = "^[\\u4e00-\\u9fa5]+$";
    /**
     * 正则：用户名，取值范围为a-z,A-Z,0-9,"_",汉字，不能以"_"结尾,用户名必须是6-20位
     */
    public static final String REGEX_USERNAME = "^[\\w\\u4e00-\\u9fa5]{6,20}(?<!_)$";
    /**
     * 正则：yyyy-MM-dd格式的日期校验，已考虑平闰年
     */
    public static final String REGEX_DATE = "^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$";
    /**
     * 正则：IP地址
     */
    public static final String REGEX_IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";

    /**
     * 正則 <br/>
     * 1. 只有字母、数字和下划线且不能以下划线开头和结尾的正则表达式：^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$ 只有字母和数字的：
     * ^[a-zA-Z0-9_]+$ <br/>
     * 2. 至少一个汉字、数字、字母、下划线: "[a-zA-Z0-9_\u4e00-\u9fa5]+" <br/>
     * 3. 至少一个汉字的正则表达式："^[\u4e00-\u9fa5]" <br/>
     * 4. 最多10个汉字: ValidationExpression="^[\u4e00-\u9fa5]{0,10}" <br/>
     * 5. *
     * 只含有汉字、数字、字母、下划线不能以下划线开头和结尾：^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$ 解释：
     * ^ 与字符串开始的地方匹配 (?!_) 不能以_开头 (?!.*?_$) 不能以_结尾 [a-zA-Z0-9_\u4e00-\u9fa5]+
     * 至少一个汉字、数字、字母、下划线 $ 与字符串结束的地方匹配 <br/>
     * 6. email正则表达式：两种方式都可以 (1) \w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)* (2)
     * ^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*((\\.
     * [A-Za-z]{2,}){1}$)
     */
}