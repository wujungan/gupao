package com.gupao.wjg.strategy.coderebuld.service;

import com.gupao.wjg.strategy.coderebuld.pay.PayParamVo;
import com.gupao.wjg.strategy.coderebuld.pay.PayType;
import org.springframework.stereotype.Service;

@Service
public class WeiPayService implements IPayService {
    public String prePay(PayParamVo vo, PayType payType) throws Exception {

        System.out.println("微信支付");
        return "";
    }
}
