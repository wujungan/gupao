package com.gupao.wjg.factory.abstractFactory;

import com.gupao.wjg.entity.*;

public class JavaBigDataFactory implements ICourseFactory {
    @Override
    public ILive createLive() {
        return new JavaBigDataLive();
    }

    @Override
    public IRecorded createRecored() {
        return new JavaBigDataRecord();
    }
}
