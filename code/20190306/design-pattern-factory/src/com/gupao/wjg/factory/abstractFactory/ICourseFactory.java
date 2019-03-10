package com.gupao.wjg.factory.abstractFactory;

import com.gupao.wjg.entity.ILive;
import com.gupao.wjg.entity.IRecorded;

public interface ICourseFactory {

    public ILive createLive();
    public IRecorded createRecored();
}
