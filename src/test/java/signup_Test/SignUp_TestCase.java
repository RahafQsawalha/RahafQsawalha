package signup_Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SignUp_TestCase {
	WebDriver rahafdriver;
	 @Test(dataProvider="test_data")
	  public void First_testCase(String first_name ,String last_name, String phone ,String Email,String Password ) {

		 rahafdriver.findElement(By.linkText("Signup")).click();
		  rahafdriver.findElement(By.cssSelector(" div:nth-child(2) > div > input")).sendKeys(first_name);
		  rahafdriver.findElement(By.cssSelector(" div:nth-child(3) > div > input")).sendKeys(last_name);
		  rahafdriver.findElement(By.cssSelector(" div:nth-child(4) > div > input")).sendKeys(phone);
		  rahafdriver.findElement(By.cssSelector(" div:nth-child(5) > div > input")).sendKeys(Email);
		  rahafdriver.findElement(By.cssSelector(" div:nth-child(6) > div > input")).sendKeys(Password);
		  
		  WebElement submit_btn=rahafdriver.findElement(By.cssSelector(" div.form-group.mt-3 > button > span.ladda-label"));
		  JavascriptExecutor java=(JavascriptExecutor)rahafdriver;
		java.executeScript("arguments[0].click()", submit_btn);
		  //java.executeScript("scroll(0,250)");
		  submit_btn.click();
		  //rahafdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		 // Actions act=new Actions(rahafdriver);
		 // act.moveToElement(rahafdriver.findElement(By.cssSelector(" div.form-group.mt-3 > button"))).click().build().perform();
		  //Thread.sleep(2000);
		// WebDriverWait wait=new WebDriverWait (rahafdriver,20);
		// WebElement signup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[7]/button/span[1]")));
		//signup.click();
		 //submit_btn.click();

		
		  
	  }
	
	@BeforeTest
  public void Open_Browser() {
	  System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver.exe");
	  rahafdriver= new ChromeDriver();
 rahafdriver.get("https://www.phptravels.net/");
 //rahafdriver.manage().window().fullscreen();

	 // rahafdriver.get("https://devwcs.frontgate.com/");
	
	  
  }
	
	@DataProvider 
	public String[][] test_data() throws InvalidFormatException, IOException{
		Excelsheet obj = new Excelsheet();
		return obj.ReadSheet();
	}
	}
  
 
