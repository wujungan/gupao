package com.gupao.wjg.strategy.coderebuld.service;

import com.gupao.wjg.strategy.coderebuld.pay.PayParamVo;
import com.gupao.wjg.strategy.coderebuld.pay.PayType;
import org.springframework.stereotype.Service;

@Service
public class WapAlipayService implements IPayService {
    public String prePay(PayParamVo vo , PayType payType) throws Exception {

        System.out.println("支付宝手机网站支付");
        return "";
    }
}
