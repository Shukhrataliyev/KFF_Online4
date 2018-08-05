package org.kff.pages;

import org.kff.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivateInsurancePage {
private WebDriver driver;
	
	public PrivateInsurancePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(css="h2>a[href='/interactive/subsidy-calculator/']")
	public WebElement marketPlaceCalculator;
	
	@FindBy(css="h2>a[href='/private-insurance/']")
	public WebElement privateInsuranceFromInsurancepage;


}
