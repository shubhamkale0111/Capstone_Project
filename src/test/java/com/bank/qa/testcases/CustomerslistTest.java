package com.bank.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.BankManagerLoginPage;
import com.bankqa.pages.CustomerslistPage;
import com.bankqa.pages.HomePage;



public class CustomerslistTest extends TestBase {

	HomePage homePage;
	BankManagerLoginPage manager;
	CustomerslistPage customers;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homePage = new HomePage();
		manager = new BankManagerLoginPage();
		customers = new CustomerslistPage();
	}

	@Test
	public void verifySearch() throws Exception {
		String searchingName = "Harry";
		manager = homePage.managerLoginBtn();
		customers = manager.clickCustomersTab();
		customers.search(searchingName);
		String name = customers.getSearchedName();
		Assert.assertEquals(searchingName, name, "Not Found ");
		System.out.println(name + " " + searchingName);
	}
}
