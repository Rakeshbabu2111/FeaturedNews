package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class BaseClass {
	static WebDriver driver;
	
	
	
	public WebDriver setup(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) 
		{
			driver=new ChromeDriver();
			
		}
		if(browser.equalsIgnoreCase("edge"))
		{		
			driver=new EdgeDriver();		
		}
		driver.manage().deleteAllCookies();
		
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	//Capture the Screenshot
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);	
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);	
		return targetFilePath;
	}
	
	
	

}
