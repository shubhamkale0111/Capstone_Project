package com.bank.qa.testcases;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.deposite_withdraw;
import com.bankqa.pages.CustomerLoginPage;
import com.bankqa.pages.HomePage;



public class WithdrawTest extends TestBase{

	HomePage homePage;
	CustomerLoginPage customerLogin;
	deposite_withdraw accountdetails;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		
		homePage = new HomePage();
		customerLogin = new CustomerLoginPage();
		accountdetails = new deposite_withdraw();
	}
	
	
	@Test
	public void DepositMoney()throws Exception {
		
		customerLogin = homePage.customerLoginbtn();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		customerLogin.selectUser();
		
		String name = customerLogin.selectUser();
		
		accountdetails = customerLogin.clickloginbtn();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		accountdetails.clickWithdrawlTab();
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		accountdetails.enterWithdrawlAmount("100");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		accountdetails.clickWithdrawlButton();
		
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		String alertMsg = accountdetails.getWithdarwlSuccessMSG();
		
		Assert.assertEquals(alertMsg,"Transaction successful");
		driver.manage().timeouts().implicitlyWait(800, TimeUnit.SECONDS);
		

	}
	// close browser after complete of operation
		@AfterMethod
		public void closebrowse() {
			driver.quit();
		}
	
	
}


