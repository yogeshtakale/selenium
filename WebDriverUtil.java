package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Set;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//import org.openqa.selenium.WebDriver;

public class WebDriverUtil {

private static final String ScreenshotName = null;
//	public WebDriver driver; 
		// TODO Auto-generated method stub
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

	}
	public void handledropdown(WebElement elememt,String targetedelement){
	Select s= new Select(elememt);
	s.selectByVisibleText(targetedelement);
	}
	public void mousehover(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
		a.perform();
		
		
	}
	public void switchwindow(WebDriver driver,String exceptedurl) {
		Set<String> ids= driver.getWindowHandles();
		for(String e:ids) {
			String actualurl = driver.switchTo().window(e).getCurrentUrl();
			if(actualurl.contains(exceptedurl)) {
				break;
			}
		}
	}
	public File screenshot(WebDriver driver, String string) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File teFile=ts.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File("./Screenshot/"+ScreenshotName+".png");
		FileUtils.copyFile(teFile, destinationFile);
		return destinationFile;
		
	}

}
