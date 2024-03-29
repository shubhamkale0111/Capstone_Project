package com.bankqa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;



public class BankManagerLoginPage extends TestBase{

	public BankManagerLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//
		@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
		WebElement addCustomerTab;
		
		@FindBy(xpath = "//button[contains(text(),'Open Account')]")
		WebElement openAccountTab;
		
		@FindBy(xpath = "//button[contains(normalize-space(), \"Customers\")]")
		WebElement customersTab;



		
		public AddCustomerPage clickaddCustomerTab() throws IOException
		{
			addCustomerTab.click();
			return new AddCustomerPage();
		}
		
		public OpenAccountPage clickopenAccountTab() throws Exception
		{
			openAccountTab.click();
			return new OpenAccountPage();
		}
		
		public CustomerslistPage clickCustomersTab() throws IOException
		{
			customersTab.click();
			return new CustomerslistPage();
		}
		
}
