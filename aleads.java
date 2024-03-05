package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.Excelutils;
import CommonUtils.JavaUtils;
import CommonUtils.PropertyUtils;
import CommonUtils.WebDriverUtil;

public class aleads {
	@Test
	public void LeadsTest() throws IOException,InterruptedException
	{
		PropertyUtils putil=new PropertyUtils();
		WebDriverUtil wutil=new WebDriverUtil();
		Excelutils eutil =new Excelutils();
		JavaUtils jutil=new JavaUtils();
		WebDriver driver=new ChromeDriver();
	
		String URL=putil.getDataPropertyFile("Url");
		String USERNAME=putil.getDataPropertyFile("Username");
		String PASSWORD=putil.getDataPropertyFile("password");
		// PropertyUtils putil=new PropertyUtils();
		// WebDriverUtil  wutils=new WebDriverUtil();
		// Excelutils eutil=new Excelutils();
		// JavaUtils jutils=new JavaUtils ();
		//WebDriver driver=new ChromeDriver();
	wutil.maximize(driver);
	wutil.implicitwait(driver);
	//String USERNAME = putil.getDataPropertyFile("Username");
//	String PASSWORD = putil.getDataPropertyFile("password");
	
	String Last = eutil.getDataFromExcel("Leads", 1, 1);
	String First = eutil.getDataFromExcel("Leads", 0, 1);
	String COMP = eutil.getDataFromExcel("Leads",2 , 1);
	String grp = eutil.getDataFromExcel("Leads", 3, 1);
	//String URL = putil.getDataPropertyFile("Url");
	
	//String FN = eutils.getDataFromExcel("Leads", 1, 1);
	driver.get(URL);
	Thread.sleep(2000);
	
	//driver.findElement(By.cssSelector("input[name='user_name']")).sendKeys(USERNAME);
	//driver.findElement(By.cssSelector("input[name='user_password']")).sendKeys(PASSWORD);
	//driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("(//a[text()='Leads'])[1]")).click();
	driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(First);
	driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(Last);
	driver.findElement(By.cssSelector("input[name='company']")).sendKeys(COMP);
	driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
	WebElement drop = driver.findElement(By.cssSelector("select[name='assigned_group_id']"));
	wutil.handledropdown(drop, grp);
	
		
	}

}

