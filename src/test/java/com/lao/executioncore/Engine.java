package com.lao.executioncore;


import java.lang.reflect.Method;

import org.openqa.selenium.By;

import com.lao.actionkeywords.ActionKeywords;
import com.lao.constants.Constants;
import com.lao.utilities.ExcelUtilities;
import com.lao.utilities.Locators;

public class Engine {
	ActionKeywords actionkeywords;
	Method[] methods;
    public static By locators;
    
	public Engine() {
           actionkeywords = new ActionKeywords();
           methods = actionkeywords.getClass().getMethods();
	}
	
	public void executekeywords() throws Exception {
		  for (int i = 0; i < methods.length; i++) {
		if(methods[i].getName().equalsIgnoreCase(ExcelUtilities.keywordcolumnvalue)) {
			   methods[i].invoke(actionkeywords);
			   break;
		}
	}
}
	
	public void findWebelementsToBeUsed() {
		
		switch (ExcelUtilities.locatorname) {
		case Constants.ID:
		    locators = Locators.getId(ExcelUtilities.locatorvalue);	
		    break;
		case Constants.NAME:
			locators = Locators.getName(ExcelUtilities.locatorvalue);
			break;
		case Constants.XPATH:
			locators = Locators.getXpath(ExcelUtilities.locatorvalue);
			break;
		case Constants.LINK_TEXT:
			locators = Locators.getLinkText(ExcelUtilities.locatorvalue);
			break;
		case Constants.PARTIAL_LINK_TEXT :
			locators = Locators.getPartialLinkText(ExcelUtilities.locatorvalue);	
			break;
		case Constants.TAGNAME:
			locators = Locators.getTagName(ExcelUtilities.locatorvalue);	
			break;
		case Constants.SELECTOR:
			locators = Locators.getCssSelector(ExcelUtilities.locatorvalue);	
			break;
		case Constants.CLASS_NAME:
			locators = Locators.getclassName(ExcelUtilities.locatorvalue);	
			break;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		 ExcelUtilities utilities = new ExcelUtilities();
		 utilities.readExcelFile(Constants.EXCEL_LOCATION);
		 
		 Engine engine = new Engine();

		 
		 
		 for (int row = 1; row <= ExcelUtilities.totalRows; row++) {
			 
            utilities.getValuesFromExcel(row, Constants.LOCATOR_COLUMN, Constants.KEYWORD_COLUMN, Constants.DATA_COLUMN);
            
		    engine.findWebelementsToBeUsed();
		    
			engine.executekeywords();
		}
	}

}
