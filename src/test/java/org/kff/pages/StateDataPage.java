package org.kff.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StateDataPage {

	private WebDriver driver;
	public StateDataPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}
	
@FindBy(id="search-field" )	
public WebElement searchField;

@FindBy(name="geo-picker" )	
public WebElement selectState;

	
	//@FindBy(xpath = "//div[@id='state-health-wrapper']//h2")
	@FindBy(xpath = "//h2[.='Search State Health Facts:']")
	public WebElement SSHF;
	


}
