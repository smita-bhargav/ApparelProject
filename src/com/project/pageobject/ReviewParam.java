package com.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

public class ReviewParam {
	
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
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_commntform_Xpath)
	private WebElement clickCommntlnk;
	

	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_rw_commnttitle_id)
	private WebElement reviewtitle;
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_rw_content_id)
	private WebElement reviewcontent;
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.apparel_rw_subnewmsg_id)
	private WebElement reviewmsg;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_reviewDress1_Xpath)
	private WebElement reviewdress1;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_reviewDress2_Xpath)
	private WebElement reviewdress2;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_ok_Xpath)
	private WebElement reviewOkBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_close_Xpath)
	private WebElement reviewClosepopUp;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
	
	
	WebDriver driver; //local to this page
	public ReviewParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogoutClickbtn() {
		return logoutClickbtn;
	}
	public void setLogoutClickbtn(WebElement logoutClickbtn) {
		this.logoutClickbtn = logoutClickbtn;
	}
	
	public WebElement getReviewClosepopUp() {
		return reviewClosepopUp;
	}
	public void setReviewClosepopUp(WebElement reviewClosepopUp) {
		this.reviewClosepopUp = reviewClosepopUp;
	}
	public WebElement getReviewOkBtn() {
		return reviewOkBtn;
	}

	public void setReviewOkBtn(WebElement reviewOkBtn) {
		this.reviewOkBtn = reviewOkBtn;
	}
	public WebElement getReviewdress2() {
		return reviewdress2;
	}

	public void setReviewdress2(WebElement reviewdress2) {
		this.reviewdress2 = reviewdress2;
	}
	public WebElement getReviewdress1() {
		return reviewdress1;
	}

	public void setReviewdress1(WebElement reviewdress1) {
		this.reviewdress1 = reviewdress1;
	}
	public WebElement getReviewmsg() {
		return reviewmsg;
	}

	public void setReviewmsg(WebElement reviewmsg) {
		this.reviewmsg = reviewmsg;
	}

	public WebElement getSearchSbmtBtn() {
		return searchSbmtBtn;
	}

	public void setSearchSbmtBtn(WebElement searchSbmtBtn) {
		this.searchSbmtBtn = searchSbmtBtn;
	}

	
	public void setReviewTitleBox(String title){
		reviewtitle.clear();
		reviewtitle.sendKeys(title);
	}
	
	public String getReviewTitleBox(){
		
		return reviewtitle.getAttribute("value");
	}
	public void setContentTxtBox(String revwcnt){
		reviewcontent.clear();
		reviewcontent.sendKeys(revwcnt);
	}
	
	public String getContentTxtBox(){
		
		return reviewcontent.getAttribute("value");
	}
	
	public WebElement getClickCommntlnk() {
		return clickCommntlnk;
	}

	public void setClickCommntlnk(WebElement clickCommntlnk) {
		this.clickCommntlnk = clickCommntlnk;
	}
	
	public void setSearchBox(String srch){
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}
	
	public String getSearchBox(){
		
		return searchTextbox.getAttribute("value");
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
   public void ReviewDress(String title,String comnt){
	  // System.out.println(title+" : "+comnt);
	   setReviewTitleBox(title);
	   setContentTxtBox(comnt);
	  
	  // WebElement seldress_Xpath=driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'"+clickdress+"')]"));
	  //System.out.println("seldress_Xpath  : "+seldress_Xpath); 
	  // setSelectedDress(seldress_Xpath);
		
		
	} 

}
