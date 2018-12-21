package com.likai.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.xmlbeans.impl.common.ReaderInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckRyCsny {
    public static void main(String [] args) {
        InputStream in = null ;
        HSSFSheet sheet = null ;
        List<String> errorList = new ArrayList<String>() ;
        try {
            in = new FileInputStream(new File("D://111.xls")) ;

            //获取io输入流
            POIFSFileSystem fs = new POIFSFileSystem(in) ;
            //获取工作簿
            HSSFWorkbook wb = new HSSFWorkbook(fs) ;
            //获取sheet页
            sheet = wb.getSheetAt(0) ;
        } catch (Exception e) {

        }

        if(sheet != null) {
            //遍历行 从第二行开始
            for(int rowNums = 1 ; rowNums <= sheet.getLastRowNum() ; rowNums ++) {
                //取得行
                HSSFRow row = sheet.getRow(rowNums) ;
                if(row == null) {
                    continue ;
                }
                row.getCell(2).setCellType(Cell.CELL_TYPE_STRING) ;
                String csny = String.valueOf(row.getCell(2).getStringCellValue()) ;
                String xm = String.valueOf(row.getCell(0).getStringCellValue()) ;
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
                if(csny.matches("[12]\\d{3}(0\\d|1[0-2])([0-2]\\d|3[01])")) {

                } else {
                    System.out.println(csny);
                    errorList.add(xm) ;
                }
             }
        }


        System.out.println(errorList);
    }
}
