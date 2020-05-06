package com.project.testcase;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
import com.project.utilities.ExcelReader;
import com.project.utilities.PropertyReader;
import com.project.utilities.TakingScreenShots;

import org.testng.annotations.*;

public class ApparelSearch {

	public ApparelSearch() {
		PropertyConfigurator.configure("./log4j.properties");
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger =Logger.getLogger("ApparelSearch");
	
	WebDriver driver;// instance variable
	JavascriptExecutor js;
	
	 @BeforeTest
	 @Parameters({"browser"})
		private void ApparelBrowser(String browser) throws IOException {
			
		    driver = com.project.utilities.ApparelBrowser.launchBrowser(browser);
			
		}
	

	@Test(dataProvider = "getloginData",priority = 1)
	public void signIn(Hashtable<String, String> dataxl) throws Exception {
		try {
				
				SearchParam signinDetail = new SearchParam(driver);
				signinDetail.getLgnClickbtn().click();
				Thread.sleep(2000);
				signinDetail.SignInDetails(dataxl.get("email"), dataxl.get("password"));
	
				System.out.println("Get login detail of the Current Record - " + signinDetail.getEmail());
				logger.info("Get login detail of the Current Record - " + signinDetail.getEmail());
				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,250)", ""); // scroll down
				signinDetail.getSbmtBtn().click();
			} 
			catch (Exception e) 
			{
				TakingScreenShots.capturescreen(driver, "ApparelSearchError");
				throw (e);
		}
	}

	@Test(dataProvider ="getSearchData",priority = 2)
	public void searchApparel(Hashtable<String, String> searchdataxl) throws IOException, InterruptedException {

		SearchParam serachObj = new SearchParam(driver);
		serachObj.SearchInDetails(searchdataxl.get("Search"));
		serachObj.getSearchSbmtBtn().click();
		
		String[] count =(serachObj.getDresscount().getText()).split(("\\s+"));
		System.out.println("DB : "+searchdataxl.get("Quantity")+" Screen : " +count[0]);
		logger.info(searchdataxl.get("Search"));
		if(count[0].equals(searchdataxl.get("Quantity")))
		{System.out.println("Search Pass");
		logger.info(searchdataxl.get("Search")+"Search Pass");
		}
		
		else
		{System.out.println("Search Fail");
		logger.info(searchdataxl.get("Search")+"Search Fail");
		}
		TakingScreenShots.capturescreen(driver, "ApparelSearch");
		Thread.sleep(2000);
		
		

	}
	@Test(priority=3)
	public void SignOut() throws IOException{
		SearchParam serachObj = new SearchParam(driver);
		js.executeScript("window.scrollBy(0,-250)", ""); // scroll up
		WebElement logOf = serachObj.getLogoutClickbtn();
		
		if (logOf.getText().equalsIgnoreCase("Sign out")) {
			//TakingScreenShots.capturescreen(driver, "ApparelSignOut");
			logOf.click();
			System.out.println("LogOff Successful!");
			logger.info("LogOff Successful!");
		} else {
			System.out.println("LogOff UnSuccessful!");
			logger.info("LogOff UnSuccessful!");
		}
	}

	@DataProvider
	public Object[][] getloginData() throws IOException {
		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxSearchname");
		String sheetname = PropertyReader.ReadProperty("loginsheetname");
		System.out.println("filepath : " + filepath + "  " + filename);
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}
	@DataProvider
	public Object[][] getSearchData() throws IOException {
		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath + PropertyReader.ReadProperty("subfolderpath");
		String filename = PropertyReader.ReadProperty("xlsxSearchname");
		String sheetname = PropertyReader.ReadProperty("searchsheetname");
		System.out.println("filepath : " + filepath + "  " + filename);
		return ExcelReader.ReadExcelToObjectArr(filepath, filename, sheetname);
	}

	@AfterTest
	private void CloseBrowser() throws InterruptedException {
		
		 com.project.utilities.CloseBrowser.emptyBrowser(driver);
	}

}
