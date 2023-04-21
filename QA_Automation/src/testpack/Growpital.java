package testpack;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		
		
		//This will wait for 5 sec and click on email button
		
		explicitWait(driver,5,"//input[@type='email']");
		
		//This will wait for 5 sec and click on emailInput section
		
		WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
		
		//once we've are on email Input I've entered the values
		
		emailInput.sendKeys("neilrajurkar95@gmail.com");
		
		//after finding element below code will help to enter password 
		
		WebElement passInput = driver.findElement(By.className("password-input"));
		
		passInput.sendKeys("Liverpool@01");
		
		//Below code will help to click on Login
		
		WebElement login = driver.findElement(By.xpath("//div[text()='Login']"));
		
		login.click();
		
		//Below code is to show we can also use Delay (Thread.sleep) and Clicked on svg element to bring View profile 
		Thread.sleep(10000);
		
		WebElement navDropDown = driver.findElement(By.xpath("(//*[local-name()='svg'])[3]"));
		
		navDropDown.click();
		
		//Below is the code to click on View Profile Option
		WebElement viewProfile = driver.findElement(By.xpath("//a[@class='popup-content']"));
		
		viewProfile.click();
		
		//Below is the code to make sure we are on a Personal Information Section
		
		WebElement personalInfo = driver.findElement(By.xpath("//div[@class='form-card-title']"));
		
		String text = personalInfo.getText();
		
		boolean verifySectionofPerosanalInfo = text.equalsIgnoreCase("Personal Information");
		
		System.out.println(text + " " + verifySectionofPerosanalInfo);
		
		//Below is the code to update PAN and to Close the same
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,200)");
		
		explicitWait(driver, 10, "(//div[@class='exclamation-icon-wrapper'])[1]");
		
		WebElement panbutton = driver.findElement(By.xpath("//input[@placeholder='Enter you PAN Card Number']"));
		
		panbutton.sendKeys("CACKPR0128R");
		
		driver.findElement(By.xpath("(//button[@class='custom-button '])[3]")).click();
		
		Thread.sleep(2000);
		
		//Since Getting error while submitting pan I've closed the pop-ups so that script can run further
		
		WebElement closepopup = driver.findElement(By.xpath("(//*[local-name()='svg'])[5]"));
		
		closepopup.click();
		
		
		closepopup = driver.findElement(By.xpath("(//*[local-name()='svg'])[4]"));
		
		closepopup.click();
		
		
		//below is the code to wait for 5 sec and then click on Upload Documents tab
		
		explicitWait(driver,5,"(//button[@class='custom-button unVerified'])[3]");
		
		//Below is the code to make sure we are on a Upload Your Document Section
		WebElement uploadDocSection = driver.findElement(By.xpath("(//div[@class='form-card-title'])[1]"));
		
		String text2 = uploadDocSection.getText();
		
		boolean verifyUploadDocSection = text2.equalsIgnoreCase("Upload your documents");
		
		System.out.println(text2 + " " +verifyUploadDocSection);
		
		//this code will help to close the browser
		driver.quit();
		
	}

}
