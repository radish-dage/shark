package com.shark.utils;

import java.io.IOException;
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
     * @param reqHeaderPro 请求头属性，不定参数，有参时最多也只有一个
     * @return
     */
    public static HttpURLConnection createHttpUrlConn(String urlPath, String requestMethod, Map<String,String>...reqHeaderPro) throws IOException {
        URL url = new URL(urlPath);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod(requestMethod);

        //设置请求头
        if(reqHeaderPro[0].size() != 0){
            Iterator<Map.Entry<String,String>> iterator = reqHeaderPro[0].entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,String> entry = iterator.next();
                httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }

        return httpURLConnection;
    }
}
