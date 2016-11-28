package com.glance.dashboard.tests;


	import java.sql.Date;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Collections;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import org.junit.Test;

	import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

	public class Test2 {
	public WebDriver driver;

	@Test
	public void my() throws Exception
	{
	driver =new FirefoxDriver();
	WebDriverWait wait=new WebDriverWait(driver, 30);
	driver.get("http://www.spicejet.com/");
	wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".book_a_flight")));
	driver.findElement(By.cssSelector(".book_a_flight")).click();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchVieworiginStation1_CTXT")).click();
	driver.findElement(By.cssSelector("#ul1>li>a[value='DEL']")).click();
	driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchViewdestinationStation1_CTXT")).click();
	driver.findElement(By.cssSelector("#ul1>li>a[value='GOI']")).click();
	driver.findElement(By.cssSelector("#custom_date_picker_id_1")).click();
	Calendar now = Calendar.getInstance();
	System.out.println("Current Year is : " + now.get(Calendar.YEAR));
	     //month start from 0 to 11
	     System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
	     System.out.println("Current Date is : " + now.get(Calendar.DATE));

	now.add(Calendar.DATE, 51);
	int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
	driver.findElement(By.linkText("" + dayOfMonth)).click();
	System.out.println("Starting Year of travel is : " +now.get(Calendar.YEAR));
	     //month start from 0 to 11
	     System.out.println("Starting month of travel is : " +(now.get(Calendar.MONTH) + 1 ));
	     System.out.println("Starting date of travel is : " +now.get(Calendar.DATE));
	     driver.findElement(By.cssSelector("#custom_date_picker_id_2")).click();
	     /*int dayOfMonth2= dayOfMonth+5;
	     */

	    now.add(Calendar.DATE, 55);
	    int dayOfMonth2 = now.get(Calendar.DAY_OF_MONTH);
	     driver.findElement(By.linkText("" + dayOfMonth2)).click();
	     System.out.println("End Year of travel is : " + now.get(Calendar.YEAR));
	     //month start from 0 to 11
	     System.out.println("End month of travel is : " +(now.get(Calendar.MONTH) + 1 ));
	     System.out.println("End date of travel is : " + now.get(Calendar.DATE));

	     //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     WebElement dropdown=driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_DropDownListPassengerType_ADT"));
	     Select dropdown1=new Select(dropdown);
	     dropdown1.selectByValue("1");

	  driver.findElement(By.cssSelector("#ControlGroupSearchView_AvailabilitySearchInputSearchView_ButtonSubmit")).click();
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	     WebElement
	tab=driver.findElement(By.xpath("//table[@id='availabilityTable1']"));
	  List<WebElement> tableRows = tab.findElements(By.tagName("tr"));
	  {
	for(WebElement cell:tableRows)
	{
	List<WebElement>data=cell.findElements(By.xpath("//td[5]"));
	for(WebElement d:data)
	{
	System.out.println(d.getText());
	  }
	break;
	   }
	   }}
	}

