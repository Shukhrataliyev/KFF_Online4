package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Menu;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class Test789 extends TestBase {
	
	HomePage homePage = new HomePage(driver);
	StateDataPage newUpdatedInd = new StateDataPage(driver);
	
	@Test
	public void Test7() {
		
		homePage.menu.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
		homePage.statHealthFacts.click();
		homePage.statHealthFactsSub.click();
		
		homePage.statHealthFacts.click();
		homePage.statHealthFactsSub.click();

		StateDataPage stateDataPage = new StateDataPage(driver);
		extentLogger.info("verifying 'Search State Health Facts:' is displayed");
		assertTrue(stateDataPage.SSHF.isDisplayed());
		assertEquals(newUpdatedInd, "NEW & UPDATED INDICATORS");
		
		stateDataPage.section1115.click();
		
		
		
	}
	
//	@Test
//	public void Test8() {
//		
//	}
//	
//	@Test
//	public void Test9() {
//		
//	}

}
