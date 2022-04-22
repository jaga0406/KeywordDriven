package com.lao.utilities;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.lao.constants.Constants;

public class ExcelUtilities {
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	String cellValue;
	public static String locatorcolumnvalue;
	public static String locatorname;
	public static String locatorvalue;
	public static String keywordcolumnvalue;
	public static String datacolumnvalue;
	public static int totalRows;
	
     public void readExcelFile(String location) throws IOException {
    	 FileInputStream file = new FileInputStream(location);
    	 workbook = new XSSFWorkbook(file);
    	 sheet = workbook.getSheet(Constants.SHEET_NAME);
         totalRows = sheet.getLastRowNum();
     } 
    	 
    public void getValuesFromExcel(int row, int locatorcolumn, int keywordcolumn, int datacolumn) {

     locatorcolumnvalue = sheet.getRow(row).getCell(locatorcolumn).toString().trim();
    
    if (!locatorcolumnvalue.contains("NA")) {
    	 locatorname = locatorcolumnvalue.split("=")[0].toString().trim();
    	 locatorvalue = locatorcolumnvalue.split("=")[1].toString().trim();
	} else {
		locatorname = "NA";
		locatorvalue = "NA";
	}
    
    keywordcolumnvalue = sheet.getRow(row).getCell(keywordcolumn).toString().trim();
    datacolumnvalue = sheet.getRow(row).getCell(datacolumn).toString().trim();
    
    System.out.println(locatorname+ " : " +locatorvalue + " keyword :" +keywordcolumnvalue + " Data :" +datacolumnvalue);
    
    } 	 
    	 
}
     
 
    	


