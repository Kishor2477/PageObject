package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class MyLeadsPage extends ProjectSpecificMethods {
	
	public MyLeadsPage(ChromeDriver inWardDriver) {
		this.driver = inWardDriver;
		PageFactory.initElements(driver, this);
	}
public CreateLeadPage clickCreateLead() throws IOException {
	try {
		driver.findElement(By.linkText(prop1.getProperty("myLeads.createlead.linktext"))).click();
		reportStep("Clicked Create Lead Successfully", "pass");
	} catch (Exception e) {
		reportStep("Not Clicked Create Lead Successfully"+e, "fail");
	}
	return new CreateLeadPage(driver);
}
}
