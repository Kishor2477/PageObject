package com.leaftaps.ui.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.leaftaps.ui.base.ProjectSpecificMethods;

public class ViewLeadPage extends ProjectSpecificMethods {
	
	public ViewLeadPage(ChromeDriver inWardDriver) {
		this.driver = inWardDriver;
		PageFactory.initElements(driver, this);
	}
	public ViewLeadPage verifyLeadId() throws IOException {
		String replaceAll;
		try {
			replaceAll = driver.findElement(By.id(prop1.getProperty("viewLead.verifyLeadid.id"))).getText().replaceAll("[^0-9]", "");
			reportStep("Lead ID Verified Successfully", "pass");
			System.out.println(replaceAll);
		} catch (Exception e) {
			reportStep("Lead ID is not Verified Successfully"+e, "fail");
		}
		
		return this;
	}

}
