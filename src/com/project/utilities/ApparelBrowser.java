package com.project.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApparelBrowser {

	static WebDriver driver = null;

	public static WebDriver launchBrowser(String browsername) throws IOException {

		if (browsername.equalsIgnoreCase(PropertyReader.ReadProperty("browserchrome"))) {

			System.setProperty(PropertyReader.ReadProperty("chromeproperty"),
					PropertyReader.ReadProperty("chromedriverpath"));
			driver = new ChromeDriver();
			// System.out.println("Thread id: "+Thread.currentThread().getId());

		} else if (browsername.equalsIgnoreCase(PropertyReader.ReadProperty("browsergecko"))) {

			System.setProperty(PropertyReader.ReadProperty("geckoproperty"),
					PropertyReader.ReadProperty("geckodriverpath"));
			driver = new FirefoxDriver();
			// System.out.println("Thread id: "+Thread.currentThread().getId());

		} else if (browsername.equalsIgnoreCase(PropertyReader.ReadProperty("browserie"))) {
			System.setProperty(PropertyReader.ReadProperty("ieproperty"), PropertyReader.ReadProperty("iedriverpath"));
			driver = new InternetExplorerDriver();
			// System.out.println("Thread id: "+Thread.currentThread().getId());

		} else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get(PropertyReader.ReadProperty("appurl"));

		return driver;
	}

}
