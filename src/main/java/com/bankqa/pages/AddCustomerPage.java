package com.bankqa.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;



public class AddCustomerPage extends TestBase {

	public AddCustomerPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addCustomerBtn;

	// Actions
	public void enterFName(String fName) {
		firstName.sendKeys(fName);
	}

	public void enterLName(String lName) {
		lastname.sendKeys(lName);
	}

	public void enterPCode(String code) {
		postCode.sendKeys(code);
	}

	public void clickaddCustBtn() {
		addCustomerBtn.click();
	}

	public String acceptAlert() {
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		al.accept();

		return alertText;
	}
}

