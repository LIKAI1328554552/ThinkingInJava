package com.likai.chapter18.pratice;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Test1 {
    //传入正则表达式 .+\.xml 筛选后缀为.xml的文件
    public static void main(String [] args) {
        //表示项目根目录
        File path = new File(".") ;
        String [] list ;
        //传入正则表达式 以便筛选文件
        if(args.length == 0) {
            list = path.list() ;
        } else {
            //每个文件名都会调用DirFileName实现的accept方法
            list = path.list(new DirFileName(args[0])) ;
        }

        //之前用过 按照字母排序
        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

/**
 * 自定义文件名称过滤器
 */
class DirFileName implements FilenameFilter {
    private Pattern pattern ;
    public DirFileName() {
        super();
    }
    public DirFileName(String regex) {
        pattern = Pattern.compile(regex) ;
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
