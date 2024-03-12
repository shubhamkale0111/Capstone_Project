package com.bank.qa.testcases;
import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.BankManagerLoginPage;
import com.bankqa.pages.HomePage;
import com.bankqa.pages.OpenAccountPage;



public class OpenAccountTest extends TestBase {

	HomePage homePage;
	BankManagerLoginPage manager;
	OpenAccountPage openAccount;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homePage = new HomePage();
		manager = new BankManagerLoginPage();
		openAccount = new OpenAccountPage();
	}

	@Test(priority = 3)
	public void createAccount() throws Exception {
		
		manager = homePage.managerLoginBtn();
		
		openAccount = manager.clickopenAccountTab();
		
		openAccount.selectCustomer();
		
		openAccount.selectCurrency();
		
		openAccount.clickProcessBtn();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String alertmsg = openAccount.acceptAlert();
		System.out.println(alertmsg);
	}
	// close browser after complete of operation
		@AfterMethod
		public void closebrowse() {
			driver.quit();
		}
}
