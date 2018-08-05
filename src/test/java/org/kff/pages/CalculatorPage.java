package org.kff.pages;

import java.util.ArrayList;
import java.util.List;

import org.kff.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {

	
	private WebDriver driver;

	public CalculatorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(Driver.getDriver(), this);
	} 
	
	
	@FindBy(id="zip-prompt")
	public WebElement stateText; 

	@FindBy(xpath="//span[@class='num' and .='1.']")
	public WebElement stateTextNum1; 
	
	@FindBy(id="state-dd")
	public WebElement stateDropDown; 
	
	@FindBy(css="p:contains(^Enter your zip code$)")  //xpath="//p[.='Enter your zip code']"
	public WebElement zipcodeText; 
	
	@FindBy (name="zip")
	public WebElement zipcodeBox;

	@FindBy(css="p:contains(^Select county$)")  //xpath="//p[.='Select county']"
	public WebElement countyText; 
	
	@FindBy(id="locale-inner")
	public WebElement countyDropDown; 
	
	@FindBy(xpath="//p[.='Enter income as']")  //xpath="//p[.='Enter income as']"
	public WebElement incomeText; 
	
	@FindBy(name="income-type")
	public WebElement incomeDropDown; 
	
	@FindBy(id="income-prompt")
	public WebElement householdText; 
	
	@FindBy(name="income")
	public WebElement incomeBox; 
	
	@FindBy(xpath="//span[.='4.']//following-sibling::p")
	public WebElement coverageavailableText; 
	
	@FindBy(name="employer-coverage")
	public WebElement coverageDropDown; 
	
	@FindBy(xpath="//span[.='5.']//following-sibling::p")
	public WebElement numberOfPeopleText; 
	
	@FindBy(name="people")
	public WebElement numberOfPeopleDropDown;
	
	@FindBy(xpath="//span[.='6.']//following-sibling::p")
	public WebElement adultsText; 
	
	@FindBy(name="adult-count")
	public WebElement adultDropDown;
	
	@FindBy(xpath="//span[.='7.']//following-sibling::p")
	public WebElement childrenText; 
	
	@FindBy(name="child-count")
	public WebElement childDropDown;
	
	@FindBy(xpath="(//article//a)[1]")
	public WebElement healthInsuranceMarketplaceCalculator; 
	
	@FindBy(xpath="(//p[@class = 'byline'])[1]")
	public WebElement date; 

	@FindBy(xpath="(//div[@id='subsidy-calculator-new']//strong)[1]")
	public WebElement verifyText; 
	
	@FindBy(css="span[class='num']+p")
	public List<WebElement> listCalculatorOptons; 
	
	

	
	@FindBy(xpath="//strong[contains(text(),'2018 plans')]")
	public WebElement noteText; 
	
	@FindBy(linkText="notes")
	public WebElement noteLink; 
	
	@FindBy(linkText="Frequently Asked Questions")
	public WebElement faqLink;
	
	@FindBy(xpath="//h5[.='about this tool']/..//following-sibling::a")
	public WebElement aboutPlus; 
	
	@FindBy(xpath="//h5[.='notes']/..//following-sibling::a")
	public WebElement notesPlus; 
	
	@FindBy(xpath="//h5[.='Frequently Asked Questions']/..//following-sibling::a")
	public WebElement faqPlus; 

	@FindBy(xpath="//h5[.='about this tool']/../..//following-sibling::dd")
	public WebElement aboutParagraph; 
	
	@FindBy(xpath="//h5[.='notes']/../..//following-sibling::dd")
	public WebElement notesParagraph; 
	
	@FindBy(xpath="//h5[.='Frequently Asked Questions']/../..//following-sibling::dd")
	public WebElement faqParagraph;
	
	@FindBy(xpath="//input[@type='submit' and @value='Submit']")
	public WebElement submitBtn; 
	
	@FindBy(xpath="//p[@class='form-message']")
	public WebElement message; 
	
	@FindBy(xpath="//h2[.='Results']")
	public WebElement results; 

	@FindBy (xpath="//h4[contains(text(), 'Market')]")
	public WebElement header; 
	
	@FindBy(xpath="//p[.='Please enter a valid income.']")
	public WebElement PleaseEnterValidText; 
}
