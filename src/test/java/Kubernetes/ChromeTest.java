package Kubernetes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ChromeTest
{
	public static RemoteWebDriver driver;

	@BeforeSuite
	public static void setUp() throws Exception {

		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setPlatform(Platform.LINUX);
		driver = new RemoteWebDriver(new URL("http://192.168.99.100:30001/wd/hub"),dc);

	}

	@Test
	public void chrome() throws MalformedURLException
	{
		String baseUrl = "https://b2bui2.tltid.com/login";
		String expectedTitle = "Login";
		driver.get(baseUrl);
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		if (actualTitle.contentEquals(expectedTitle))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test Failed");

		}}
	@Test
	public void loginbutton() throws InterruptedException
	{
		WebDriverWait wait =new WebDriverWait(driver,100);
		Thread.sleep(10);
		WebElement Element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		String b = Element.getText();
		System.out.println(b);
		Element.click();
		if(b.contentEquals("Login"))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test passed");
		}
	}

	@Test
	public void password() throws IOException
	{
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
		username.click();
		System.out.println("username field clicked");
		username.sendKeys("a.pandian@wintlt.com");
		System.out.println("Username field entered");
		WebElement password =driver.findElement(By.xpath("//input[@type='password']"));
		password.click();
		System.out.println("password field clicked");
		password.sendKeys("12345S#");
		System.out.println("password field entered");
		WebElement button = driver.findElement(By.xpath("//button[@type='submit']"));
		JavascriptExecutor js = driver;
		js.executeScript("arguments[0].click();", button);
	}
	@Test
	public void password1() throws IOException, InterruptedException
	{
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 100);
		Thread.sleep(30000);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[2]"))).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("YVR");
	}

	@Test
	public void tofield() throws IOException
	{
		System.out.println("driver="+driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='text'])[3]"))).click();
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("YYZ");
	}

	@AfterSuite
	public void close() throws InterruptedException
	{
		driver.close();
		System.out.println("browser closed");





	}
}
