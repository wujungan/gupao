package com.gupao.wjg.deligate;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 军机处
 */
public class PrivyCouncil {
    
    static Map<String,General> map=new ConcurrentHashMap<String,General>();
    
 static{
         map.put("recapturetaiwan",new ShiLang());
         map.put("recoveryxinjiang",new Zouzhongtang());

 }

    public void command(WarType warType) {
        General general = map.get(warType.getCode());
        if(general!=null){
            general.startWar();
        }
    }
}
