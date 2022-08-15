package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	@FindBy(how = How.ID,using = "username") private WebElement elementUsername;
	@FindBy(how = How.ID,using = "password") private WebElement elementPassword;

	public LoginPage(ChromeDriver inWardDriver) {
	
			this.driver = inWardDriver;
		
		PageFactory.initElements(driver, this);
	}
	
	

	public LoginPage typeUsername() throws IOException {
		try {
			elementUsername.sendKeys("DemoSalesManager");
			reportStep("Username is entered correctly", "pass");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			reportStep("Username is not entered correctly"+e, "fail");
		}
		return this;
	}

	public WelcomePage typePassword() throws IOException {
		try {
			elementPassword.sendKeys("crmsfa", Keys.ENTER);
			reportStep("Password is entered correctly", "pass");
		} catch (Exception e) {
			
			reportStep("Password is not entered correctly"+e, "fail");
		}
		return new WelcomePage(driver);
	}

	/*
	 * public void clickLogin() {
	 * driver.findElement(By.linkText("CRM/SFA")).click(); }
	 */
}
