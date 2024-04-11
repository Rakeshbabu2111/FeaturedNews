package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	// WebElements...

	@FindBy(xpath = "//*[@id='O365_MainLink_MePhoto']/div/div/div/div/div[2]")
	WebElement btn_user_element;

	@FindBy(xpath = "//div[@id='mectrl_currentAccount_primary']")
	public WebElement txt_username_element;

	@FindBy(xpath = "//div[@id='mectrl_currentAccount_secondary']")
	public WebElement txt_email_element;

	@FindBy(xpath = "//a[@id='news_text_title']")
	List<WebElement> txt_newsSlides_element;
	
	@FindBy(xpath="//*[@id='news_text_title']")
	List<WebElement> txt_news_element;
	

	// Click on the User Information button
	public void clickuserInfo() throws InterruptedException {
		Thread.sleep(5000);
		btn_user_element.click();
		Thread.sleep(3000);
	}
    
	//check the news are displayed are not
	public boolean verifyNewsPagesDisplayed() {
		boolean check=false;
		for(WebElement news:txt_news_element) {
			if(news.isDisplayed()) {
				check=true;
			}
			else {
				check=false;
				break;
			}
		}
		return check;
	}

	// Verify Header and tooltip are displayed same
	public boolean verifyHeaderAndTooltip() {
		boolean checkHeaderAndTooltip = false;

		for (WebElement newsslides : txt_newsSlides_element) {

			String header = newsslides.getText();
			String tooltip = newsslides.getAttribute("title");
			if (header.equalsIgnoreCase(tooltip)) {
				checkHeaderAndTooltip = true;
				continue;
			} else {
				checkHeaderAndTooltip = false;
				System.out.println(header + " " + tooltip);
				System.out.println("Tooltip and header are not matching.TestCase Failed");

			}
		}
		return checkHeaderAndTooltip;

	}

	// Click on the News Slide-1
	public void clickOnNewsslide1() {
		txt_newsSlides_element.get(0).click();
	}

	// Click on the News Slide-2
	public void clickOnNewsslide2() {
		txt_newsSlides_element.get(1).click();
	}

	// Click on the News Slide-3
	public void clickOnNewsslide3() {
		txt_newsSlides_element.get(2).click();
	}

	// Click on the News Slide-4
	public void clickOnNewsslide4() {
		txt_newsSlides_element.get(3).click();
	}

	// Click on the News Slide-5
	public void clickOnNewsslide5() {
		txt_newsSlides_element.get(4).click();
	}
	
	//Scroll down the page to view all the News
	public void scrollDownToViewNews() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (int i = 0; i < 10000; i += 1000) {
			js.executeScript(
					"document.querySelector(\"div[data-automation-id='contentScrollRegion'\").scrollTop=" + i + " ");
		}
	}

}
