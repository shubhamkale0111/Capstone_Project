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



public class WithdrawTest extends TestBase{

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
	
	
	@Test
	public void DepositMoney()throws Exception {
		customerLogin = homePage.customerLoginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		customerLogin.selectUser();
		String EXPname = customerLogin.selectUser();
		accountdetails = customerLogin.clickloginbtn();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accountdetails.clickWithdrawlTab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		accountdetails.enterWithdrawlAmount("100");
		accountdetails.clickWithdrawlButton();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);;
		
		String alertMsg = accountdetails.getWithdarwlSuccessMSG();
		Assert.assertEquals(alertMsg,"Transaction successful");
		
		

	}
	
	
}


