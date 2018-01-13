package com.liotw.springboot.jpa.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class Result<T> {

    public Integer getResCode() {
        return resCode;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 转换为JSON字符串，默认:
     * WriteNullListAsEmpty    List字段如果为null,输出为[],而非null
     * WriteNullStringAsEmpty  字符类型字段如果为null,输出为”“,而非null
     * WriteMapNullValue       是否输出值为null的字段,默认为false
     */
    public String toJson() {
        if (this.data == null) {
            return JSON.toJSONString(this);
        }
        return toJson(SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteMapNullValue);
    }

    public String toJson(SerializerFeature... features) {
        if (null == features) {
            return toJson();
        }
        return JSON.toJSONString(this, features);
    }

    @Override
    public String toString() {
        return "Result{" +
                "resCode=" + resCode +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }

    private Integer resCode;
    private String resMsg;
    private T data;

}
