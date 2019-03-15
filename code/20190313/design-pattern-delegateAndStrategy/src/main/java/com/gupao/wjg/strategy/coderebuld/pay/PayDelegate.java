package com.gupao.wjg.strategy.coderebuld.pay;

import com.alibaba.fastjson.JSONObject;
import com.gupao.wjg.strategy.coderebuld.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PayDelegate {

    @Autowired
    private WeiPayService weiPayService;

    @Autowired
    private DirectAlipayService directAlipayService;

    @Autowired
    private WapAlipayService wapAlipayService;

    @Autowired
    private CCBPayService ccbPayService;

    private static Map<String, IPayService> payMap=new ConcurrentHashMap<String ,IPayService>();

    private PayDelegate() {
        payMap.put(PayType.WEIXIN.getCode(),weiPayService);
        payMap.put(PayType.ALIPAYDIRECT.getCode(),directAlipayService);
        payMap.put(PayType.ALIPAYWAP.getCode(),wapAlipayService);
        payMap.put(PayType.LONG.getCode(),ccbPayService);
        payMap.put(PayType.JUHE.getCode(),ccbPayService);
    }

    public PayDelegate getInstance(){
        return new PayDelegate();
    }

    public String prePay(PayParamVo vo, PayType payType){
        IPayService iPayService = payMap.get(payType.getCode());
        if(iPayService==null){
            return faield("支付方式不存在");
        }
        try {
            return iPayService.prePay(vo,payType);
        } catch (Exception e) {
            e.printStackTrace();
            return faield(e.getMessage());
        }
    }

    private String faield(String msg){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",400);
        jsonObject.put("msg",msg);
        return jsonObject.toJSONString();
    }

}
