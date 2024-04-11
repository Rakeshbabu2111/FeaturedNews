package utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.HomePage;

public class ExcelUtility {
	WebDriver driver;
	WebDriverWait wait;
	HomePage homepage;
	public ExcelUtility(WebDriver driver) {
		this.driver=driver;
	}
	
public void captureUserInformation() throws FileNotFoundException, InterruptedException {
	    
	    homepage=new HomePage(driver,wait);		
		Thread.sleep(5000);
		FileOutputStream file=new FileOutputStream("C:\\Users\\2327178\\eclipse-workspace\\CASProject-Featured_News\\testData\\userInformation.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();		
		Thread.sleep(5000);
		String userName=homepage.txt_username_element.getText();
		String emailId=homepage.txt_email_element.getText();		
		XSSFRow row1=sheet.createRow(0);
	    XSSFCell cell1=row1.createCell(0);
	    cell1.setCellValue(userName);
		XSSFCell cell2=row1.createCell(1);
		cell2.setCellValue(emailId);
		try {
			workbook.write(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}
