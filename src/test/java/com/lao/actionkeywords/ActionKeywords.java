package com.lao.actionkeywords;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.lao.constants.Constants;
import com.lao.executioncore.Engine;
import com.lao.utilities.ExcelUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionKeywords {
	
	
	      static WebDriver driver;
	public static void openBrowser() {
	 switch (ExcelUtilities.datacolumnvalue) {
		case Constants.CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
			break;
		case Constants.EDGE:
			WebDriverManager.edgedriver().setup(); 
			driver = new EdgeDriver();
		    driver.manage().window().maximize();
			break;
		case Constants.SAFARI:
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		    driver.manage().window().maximize();
			break;	
		case Constants.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		    driver.manage().window().maximize();
			break;	
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		    driver.manage().window().maximize();
			break;
		}
    }
	
	public static void goToUrl() {
		  driver.get(ExcelUtilities.datacolumnvalue);
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
	}
	
	public static void enterUsername() {
		 WebElement username = driver.findElement(Engine.locators);
		 username.sendKeys(ExcelUtilities.datacolumnvalue);
	}
	
	public static void enterPassword() {
		 WebElement password = driver.findElement(Engine.locators);
		  password.sendKeys(ExcelUtilities.datacolumnvalue);
	}
	public static void clickLogin() {
		 WebElement login = driver.findElement(Engine.locators);
	     login.click();
	}
	
	public static void clickDirectory() {
		 WebElement directory = driver.findElement(Engine.locators);
		 directory.click();
	}
	
	public static void selectQALead() {
		 Select selectQA = new Select(driver.findElement(Engine.locators));
		 selectQA.selectByVisibleText(ExcelUtilities.datacolumnvalue);
	}
	
	public static void clickSearch() {
		 WebElement search = driver.findElement(Engine.locators);
		 search.click();
	}
	public static void quitBrowser() {
	     driver.quit();
	}
	
}
