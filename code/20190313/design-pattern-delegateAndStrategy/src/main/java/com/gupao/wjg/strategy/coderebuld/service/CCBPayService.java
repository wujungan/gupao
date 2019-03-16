package com.gupao.wjg.strategy.coderebuld.service;

import com.gupao.wjg.strategy.coderebuld.pay.PayParamVo;
import com.gupao.wjg.strategy.coderebuld.pay.PayType;
import org.springframework.stereotype.Service;

@Service
public class CCBPayService implements IPayService {
    private String prePay(PayParamVo vo,String payType) throws Exception {
        System.out.println(payType+"逻辑处理");
        return "";
    }

    public String prePay(PayParamVo vo, PayType payType) throws  Exception{
        System.out.println(payType.getName());
        return this.prePay(vo,payType.getCode());
    }
}
