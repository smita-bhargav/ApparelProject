package com.project.utilities;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.project.pageobject.SignInParam;

import lombok.extern.java.Log;

@Log
public class ApparelSiginOut {

	public static JavascriptExecutor apparelSignIn(WebDriver driver, Hashtable<String, String> dataxl)
			throws Exception {
		JavascriptExecutor js;

		try {

			SignInParam signinDetail = new SignInParam(driver);
			signinDetail.getLgnClickbtn().click();
			Thread.sleep(2000);
			signinDetail.SignInDetails(dataxl.get("email"), dataxl.get("password"));

			System.out.println("Get login detail of the Current Record - " + signinDetail.getEmailTextbox());
			log.info("Get login detail of the Current Record - " + signinDetail.getEmailTextbox());
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", ""); // scroll down
			signinDetail.getSbmtBtn().click();
		} catch (Exception e) {
			TakingScreenShots.capturescreen(driver, "ApparelSignInError");
			throw (e);
		}
		return js;
	}

	public static void signOut(WebDriver driver) throws IOException {
		JavascriptExecutor js;
		try {
			SignInParam shareProdlogObj = new SignInParam(driver);
			js = (JavascriptExecutor) driver;

			js.executeScript("window.scrollBy(0,-250)", ""); // scroll up
			WebElement logOf = shareProdlogObj.getLogoutClickbtn();

			if (logOf.getText().equalsIgnoreCase("Sign out")) {
				TakingScreenShots.capturescreen(driver, "ApparelSignOut");
				logOf.click();
				log.info("LogOff Successful!");
			} else {
				log.info("LogOff UnSuccessful!");
			}

		} catch (Exception e) {
			TakingScreenShots.capturescreen(driver, "ApparelSearchError");
			throw (e);
		}

	}

}
