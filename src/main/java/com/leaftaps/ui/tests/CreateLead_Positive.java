package com.leaftaps.ui.tests;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.leaftaps.ui.base.ProjectSpecificMethods;
import com.leaftaps.ui.pages.LoginPage;

public class CreateLead_Positive extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setValues() {
		testName = "Create Positive Lead";
		testDescription = "Creating Postive Lead for Postive Testcase";
		testAuthor = "Kishor";
		testCategory = "Functional";
		filename="tc002";
	}
	
	@Test(dataProvider = "testdata")
	public void tc002(String cName,String fName, String lName) throws IOException {
		new LoginPage(driver).typeUsername()
		.typePassword()
		.clickCRMSFA()
		.clickLead()
		.clickCreateLead()
		.typeCompanyName(cName)
		.typeFirstName(fName)
		.typeLastName(lName)
		.clickCreateLeadButton()
		.verifyLeadId();
		
	}
}
