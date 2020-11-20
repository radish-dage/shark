package com.shark.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 扫包工具类，用于扫描指定包下面的所有类，包括子包
 *
 * @Author dage
 * @Date 2020/11/17 22:31
 * @Version 1.0
 */
public class ScanUtil {

    /**
     * 存放所有类的全限定名
     */
    private static List<String> classList = new ArrayList<>();

    /**
     * 扫包
     * @param packages 指定包，不指定全扫描
     * @return
     */
    public static List<String> scanPackage(String packages) {
        //1.获取当前项目的classes路径
        String classesPath = getClassesPath();

        //2.获取包的全路径
        //指定多个包用逗号分隔，这里按逗号分割
        String[] packageStrs = packages.split(",");

        for (String packageStr : packageStrs) {
            //获取包绝对路径
            String packagePath = getAbsolutePath(packageStr, classesPath);

            //遍历目录将类名存入list中
            classNameToList(packagePath);
        }

        return classList;
    }

    /**
     * 遍历目录将类名存入list中
     * @param packagePath 包路径
     */
    private static void classNameToList(String packagePath){
        //获取路径下所有文件或文件夹
        File[] files = new File(packagePath).listFiles();
        if(files != null){
            for (File file : files) {
                if(file.isDirectory()){
                    //是目录获取绝对路径递归调用
                    classNameToList(file.getAbsolutePath());
                }else{
                    //是文件，将文件名转为完整类名
                    String className = fileNameToClassName(file);
                    if(className != null){
                        classList.add(className);
                    }
                }
            }
        }
    }

    /**
     * 将文件名转为完整类名
     * @param file
     * @return
     */
    private static String fileNameToClassName(File file){
        if(file.getName().endsWith(".class")){
            //获取文件绝对路径，截取文件的全限定名，转为全限定名格式
            return file.getAbsolutePath().//获取文件绝对路径
                    substring(getClassesPath().length()-1, file.getAbsolutePath().length()-6).//截取文件的全限定名
                    replace(File.separator,".");//转为全限定名格式
        }else{
            return null;
        }
    }

    /**
     * 获取包的绝对路径
     * @param packageStr 包的全限定名
     * @param classesPath 当前项目的classes路径
     * @return 返回包的绝对路径
     */
    private static String getAbsolutePath(String packageStr, String classesPath) {
        return classesPath + packageStr.replace(".", File.separator);
    }

    /**
     * 获取当前项目的classes路径
     * @return 返回classes路径
     */
    private static String getClassesPath(){
        return ScanUtil.class.getClassLoader().getResource("").getPath();
    }
}
