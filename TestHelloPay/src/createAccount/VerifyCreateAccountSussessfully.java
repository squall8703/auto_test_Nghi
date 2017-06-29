package createAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCreateAccountSussessfully {
  @Test
  public void Test1() 
  {
	  	String email = "fedcba131@yahoo.com";
	  	String first_name = "Nghi";
	    System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lazada.vn/customer/account/create");
		
		driver.findElement(By.xpath("//input[@value='male'][@name='RegistrationForm[gender]']")).click();
		
		driver.findElement(By.id("RegistrationForm_email")).sendKeys(email);
		
		driver.findElement(By.id("RegistrationForm_first_name")).sendKeys(first_name);
		
		WebElement day = driver.findElement(By.id("RegistrationForm_day"));
		Select day_dd = new Select(day);
		day_dd.selectByValue("01");
		
		WebElement month = driver.findElement(By.id("RegistrationForm_month"));
		Select month_dd = new Select(month);
		month_dd.selectByValue("01");
		
		WebElement year = driver.findElement(By.id("RegistrationForm_year"));
		Select year_dd = new Select(year);
		year_dd.selectByValue("1987");
		
		driver.findElement(By.id("RegistrationForm_password")).sendKeys("Nghi@password123");
		
		driver.findElement(By.id("RegistrationForm_password2")).sendKeys("Nghi@password123");
		
		driver.findElement(By.id("send")).click();
		
		String actual_title = driver.getTitle(); 
		Assert.assertEquals(actual_title, "Lazada - My account");
		
		String actual_name = driver.findElement(By.xpath("//span[@class='dropdown__toggle-text_style_ellipsis']")).getText();
		Assert.assertEquals(actual_name, first_name.toUpperCase());
		
		driver.quit();
  }
  
  @Test
  public void Test2() 
  {
	  	String search_term = "test";
	  	System.setProperty("webdriver.chrome.driver", "D:/Selenium/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.lazada.vn");
		
		driver.findElement(By.xpath("//input[@name='q'][@type='search']")).sendKeys(search_term);
		driver.findElement(By.xpath("//button[@data-qa-locator='header-search-button']")).click();
		
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_url, "http://www.lazada.vn/catalog/?q=" + search_term );
		
		String actual_text = driver.findElement(By.xpath("//h1[@class='c-catalog-title__title']")).getText();
		Assert.assertEquals(actual_text, "Kết quả tìm kiếm của \"" + search_term + "\"");	
		
		driver.quit();
  }
}
