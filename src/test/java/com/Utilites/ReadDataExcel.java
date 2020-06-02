package com.Utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataExcel {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("C://Users//ADMIN//Desktop//EMPDETAILS.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//Count Row count
		int rowCount= sheet.getLastRowNum();
		//Count Col count
		int colCount=sheet.getRow(0).getLastCellNum();
		for(int i=0; i<rowCount;i++) {
			XSSFRow currentrow=sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				String value =currentrow.getCell(j).toString();
				System.out.print("   "+value);
			}
			System.out.println();
		}
	}

}
