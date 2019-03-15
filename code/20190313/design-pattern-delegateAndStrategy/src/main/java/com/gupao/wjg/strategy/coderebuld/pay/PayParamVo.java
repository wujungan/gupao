package com.gupao.wjg.strategy.coderebuld.pay;

public class PayParamVo {


    private String openId;
    private String spbillCreateIp;

    private String orderNo;
    private String mobileRsServiceUrl;

    private String payType;

    private String returnUrl;


    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSpbillCreateIp() {
        return spbillCreateIp;
    }

    public void setSpbillCreateIp(String spbillCreateIp) {
        this.spbillCreateIp = spbillCreateIp;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getMobileRsServiceUrl() {
        return mobileRsServiceUrl;
    }

    public void setMobileRsServiceUrl(String mobileRsServiceUrl) {
        this.mobileRsServiceUrl = mobileRsServiceUrl;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }


}
