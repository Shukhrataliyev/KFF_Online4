package org.kff.tests;


import static org.testng.Assert.assertEquals;

import org.kff.pages.HomePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Test2 extends TestBase {
	
	
	HomePage homePage = new HomePage(driver);
	StateDataPage stateDataPage = new StateDataPage(driver);

	
	
	@Test(priority = 4)
	public void Test4() {
		
		extentLogger = report.createTest("Verifying TestCase4 Sort States A->Z and Z->A");
		
		stateDataPage.goToStateHealthFacts(driver);
		stateDataPage = new StateDataPage(driver);
		stateDataPage.topLeftCategoriesHCB.click();
		
		stateDataPage.HCBIndicators.click();
		
		BrowserUtils.waitFor(3);
		extentLogger.info("verifying Alabama (state sort A->Z)");
		assertEquals(stateDataPage.firstStateTable.getText(),"Alabama" );
		
	
		stateDataPage.sortLocation.click();
		
		BrowserUtils.waitFor(3);
		extentLogger.info("verifying Wyoming (state sort Z->A)");
		assertEquals(stateDataPage.sortedStateTable.getText(),"Wyoming" );
		
	}
	
	@Test(priority = 5)
	public void Test5() {
		
		stateDataPage.goToStateHealthFacts(driver);
		StateDataPage stateDataPage = new StateDataPage(driver);
		
		
		
		stateDataPage.topLeftCategoriesDE.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Demographics and the Economy" );
		driver.navigate().back();
		
		
		stateDataPage.topLeftCategoriesHCB.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Health Costs & Budgets" );
		driver.navigate().back();
		
	
		stateDataPage.topLeftCategoriesHCU.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Health Coverage & Uninsured" );
		driver.navigate().back();
	
		stateDataPage.topLeftCategoriesHIMC.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Health Insurance & Managed Care" );
		driver.navigate().back();
		
		stateDataPage.topLeftCategoriesHR.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Health Reform" );
		driver.navigate().back();
		
		stateDataPage.topLeftCategoriesHS.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Health Status" );
		driver.navigate().back();

		stateDataPage.topLeftCategoriesHADS.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"HIV/AIDS" );
		driver.navigate().back();
		
		
		stateDataPage.topLeftCategoriesMC.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Medicaid & CHIP" );
		driver.navigate().back();
		
		
		stateDataPage.topLeftCategoriesM.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Medicare" );
		driver.navigate().back();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		
		stateDataPage.topLeftCategoriesMH.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Minority Health" );
		driver.navigate().back();
	
		
		stateDataPage.topLeftCategoriesPSU.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Providers & Service Use" );
		driver.navigate().back();
	
		
		stateDataPage.topLeftCategoriesWH.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Women's Health" );
		driver.navigate().back();
		
		
//****Select State Alabama after then that opened page links tested...
		
		stateDataPage.selectStateDropDown();
		String selectedStateurl= driver.getCurrentUrl();
		
		stateDataPage.topLeftCategoriesDE.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Alabama: "+"Demographics and the Economy" );
		driver.navigate().to(selectedStateurl);
		
		
		stateDataPage.topLeftCategoriesHCB.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Alabama: "+"Health Costs & Budgets" );
		driver.navigate().to(selectedStateurl);
		
	
		stateDataPage.topLeftCategoriesHCU.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Alabama: "+"Health Coverage & Uninsured" );
		driver.navigate().to(selectedStateurl);
	
		stateDataPage.topLeftCategoriesHIMC.click();
		assertEquals(stateDataPage.nextPageClickedTitle.getText(),"Alabama: "+"Health Insurance & Managed Care" );
		driver.navigate().to(selectedStateurl);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,200)");
		
	}
	
	@Test(priority = 6)
	public void Test6() {
		
		extentLogger = report.createTest("Verifying TestCase6 StateFacts");
		
		stateDataPage.goToStateHealthFacts(driver);
		
		StateDataPage stateDataPage = new StateDataPage(driver);
		
		//1 
		extentLogger.info("verifying title");
		assertEquals(stateDataPage.SHFacts.getAttribute("title"), "State Health Facts");
		
		//2
		extentLogger.info("verifying searchboxtitle");
		assertEquals(stateDataPage.SSHF.getText(), "Search State Health Facts:");
		
		//3
		extentLogger.info("verifying menu Title");
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,100)");
//		assertEquals(stateDataPage.chooseCatLoc.getText(), "Choose Category   - or -   Choose Location");
//		
//		//4
//		extentLogger.info("verifying title again");
//		assertEquals(stateDataPage.SHFacts.getAttribute("title"), "State Health Facts");
		
	}
	
	
		

}
