package com.project.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public static Object[][] ReadExcelToObjectArr(String filepath,String filename, String sheetname) throws IOException{
		File file = new File(filepath +"/" + filename);
	
		FileInputStream inputStream = new FileInputStream(file);
		//if i want to read from a xlsx file - i need to create an instance
		//of XSSFWorkbook - if i want to read from xls file - i need to create an
		//instance of HSSFWorkbook
		//Create an instance of Workbook
		
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetname);
		
		//number of data sets for the testcases - different sets of data for the testcase
		int rowCount= sheet.getLastRowNum();
	
		System.out.println("Number of Rows : " + rowCount); //this does not take into consideration the headerow - only data rows
		//2 dminesional object array
		Object[][] data = new Object[rowCount][1];
		Row keysrow = sheet.getRow(0); //keys row - first row or header row
		Hashtable<String,String> record = null;

		for(int r=1;r<rowCount+1;r++){ //0,1,2
			record = new Hashtable<String,String>();
			Row datarow = sheet.getRow(r);
			for(int c=0;c<datarow.getLastCellNum();c++){
				String key = keysrow.getCell(c).getStringCellValue();
				String val = datarow.getCell(c).getStringCellValue();
				record.put(key, val);
			}
			data[r-1][0] = record;
		}
		return data;
	}

	
	

}
