package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.objectMap.ObjectRepos;
import com.project.pageobject.ShareProdParam;
import com.project.pageobject.SignInParam;
import com.project.utilities.ApparelSiginOut;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelSharProdGmail {

	WebDriver driver;// instance variable
	JavascriptExecutor js;
	Actions action = null;

	@BeforeTest
	@Parameters({ "browser" })
	private void apparelBrowser(String browser) throws IOException {

		driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);

	}

	@Test(dataProvider = "getloginData", priority = 1)
	public void signIn(Hashtable<String, String> dataxl) throws Exception {
		js = ApparelSiginOut.apparelSignIn(driver, dataxl);
	}

	@Test(dataProvider = "getSearchData", priority = 2)
	public void searchApparel(Hashtable<String, String> reviesdataxl) throws IOException, InterruptedException {

		ShareProdParam shareprodObj = new ShareProdParam(driver);
		shareprodObj.SearchDetail(reviesdataxl.get("Search"), reviesdataxl.get("Click Dress"));
		shareprodObj.getSearchSbmtBtn().click();

		js.executeScript("window.scrollBy(0,950)", "");

		if (reviesdataxl.get("Click Dress").equals(shareprodObj.getReviewdress1().getText())) {
			shareprodObj.getReviewdress1().click();
		} else if (reviesdataxl.get("Click Dress").equals(shareprodObj.getReviewdress2().getText())) {
			shareprodObj.getReviewdress2().click();
		}

	}

	@Test(priority = 3)
	public void lgnPinApparel() throws IOException, InterruptedException {
		ShareProdParam shareprodPinObj = new ShareProdParam(driver);
		js.executeScript("window.scrollBy(0,400)", "");
		shareprodPinObj.getGoogleShareClk().click();
		String parentWinID = driver.getWindowHandle();
		log.info("Parent Window ID - " + parentWinID + " : " + shareprodPinObj.getGoogleShareClk().getText());

		// once I perform operation - there will be 2 open windows
		Set<String> winids = driver.getWindowHandles();
		for (String winid : winids) {
			log.info(winid.toString());
			// you can use this approach for 2 or more winids and placing it in
			// array
		}
		Iterator<String> itr = winids.iterator();
		String mainwinid = itr.next().toString();
		String subwinid = itr.next().toString();

		driver.switchTo().window(subwinid);

		Thread.sleep(3000);
		driver.close(); // this will close the subwindow
		// navigate back to the main window
		driver.switchTo().window(mainwinid);
		// driver.findElement(By.id("topMnuinsurance")).click();

	}

	@Test(priority = 4)
	public void signOut() throws IOException {
		ApparelSiginOut.signOut(driver);
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxShareProd");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@DataProvider
	public Object[][] getSearchData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxShareProd");
		String sheetname = PropertyReader.ReadProperty("reviewsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
