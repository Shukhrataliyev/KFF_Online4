package org.kff.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.List;

import org.kff.pages.CalculatorPage;
import org.kff.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests14_17 extends TestBase {

	CalculatorPage caclulatorPage;
	CalculatorPage calculatorPage = new CalculatorPage(driver);
	HomePage homePage = new HomePage(driver);

	@Test
	public void testCase14() {
		caclulatorPage = new CalculatorPage(driver);
		homePage = new HomePage(driver);
		homePage.goToCalculatorPage(driver);
		caclulatorPage = new CalculatorPage(driver);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Health Insurance Marketplace Calculator | The Henry J. Kaiser Family Foundation";
		assertEquals(expectedTitle, actualTitle);

		caclulatorPage.stateViaDropDown();
		caclulatorPage.incomeViaDropDown();
		caclulatorPage.spouseJobViaDropDown();
		caclulatorPage.numberOfPeopleInFamilyViaDropDown();
		caclulatorPage.numberOfAdulstViaDropDown();
		caclulatorPage.numberOfChildrenViaDropDown();
		caclulatorPage.submit.click();
		caclulatorPage.clear.click();

		String actual = "Please enter a valid income.";
		String expected = driver.findElement(By.xpath("//p[.='Please enter a valid income.']")).getText();
		assertEquals(actual, expected);

	}

	@Test
	public void testCase15() {
		homePage = new HomePage(driver);
		homePage.goToCalculatorPage(driver);
		caclulatorPage = new CalculatorPage(driver);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Health Insurance Marketplace Calculator | The Henry J. Kaiser Family Foundation";
		assertEquals(expectedTitle, actualTitle);

		caclulatorPage.stateViaDropDown();
		caclulatorPage.incomeViaDropDown();
		caclulatorPage.spouseJobViaDropDown();
		caclulatorPage.numberOfPeopleInFamilyViaDropDown();
		caclulatorPage.numberOfAdulstViaDropDown();
		caclulatorPage.numberOfChildrenViaDropDown();

		caclulatorPage.noYesSpouseJobViaDropDown();
		caclulatorPage.coveregeSpouseJobViaDropDown();
		List<String> lst = new ArrayList<>();
		lst.add("Yes");
		lst.add("No");
		for (String each : caclulatorPage.noYesSpouseJobViaDropDown()) {
			assertTrue(lst.contains(each));
		}

	}

	@Test
	public void testCase16(List<WebElement> numberOfPeopleInFamily) {
		homePage = new HomePage(driver);
		homePage.goToCalculatorPage(driver);
		caclulatorPage = new CalculatorPage(driver);

		caclulatorPage = new CalculatorPage(driver);

		String actualTitle = driver.getTitle();
		String expectedTitle = "Health Insurance Marketplace Calculator | The Henry J. Kaiser Family Foundation";
		assertEquals(expectedTitle, actualTitle);

		caclulatorPage.listMaker(numberOfPeopleInFamily);
		caclulatorPage.twoPeopleInFamilyViaDropDown();

	}

	@Test
	public void testCase17() {
		homePage = new HomePage(driver);
		homePage.goToCalculatorPage(driver);
		caclulatorPage = new CalculatorPage(driver);

		caclulatorPage = new CalculatorPage(driver);

		String actualTitle = driver.getTitle();

		String expectedTitle = "Health Insurance Marketplace Calculator | The Henry J. Kaiser Family Foundation";
		assertEquals(expectedTitle, actualTitle);

		caclulatorPage.stateViaDropDown();
		caclulatorPage.incomeViaDropDown();
		caclulatorPage.spouseJobViaDropDown();
		caclulatorPage.numberOfPeopleInFamilyViaDropDown();
		caclulatorPage.numberOfAdulstViaDropDown();
		caclulatorPage.numberOfChildrenViaDropDown();
		caclulatorPage.submit.isDisplayed();
		caclulatorPage.clear.isDisplayed();

		caclulatorPage.noAdults();
		caclulatorPage.oneAdultViaDropDown();
		caclulatorPage.age21ViaDropDown();
		caclulatorPage.usesTobaccoViaDropDown();

	}

}