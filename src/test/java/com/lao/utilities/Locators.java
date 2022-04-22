package com.lao.utilities;

import org.openqa.selenium.By;

public class Locators {

	public static By getId(String locatorvalue) {
	       return	By.id(locatorvalue);
	}
	public static By getName(String locatorvalue) {
		   return	By.name(locatorvalue);
		}
	public static By getXpath(String locatorvalue) {
		   return	By.xpath(locatorvalue);
		}
	public static By getLinkText(String locatorvalue) {
		   return	By.linkText(locatorvalue);
		}
	public static By getPartialLinkText(String locatorvalue) {
		   return	By.partialLinkText(locatorvalue);
		}
	public static By getTagName(String locatorvalue) {
		   return	By.tagName(locatorvalue);
		}
	public static By getCssSelector(String locatorvalue) {
		   return	By.cssSelector(locatorvalue);
		}
	public static By getclassName(String locatorvalue) {
		   return	By.className(locatorvalue);
		}
}
