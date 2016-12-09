package com.glance.common.tests;

import org.testng.annotations.DataProvider;

public class GlanceDataProvider {
	
	public static String path="TestData.xlsx";
	
	@DataProvider(name="chartTestData")
	public static Object[][] getChartData() throws Exception
	{
		
		String sheetName="ChartData";
		String accountName=null;
		String metric=null;
		String title=null;
		String footer=null;
		String description=null;
		String dataTable=null;
		String labelColumn=null;
		String dataField=null;
		String dataSeriesField=null;
		String chartSeriesField=null;		
		String screen=null;
		Object[][] chartData = null;		
		
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		chartData = new Object[rows-1][];
		for(int i=1;i<rows;i++)
		{
			accountName = excelReader.getData(sheetName, i, 0);
			System.out.println(accountName);
			metric = excelReader.getData(sheetName, i, 1);
			System.out.println(metric);
			title = excelReader.getData(sheetName, i, 2);
			System.out.println(title);
			footer= excelReader.getData(sheetName, i, 3);
			System.out.println(footer);
			description=excelReader.getData(sheetName, i, 4);
			System.out.println(description);
			
			dataTable=excelReader.getData(sheetName, i, 5);
			System.out.println(dataTable);
			
			labelColumn=excelReader.getData(sheetName, i, 6);
			System.out.println(labelColumn);
			
			dataField=excelReader.getData(sheetName, i, 7);
			System.out.println(dataField);
			
			dataSeriesField=excelReader.getData(sheetName, i, 8);
			System.out.println(dataSeriesField);
			
			chartSeriesField=excelReader.getData(sheetName, i, 9);
			System.out.println(chartSeriesField);
			
			chartData[i - 1] = new Object[] { accountName,metric,title,footer,description,dataTable,labelColumn,dataField,dataSeriesField,chartSeriesField };
			
		}
		return chartData;
	}
	
	
	@DataProvider(name="GL_UM_02")
	public static Object[][] getMUUserName() throws Exception
	{
		String sheetName="GL_UM_02";
		String colomName=null;
		Object[][] sortingColom = null;
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		sortingColom = new Object[rows-1][];
		for(int i=1;i<rows;i++){
			colomName = excelReader.getData(sheetName, i, 0);
			
			
			
			sortingColom[i-1]=new Object[]{colomName};
		}
		
		return sortingColom;
		
	}
	
	@DataProvider(name="GL_UM_08")
	public static Object[][] getKeyWord() throws Exception
	{
		String sheetName="GL_UM_08";
		String keyWord=null;
		String expectedsearch = null;
		Object[][] searchKeyWord = null;
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		searchKeyWord = new Object[rows-1][];
		for(int i=1;i<rows;i++){
			keyWord = excelReader.getData(sheetName, i, 0);
			expectedsearch = excelReader.getData(sheetName, i, 1);
			
			
			searchKeyWord[i-1]=new Object[]{keyWord,expectedsearch};
		}
		
		return searchKeyWord;
		
	}
	
	@DataProvider(name="GL_UM_09_1")
	public static Object[][] getPagination() throws Exception
	{
		String sheetName="GL_UM_09_1";
		String pagination=null;
		Object[][] pageNavigation = null;
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		pageNavigation = new Object[rows-1][];
		for(int i=1;i<rows;i++){
			pagination = excelReader.getData(sheetName, i, 0);
						
			
			pageNavigation[i-1]=new Object[]{pagination};
		}
		
		return pageNavigation;
		
	}
	
	@DataProvider(name="GL_UM_09_2")
	public static Object[][] getIntPagination() throws Exception
	{
		String sheetName="GL_UM_09_2";
		int middlePagination =0;
		Object[][] pageNavigation = null;
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		pageNavigation = new Object[rows-1][];
		for(int i=1;i<rows;i++){
			middlePagination = excelReader.getIntData(sheetName, i, 0);
			
			
			pageNavigation[i-1]=new Object[]{middlePagination};
		}
		
		return pageNavigation;
		
	}

	@DataProvider(name="GL_UM_12")
	public static Object[][] getdropDownValue() throws Exception
	{
		String sheetName="GL_UM_12";
		String dropDownValue=null;
		Object[][] selectDropDownValue = null;
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		selectDropDownValue = new Object[rows-1][];
		for(int i=1;i<rows;i++){
			dropDownValue = excelReader.getData(sheetName, i, 0);
			
			
			
			selectDropDownValue[i-1]=new Object[]{dropDownValue};
		}
		
		return selectDropDownValue;
		
	}

}
