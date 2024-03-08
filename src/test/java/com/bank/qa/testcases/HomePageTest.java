package com.bank.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.qa.base.TestBase;
import com.bankqa.pages.HomePage;




public class HomePageTest extends TestBase {
	HomePage homePage;

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void homePageTest() throws InterruptedException {
		String explogo = homePage.verifyLogoText();
		Assert.assertEquals(explogo, "XYZ Bank", "Expected logo text is not present");
		String expTitle = homePage.getPageTitle();
		Assert.assertEquals(expTitle, "XYZ Bank", "Expected title is not present");
		String actUrl = homePage.getPageURL();
		Assert.assertEquals(actUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",
				"Expected url is not present");
		System.out.println(actUrl);
	}
}
