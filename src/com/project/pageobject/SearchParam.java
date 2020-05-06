package com.project.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

public class SearchParam {
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_mail_id)
	private WebElement emailTextbox;

	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_pwd_id)
	private WebElement pwdTextbox;
	
	@CacheLookup
	@FindBy(className=ObjectRepos.ApparelPage.apparel_lgnclk_class)
	private WebElement lgnClickbtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_sbmt_Xpath)
	private WebElement sbmtBtn;
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_sr_serchtxt_id)
	private WebElement searchTextbox;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_sr_serchsbmt_Xpath)
	private WebElement searchSbmtBtn;

	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
    
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_sr_dresscount_Xpath)
	private WebElement dresscount;
	
	WebDriver driver; //local to this page
	public SearchParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getDresscount() {
		return dresscount;
	}
	public void setDresscount(WebElement dresscount) {
		this.dresscount = dresscount;
	}
	public WebElement getLogoutClickbtn() {
		return logoutClickbtn;
	}


	public void setLogoutClickbtn(WebElement logoutClickbtn) {
		this.logoutClickbtn = logoutClickbtn;
	}
	
	public WebElement getSearchSbmtBtn() {
		return searchSbmtBtn;
	}
	public void setSearchSbmtBtn(WebElement searchSbmtBtn) {
		this.searchSbmtBtn = searchSbmtBtn;
	}
	
	public WebElement getSbmtBtn() {
		return sbmtBtn;
	}
	public void setSbmtBtn(WebElement sbmtBtn) {
		this.sbmtBtn = sbmtBtn;
	}
	public WebElement getLgnClickbtn() {
		return lgnClickbtn;
	}
	public void setLgnClickbtn(WebElement lgnClickbtn) {
		this.lgnClickbtn = lgnClickbtn;
	}
	public void setEmail(String emal){
		emailTextbox.clear();
		emailTextbox.sendKeys(emal);
	}
	
	public String getEmail(){
		
		return emailTextbox.getAttribute("value");
	}
	
	public void setPwd(String pwd){
		pwdTextbox.clear();
		pwdTextbox.sendKeys(pwd);
	}
	
	public String getPwd(){
   
		return pwdTextbox.getAttribute("value");
	}
	public void SignInDetails(String email, String passwd){
		
		setEmail(email);
		setPwd(passwd);
		
	}

	public void setSearchBox(String srch){
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}
	
	public String getSearchBox(){
		
		return searchTextbox.getAttribute("value");
	}
	public void SearchInDetails(String searchapprl){
		
		setSearchBox(searchapprl);
	}            	  

}
