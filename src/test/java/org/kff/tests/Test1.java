package org.kff.tests;

import org.kff.pages.HomePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.kff.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase {
	
	HomePage homePage = new HomePage(driver);
	StateDataPage stateDataPage = new StateDataPage(driver);
	String actualTitle = "Search | Search Results | Health aid | The Henry J. Kaiser Family Foundation";
	String actualNewTitle = "State Health Facts | The Henry J. Kaiser Family Foundation";
	

	@Test(priority = 1)
	public void Test1() {
		

		extentLogger = report.createTest("Verifying the title");

		BrowserUtils.waitForPageToLoad(3);
		stateDataPage.searchField.sendKeys("Health aid");
		stateDataPage.searchSubmit.click();
		String ecpectedTitle = Driver.getDriver().getTitle();
		
		extentLogger.info("verifying title");
		Assert.assertEquals(actualTitle, ecpectedTitle,"actual and expected does not match");

	}
	
	@Test(priority = 2)
	public void Test2() {
		
		homePage = new HomePage(driver);
		homePage.menu.click();
		BrowserUtils.hover(homePage.statHealthFacts);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		
		homePage.statHealthFacts.click();
		homePage.statHealthFactsSub.click();
		String expectedNewTitle = Driver.getDriver().getTitle();
		//extentLogger = report.createTest("Verifying the title");
		extentLogger.info("verifying title");
		Assert.assertEquals(actualNewTitle, expectedNewTitle, " Titles don't match ");
		
		extentLogger.info("verifying number of links");
		Assert.assertEquals(138,homePage.links.size());
	}
	@Test(priority = 3)
	public void Test3() {
		
		homePage.goToStateData(driver);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,3000)");

		homePage = new HomePage(driver);
		stateDataPage = new StateDataPage(driver);
		
		stateDataPage.demographics.click();
		stateDataPage.totalNumberOfResidents.click();
		String actualState = stateDataPage.states.get(2).getText();
		extentLogger = report.createTest("Verifying the first state");
		extentLogger.info("Verifying the first state");
		Assert.assertEquals(actualState, "Alabama");
		String actualPopualation = stateDataPage.residents.get(2).getText();
		extentLogger.info("Verifying population of the first state");
		Assert.assertEquals(actualPopualation, "4,834,100");
		homePage.goToStateData(driver);
		stateDataPage.healthReform.click();
		
	}
	
	

}
