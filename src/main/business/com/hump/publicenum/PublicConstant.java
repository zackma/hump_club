package com.hump.publicenum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zackma on 2017/11/14 0014.
 */
public enum PublicConstant {
    /**
     * 逻辑删除是
     */
    DELETE_Y("Y","逻辑删除是"),
    /**
     * 逻辑删除否
     */
    DELETE_N("N","逻辑删除否");

    private String code;
    private String note;

    PublicConstant(String code,String note){
        this.code = code;
        this.note = note;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 添加枚举字段Map映射方便其它枚举取值（可扩展其它字段映射Map）
     */
    private static Map<String,String> noteMap = new HashMap<String,String>();
    static{
        for(PublicConstant c:PublicConstant.values()){
            noteMap.put(c.getCode(),c.getNote());
        }
    }
    public static String getNoteByCode(String Code){
        return noteMap.get(Code);
    }
}
