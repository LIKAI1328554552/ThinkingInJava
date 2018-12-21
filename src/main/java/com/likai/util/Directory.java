package com.likai.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
    /**
     * 返回指定目录下符合所要求格式的文件数组
     * @param dir 目录
     * @param regex 正则格式
     * @return
     */
    public static File [] local(File dir,final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex) ;
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }) ;
    }

    /**
     * 返回指定路径下符合所要求格式的文件数组
     * @param path 文件路径
     * @param regex 正则格式
     * @return
     */
    public static File [] local(String path,final String regex) {
        return local(new File(path),regex) ;
    }

    public static class TreeInfo {
        public List<File> files = new ArrayList<File>() ;
        public List<File> dirs = new ArrayList<File>() ;

        public void addAll(TreeInfo other) {
            this.files.addAll(other.files) ;
            this.dirs.addAll(other.dirs) ;
        }


        public static TreeInfo recurseDirs(File startDir,String regex) {
            TreeInfo result = new TreeInfo() ;
            for (File item : startDir.listFiles()) {
                if (item.isDirectory()) {
                    result.dirs.add(item) ;
                    result.addAll(recurseDirs(item,regex));
                } else {
                    if(item.getName().matches(regex)) {
                        result.files.add(item) ;
                    }
                }
            }

            return result ;
        }

        public String toString() {
            String content = "files: " + this.files + "\n" ;
            content += "dirs: " + this.dirs ;
            return content ;
        }

        public static void main(String [] args) {
            System.out.println(walk("D:\\workspace_idea\\ThinkingInJava\\src\\main\\java"));
        }

        public static TreeInfo walk(String start) {
            return recurseDirs(new File(start),".*") ;
        }

        public static TreeInfo walk(File start) {
            return recurseDirs(start,".*") ;
        }

        public static TreeInfo walk(String start,String regex) {
            return recurseDirs(new File(start),regex) ;
        }

        public static TreeInfo walk(File start,String regex) {
            return recurseDirs(start,regex) ;
        }

    }

    public static void main(String [] args) {
        System.out.println(TreeInfo.walk("D:\\workspace_idea\\ThinkingInJava\\src\\main\\java",".*\\.java"));
    }


}
