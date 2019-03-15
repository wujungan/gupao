package com.gupao.wjg.strategy.coderebuld.service;

import com.gupao.wjg.strategy.coderebuld.pay.PayParamVo;
import com.gupao.wjg.strategy.coderebuld.pay.PayType;

public interface IPayService {

    public  String prePay(PayParamVo vo, PayType payType) throws Exception;
}
