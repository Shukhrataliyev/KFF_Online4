package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.kff.pages.PrivateInsurancePage;
import org.kff.pages.StateDataPage;
import org.kff.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class KFFTestCases18_21 extends TestBase {

	HomePage homePage = new HomePage(driver);
	StateDataPage stateDataPage = new StateDataPage(driver);

	@Test(priority = 18) 
	public void TesCase_18(){
		extentLogger = report.createTest("Verifying the munu function");

		extentLogger.info("verifying title");
		assertEquals(driver.getTitle(),
				"Kaiser Family Foundation - Health Policy Research, Analysis, Polling, Facts, Data and Journalism",
				"HomePage is not displayed. Application is down.");
		
		HomePage homePage = new HomePage(driver);
		homePage.menu.click();
		
		BrowserUtils.hover(homePage.privateInsurance);
		homePage.privateInsurance.click();

		PrivateInsurancePage privateInsurance = new PrivateInsurancePage(driver);

		extentLogger.info("Header 'Private insurance' is displayed");
		assertTrue(privateInsurance.privateInsuranceFromInsurancepage.isDisplayed());
		System.out.println(privateInsurance.privateInsuranceFromInsurancepage.getText());
		
		BrowserUtils.scroll(privateInsurance.marketPlaceCalculator);
		privateInsurance.marketPlaceCalculator.click();

		CalculatorPage calculatorPage = new CalculatorPage(driver);
		extentLogger.info("verifying 'all calculator fields' are displayed");
		for (WebElement each : calculatorPage.listCalculatorOptons) {
			if (each.isDisplayed()) {
				assertTrue(each.isDisplayed());
			}
		}
	
	}
	
	@Test(priority = 19) 
	public void TestCase_19(){
		driver.get("https://www.kff.org/interactive/subsidy-calculator/");
		
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String actualStateText = calculatorPage.stateText.getText();
		
		extentLogger = report.createTest("Verifying 'State selected' is displayed");
		assertTrue(calculatorPage.stateText.isDisplayed());
		assertEquals(actualStateText, "Select a State");
		
		calculatorPage.stateDropDown.click();
		Select dropDownState = new Select(calculatorPage.stateDropDown);
		extentLogger = report.createTest("Verifying 'Colorado' stated is selected");
		String value = "Colorado";
		dropDownState.selectByVisibleText(value);

		extentLogger = report.createTest("Verifying '20855' zipcode is inserted");
		calculatorPage.zipcodeBox.sendKeys("20855");
		extentLogger = report.createTest("Verifying 'Maryland' stated is displayed");
		assertEquals(dropDownState.getFirstSelectedOption().getText(), "Maryland");
	}

	@Test(priority = 20) 
	public void TestCase_20(){
		driver.get("https://www.kff.org/interactive/subsidy-calculator/");
		
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		extentLogger = report.createTest("'wooden spoon' key inserted");
		calculatorPage.incomeBox.sendKeys("wooden spoon");
		BrowserUtils.scroll(calculatorPage.submitBtn);
		calculatorPage.submitBtn.click();
		
		extentLogger = report.createTest("'Please enter a valid income.' is displayed" );
		assertTrue(calculatorPage.PleaseEnterValidText.isDisplayed());
		String actual = calculatorPage.PleaseEnterValidText.getText();
		assertEquals(actual, "Please enter a valid income.");
	}

	@Test(priority = 21) 
	public void TestCase_21(){
		driver.get("https://www.kff.org/interactive/subsidy-calculator/");
		
		CalculatorPage calculatorPage = new CalculatorPage(driver);
		String actualCoverageText = calculatorPage.coverageavailableText.getText();
		
		extentLogger = report.createTest("Verifying 'Is coverage available from your or your spouse’s job?' is displayed");
		assertTrue(calculatorPage.coverageavailableText.isDisplayed());
		assertEquals(actualCoverageText, "Is coverage available from your or your spouse’s job?");
		
		Select dropDownCoverage = new Select(calculatorPage.coverageDropDown);
		dropDownCoverage.selectByVisibleText("No");
		
		List<String> actualCoverageDropdownList =Arrays.asList("No", "Yes"); 
		List<WebElement> allCoverageOptions = dropDownCoverage.getOptions();

		extentLogger = report.createTest("Verifying 'No' and 'Yes' in the deopdown list");
		for (int i = 0; i < allCoverageOptions.size(); i++) {
			assertEquals(allCoverageOptions.get(i).getText(), actualCoverageDropdownList.get(i));
		}

		extentLogger = report.createTest("Verifying 'Is coverage available from your or your spouse’s job?' is displayed");
		assertTrue(calculatorPage.coverageavailableText.isDisplayed());
		assertEquals(actualCoverageText, "Is coverage available from your or your spouse’s job?");
		
		
	}

}
















