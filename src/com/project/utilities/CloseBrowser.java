package com.project.utilities;

import org.openqa.selenium.WebDriver;

public class CloseBrowser {

	public static WebDriver emptyBrowser(WebDriver driver) throws InterruptedException{
		
		Thread.sleep(4000);
		if(driver!=null){
			driver.quit();
		}
		return driver;
	}
	
	

}
