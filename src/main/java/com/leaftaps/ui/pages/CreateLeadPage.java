package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class CreateLeadPage extends ProjectSpecificMethods {
	
	public CreateLeadPage(ChromeDriver inWardDriver) {
		this.driver = inWardDriver;
		PageFactory.initElements(driver, this);
	}
	
	
	
public CreateLeadPage typeCompanyName(String cName) throws IOException {
	try {
		driver.findElement(By.id(prop1.getProperty("createLeadPage.companyname.id"))).sendKeys(cName);
		reportStep("Entered Company name Successfully", "pass");
	} catch (Exception e) {
		reportStep("Not Entered Company name Successfully"+e, "fail");
	}
	return this;
}
public CreateLeadPage typeFirstName(String fName) throws IOException {
	try {
		driver.findElement(By.id(prop1.getProperty("createLeadPage.firstname.id"))).sendKeys(fName);
		reportStep("Entered first name Successfully", "pass");
	} catch (Exception e) {
		reportStep("Not Entered first name Successfully"+e, "fail");
	}
	return this;
}
public CreateLeadPage typeLastName(String lName) throws IOException {
	try {
		driver.findElement(By.id(prop1.getProperty("createLeadPage.lastname.id"))).sendKeys(lName);
		reportStep("Entered Last name Successfully", "pass");
	} catch (Exception e) {
		reportStep("Not Entered Last name Successfully"+e, "fail");
	}
	return this;
}

public ViewLeadPage clickCreateLeadButton() throws IOException {
	try {
		driver.findElement(By.name(prop1.getProperty("createLeadPage.clickleadbutton.name"))).click();
		reportStep("Clicked Create Leadbutton  Successfully", "pass");
	} catch (Exception e) {
		reportStep("Not Clicked Create Leadbutton  Successfully"+e, "fail");
	}
	return new ViewLeadPage(driver);
}

}
