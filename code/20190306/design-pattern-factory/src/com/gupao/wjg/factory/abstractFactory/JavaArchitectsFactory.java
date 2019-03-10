package com.gupao.wjg.factory.abstractFactory;

import com.gupao.wjg.entity.*;

public class JavaArchitectsFactory implements ICourseFactory {
    @Override
    public ILive createLive() {
        return new JavaArchitectsLive();
    }

    @Override
    public IRecorded createRecored() {
        return new JavaArchitectsRecord();
    }
}
