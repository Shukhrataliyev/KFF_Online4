package org.kff.pages;

import java.util.List;

import org.kff.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="search-field")
	public WebElement search;

	@FindBy(xpath="//a[.='menu']")
	public WebElement menu;
	
	@FindBy(css="a[href='/statedata']")
	public WebElement statHealthFacts;
	
	@FindBy(css="a[href='/private-insurance/']")
	public WebElement privateInsurance;
	
	@FindBy(xpath="//ul[@class='sub-menu']//a[@href='/statedata']")
	public WebElement statHealthFactsSub;
	
	@FindBy(xpath="//h4[.='Featured State Data Resources']")
	public WebElement featuredStateData;
	
	@FindBy(css="h3.kicker")
	public WebElement newUpdatedIndicator;
	
	@FindBy(id="search-submit")
	public WebElement submitBtn;
	
	@FindBy(tagName="a")
	public List<WebElement> links;
	
	public void goToCalculatorPage(WebDriver driver){
		driver.navigate().to("https://www.kff.org/interactive/subsidy-calculator/");
	}

	
	public void goToStateData(WebDriver driver){
		driver.navigate().to("https://www.kff.org/statedata");
	}
	
	
	
	
	



}