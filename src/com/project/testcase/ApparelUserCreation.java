package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.objectMap.ObjectRepos;
import com.project.pageobject.UserCreateParam;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelUserCreation {

	WebDriver driver = null;// instance variable
	JavascriptExecutor js = null;
	SoftAssert softObj = new SoftAssert();

	@BeforeTest
	@Parameters({ "browser" })
	private void apparelBrowser(String browser) throws IOException {

		driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);

	}

	@Test(dataProvider = "getLogincreateData")
	public void accountCreation(Hashtable<String, String> dataxl) throws InterruptedException, IOException {

		UserCreateParam logincreation = new UserCreateParam(driver);
		logincreation.getLgnClickbtn().click();
		logincreation.accountDetail(dataxl.get("email"));
		logincreation.getCreateAcntSbmt().click();

		List<WebElement> error = null;
		try {
			logincreation.createAccount(dataxl.get("title"), dataxl.get("custfirstnm"), dataxl.get("custlastnm"),
					dataxl.get("password"), dataxl.get("day"), dataxl.get("month"), dataxl.get("year"),
					dataxl.get("fname"), dataxl.get("lname"), dataxl.get("cmpny"), dataxl.get("address"),
					dataxl.get("address2"), dataxl.get("city"), dataxl.get("state"), dataxl.get("pcode"),
					dataxl.get("cntry"), dataxl.get("info"), dataxl.get("phone"), dataxl.get("mobile"),
					dataxl.get("other"));
			log.info(dataxl.get("cntry"));
			if (dataxl.get("pcode").length() >= 5 && !dataxl.get("cntry").isEmpty()
					&& !dataxl.get("cntry").equals("-")) {
				log.info("Postcode is greater or equals to 5 character.");

			} else if (dataxl.get("pcode").length() < 5 && !dataxl.get("pcode").isEmpty()
					&& dataxl.get("pcode") != null) {
				log.info("Postcode shouldnt be less than 5 character.");

			} else if (dataxl.get("cntry").isEmpty() || dataxl.get("cntry").equals("-")) {
				log.info("Country field is empty.");

			}
			logincreation.getRegisterSbmt().click();
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1250)", ""); // scroll up
			Thread.sleep(3000);
			error = driver.findElements(By.xpath(ObjectRepos.ApparelPage.APPAREL_CR_ERROR_XPATH));
			if (!error.equals(null) && !error.isEmpty()) {
				softObj.assertEquals(error.size() > 0, true, "Error occur");

				log.info("Inside error log");
				TakingScreenShots.capturescreen(driver, "ApparelUserCreationError");
			} else {

				WebElement logOf = logincreation.getLogoutClickbtn();

				if (logOf.getText().equalsIgnoreCase("Sign out")) {
					TakingScreenShots.capturescreen(driver, "ApparelSignOut");
					logOf.click();
					log.info("LogOff Successful!");
				} else {
					log.info("LogOff UnSuccessful!");
				}
			}
		} catch (Exception e) {

			throw (e);

		}
	}

	@DataProvider
	public Object[][] getLogincreateData() throws IOException {
		String ProjectPath = System.getProperty("user.dir"); // absolute project
																// path
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxUserCreate");
		String sheetname = PropertyReader.ReadProperty("userCreationsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
