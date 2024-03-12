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
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addCustomerBtn;

	
	public void EnterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);
	}

	public void EnterLastName(String LastName) {
		lastName.sendKeys(LastName);
	}

	public void EnterPostCode(String Postcode) {
		postCode.sendKeys(Postcode);
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

