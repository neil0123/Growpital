package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Growpital {
	
	public static void explicitWait(WebDriver driver, int seconds, String xpathExpression) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression))).click();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.growpital.com/");
		
		driver.manage().window().maximize();
		
		//I've created explicit method to manage synchronization issue however we can also use Thread.sleep
		
		explicitWait(driver,5,"(//a[@href='https://app.growpital.com/login'])[1]");
		
		explicitWait(driver,5,"//input[@type='email']");
		
		WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
		
		emailInput.sendKeys("neilrajurkar95@gmail.com");
		
		WebElement passInput = driver.findElement(By.className("password-input"));
		
		passInput.sendKeys("Liverpool@01");
		
		WebElement login = driver.findElement(By.xpath("//div[text()='Login']"));
		
		login.click();
		
		Thread.sleep(10000);
		
		WebElement navDropDown = driver.findElement(By.xpath("(//*[local-name()='svg'])[3]"));
		
		navDropDown.click();
		
		WebElement viewProfile = driver.findElement(By.xpath("//a[@class='popup-content']"));
		
		viewProfile.click();
		
		//Below is the code to make sure I'm on a Personal Information Section
		
		WebElement personalInfo = driver.findElement(By.xpath("//div[@class='form-card-title']"));
		
		String text = personalInfo.getText();
		
		boolean verifySectionofPerosanalInfo = text.equalsIgnoreCase("Personal Information");
		
		System.out.println(text + " " + verifySectionofPerosanalInfo);
		
		explicitWait(driver,5,"(//button[@class='custom-button unVerified'])[3]");
		
		//Below is the code to make sure I'm on a Upload Your Document Section
		WebElement uploadDocSection = driver.findElement(By.xpath("(//div[@class='form-card-title'])[1]"));
		
		String text2 = uploadDocSection.getText();
		
		boolean verifyUploadDocSection = text2.equalsIgnoreCase("Upload your documents");
		
		System.out.println(text2 + " " +verifyUploadDocSection);
		
		driver.quit();
		
	}

}