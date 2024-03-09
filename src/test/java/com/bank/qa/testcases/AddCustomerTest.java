package com.bank.qa.testcases;

import java.io.IOException;
import java.time.Duration;

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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		addCustomer.enterFName(prop.getProperty("FirstName"));
		addCustomer.enterLName(prop.getProperty("LastName"));
		addCustomer.enterPCode(prop.getProperty("Postcode"));
		
		addCustomer.clickaddCustBtn();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String alertMsg = addCustomer.acceptAlert();
		System.out.println(alertMsg);
	}
}
