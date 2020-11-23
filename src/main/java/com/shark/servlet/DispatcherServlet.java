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
import java.lang.reflect.Parameter;
import java.util.*;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("POST Request");
        requestUrlToMethodInvoke(req, resp, postMap);
    }

    private void requestUrlToMethodInvoke(HttpServletRequest req, HttpServletResponse resp, Map<String, Method> map) {
        //1.获取请求的路径
        String reqUrl = req.getRequestURI();
        String[] reqUrls = reqUrl.split("/");
        reqUrl = "/" + reqUrls[reqUrls.length - 1].substring(0,reqUrls[reqUrls.length - 1].length() - 3);

        //获取参数列表
        Map<String,String[]> paramMap = req.getParameterMap();

        //2.根据请求路径从map中取出对应的method然后回调
        Method method = map.get(reqUrl);

        if(method == null){//获取不到对应的映射方法，转发到404
            try {
                req.getRequestDispatcher("/html/404.html").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

            //动态设参
            Parameter[] parameters = method.getParameters();
            Object[] params = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                String[] paramsStr = paramMap.get(parameters[i].getName());
                params[i] = paramsStr[0];
            }

            try {
                //实例化
                Object object = method.getDeclaringClass().getDeclaredConstructor().newInstance();
                //回调方法，以json格式响应返回值
                String json = (String) method.invoke(object,params);
                resp.getWriter().write(json);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
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
                        //获取有注解方法的value值，对应我们的请求url，缓存到map集合
                        if(HttpCode.GET.equals(method.getAnnotation(RequestUrlMapping.class).type())){
                            getMap.put(method.getAnnotation(RequestUrlMapping.class).url(), method);
                        }else if(HttpCode.POST.equals(method.getAnnotation(RequestUrlMapping.class).type())){
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
