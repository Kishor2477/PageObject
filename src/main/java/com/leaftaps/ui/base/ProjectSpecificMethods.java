package com.leaftaps.ui.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificMethods {
	public ChromeDriver driver;
	public static Properties prop1;

	public String filename;
	
	public static ExtentTest test;
	public static ExtentReports extend;
	public String testName,testDescription,testAuthor,testCategory;

	@DataProvider
	public String[][] testdata() throws IOException {
		String[][] readExcelData = com.leaftaps.ui.utility.ReadExcelData.readExcelData(filename);
		return readExcelData;
	}
	
	@BeforeSuite
	public void startReports() {
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		reporter.setAppendExisting(true);
		extend = new ExtentReports();
		extend.attachReporter(reporter);
		

	}
	@BeforeClass
	public void textCaseDetails() {
		test = extend.createTest(testName, testDescription);
		test.assignAuthor(testAuthor);
		test.assignCategory(testCategory);

	}
	
	public int takeSnap() throws IOException {
		int ranNum = (int) (Math.random() * 99999+10000);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".png");
		FileUtils.copyFile(source, target);
		return ranNum;
	}
	
	public void reportStep(String stepDesc,String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
			test.pass(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail"))
		{
			test.fail(stepDesc,MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			throw new RuntimeException("View Steps for details");
		}

	}

	
	
	@AfterSuite
	public void stopReport() {
		extend.flush();

	}

	@org.testng.annotations.Parameters({ "URL" })
	@BeforeMethod
	public void login() throws Exception {

		// Getting App config File
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("./config/Appconfig.properties");
		prop.load(file);
		// prop.getProperty("Language");

		// Getting language config
		prop1 = new Properties();
		FileInputStream file1 = new FileInputStream("./config/" + prop.getProperty("Language") + ".properties");
		prop1.load(file1);

		String property = prop.getProperty("URL");
		System.out.println(property);

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get(prop.getProperty("URL"));

	}

	@AfterMethod
	public void close() {
		driver.close();
	}

}
