package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.project.pageobject.PlaceOrdParam;
import com.project.pageobject.ReviewParam;

import com.project.pageobject.SignInParam;
import com.project.utilities.ApparelSiginOut;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import lombok.extern.java.Log;

@Log
public class ApparelPlacOrder {

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

	@Test(priority = 2)
	public void searchApparel() throws IOException, InterruptedException {

		PlaceOrdParam placeordObj = new PlaceOrdParam(driver);
		Thread.sleep(3000);
		log.info("dress : " + placeordObj.getMainMenu().getText());
		placeordObj.getMainMenu().click();
		placeordObj.getSubmenu1().click();
		js.executeScript("window.scrollBy(0,750)", ""); // scroll down
		Actions actions = new Actions(driver);
		actions.moveToElement(placeordObj.getInstockBtn()).click().build().perform();
		placeordObj.getAddtoCartbtn().click();
		placeordObj.getContinuShoping().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-750)", ""); // scroll up

		placeordObj.getMainMenu().click();
		;
		placeordObj.getSubmenu2().click();
		js.executeScript("window.scrollBy(0,750)", ""); // scroll down

		actions.moveToElement(placeordObj.getInstockBtn()).click().build().perform();
		placeordObj.getAddtoCartbtn().click();
		placeordObj.getContinuShoping().click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-750)", ""); // scroll up

		placeordObj.getMainMenu().click();
		placeordObj.getSubmenu3().click();
		js.executeScript("window.scrollBy(0,750)", ""); // scroll down
		actions.moveToElement(placeordObj.getInstockBtn()).click().build().perform();
		placeordObj.getSummercolDress().click();
		placeordObj.getAddtoCartbtn().click();
		placeordObj.getProceedShoping().click();
		js.executeScript("window.scrollBy(0,2050)", ""); // scroll down
		placeordObj.getCheckoutBtn().click();
		js.executeScript("window.scrollBy(0,950)", ""); // scroll down
		placeordObj.getAddrescheckBtn().click();
		js.executeScript("window.scrollBy(0,450)", ""); // scroll down
		placeordObj.getAgrCondBtn().click();
		placeordObj.getCarrProcBtn().click();
		js.executeScript("window.scrollBy(0,750)", ""); // scroll down
		placeordObj.getBankPayBtn().click();
		js.executeScript("window.scrollBy(0,550)", ""); // scroll down
		placeordObj.getConfrmOrdBtn().click();
		js.executeScript("window.scrollBy(0,350)", ""); // scroll down
		TakingScreenShots.capturescreen(driver, "ApparelOrder");
	}

	@Test(priority = 3)
	public void signOut() throws IOException {
		ApparelSiginOut.signOut(driver);
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxPlaceOrder");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@DataProvider
	public Object[][] getSearchData() throws IOException {

		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxPlaceOrder");
		String sheetname = PropertyReader.ReadProperty("reviewsheetname");

		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void closeBrowser() throws InterruptedException {
		com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
