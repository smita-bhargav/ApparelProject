package com.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.project.objectMap.ObjectRepos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public @Data class PlaceOrdParam{
	
		
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_MANIMENU_XPATH)
	private WebElement mainMenu;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_SUBMENU1_XPATH)
	private WebElement submenu1;
		
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_SUBMENU2_XPATH)
	private WebElement submenu2;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_SUBMENU3_XPATH)
	private WebElement submenu3;
		
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_SELECTDRESS_XPATH)
	private WebElement selectDress;
		
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_ADDCART_XPATH)
	private WebElement addtoCartbtn;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SUMMERCOL_XPATH)
	private WebElement summercolDress;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_CONTINUE_XPATH)
	private WebElement continuShoping;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_PROCEED_XPATH)
	private WebElement proceedShoping;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_INSTOCK_XPATH)
	private WebElement instockBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CHECKOUT_XPATH)
	private WebElement checkoutBtn;

	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_ADDRESSCHECKOUT_XPATH)
	private WebElement addrescheckBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_AGREEECOND_XPATH)
	private WebElement agrCondBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CARRPROCESS_XPATH)
	private WebElement carrProcBtn;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_BANKPAY_XPATH)
	private WebElement bankPayBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CONFIRMORDER_XPATH)
	private WebElement confrmOrdBtn;
	//Manufacturer Elements
    @CacheLookup
    @FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_MANUFACT_SELECT_XPATH)
    private WebElement manufactRadio;
    
    @FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_MANUFACT_COUNT_XPATH)
    private WebElement manufactCount;
	

	WebDriver driver; //local to this page
	public PlaceOrdParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}

}

