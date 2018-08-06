package org.kff.tests;

import static org.testng.Assert.assertEquals;

import org.kff.pages.CalculatorPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests14_17 extends TestBase{

	
	
CalculatorPage caclulatorPage;
	
	@Test
	public void houseHold() {
		caclulatorPage= new CalculatorPage(driver);
		
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
		String expected =driver.findElement(By.xpath("//p[.='Please enter a valid income.']")).getText();
		assertEquals(actual, expected);
	
	}		

	@Test
	public void plusSgin() {
		
		caclulatorPage= new CalculatorPage(driver);
		
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
		
		for (WebElement webElement : caclulatorPage.noYes) {
			System.out.println(webElement.getText());
		
		caclulatorPage.coveregeSpouseJobViaDropDown();
	}
	}
		@Test
		public void numberOfPeopleInFamily() {
			
			caclulatorPage= new CalculatorPage(driver);
			
			String actualTitle = driver.getTitle();
			String expectedTitle = "Health Insurance Marketplace Calculator | The Henry J. Kaiser Family Foundation";
			assertEquals(expectedTitle, actualTitle);	

	}	
	
	
}
