package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods {
	
	public WelcomePage(ChromeDriver inWardDriver) {
		this.driver = inWardDriver;
		PageFactory.initElements(driver, this);
	}
	
	public HomePage clickCRMSFA() throws IOException {
		try {
			driver.findElement(By.linkText(prop1.getProperty("welcomePage.crmsfa.linktext"))).click();
			reportStep("Clicked CRM SFA Successfully", "pass");
		} catch (Exception e) {
			reportStep("Not Clicked CRM SFA Successfully"+e, "fail");
		}
		return new HomePage(driver);
	}

}
