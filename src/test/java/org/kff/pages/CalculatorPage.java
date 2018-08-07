package org.kff.pages;

import java.util.ArrayList;
import java.util.List;

import org.kff.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	
	
	
	@FindBy(id = "state-dd")
	public WebElement selectState;

	@FindBy(name = "income-type")
	public WebElement incomeAs;

	@FindBy(name = "income")
	public WebElement houseHold;

	@FindBy(name = "employer-coverage")
	public WebElement yourSpouseJob;

	@FindBy(name = "employer-coverage")
	public WebElement noYes;

	@FindBy(name = "people")
	public WebElement numberOfPeopleInFamily;

	@FindBy(name = "adult-count")
	public WebElement numberOfAdults;

	@FindBy(name = "child-count")
	public WebElement numberOfChildren;

	@FindBy(css = "input[value=Submit]") // input[@value='Submit']
	public WebElement submit;

	@FindBy(css = "input[value='Clear']") // input[@value='Clear']
	public WebElement clear;

	@FindBy(xpath = "//p[.='Please enter a valid income.']")
	public WebElement enterValidIncomeText;

	@FindBy(xpath = "//dl[@class='about accordionShow']//a[@class='plus-btn']")
	public WebElement clickOnPlus;
	
	
	@FindBy(xpath = "//select[@name='adults[0][age]']")
	public WebElement age21;
	

	@FindBy(xpath = "//select[@name='adults[0][tobacco]']")
	public WebElement no;
	
	@FindBy(xpath = "//p[@class='adult-info-wrapper adult-info0']")
	public WebElement ageDisplayed;
	
	@FindBy(xpath = "//select[@name='adults[0][tobacco]']")
	public WebElement usesTobaccoDisplayed;

	@FindBy (xpath="//span[@class='inline-tip']")
	public List<WebElement> questionMarkList;  

	
	
	

	public void stateViaDropDown() {

		Select state = new Select(selectState);
		state.selectByIndex(0);
	}

	public void incomeViaDropDown() {

		Select income = new Select(incomeAs);
		income.selectByIndex(0);

	}

	public void spouseJobViaDropDown() {

		Select spouseJob = new Select(yourSpouseJob);
		spouseJob.selectByIndex(0);

	}

	public void numberOfPeopleInFamilyViaDropDown() {

		Select peopleInFamily = new Select(numberOfPeopleInFamily);
		peopleInFamily.selectByIndex(0);
	}

	public void numberOfAdulstViaDropDown() {

		Select numOfAdult = new Select(numberOfAdults);
		numOfAdult.selectByIndex(0);
	}

	public void numberOfChildrenViaDropDown() {

		Select numOfChildren = new Select(numberOfChildren);
		numOfChildren.selectByIndex(0);
	}

	public List<String> noYesSpouseJobViaDropDown() {


		Select yesNo = new Select( noYes);
		List<WebElement> lst=yesNo.getOptions();
		List<String> lstStr=new ArrayList<>(); 
		for (WebElement object : lst) {
			lstStr.add(object.getText()); 
		}
		return lstStr; 
		
	}

	public void coveregeSpouseJobViaDropDown() {

		Select coverageYes = new Select(yourSpouseJob);
		coverageYes.selectByIndex(1);

	}

	public List<String> listMaker(List<WebElement> elements) {
		List<String> ls = new ArrayList<>();
		for (WebElement numberOfPeopleInFamily : elements) {
			ls.add(numberOfPeopleInFamily.getText());
		}
		return ls;
	}

	public void twoPeopleInFamilyViaDropDown() {

		Select peopleInFamily = new Select(numberOfPeopleInFamily);
		peopleInFamily.selectByIndex(1);
	}

	public void noAdults() {

		Select list = new Select(numberOfAdults);
		List<WebElement> allSelectedOptions = list.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}

	}
	
	public void oneAdultViaDropDown() {

		Select numOfAdult = new Select(numberOfAdults);
		numOfAdult.selectByIndex(1);
	}
	
	
	public void age21ViaDropDown() {

		Select age = new Select(age21);
		age.selectByVisibleText("21");

	}
	
	public void usesTobaccoViaDropDown() {

		Select useTobacco = new Select(no);
		useTobacco.selectByVisibleText("No");

	}
	
	
	
	
	public String getFirstDropDown(WebElement wb){
		Select slc=new Select(wb);
		return slc.getFirstSelectedOption().getText();
	}
	

}
