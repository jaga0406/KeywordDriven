package com.lao.test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase01 {

	public static void main(String[] args) {
		 
		
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\git\\repository2\\jaga_selenium\\browser drivers\\chromedriver_win32\\chromedriver.exe");
      
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/validateCredentials");
	  
	  WebElement username = driver.findElement(By.id("txtUsername"));
	  username.sendKeys("Admin");
	  
	  WebElement password = driver.findElement(By.id("txtPassword"));
	  password.sendKeys("admin123");
	  
	  WebElement login = driver.findElement(By.id("btnLogin"));
      login.click();
	  
	}

}
