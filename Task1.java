package RealTime;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task1 
{
	WebDriver driver;
	String name = "vqiam";
	@BeforeTest
	public void setup()
	{
		
		System.setProperty("webdriver.chrome.driver", "/Users/bharathreddymosarla/Selenium_Java/Browsers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://dotnetfiddle.net/");
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test() throws Exception
	{
	
		char firstchar = name.toUpperCase().charAt(0);  // stores the first letter of name variable value

		switch(firstchar) 
		{
			case 'A' : case 'B' : case 'C' : case 'D' : case 'E' : case 'F' : case 'G' : case 'H' :
				
				WebElement pkgname= driver.findElement(By.xpath("//*[@class='nuget-packages']//following::input[@type='search']"));
				pkgname.sendKeys("nunit"+Keys.ENTER);
				
				WebElement name =driver.findElement(By.xpath("//*[@id='menu']/li[@class='ui-menu-item']/a[@package-id='NUnit']"));
				name.click();
				
				WebElement version = driver.findElement(By.xpath("//*[@id=\"menu\"]/li[1]/ul/li[13]/a"));
				version.click();				
				
				WebElement selectpkg = driver.findElement(By.xpath("//*[@class='package-name']"));
				System.out.println(selectpkg.getText());  // print selected package name
				
				break;
			case 'I' : case 'J' : case 'K' : case 'L' : case 'M' :	case 'N' :
				
				WebElement sharebtn = driver.findElement(By.id("Share"));
				sharebtn.click();
				
				WebElement path = driver.findElement(By.id("ShareLink"));
				path.click();
				
				String link=path.getAttribute("value");
				

				if(link.contains("https://dotnetfiddle.net/"))    // checking given link text is in a share link field
				{
					System.out.println("given linktext contains provided link");
				}
				else
				{
					System.out.println(" given linktext Not contains provided link");
				}
				
				break;
			case 'O' : case 'P' : case 'Q' : case 'R' : case 'S' : case 'T' :
				
				WebElement savebtn = driver.findElement(By.id("save-button"));
				savebtn.click();
				
				Thread.sleep(3000);
				
				Assert.assertEquals(true,driver.findElement(By.xpath("//*[@id='login-modal-label']")).isDisplayed());  // checking login screen is displayed or not
				
				break;
			case 'U' : case 'V' : case 'W' : case 'X' : case 'Y' : case 'Z' :
				
				WebElement start = driver.findElement(By.xpath("//*[@id=\"top-navbar\"]/div[2]/div[2]/div[5]/a"));
				start.click();
				
				Assert.assertEquals(true, driver.getCurrentUrl().contains("GettingStarted")); // verifying getting started page
				break;
			 
			default:
				System.out.println("name should start with alaphabet only");
		
		}
	
	}
	@AfterTest
	public void terminate()
	{
		driver.close();
	}

}
