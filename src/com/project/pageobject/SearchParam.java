package com.project.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class SearchParam {

	@CacheLookup
	@FindBy(id = ObjectRepos.ApparelPage.APPAREL_SR_SEARCHTXT_ID)
	private @Getter WebElement searchTextbox;

	@CacheLookup
	@FindBy(xpath = ObjectRepos.ApparelPage.APPAREL_CR_SERCHSBMT_XPATH)
	private @Getter @Setter WebElement searchSbmtBtn;

	@CacheLookup
	@FindBy(xpath = ObjectRepos.ApparelPage.APPAREL_SERCH_DRESS_XPATH)
	private @Getter @Setter WebElement dresscount;

	WebDriver driver; // local to this page

	public SearchParam(WebDriver driver) {
		this.driver = driver; // this drive is passed from my testcase - getting
								// assigned to my local driver
		// in the page and connection is established
		PageFactory.initElements(driver, this);
	}

	public void setSearchBox(String srch) {
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}

	public void SearchInDetails(String searchapprl) {

		setSearchBox(searchapprl);
	}

}
