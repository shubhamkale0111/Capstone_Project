package com.bank.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.AddCustomerPage;
import com.bankqa.pages.BankManagerLoginPage;
import com.bankqa.pages.HomePage;



public class AddCustomerTest extends TestBase {

	HomePage homePage;
	BankManagerLoginPage manager;
	AddCustomerPage addCustomer;
	

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homePage = new HomePage();
		manager = new BankManagerLoginPage();
		addCustomer = new AddCustomerPage();
		
	}

	@Test
	public void verifyManagerLogin() throws Exception {
		
		homePage.managerLoginBtn();
		
		manager.clickaddCustomerTab();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		addCustomer.EnterFirstName(prop.getProperty("FirstName"));//getting first Name of customer from config
		addCustomer.EnterLastName(prop.getProperty("LastName"));//getting last name of customer from config
		addCustomer.EnterPostCode(prop.getProperty("Postcode"));//getting post code of customer from config
		
		addCustomer.clickaddCustBtn(); // click on add button
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		String alertMsg = addCustomer.acceptAlert();
		System.out.println(alertMsg);
		
	}
	// close browser after complete of operation
	@AfterMethod
	public void closebrowse() {
		driver.quit();
	}
	
}
