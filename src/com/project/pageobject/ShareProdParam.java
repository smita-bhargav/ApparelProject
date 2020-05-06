package com.project.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

public class ShareProdParam {
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
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_reviewDress1_Xpath)
	private WebElement reviewdress1;
	
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_reviewDress2_Xpath)
	private WebElement reviewdress2;
	
	/*****Pin Interest****/
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_pin_Xpath)
	private WebElement pinInterestclk;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_pinlgnid_Xpath)
	private WebElement pinLgnId;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_pinlgnpsswd_Xpath)
	private WebElement pinLgnPswd;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_pinlgnsbmt_Xpath)
	private WebElement pinLgnSbtmt;
	
	/*****Facebook****/
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_facebook_Xpath)
	private WebElement facebookClk;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_facebklgn_Xpath)
	private WebElement facebookLgnId;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_facebkpswrd_Xpath)
	private WebElement facebookLgnPswrd;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_facebkSbmt_Xpath)
	private WebElement facebookSbmit;
	
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_facebkCancel_Xpath)
	private WebElement facebookCancel;
	/******Google Share******/
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_shr_google_Xpath)
	private WebElement googleShareClk;

	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
	
	
	WebDriver driver; //local to this page
	public ShareProdParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getGoogleShareClk() {
		return googleShareClk;
	}

	public void setGoogleShareClk(WebElement googleShareClk) {
		this.googleShareClk = googleShareClk;
	}
	
	public WebElement getLogoutClickbtn() {
		return logoutClickbtn;
	}

	public void setLogoutClickbtn(WebElement logoutClickbtn) {
		this.logoutClickbtn = logoutClickbtn;
	}
	
	public WebElement getFacebookClk() {
		return facebookClk;
	}


	public void setFacebookClk(WebElement facebookClk) {
		this.facebookClk = facebookClk;
	}


	public WebElement getFacebookSbmit() {
		return facebookSbmit;
	}


	public void setFacebookSbmit(WebElement facebookSbmit) {
		this.facebookSbmit = facebookSbmit;
	}


	public WebElement getFacebookCancel() {
		return facebookCancel;
	}


	public void setFacebookCancel(WebElement facebookCancel) {
		this.facebookCancel = facebookCancel;
	}
	public void setfacebookLgnId(String lgn){
		facebookLgnId.clear();
		facebookLgnId.sendKeys(lgn);
	}
	
	public String getfacebookLgnId(){
		
		return facebookLgnId.getAttribute("value");
	}
	
	public void setfacebookPsswrd(String pwd){
		facebookLgnPswrd.clear();
		facebookLgnPswrd.sendKeys(pwd);
	}
	
	public String getfacebookPsswrd(){
		
		return facebookLgnPswrd.getAttribute("value");
	}

	public void setpinLgnId(String lgn){
		pinLgnId.clear();
		pinLgnId.sendKeys(lgn);
	}
	
	public String getpinLgnId(){
		
		return pinLgnId.getAttribute("value");
	}
	public void setpinLgnPswd(String pwd){
		pinLgnPswd.clear();
		pinLgnPswd.sendKeys(pwd);
	}
	
	public String getpinLgnPswd(){
		
		return pinLgnPswd.getAttribute("value");
	}

	public WebElement getPinLgnSbtmt() {
		return pinLgnSbtmt;
	}

	public void setPinLgnSbtmt(WebElement pinLgnSbtmt) {
		this.pinLgnSbtmt = pinLgnSbtmt;
	}

	
	public WebElement getReviewdress1() {
		return reviewdress1;
	}

	public void setReviewdress1(WebElement reviewdress1) {
		this.reviewdress1 = reviewdress1;
	}

	public WebElement getReviewdress2() {
		return reviewdress2;
	}

	public void setReviewdress2(WebElement reviewdress2) {
		this.reviewdress2 = reviewdress2;
	}

	public void setSearchBox(String srch){
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}
	
	public String getSearchBox(){
		
		return searchTextbox.getAttribute("value");
	}
	public WebElement getPinInterestClk() {
		return pinInterestclk;
	}
	public void setPinInterestClk(WebElement pinInterest) {
		this.pinInterestclk = pinInterest;
	}

	
	public WebElement getSearchSbmtBtn() {
		return searchSbmtBtn;
	}

	public void setSearchSbmtBtn(WebElement searchSbmtBtn) {
		this.searchSbmtBtn = searchSbmtBtn;
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
	
	 public void SignInDetails(String email, String passwd){
		   
			setEmail(email);
			setPwd(passwd);
			
	}
	 public void SearchDetail(String searchapprl,String clickdress){
		   //System.out.println(searchapprl+ " clickdress  : "+clickdress);
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
