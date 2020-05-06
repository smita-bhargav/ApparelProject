package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
import com.project.pageobject.PlaceOrdParam;
import com.project.pageobject.ShareProdParam;
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

public class ApparelSharProdPin {
	
	public ApparelSharProdPin() {
		PropertyConfigurator.configure("./log4j.properties");
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger =Logger.getLogger("ApparelSharProdPin");
	
	WebDriver driver;//instance variable
    JavascriptExecutor js ;
    Actions action= null;
  

    @BeforeTest
    @Parameters({"browser"})
	private void ApparelBrowser(String browser) throws IOException {
    	
	    driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);
		
	}
	@Test(dataProvider = "getloginData",priority = 1)
	public void signIn(Hashtable<String, String> dataxl) throws IOException {
		try {
				
			ShareProdParam signinDetail = new ShareProdParam(driver);
				signinDetail.getLgnClickbtn().click();
				signinDetail.SignInDetails(dataxl.get("email"), dataxl.get("password"));
	
				logger.info("Get login detail of the Current Record - " + signinDetail.getEmail());
	
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", ""); // scroll down
				signinDetail.getSbmtBtn().click();
			} 
			catch (Exception e) 
			{
				TakingScreenShots.capturescreen(driver, "ApparelShareProductError");
				throw (e);
		}
	}
	@Test(dataProvider ="getSearchData",priority = 2)
	public void searchApparel(Hashtable<String, String> reviesdataxl) throws IOException, InterruptedException {

		ShareProdParam shareprodObj = new ShareProdParam(driver);
		shareprodObj.SearchDetail(reviesdataxl.get("Search"),reviesdataxl.get("Click Dress"));
		shareprodObj.getSearchSbmtBtn().click();
	
	    js.executeScript("window.scrollBy(0,950)", "");
	    
	    if(reviesdataxl.get("Click Dress").equals(shareprodObj.getReviewdress1().getText()))
    	{shareprodObj.getReviewdress1().click();}
	    else  if(reviesdataxl.get("Click Dress").equals(shareprodObj .getReviewdress2().getText()))
    	{shareprodObj.getReviewdress2().click();}
	  	    
	}
	@Test(dataProvider ="getPinLgnData",priority = 3)
	public void lgnPinApparel(Hashtable<String, String> pindataxl) throws IOException, InterruptedException {
		ShareProdParam shareprodPinObj= new ShareProdParam(driver);
		js.executeScript("window.scrollBy(0,400)", "");
		shareprodPinObj.getPinInterestClk().click();
		String parentWinID = driver.getWindowHandle();
		logger.info("Parent Window ID - " + parentWinID+" : "+shareprodPinObj.getPinInterestClk().getText());	
		
		//once I perform operation - there will be 2 open windows
		Set<String> winids = driver.getWindowHandles();
		for(String winid:winids){
			logger.info(winid.toString());
			//you can use this approach for 2 or more winids and placing it in array
		}
		Iterator<String> itr = winids.iterator();
		String mainwinid=itr.next().toString();
		String subwinid = itr.next().toString();
		
		driver.switchTo().window(subwinid);
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepos.ApparelPage.apparel_shr_pinlgn_Xpath)));
		driver.findElement(By.xpath(ObjectRepos.ApparelPage.apparel_shr_pinlgn_Xpath)).click();
		shareprodPinObj.PinInterestLogin(pindataxl.get("email"),pindataxl.get("password"));
		TakingScreenShots.capturescreen(driver, "ApparelPinInterest");
		shareprodPinObj.getPinLgnSbtmt().click();
		
		Thread.sleep(3000);
		driver.close(); //this will close the subwindow
		//navigate back to the main window
		driver.switchTo().window(mainwinid);		
		
	}
	@Test(priority=4)
	public void SignOut() throws IOException{
		ShareProdParam shareProdlogObj = new ShareProdParam(driver);
		js.executeScript("window.scrollBy(0,-250)", ""); // scroll up
		WebElement logOf = shareProdlogObj.getLogoutClickbtn();
		System.out.println("log off " + logOf.getText());
		if (logOf.getText().equalsIgnoreCase("Sign out")) {
			//TakingScreenShots.capturescreen(driver, "ApparelSignOut");
			logOf.click();
			logger.info("LogOff Successful!");
		} else {
			logger.info("LogOff UnSuccessful!");
		}
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
	@DataProvider
	public Object[][] getPinLgnData() throws IOException {
		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxShareProd");
		String sheetname = PropertyReader.ReadProperty("pinintlgnsheetname");
	
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}
	
	
	 @AfterTest
	    private void CloseBrowser() throws InterruptedException {
	    	com.project.utilities.CloseBrowser.emptyBrowser(driver);
	    }

	

	
}

