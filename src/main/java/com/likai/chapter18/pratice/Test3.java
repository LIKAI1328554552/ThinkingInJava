package com.likai.chapter18.pratice;

import com.likai.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Test3 {
    public static void main(final String [] args) {
        File path = new File(".") ;
        String [] list = null ;
        if(args.length == 0) {
            list = path.list() ;
        } else {
            list = path.list(new FilenameFilter() {
                private Pattern pattern = Pattern.compile(args[0]) ;
                @Override
                public boolean accept(File dir, String name) {
                    //验证格式
                    if(pattern.matcher(name).matches()) {
                        String content = null;
                        try {
                            content = TextFile.read(new File("").getCanonicalPath() + File.separator + name);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        if (pattern.matcher(content).matches()) {
                            return true ;
                        } else {
                            return false;
                        }
                    } else {
                        return false ;
                    }
                }
            }) ;
        }

        Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
        for (String s : list) {
            System.out.println(s);

        }
    }
}
