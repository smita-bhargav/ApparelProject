package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.pageobject.SearchParam;
import com.project.pageobject.SignInParam;
import com.project.utilities.ApparelSiginOut;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

import org.testng.annotations.*;

@Log
public class ApparelSearch {
	WebDriver driver;// instance variable
	JavascriptExecutor js;

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
	public void searchApparel(Hashtable<String, String> searchdataxl) throws IOException, InterruptedException {

		SearchParam serachObj = new SearchParam(driver);
		serachObj.SearchInDetails(searchdataxl.get("Search"));
		serachObj.getSearchSbmtBtn().click();

		String[] count = (serachObj.getDresscount().getText()).split(("\\s+"));
		System.out.println("DB : " + searchdataxl.get("Quantity") + " Screen : " + count[0]);
		log.info(searchdataxl.get("Search"));
		if (count[0].equals(searchdataxl.get("Quantity"))) {
			System.out.println("Search Pass");
			log.info(searchdataxl.get("Search") + "Search Pass");
		}

		else {
			System.out.println("Search Fail");
			log.info(searchdataxl.get("Search") + "Search Fail");
		}
		TakingScreenShots.capturescreen(driver, "ApparelSearch");
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void signOut() throws IOException {
		ApparelSiginOut.signOut(driver);
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxSearchname");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");
		log.info("filepath : " + filepath + "  " + filename);
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@DataProvider
	public Object[][] getSearchData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxSearchname");
		String sheetname = PropertyReader.ReadProperty("searchsheetname");
		log.info("filepath : " + filepath + "  " + filename);
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {

		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
