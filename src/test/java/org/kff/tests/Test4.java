package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test4 extends TestBase {
	CalculatorPage calculatorPage= new CalculatorPage(driver);
	HomePage homePage = new HomePage(driver);
	
	@Test(priority = 10)
	public void Test10(){
		extentLogger = report.createTest("Checking + sign visibility");
	
		homePage.goToCalculatorPage(driver);
		
		calculatorPage = new CalculatorPage(driver);
		extentLogger.info("verifying header");
		assertEquals(calculatorPage.noteText.getText(), "Note: This calculator has been updated with premiums for 2018 plans.");
		
		//check about this tool plus button works properly
		extentLogger.info("verifying about this tool + sign ");
		assertEquals(calculatorPage.aboutPlus.getAttribute("class"),"plus-btn active" );
		calculatorPage.aboutPlus.click();
		assertEquals(calculatorPage.aboutPlus.getAttribute("class"),"plus-btn" );
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.aboutParagraph.getCssValue("display"), "none");
		
		calculatorPage.aboutPlus.click();
		assertEquals(calculatorPage.aboutPlus.getAttribute("class"),"plus-btn active" );
		
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.aboutParagraph.getCssValue("display"), "block");
		
		
		//check frequently asked questions work properly
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		
		calculatorPage.faqPlus.click();
		extentLogger.info("verifying FAQ + sign ");
		assertEquals(calculatorPage.faqPlus.getAttribute("class"),"plus-btn active" );
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.faqParagraph.getCssValue("display"), "block");
		
		calculatorPage.faqPlus.click();
		assertEquals(calculatorPage.faqPlus.getAttribute("class"),"plus-btn" );
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.faqParagraph.getCssValue("display"), "none");
		
		
		
	}
	
	@Test(priority = 11)
	public void Test11(){
		extentLogger = report.createTest("Checking item accepts negative value");
		homePage.goToCalculatorPage(driver);
		
		calculatorPage = new CalculatorPage(driver);
		extentLogger.info("verifying 2018 calculator + sign ");
		assertEquals(calculatorPage.noteText.getText(), "Note: This calculator has been updated with premiums for 2018 plans.");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		extentLogger.info("verifying header");
		assertTrue(calculatorPage.householdText.isDisplayed());
		calculatorPage.incomeBox.sendKeys("-10000");
		extentLogger.info("verifying error message appeared when we enter negative value sign ");
		calculatorPage.submitBtn.click();
		BrowserUtils.waitFor(1);
		
		if(calculatorPage.results.isDisplayed()){
			assertTrue(false, "result page shown no error message appearead");
		}else{
			 assertEquals(calculatorPage.message.getText(), 
					"Please enter a positive value. Your income should be more than $1 ");
		}
	
		
	}
	
	@Test(priority = 12)
	public void Test12(){
		extentLogger = report.createTest("Checking item accepts negative value");
		homePage.goToCalculatorPage(driver);
		calculatorPage = new CalculatorPage(driver);
		extentLogger.info("verifying header");
		assertEquals(calculatorPage.header.getText(), "Financial Help for Health Insurance Coverage through Marketplaces");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		extentLogger.info("verifying income fields");
		assertEquals(calculatorPage.householdText.getText(), "Enter your yearly household income (dollars)");
		assertEquals(calculatorPage.incomeBox.getAttribute("value"), "");
		assertEquals(calculatorPage.incomeText.getText(), "Enter income as" );
		Select slc= new Select(calculatorPage.incomeDropDown); 
		assertEquals(slc.getFirstSelectedOption().getText(), "2018 Dollars" );
		List<WebElement> options= slc.getOptions();
		List<String> lst= new ArrayList<>(); 
		lst.add("2018 Dollars");
		lst.add("% of Poverty");
		extentLogger.info("verifying income dropdown options");
		for (WebElement option : options) {
			assertTrue(lst.contains(option.getText()));
		}
		
		slc.selectByVisibleText("% of Poverty");
		assertEquals(slc.getFirstSelectedOption().getText(), "% of Poverty" );
		
	//	assertEquals(slc.getAllSelectedOptions(), );
		
		
	}
	
	@Test(priority = 13)
	public void Test13(){
		extentLogger = report.createTest("Checking item accepts negative value");
		homePage.goToCalculatorPage(driver);
		calculatorPage = new CalculatorPage(driver);
		assertEquals(calculatorPage.header.getText(), "Financial Help for Health Insurance Coverage through Marketplaces");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		extentLogger.info("verifying all fields are visible");
		for (WebElement each : calculatorPage.listCalculatorOptons) {
			if (each.isDisplayed()) {
				assertTrue(each.isDisplayed());
			}
		}
		
		Map <String, String> expectedMap= new HashMap(); 
		
		expectedMap.put("state", "US Avarage"); 
		expectedMap.put("incomeas", "2018 Dollars");
		expectedMap.put("annual income", "");
		expectedMap.put("covarage", "No");
		expectedMap.put("numberOfPeople", "1");
		expectedMap.put("numberOfadults", "No Adults");
		expectedMap.put("numberOfChilderen", "No Childeren");
		
		Map <String, String> actualMap= new HashMap(); 
		
		actualMap.put("state", calculatorPage.getFirstDropDown(calculatorPage.stateDropDown)); 
		actualMap.put("incomeas", calculatorPage.getFirstDropDown(calculatorPage.incomeDropDown));
		actualMap.put("annual income", calculatorPage.houseHold.getAttribute("value"));
		actualMap.put("covarage", calculatorPage.getFirstDropDown(calculatorPage.coverageDropDown));
		actualMap.put("numberOfPeople", calculatorPage.getFirstDropDown(calculatorPage.numberOfPeopleDropDown));
		actualMap.put("numberOfadults", calculatorPage.getFirstDropDown(calculatorPage.adultDropDown));
		actualMap.put("numberOfChilderen", calculatorPage.getFirstDropDown(calculatorPage.childDropDown));
		
		extentLogger.info("verifying all defaults values");
		for(Entry<String, String> each: expectedMap.entrySet()){
			assertEquals(actualMap.get(each), expectedMap.get(each));
			
			}
		
		
	
	
}
	
}
