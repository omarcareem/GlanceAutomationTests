package com.glance.common.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.glance.pageobjects.logs.TestLog;

public class ExcelReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public ExcelReader(String path) throws IOException {
		try {
			// File src = new File(path);
			FileInputStream fileInputStream = new FileInputStream(path);
			wb = new XSSFWorkbook(fileInputStream);
		}catch (Exception ex) {
			TestLog.log.info("Could not fetch the file " + ex);
		}
	}

	public String getData(String sheetName, int row, int column) {
		sheet = wb.getSheet(sheetName);
		XSSFCell cell=sheet.getRow(row).getCell(column);
		
		cell.setCellType(1);
		String data = cell.getStringCellValue();	
		//String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getIntData(String sheetName, int row, int column) {
		sheet = wb.getSheet(sheetName);

		int intData = sheet.getRow(row).getCell(column).getCellType();
		return intData;
	}

	public int getRowCount(String sheetName) {
		// int rows = wb.getSheetAt(sheetIndex).getLastRowNum();
		// rows = rows+1;
		// return rows;

		int rows = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		return rows;
	}
	
}
