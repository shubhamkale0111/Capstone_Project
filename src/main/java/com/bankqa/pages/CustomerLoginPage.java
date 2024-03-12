package com.bankqa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bank.qa.base.TestBase;



public class CustomerLoginPage extends TestBase {

	public CustomerLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//select[@id='userSelect']")
	WebElement YourNameDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;


	public String selectUser() {
		Select sc = new Select(YourNameDropdown);
		sc.selectByIndex(1);
		String selecteduser = sc.getFirstSelectedOption().getText();

		return selecteduser;
	}

	public deposite_withdraw clickloginbtn() throws Exception {
		loginBtn.click();

		return new deposite_withdraw();
	}
}

