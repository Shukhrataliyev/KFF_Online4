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
	
	@FindBy(xpath = "//h3[.='New & Updated Indicators']")
	public WebElement newUpdatedInd;
	
	@FindBy(xpath="//a[.='Section 1115 Medicaid Waiver Tracker']")
	public WebElement section1115;
	
	@FindBy(linkText="Demographics and the Economy")
	public WebElement topLeftCategoriesDE;
	
	//@FindBy(xpath="//div[@id=\"top-left-categories\"]/ul/li[2]/a")
	@FindBy(linkText="Health Costs & Budgets")
	public WebElement topLeftCategoriesHCB;
	
	@FindBy(linkText="Health Coverage & Uninsured")
	public WebElement topLeftCategoriesHCU;
	
	@FindBy(linkText="Health Insurance & Managed Care")
	public WebElement topLeftCategoriesHIMC;
	
	@FindBy(linkText="Health Reform")
	public WebElement topLeftCategoriesHR1;
	
	@FindBy(xpath="//div[@id=\"top-left-categories\"]/ul/li[5]/a")
	public WebElement topLeftCategoriesHR;
	
	@FindBy(linkText="Health Status")
	public WebElement topLeftCategoriesHS;
	
	//@FindBy(linkText="HIV/AIDS")
	@FindBy(xpath="//div[@id=\"top-left-categories\"]/ul/li[7]/a")
	
	public WebElement topLeftCategoriesHADS;
	
	@FindBy(linkText="Medicaid & CHIP")
	public WebElement topLeftCategoriesMC;
	
	//@FindBy(linkText="Medicare")
	@FindBy(xpath="//div[@id=\"top-left-categories\"]/ul/li[9]/a")
	public WebElement topLeftCategoriesM;
	
	@FindBy(linkText="Minority Health")
	public WebElement topLeftCategoriesMH;
	
	@FindBy(linkText="Providers & Service Use")
	public WebElement topLeftCategoriesPSU;
	
	@FindBy(linkText="Women's Health")
	public WebElement topLeftCategoriesWH;
	
	@FindBy(xpath="//div[@class='box primary']/h2")
	public WebElement nextPageClickedTitle;
	
	
	@FindBy(linkText="Health Care Expenditures by State of Residence (in millions)")
	public WebElement HCBIndicators;
	
	
	@FindBy(xpath="//span[@title='Alabama']")
	public WebElement firstStateTable;
	
	
	@FindBy(id="agSortAsc")
	public WebElement sortLocation;
	
	@FindBy(xpath="//span[@title='Wyoming']")
	public WebElement sortedStateTable;
	
	@FindBy(xpath = "//a[@title='State Health Facts']")
	public WebElement SHFacts;

	
	public void goToStateHealthFacts(WebDriver driver){
		driver.navigate().to("https://www.kff.org/statedata/");
	}
	
	
	
	public void selectStateDropDown() {

		Select state = new Select(selectState);
		
		state.selectByValue("AL"); // Alabama selected
	
	}

}
