package pageObjects;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {

	WebDriver driver;
	WebDriverWait wait;

	public NewsPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	// WebElements...

	@FindBy(xpath = "//article//p")
	List<WebElement> txt_newsDescription;

	@FindBy(xpath = "//article//p|//article//h3")
	List<WebElement> txt_news2Description_element;

	@FindBy(xpath = "//article//p|//article//h3")
	List<WebElement> txt_news3Description_element;

	@FindBy(xpath = "//article//p")
	List<WebElement> txt_news4Description_element;

	@FindBy(xpath = "//article//p|//article//h3")
	List<WebElement> txt_news5Description_element;

	@FindBy(css = "button[name='Share']")
	WebElement btn_share_element;

	@FindBy(xpath = "//li[@role='presentation']")
	List<WebElement> txt_Shareoptions_element;

	@FindBy(className = "jg_z_9f38462c")
	WebElement txt_associateDetails_element;

	@FindBy(className = "jg_z_9f38462c")
	WebElement txt_associateDetailsBeforeHover_element;

	@FindBy(className = "_4AL1R")
	WebElement txt_associateDetailsAfterHover_element;

	@FindBy(css = "button[name='Share']")
	WebElement btn_shareOption_element;

	@FindBy(xpath = "//li[@role='presentation']")
	List<WebElement> btn_shareOptions_elements;

	@FindBy(xpath = "//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[1]/button/span/span")
	public WebElement txt_likes_element;

	@FindBy(xpath = "//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[4]/button/span/span")
	public WebElement txt_views_element;


	@FindBy(xpath = "//span//u")
	List<WebElement> txt_hyperlinksNews3_element;

	@FindBy(xpath = "//p//a")
	List<WebElement> txt_hyperlinks_element;

	// Print the News Slide-1 Description in text File....
	public void printNews1Description() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String filepath = ".\\News Description\\" + timeStamp + "News1Description.txt";
		FileWriter file = new FileWriter(filepath);
		for (WebElement str : txt_newsDescription) {
			file.write(str.getText() + System.lineSeparator());
		}
		file.close();
	}

	// Print the News Slide-2 Description in text File....
	public void printNews2Description() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String filepath = ".\\News Description\\" + timeStamp + "News2Description.txt";
		FileWriter file = new FileWriter(filepath);
		for (WebElement str : txt_news2Description_element) {
			file.write(str.getText() + System.lineSeparator());
		}

		file.close();
	}

	// Print the News Slide-3 Description in text File....
	public void printNews3Description() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String filepath = ".\\News Description\\" + timeStamp + "News3Description.txt";
		FileWriter file = new FileWriter(filepath);
		for (WebElement str : txt_news3Description_element) {
			file.write(str.getText() + System.lineSeparator());
		}
		file.close();
	}

	// Print the News Slide-4 Description in text File....
	public void printNews4Description() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String filepath = ".\\News Description\\" + timeStamp + "News4Description.txt";
		FileWriter file = new FileWriter(filepath);
		for (WebElement str : txt_news4Description_element) {
			file.write(str.getText() + System.lineSeparator());
		}
		file.close();
	}

	// Print the News Slide-5 Description in text File....
	public void printNews5Description() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String filepath = ".\\News Description\\" + timeStamp + "News5Description.txt";
		FileWriter file = new FileWriter(filepath);
		for (WebElement str : txt_news5Description_element) {
			file.write(str.getText() + System.lineSeparator());
		}
		file.close();
	}

	// Verify the Share Option button is displayed and print the share option on
	// clicking the Share Button
	public void verifyShareOptionAndPrint() {
		btn_share_element.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		for (WebElement options : txt_Shareoptions_element) {
			System.out.println(options.getText());
		}

	}

	// Verify the Associate details are displayed when hovered on it
	public boolean verifyAssociateDetailsPopupOnHover() throws InterruptedException {
		boolean check = false;
		Actions action = new Actions(driver);
		Thread.sleep(5000);
		action.moveToElement(txt_associateDetails_element).build().perform();
		Thread.sleep(7000);
		String txt_asscociateDetailsBeforeHover = txt_associateDetailsBeforeHover_element.getText();
		String txt_asscociateDetailsAfterHover = txt_associateDetailsAfterHover_element.getText();
		if (txt_asscociateDetailsBeforeHover.equalsIgnoreCase(txt_asscociateDetailsAfterHover)) {
			check = true;
		}
		return check;

	}

	// Verify Share button is displayed and Print the Share Options
	public boolean verifyShareOptionAndPrintShareOptions() throws InterruptedException {
		boolean check = btn_shareOption_element.isDisplayed();
		btn_shareOption_element.click();
		Thread.sleep(5000);
		System.out.println("Share button is present");
		for (WebElement options : btn_shareOptions_elements) {
			System.out.println(options.getText());
		}
		return check;
	}

	// Scroll the page to view the Likes and Comments in the news page
	public void scrollPageToViewLikesAndComments() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 7000; i += 1000) {
			js.executeScript(
					"document.querySelector(\"div[data-automation-id='contentScrollRegion'\").scrollTop=" + i + " ");
		}
	}

	/* Verify Hyperlinks are displayed in the news page-1
	public boolean verifyHyperlinksNews3() {
		boolean check = false;
		for (WebElement hyperlinks : txt_hyperlinksNews3_element) {
			check = hyperlinks.isDisplayed();
		}
		return check;
	}*/

	// Verify Hyperlinks are displayed in the news pages
	public boolean verifyHyperlinksNews() {
		boolean check = false;
		for (WebElement hyperlinks : txt_hyperlinks_element) {
			check = hyperlinks.isDisplayed();
		}
		return check;
	}

	// Print the number of Likes in the News
	public String likesOfNews() {
		return txt_likes_element.getText();
	}

	// Print the number of Views in the News
	public String viewsOfNews() {
		return txt_views_element.getText();
	}

}
