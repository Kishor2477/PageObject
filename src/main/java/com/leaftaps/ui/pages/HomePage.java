package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {
	
	public HomePage(ChromeDriver inWardDriver) {
		this.driver = inWardDriver;
		PageFactory.initElements(driver, this);
	}
public MyLeadsPage clickLead() throws IOException {
	try {
		driver.findElement(By.linkText(prop1.getProperty("homePage.leads.linktext"))).click();
		reportStep("Clicklead clicked Successfully", "pass");
	} catch (Exception e) {
		reportStep("Clicklead not clicked Successfully"+e, "fail");
	}
	return new MyLeadsPage(driver);
}
}
