package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pageobject.PlaceOrdParam;
import com.project.pageobject.SearchParam;
import com.project.pageobject.ShareProdParam;
import com.project.pageobject.SignInParam;
import com.project.utilities.ApparelSiginOut;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelManufacturer {

	WebDriver driver;// instance variable
	JavascriptExecutor js;
	boolean verify;

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
	public void searchApparel(Hashtable<String, String> searchdataxl) throws IOException, InterruptedException {
		try {
			PlaceOrdParam placeordObj = new PlaceOrdParam(driver);

			log.info("dress : " + placeordObj.getMainMenu().getText() + " Search : " + searchdataxl.get("Search")
					+ " Quantity : " + searchdataxl.get("Quantity"));
			placeordObj.getMainMenu().click();

			Thread.sleep(2000);
			// js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1800)", ""); // scroll down
			placeordObj.getManufactRadio().click();
			String count = placeordObj.getManufactCount().getText();
			Thread.sleep(3000);
			verify = count.contains(searchdataxl.get("Quantity"));
			if (verify) {
				log.info("Success! Manufacturer Count Same as expected");
				TakingScreenShots.capturescreen(driver, "ApparelManuFacturer");
			} else {
				log.info("Fail!");
			}
		} catch (Exception e) {
			TakingScreenShots.capturescreen(driver, "ApparelManuFactError");
			throw (e);

		}
	}

	@Test(priority = 3)
	public void signOut() throws IOException {
		ApparelSiginOut.signOut(driver);
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxManufactname");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@DataProvider
	public Object[][] getSearchData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxManufactname");
		String sheetname = PropertyReader.ReadProperty("manufactsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
