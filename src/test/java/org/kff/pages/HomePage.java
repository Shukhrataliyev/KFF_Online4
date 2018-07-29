package org.kff.pages;

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
	
	@FindBy(xpath="//ul[@class='sub-menu']//a[@href='/statedata']")
	public WebElement statHealthFactsSub;
	
	@FindBy(xpath="//a")
	public WebElement links;
	
	@FindBy(xpath="//h4[.='Featured State Data Resources']")
	public WebElement featuredStateData;
	
	@FindBy(css="h3.kicker")
	public WebElement newUpdatedIndicator;
	
	@FindBy(id="search-submit")
	public WebElement submitBtn;
	
	
	
	
	
	
	

	

}