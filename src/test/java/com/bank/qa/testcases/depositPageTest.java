package com.bank.qa.testcases;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.AccountPage;
import com.bankqa.pages.CustomerLoginPage;
import com.bankqa.pages.HomePage;

public class depositPageTest extends TestBase {
	HomePage homePage;
	CustomerLoginPage customerLogin;
	AccountPage accountdetails;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		homePage = new HomePage();
		customerLogin = new CustomerLoginPage();
		accountdetails = new AccountPage();
	}
	public depositPageTest() {
		super();
	}
	
	@Test
	public void DepositMoney()throws Exception {
		customerLogin = homePage.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		customerLogin.selectUser();
		String EXPname = customerLogin.selectUser();
		accountdetails = customerLogin.clickloginbtn();
		
		accountdetails.clickDepositTab();
		
		accountdetails.enterDepositAmount("50000");
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		accountdetails.clickDepositButton();
		
	
		
		String alertMsg = accountdetails.getDepositSuccessMSG();
		Assert.assertEquals(alertMsg,"Deposit Successful");

	}
		

}
