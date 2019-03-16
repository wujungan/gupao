package com.gupao.wjg.deligate;

/**
 * 战争类型
 */
public enum WarType {

    RECAPTURETAIWAN("收复台湾","recapturetaiwan"),RECOVERYXINJIANG("收复新疆","recoveryxinjiang");

    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private WarType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public static String getNameByCode(String code) {
        for (WarType status : WarType.values()) {
            if (status.code.equals(code)) {
                return status.getName();
            }
        }
        return "";
    }
}
