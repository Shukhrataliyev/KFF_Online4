package org.kff.pages;

import java.util.List;

import org.kff.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class StateDataPage {

	private WebDriver driver;

	public StateDataPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "(//input[@id='search-field'])[last()]")
	public WebElement searchField;

	@FindBy(xpath = "(//input[@id='search-submit'])[last()]")
	public WebElement searchSubmit;

//	@FindBy(id = "search-field")
//	public WebElement searchField;

	@FindBy(name = "geo-picker")
	public WebElement selectState;
	
	@FindBy(linkText= "Demographics and the Economy")
	public WebElement demographics;
	
	@FindBy(xpath = "//*[@id=\"top-left-categories\"]/ul/li[5]/a")
	public WebElement healthReform;
	
	@FindBy(css= "a[href='https://www.kff.org/other/state-indicator/total-residents/']")
	public WebElement totalNumberOfResidents;
	
	@FindBy(css ="div[colid='Location']" )
	public List<WebElement> states;
	
	@FindBy(css ="div[colid='Total Residents']" )
	public List<WebElement> residents;

	// @FindBy(xpath = "//div[@id='state-health-wrapper']//h2")
	@FindBy(xpath = "//h2[.='Search State Health Facts:']")
	public WebElement SSHF;
	


}
