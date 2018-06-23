package com.framelib.dubbo.doctor;

/**
 * 医生分组负责人枚举 0 不是 1 是
 * Created by zhouzengbao on 16/05/2017.
 */
public enum DoctorGroupFunctionary {
    O(0,"不是负责人"),S(1,"是负责人");

    private int key;
    private String value;

    DoctorGroupFunctionary(int key,String value){
        this.key = key;
        this.value =value;
    }

    public Integer getKey() { return key; }
    public String getValue() { return value; }
}
