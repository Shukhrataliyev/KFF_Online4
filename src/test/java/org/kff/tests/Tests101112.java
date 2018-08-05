package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Tests101112 extends TestBase {
	CalculatorPage calculatorPage= new CalculatorPage(driver);
	HomePage homePage = new HomePage(driver);
	
	@Test
	public void testCase10(){

		
		homePage.goToCalculatorPage(driver);
		
		calculatorPage = new CalculatorPage(driver);
		assertEquals(calculatorPage.noteText.getText(), "Note: This calculator has been updated with premiums for 2018 plans.");
		
		//check about this tool plus button works properly
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
		assertEquals(calculatorPage.faqPlus.getAttribute("class"),"plus-btn active" );
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.faqParagraph.getCssValue("display"), "block");
		
		calculatorPage.faqPlus.click();
		assertEquals(calculatorPage.faqPlus.getAttribute("class"),"plus-btn" );
		BrowserUtils.waitFor(1);
		assertEquals(calculatorPage.faqParagraph.getCssValue("display"), "none");
		
		
		
	}
	
	@Test
	public void testCase11(){
		homePage.goToCalculatorPage(driver);
		
		calculatorPage = new CalculatorPage(driver);
		assertEquals(calculatorPage.noteText.getText(), "Note: This calculator has been updated with premiums for 2018 plans.");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		
		assertTrue(calculatorPage.householdText.isDisplayed());
		calculatorPage.incomeBox.sendKeys("-10000");
		calculatorPage.submitBtn.click();
		BrowserUtils.waitFor(1);
		if(calculatorPage.results.isDisplayed()){
			assertTrue(false, "result page shown no error message appearead");
		}else{
			 assertEquals(calculatorPage.message.getText(), 
					"Please enter a positive value. Your income should be more than $1 ");
		}
		
		
		
		
	}
	
	@Test
	public void testCase12(){
		homePage.goToCalculatorPage(driver);
		calculatorPage = new CalculatorPage(driver);
		assertEquals(calculatorPage.header.getText(), "Financial Help for Health Insurance Coverage through Marketplaces");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		assertEquals(calculatorPage.householdText.getText(), "Enter your yearly household income (dollars)");
		assertEquals(calculatorPage.incomeBox.getAttribute("value"), "");
		assertEquals(calculatorPage.incomeText.getText(), "Enter income as" );
		Select slc= new Select(calculatorPage.incomeDropDown); 
		assertEquals(slc.getFirstSelectedOption().getText(), "2018 Dollars" );
		List<WebElement> options= slc.getOptions();
		List<String> lst= new ArrayList<>(); 
		lst.add("2018 Dollars");
		lst.add("% of Poverty");
		for (WebElement option : options) {
			assertTrue(lst.contains(option.getText()));
		}
		
		slc.selectByVisibleText("% of Poverty");
		assertEquals(slc.getFirstSelectedOption().getText(), "% of Poverty" );
		
	//	assertEquals(slc.getAllSelectedOptions(), );
		
		
	}
	
}
