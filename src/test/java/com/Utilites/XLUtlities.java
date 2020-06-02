package com.Utilites;


import java.io.FileInputStream;

import java.io.FileOutputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.ss.usermodel.DataFormatter;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtlities {

      public static FileInputStream fis;
      public static FileOutputStream fos;
      public static XSSFWorkbook workbook;
      public static XSSFSheet sheet;
      public static XSSFRow row;
      public static XSSFCell cell;
   
      public static int getRowCount(String xlfile, String xlsheet)throws IOException {

             fis=new FileInputStream(xlfile);
             workbook=new XSSFWorkbook(fis);
             sheet=workbook.getSheet(xlsheet);
             int rowCount=sheet.getLastRowNum();
             workbook.close();
             fis.close();
             return rowCount;
      }

      public static int getCellCount(String xlfile, String xlsheet,int rownum)throws IOException {

             fis=new FileInputStream(xlfile);
             workbook=new XSSFWorkbook(fis);
             sheet=workbook.getSheet(xlsheet);
             row=sheet.getRow(rownum);
             int cellCount=row.getLastCellNum();
             workbook.close();
             fis.close();
             return cellCount;
      }

      public static String getCellData(String xlfile, String xlsheet,int rownum,int cellCount ) throws Exception {

             fis=new FileInputStream(xlfile);
             workbook=new XSSFWorkbook(fis);
             sheet=workbook.getSheet(xlsheet);
             row=sheet.getRow(rownum);
             cell=row.getCell(cellCount);
             String data;

             try {
              //HSSFDataFormatter formatter = new HSSFDataFormatter();
                    DataFormatter formatter=new DataFormatter();
                    String cellData=formatter.formatCellValue(cell);
                    return cellData;
             }

             catch(Exception e) {
             data="";
             }
             workbook.close();
             fis.close();
             return data;
      }

      public static void setCellData(String xlfile,String xlsheet, int rownum, int cellCount,String data)throws Exception {

       fis=new FileInputStream(xlfile);
             workbook=new XSSFWorkbook(fis);
             sheet=workbook.getSheet(xlsheet);
             row=sheet.getRow(rownum);
             cell=row.createCell(cellCount);
             cell.setCellValue(data);
             fos=new FileOutputStream(xlfile);
             workbook.write(fos);
             workbook.close();
             fis.close();
             fos.close();
      }
  }
