package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pageobject.ReviewParam;
import com.project.pageobject.SearchParam;
import com.project.pageobject.SignInParam;
import com.project.utilities.ApparelSiginOut;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelReview {

	WebDriver driver;// instance variable
	JavascriptExecutor js;
	Actions action = null;

	@BeforeTest
	@Parameters({ "browser" })
	private void ApparelBrowser(String browser) throws IOException {

		driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);

	}

	@Test(dataProvider = "getloginData", priority = 1)
	public void signIn(Hashtable<String, String> dataxl) throws Exception {
		js = ApparelSiginOut.apparelSignIn(driver, dataxl);
	}

	@Test(dataProvider = "getSearchData", priority = 2)
	public void searchApparel(Hashtable<String, String> reviesdataxl) throws IOException, InterruptedException {

		ReviewParam serachObj = new ReviewParam(driver);
		serachObj.SearchDetail(reviesdataxl.get("Search"), reviesdataxl.get("Click Dress"));

		serachObj.getSearchSbmtBtn().click();

		js.executeScript("window.scrollBy(0,850)", "");
		// ReviewParam reviewObj = new ReviewParam(driver);
		log.info(reviesdataxl.get("Click Dress") + "  page : " + (serachObj.getReviewdress1().getText()));
		if (reviesdataxl.get("Click Dress").equals(serachObj.getReviewdress1().getText())) {
			serachObj.getReviewdress1().click();
		} else if (reviesdataxl.get("Click Dress").equals(serachObj.getReviewdress2().getText())) {
			serachObj.getReviewdress2().click();
		}
		Thread.sleep(3000);
		serachObj.getClickCommntlnk().click();
		/// Thread.sleep(3000);
		serachObj.ReviewDress(reviesdataxl.get("Title"), reviesdataxl.get("Comment"));
		TakingScreenShots.capturescreen(driver, "ApparelReview");
		serachObj.getReviewmsg().click();

		String comment = reviesdataxl.get("Comment");

		if (comment.length() > 50) {
			log.info("Message -Comment added Successfully!");
			serachObj.getReviewOkBtn().click();

		} else {
			log.info("Message - Require more than 50 characters!");
			serachObj.getReviewClosepopUp().click();

		}
		driver.navigate().to(PropertyReader.ReadProperty("applandingdressurl"));

	}

	@Test(priority = 3)
	public void signOut() throws IOException {
		ApparelSiginOut.signOut(driver);
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxReviw");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@DataProvider
	public Object[][] getSearchData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxReviw");
		String sheetname = PropertyReader.ReadProperty("reviewsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
