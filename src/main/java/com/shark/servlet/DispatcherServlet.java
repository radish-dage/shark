package com.shark.servlet;

import com.shark.annotation.RequestUrlMapping;
import com.shark.common.HttpCode;
import com.shark.utils.ScanUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 中央控制器，处理所有请求到指定方法的映射
 *
 * @Author dage
 * @Date 2020/11/17 23:46
 * @Version 1.0
 */
public class DispatcherServlet extends HttpServlet{

    private static final Map<String, Method> getMap = new HashMap<>();
    private static final Map<String, Method> postMap = new HashMap<>();

    @Override
    public void init() {
        //1.全局扫描（空代表全局，也可指定某个包，多个包用“,”隔开）
        List<String> classNames = ScanUtil.scanPackage("");

        //2.解析类中有注解的方法
        resolve(classNames);

        System.out.println("DispatcherServlet init OK!");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("GET Request");
        requestUrlToMethodInvoke(req, resp, getMap);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST Request");
        requestUrlToMethodInvoke(req, resp, postMap);
    }

    private void requestUrlToMethodInvoke(HttpServletRequest req, HttpServletResponse resp, Map<String, Method> map) {
        //1.获取请求的路径
        String reqUrl = req.getRequestURI();
        System.out.println("请求路径："+reqUrl);

        //2.根据请求路径从map中取出对应的method然后回调
        Method method = map.get(reqUrl);
        if(method != null){
            try {
                //实例化
                Object object = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                //回调方法
                method.invoke(object,req,resp);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }else{
            try {
                resp.getWriter().write("request have error,please check url");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 解析类中有注解的方法
     * @param classNames 所有类
     */
    private void resolve(List<String> classNames){
        //2.解析类中有注解的方法
        for (String className : classNames){
            try {
                //进行类加载
                Class<?> clazz =  Class.forName(className);
                //获取类中所有方法，遍历
                Method[] meThods = clazz.getMethods();
                for (Method method : meThods) {
                    //过滤不存在注解的方法
                    if(method.isAnnotationPresent(RequestUrlMapping.class)){
                        if(HttpCode.GET.equals(method.getAnnotation(RequestUrlMapping.class).type())){
                            //获取有注解方法的value值，对应我们的请求url，缓存到map集合
                            getMap.put(method.getAnnotation(RequestUrlMapping.class).url(), method);
                        }else if(HttpCode.POST.equals(method.getAnnotation(RequestUrlMapping.class).type())){
                            //获取有注解方法的value值，对应我们的请求url，缓存到map集合
                            postMap.put(method.getAnnotation(RequestUrlMapping.class).url(), method);
                        }
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
