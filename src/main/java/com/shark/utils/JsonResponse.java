package com.shark.utils;

import com.alibaba.fastjson.JSONObject;
import com.shark.common.HttpCode;

import java.io.Serializable;

/**
 * 响应工具类
 *
 * @Author dage
 * @Date 2020/11/23 10:02
 * @Version 1.0
 */
public class JsonResponse implements Serializable {

    /**
     * 响应信息
     */
    private String msg;

    /**
     * 响应码
     */
    private String code;

    /**
     * 数据
     */
    private Object data;


    public JsonResponse(){}

    public JsonResponse(String msg, String code, Object data){
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static String success(Object data){
        return JSONObject.toJSONString(new JsonResponse(HttpCode.OK, HttpCode.SUCCESS, data));
    }

    public static String fail(){
        return JSONObject.toJSONString(new JsonResponse(HttpCode.OK, HttpCode.FAIL, null));
    }
}
