package com.bankqa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bank.qa.base.TestBase;



public class AccountPage extends TestBase  {

	
	public AccountPage() throws IOException {
		PageFactory.initElements(driver, this);
	} 
	
	        @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//div//strong//span")
	        WebElement userName;
	        
	    // for Deposit function
			@FindBy(xpath = "(//button[@class='btn btn-lg tab'])[2]")
			WebElement DepositTab;
	
			@FindBy(xpath = "//input[@placeholder='amount']")
			WebElement depositamount;
			
			@FindBy(xpath = "(//button[contains(.,'Deposit')])[2]")
			WebElement depositBtn;
			
			@FindBy(xpath = "//span[contains(.,'Deposit Successful')]")
			WebElement depositMsg;
			
		//For Withdraw function
			@FindBy(xpath = "//button[contains(.,'Withdrawl')]")
			WebElement withdrawlTab;
			
			@FindBy(xpath = "//input[@placeholder='amount']")
			WebElement withdrawlAmount;
			
			@FindBy(xpath = "(//button[contains(.,'Withdraw')])[2]")
			WebElement withdrawlBtn;
					
			@FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
			WebElement withdrawlMsg;
			
			public String getUserName()
			{
				return userName.getText();
			}
			
		//Actions for deposit function 	
			//click on deposit tab
			public void clickDepositTab()
			{
				DepositTab.click();
			}
			//enter amount for deposit
			public void enterDepositAmount(String amount)
			{
				depositamount.sendKeys(amount);
			}
			// click on deposit button
			public void clickDepositButton()
			{
				depositBtn.click();
			}
			
			public String getDepositSuccessMSG()
			{
				return depositMsg.getText();
			}	
			
	   //Actions for Withdrawl function	
			//click on withdraw tab
			public void clickWithdrawlTab()
			{
				withdrawlTab.click();
			}
			//enter amount
			public void enterWithdrawlAmount(String amount)
			{
				withdrawlAmount.sendKeys(amount);
			}
			//click on withdraw button
			public void clickWithdrawlButton()
			{
				withdrawlBtn.click();
			}
			
			public String getWithdarwlSuccessMSG()
			{
				return withdrawlMsg.getText();
			}	

}
