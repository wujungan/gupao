package com.gupao.wjg.registerSingleton;

/**
 * 注册时单例--枚举
 */
public enum EnumSingleton {

    WEIXIN("weixin", ""), // 微信支付
    ALIPAYWAP("alipay.wap.create.direct.pay.by.user", "支付宝手机网站支付"), //
    ALIPAYDIRECT("create_direct_pay_by_user", "支付宝即时到账");

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private EnumSingleton(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(String code) {
        for (EnumSingleton status : EnumSingleton.values()) {
            if (status.code.equals(code)) {
                return status.getName();
            }
        }
        return "";
    }
}
