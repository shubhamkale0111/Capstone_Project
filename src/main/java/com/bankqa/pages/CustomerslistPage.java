package com.bankqa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;


public class CustomerslistPage extends TestBase {

	public CustomerslistPage() throws IOException {
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement searchField;
	
	@FindBy(xpath = "(//table/tbody/tr/td)[1]")
	WebElement firstlistedName;
	
	
	
	public void search(String name)
	{
		searchField.sendKeys(name);
	}
	
	public String getSearchedName()
	{
		return firstlistedName.getText();
	}
		
}
