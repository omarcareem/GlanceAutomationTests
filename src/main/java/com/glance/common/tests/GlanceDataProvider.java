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
		//String screen=null;
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
	
	/*@DataProvider(name="profileUpdateData")
	public static Object[][] getProfileUpdateData() throws Exception
	{
		
		String sheetName="ProfileUpdateData";
		String username=null;
		String emailID=null;
		String firstName=null;
		String lastName=null;
		String password=null;
		String conpassword=null;
		Object[][] profileUpdateData = null;
		
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		profileUpdateData = new Object[rows-1][];
		for(int i=1;i<rows;i++)
		{
			username = excelReader.getData(sheetName, i, 0);
			System.out.println(username);
			emailID = excelReader.getData(sheetName, i, 1);
			System.out.println(emailID);
			firstName = excelReader.getData(sheetName, i, 2);
			System.out.println(firstName);
			lastName= excelReader.getData(sheetName, i, 3);
			System.out.println(lastName);
			password=excelReader.getData(sheetName, i, 4);
			System.out.println(password);
			conpassword=excelReader.getData(sheetName, i, 5);
			System.out.println(conpassword);
			
			profileUpdateData[i - 1] = new Object[] { username,emailID,firstName,lastName,password,conpassword};
			
		}
		return profileUpdateData;
	}
	
	
	
	@DataProvider(name="loginData")
	public static Object[][] getLoginData() throws Exception
	{
		
		String sheetName="LoginData";
		String username=null;
		String password=null;
		String msg=null;
		
		Object[][] logineData = null;
		
		
		ExcelReader excelReader = new ExcelReader(path);
		int rows = excelReader.getRowCount(sheetName);
		logineData = new Object[rows-1][];
		for(int i=1;i<rows;i++)
		{
			username = excelReader.getData(sheetName, i, 0);
			System.out.println(username);
			password = excelReader.getData(sheetName, i, 1);
			System.out.println(password);
			msg = excelReader.getData(sheetName, i, 2);
			System.out.println(msg);
			
			logineData[i - 1] = new Object[] { username,password,msg};
			
		}
		return logineData;
	}
	*/
	}


