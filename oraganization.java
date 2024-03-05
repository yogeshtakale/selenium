package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import CommonUtils.Excelutils;
import CommonUtils.JavaUtils;
import CommonUtils.Listenerimpletation;
import CommonUtils.PropertyUtils;
import CommonUtils.WebDriverUtil;
@Listeners(Listenerimpletation.class)

public class oraganization {
	@Test
	public void OrganizationTest() throws IOException, InterruptedException
	{
		PropertyUtils putil=new PropertyUtils();
		WebDriverUtil wutil=new WebDriverUtil();
		Excelutils eutil =new Excelutils();
		JavaUtils jutil=new JavaUtils();
		WebDriver driver=new ChromeDriver();
	
		String URL=putil.getDataPropertyFile("Url");
		String USERNAME=putil.getDataPropertyFile("Username");
		String PASSWORD=putil.getDataPropertyFile("password");
		//to launch the web application
		driver.get(URL);
		//to maximize the windoe
		wutil.maximize(driver);
		//to apply wait
		wutil.implicitwait(driver);
		
		
		//driver.manage().window().maximize();
		//login credentials
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		String org = eutil.getDataFromExcel("Oraganizations", 0, 1);//Oraganizations
		String grp = eutil.getDataFromExcel("Oraganizations", 1, 1);
		driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(org+jutil.getRandonumber());
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		WebElement drop = driver.findElement(By.name("assigned_group_id"));
		wutil.handledropdown(drop, grp);
		driver.findElement(By.xpath("//input[@name='button'][1]")).click();
		Thread.sleep(2000);
		WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		wutil.mousehover(driver, img);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//Select s=new Select(drop);
		//s.selectByVisibleText(grp);
		//s.selectByVisibleText("Support Group");
		//click on submit
		//driver.findElement(By.id("submitButton")).click();
		//click on organization
		//driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		//driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		//driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(org);
		//driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		//driver.findElement(By.name("assigned_group_id")).click();
		//driver.findElement(By.xpath("//option[text()='Support Group']")).click();
	}
}


