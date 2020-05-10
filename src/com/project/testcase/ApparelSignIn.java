package com.project.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.project.pageobject.SignInParam;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelSignIn {

	WebDriver driver = null;
	JavascriptExecutor js = null;

	@BeforeTest
	@Parameters({ "browser" })
	private void ApparelBrowser(String browser) throws IOException {

		driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);

	}

	@Test(dataProvider = "getloginData")
	public void signIn(Hashtable<String, String> dataxl) throws IOException {
		try {

			SignInParam signinDetail = new SignInParam(driver);
			signinDetail.getLgnClickbtn().click();
			signinDetail.SignInDetails(dataxl.get("email"), dataxl.get("password"));
			log.info("Get login detail of the Current Record - " + signinDetail.getEmailTextbox());
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", ""); // scroll down
			signinDetail.getSbmtBtn().click();

			// WebDriverWait waitObj = new WebDriverWait(driver,10);
			// WebElement disp=
			// waitObj.until(ExpectedConditions.visibilityOfElementLocated(locator));
			List<WebElement> error = signinDetail.getErrorAlrt();
			if (error.size() > 0) {

				for (WebElement er : error) {
					String color = er.getCssValue("background-color");
					String hex = Color.fromString(color).asHex();
					;

					Assert.assertEquals(hex, "#f3515c", "Unmatched Background Color of Error");
					if (er.getText().contains("error")) {
						log.info("Invalid User Details.Authantication fail.");
					}
				}
			} else {
				WebElement logOf = signinDetail.getLogoutClickbtn();

				if (logOf.getText().equalsIgnoreCase("Sign out")) {
					TakingScreenShots.capturescreen(driver, "ApparelSignOut");
					logOf.click();
					log.info("LogOff Successful!");
				} else {
					log.info("LogOff UnSuccessful!");
				}
			}
		} catch (Exception e) {
			TakingScreenShots.capturescreen(driver, "ApparelSignInError");
			log.warning("Exception");
			throw (e);
		}
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxlgn");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");
		log.info("file detail : " + filepath + "  " + filename);
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
