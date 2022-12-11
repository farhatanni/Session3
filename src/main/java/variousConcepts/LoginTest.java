package variousConcepts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginTest {
	WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.techfios.com/billing/?ng=login/\r\n");
		
	}

	@Test
	public void loginTest() {
		//Storing by WebElement
		WebElement userNameElement=driver.findElement(By.id("username"));
		WebElement passwordElement=driver.findElement(By.id("password"));
		WebElement loginElement=driver.findElement(By.name("login"));
		
		
		//Storing webElement with By class
		By userNameLocator=By.id("username");
		By passwordLocator=By.id("password");
		By loginLocator=By.id("login");
		By dashboardLocator=By.xpath("//h2[text()=' Dashboard ']");
		
		userNameElement.sendKeys("demo@techfios.com");
		passwordElement.sendKeys("abc1234");
		loginElement.click();
		
//		WebDriverWait wait=new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardLocator));
		boolean status;
		try {
			WebElement dashboardElement=driver.findElement(By.xpath("//h2[text()=' Dashboard ']"));
			status=true;
		}catch(Exception e) {
			e.printStackTrace();
			status=false;
		}
		
		
		
		Assert.assertTrue("wrong page",status);

	}
//	public void  tearDown() {
//		driver.close();
//		driver.quit();
//	}


}
