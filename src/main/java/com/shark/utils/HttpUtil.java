package com.shark.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shark.common.HttpCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * http连接相关工具类
 *
 * @Author dage
 * @Date 2020/11/19 13:30
 * @Version 1.0
 */
public class HttpUtil {

    /**
     * 获取http连接
     * @param urlPath 连接路径
     * @param requestMethod 请求方法
     * @param reqHeader 请求头属性，不定参数，有参时最多也只有一个
     * @return
     * @throws IOException
     */
    public static HttpURLConnection openHttpUrlConn(String urlPath, String requestMethod, Map<String,String>...reqHeader) throws IOException {
        URL url = new URL(urlPath);
        //
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        //设置请求方法
        httpURLConnection.setRequestMethod(requestMethod);

        //设置请求头
        if(reqHeader[0].size() != 0){
            Iterator<Map.Entry<String,String>> iterator = reqHeader[0].entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> entry = iterator.next();
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        //打卡到此url引用的资源的通信连接，已打开情况下忽略该调用
        httpURLConnection.connect();

        return httpURLConnection;
    }

    /**
     * 获取数据缓冲流
     * @param httpURLConnection
     * @return
     * @throws IOException
     */
    public static BufferedReader getHttpUrlBufferedReader(HttpURLConnection httpURLConnection) throws IOException {
        return new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), HttpCode.UTF8));
    }

    /**
     * 获取流中json数据
     * @param br
     * @return
     * @throws IOException
     */
    public static JSONObject getBrJsonData(BufferedReader br) throws IOException {
        String lineString;
        StringBuilder sb = new StringBuilder();
        while( (lineString = br.readLine()) != null) {
            sb.append(lineString);
        }
        return JSON.parseObject(sb.toString());
    }
}
