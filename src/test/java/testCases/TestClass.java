package testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.NewsPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TestClass extends BaseClass {

	public WebDriver driver;
	WebDriverWait wait;
	HomePage homepage;
	NewsPage newspage;
	public Logger logger=LogManager.getLogger(TestClass.class);


	@BeforeClass
	@Parameters({ "browser" })
	public void driverConfig(String browser) {
		this.driver = setup(browser);

	}

	@Test(priority = 0)
	public void clickOnUser() throws InterruptedException, FileNotFoundException {
		homepage = new HomePage(driver, wait);
		ExcelUtility excelutility = new ExcelUtility(driver);
		Thread.sleep(3000);
		homepage.clickuserInfo();
		logger.info("Clicked on the User Information");
		Thread.sleep(10000);
		excelutility.captureUserInformation();
	}

	@Test(priority=1)
	public void verifyNewsDisplayed() throws InterruptedException {
		homepage = new HomePage(driver,wait);
		newspage=new NewsPage(driver,wait);
		homepage.scrollDownToViewNews();
		Thread.sleep(7000);
		Assert.assertEquals(homepage.verifyNewsPagesDisplayed(), true,"News are not displayed Test Method-Failed");
	}

	@Test(priority = 2)
	public void verifyHeaderAndTooltip() {
		boolean check = homepage.verifyHeaderAndTooltip();
		Assert.assertEquals(check, true);
		if (check == true) {
			logger.info("Header and the tooltip are displayed same");
		} else {
			logger.error("Header and the tooltip are not displayed same");
		}
	}

	@Test(priority = 3)
	public void validateNewsSlide1() throws IOException, InterruptedException {

		homepage = new HomePage(driver, wait);
		newspage = new NewsPage(driver, wait);
		homepage.clickOnNewsslide1();
		logger.info("Clicked on News Slide-1");
		newspage.printNews1Description();
		logger.info("News description is printed in the News1Description.txt file");
		Thread.sleep(5000);
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(newspage.verifyAssociateDetailsPopupOnHover(), true,
				"Associate details are not displayed in popup when hovered-Test Failed");
		if (newspage.verifyAssociateDetailsPopupOnHover() == true) {
			logger.info("Associate details are displayed in popup when hovered");
		}

		softassert.assertEquals(newspage.verifyShareOptionAndPrintShareOptions(), true,
				"Share option is not displayed-Test Failed");
		if (newspage.verifyShareOptionAndPrintShareOptions() == true) {
			logger.info("Share option is displayed and printed all the options displayed in share options");
		}

		Thread.sleep(5000);
		newspage.scrollPageToViewLikesAndComments();
		Thread.sleep(4000);

		softassert.assertEquals(newspage.txt_likes_element.isDisplayed(), true, "Likes are Not displayed-Test Failed");
		softassert.assertEquals(newspage.txt_views_element.isDisplayed(), true, "Views are Not displayed-Test Failed");
		System.out.println(newspage.likesOfNews());
		System.out.println(newspage.viewsOfNews());
		if (newspage.txt_likes_element.isDisplayed() == true && newspage.txt_views_element.isDisplayed() == true) {
			logger.info("Number of Likes and Views are printed");
		}
		softassert.assertAll();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");

	}

	@Test(priority = 4)
	public void validateNewsSlide2() throws IOException, InterruptedException {

		homepage = new HomePage(driver, wait);
		newspage = new NewsPage(driver, wait);

		Thread.sleep(8000);
		homepage.clickOnNewsslide2();
		logger.info("Clicked on News Slide-2");
		newspage.printNews2Description();
		logger.info("News description is printed in the News2Description.txt file");
		Thread.sleep(3000);
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(newspage.verifyAssociateDetailsPopupOnHover(), true,
				"Associate details are not displayed in popup when hovered-Test Failed");
		if (newspage.verifyAssociateDetailsPopupOnHover() == true) {
			logger.info("Associate details are displayed in popup when hovered");
		}

		softassert.assertEquals(newspage.verifyShareOptionAndPrintShareOptions(), true,
				"Share option is not displayed-Test Failed");
		if (newspage.verifyShareOptionAndPrintShareOptions() == true) {
			logger.info("Share option is displayed and printed all the options displayed in share options");
		}
		Thread.sleep(5000);
		newspage.scrollPageToViewLikesAndComments();
		Thread.sleep(4000);
		System.out.println(newspage.txt_likes_element.isDisplayed());
		Assert.assertEquals(newspage.txt_likes_element.isDisplayed(), true, "Likes are Not displayed-Test Failed");
		softassert.assertEquals(newspage.txt_views_element.isDisplayed(), true, "Views are Not displayed-Test Failed");
		System.out.println(newspage.likesOfNews());
		System.out.println(newspage.viewsOfNews());
		if (newspage.txt_likes_element.isDisplayed() == true && newspage.txt_views_element.isDisplayed() == true) {
			logger.info("Number of Likes and Views are printed");
		}
		
		softassert.assertEquals(newspage.verifyHyperlinksNews(),true,"Hyperlinks are not displayed TestMethod -Failed");
		if(newspage.verifyHyperlinksNews()==true) {
			logger.info("Hyperlinks are displayed");
		}
		softassert.assertAll();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");
	

	}

	@Test(priority = 5)
	public void validateNewsSlide3() throws InterruptedException, IOException {

		homepage = new HomePage(driver, wait);
		newspage = new NewsPage(driver, wait);
		Thread.sleep(8000);
		homepage.clickOnNewsslide3();
		logger.info("Clicked on News Slide-3");
		newspage.printNews3Description();
		logger.info("News description is printed in the News3Description.txt file");
		Thread.sleep(3000);
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(newspage.verifyAssociateDetailsPopupOnHover(), true,
				"Associate Details popup is not displayed-Test Failed");
		if (newspage.verifyAssociateDetailsPopupOnHover() == true) {
			logger.info("Associate details are displayed in popup when hovered");
		}
		softassert.assertEquals(newspage.verifyShareOptionAndPrintShareOptions(), true,
				"Share option is not displayed-Test Failed");
		if (newspage.verifyShareOptionAndPrintShareOptions() == true) {
			logger.info("Share option is displayed and printed all the options displayed in share options");
		}
		Thread.sleep(5000);
		newspage.scrollPageToViewLikesAndComments();
		Thread.sleep(4000);
		softassert.assertEquals(newspage.txt_likes_element.isDisplayed(), true, "Likes are Not displayed-Test Failed");
		softassert.assertEquals(newspage.txt_views_element.isDisplayed(), true, "Views are Not displayed-Test Failed");
		System.out.println(newspage.likesOfNews());
		System.out.println(newspage.viewsOfNews());
		if (newspage.txt_likes_element.isDisplayed() == true && newspage.txt_views_element.isDisplayed() == true) {
			logger.info("Number of Likes and Views are printed");
		}
		softassert.assertEquals(newspage.verifyHyperlinksNews(), true,
				"Hyperlinks are not displayed-TestCase-Failed");
		if(newspage.verifyHyperlinksNews()==true) {
			logger.info("Hyperlinks are displayed");
		}
		softassert.assertAll();
		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");

	}

	@Test(priority = 6)
	public void validateNewsSlide4() throws InterruptedException, IOException {

		homepage = new HomePage(driver, wait);
		newspage = new NewsPage(driver, wait);
		Thread.sleep(8000);
		homepage.clickOnNewsslide4();
		logger.info("Clicked on News Slide-4");
		newspage.printNews4Description();
		logger.info("News description is printed in the News4Description.txt file");
		Thread.sleep(3000);
		SoftAssert softassert = new SoftAssert();

		softassert.assertEquals(newspage.verifyAssociateDetailsPopupOnHover(), true,
				"Associate Details popup is not displayed-TestCase Failed");
		if (newspage.verifyAssociateDetailsPopupOnHover() == true) {
			logger.info("Associate details are displayed in popup when hovered");
		}
		softassert.assertEquals(newspage.verifyShareOptionAndPrintShareOptions(), true,
				"Share option is not displayed-TestCase Failed");
		if (newspage.verifyShareOptionAndPrintShareOptions() == true) {
			logger.info("Share option is displayed and printed all the options displayed in share options");
		}
		Thread.sleep(5000);
		newspage.scrollPageToViewLikesAndComments();
		Thread.sleep(4000);
		softassert.assertEquals(newspage.txt_likes_element.isDisplayed(), true, "Likes are Not displayed-Test Failed");
		softassert.assertEquals(newspage.txt_views_element.isDisplayed(), true, "Views are Not displayed-Test Failed");
		System.out.println(newspage.likesOfNews());
		System.out.println(newspage.viewsOfNews());

		if (newspage.txt_likes_element.isDisplayed() == true && newspage.txt_views_element.isDisplayed() == true) {
			logger.info("Number of Likes and Views are printed");
		}

		softassert.assertEquals(newspage.verifyHyperlinksNews(), true,
				"Hyperlinks are not displayed-Test Method-Failed");
		if(newspage.verifyHyperlinksNews()==true) {
			logger.info("Hyperlinks are displayed");
		}
		softassert.assertAll();

		driver.get("https://cognizantonline.sharepoint.com/sites/Be.Cognizant/SitePages/Home.aspx");

	}

	@Test(priority = 7)
	public void validateNewsSlide5() throws InterruptedException, IOException {

		homepage = new HomePage(driver, wait);
		newspage = new NewsPage(driver, wait);
		Thread.sleep(8000);
		homepage.clickOnNewsslide5();
		logger.info("Clicked on News Slide-5");
		newspage.printNews5Description();
		logger.info("News description is printed in the News5Description.txt file");
		Thread.sleep(3000);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(newspage.verifyShareOptionAndPrintShareOptions(), true,
				"Share option is not displayed-TestCase Failed");
		if (newspage.verifyShareOptionAndPrintShareOptions() == true) {
			logger.info("Share option is displayed and printed all the options displayed in share options");
		}
		
		Thread.sleep(3000);
		System.out.println(newspage.likesOfNews());
		System.out.println(newspage.viewsOfNews());
		softassert.assertEquals(newspage.verifyHyperlinksNews(), true,
				"Hyperlinks are not displayed-Test Method-Failed");
		if(newspage.verifyHyperlinksNews()==true) {
			logger.info("Hyperlinks are displayed");
		}
		softassert.assertAll();

	}

}
