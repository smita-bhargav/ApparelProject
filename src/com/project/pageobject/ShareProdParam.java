package com.project.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

import lombok.Getter;
import lombok.Setter;

public class ShareProdParam {
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_SR_SEARCHTXT_ID)
	private @Getter WebElement searchTextbox;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CR_SERCHSBMT_XPATH)
	private @Getter @Setter WebElement searchSbmtBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_REVIEWDRESS1_XPATH)
	private  @Getter @Setter  WebElement reviewdress1;
	
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_REVIEWDRESS2_XPATH)
	private  @Getter @Setter  WebElement reviewdress2;
	
	/*****Pin Interest****/
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_PIN_XPATH)
	private  @Getter @Setter WebElement pinInterestclk;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_PINLGNID_XPATH)
	private @Getter WebElement pinLgnId;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_PINLGNPASSWD_XPATH)
	private @Getter WebElement pinLgnPswd;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_PINLGNSBMT_XPATH)
	private  @Getter @Setter WebElement pinLgnSbtmt;
	
	/*****Facebook****/
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_FACEBOOK_XPATH)
	private  @Getter @Setter  WebElement facebookClk;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_FACEBKLGN_XPATH)
	private @Getter WebElement facebookLgnId;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_FACEBKPSWRD_XPATH)
	private @Getter WebElement facebookLgnPswrd;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_FACEBKSBMT_XPATH)
	private @Getter @Setter WebElement facebookSbmit;
	
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_FACEBHKCANCEL_XPATH)
	private @Getter @Setter WebElement facebookCancel;
	/******Google Share******/
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SHR_GOOGLE_XPATH)
	private @Getter @Setter WebElement googleShareClk;

	
	WebDriver driver; //local to this page
	public ShareProdParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	
	public void setfacebookLgnId(String lgn){
		facebookLgnId.clear();
		facebookLgnId.sendKeys(lgn);
	}
	
	
	public void setfacebookPsswrd(String pwd){
		facebookLgnPswrd.clear();
		facebookLgnPswrd.sendKeys(pwd);
	}
	
	
	public void setpinLgnId(String lgn){
		pinLgnId.clear();
		pinLgnId.sendKeys(lgn);
	}
	
	public void setpinLgnPswd(String pwd){
		pinLgnPswd.clear();
		pinLgnPswd.sendKeys(pwd);
	}
	public void setSearchBox(String srch){
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}
	public void SearchDetail(String searchapprl,String clickdress){
		
		   setSearchBox(searchapprl);
	  }
	 
	 public void PinInterestLogin(String email,String password)
	 {
		 setpinLgnId(email);
		 setpinLgnPswd(password);
	 }
	 public void FaceBookLogin(String email,String password)
	 {
		 setfacebookLgnId(email);
		 setfacebookPsswrd(password);
	 }
	  
		  
}
