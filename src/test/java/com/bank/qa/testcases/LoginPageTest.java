package com.bank.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.deposite_withdraw;
import com.bankqa.pages.CustomerLoginPage;
import com.bankqa.pages.HomePage;



public class LoginPageTest extends TestBase {

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
	public void verifyLogin() throws Exception {
		
		customerLogin = homePage.customerLoginbtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		customerLogin.selectUser();
		
		String EXPname = customerLogin.selectUser();
		
		accountdetails = customerLogin.clickloginbtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String ActUser = accountdetails.getUserName();
		
		System.out.println(EXPname + "  and   " + ActUser);
		
		Assert.assertEquals(EXPname, ActUser, "Selected user is not logged in...");
	}
	
	// close browser after complete of operation
		@AfterMethod
		public void closebrowse() {
			driver.quit();
		}
}

