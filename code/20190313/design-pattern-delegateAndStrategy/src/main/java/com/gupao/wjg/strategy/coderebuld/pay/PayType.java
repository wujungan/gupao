package com.gupao.wjg.strategy.coderebuld.pay;

public enum PayType {

    WEIXIN("weixin", "微信支付"), // 微信支付
    ALIPAYWAP("alipay.wap.create.direct.pay.by.user", "支付宝手机网站支付"), //
    ALIPAYDIRECT("create_direct_pay_by_user", "支付宝即时到账"),
    JUHE("juhe", "聚合支付"),
    LONG("long", "龙支付");


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

    private PayType(String code, String name) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(String code) {
        for (PayType status : PayType.values()) {
            if (status.code.equals(code)) {
                return status.getName();
            }
        }
        return "";
    }
}