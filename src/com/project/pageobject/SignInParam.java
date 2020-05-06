package com.project.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

public class SignInParam {
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
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_error_Xpath)
	private List<WebElement> errorAlrt;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
	
	
	WebDriver driver; //local to this page
	public SignInParam(WebDriver driver) {
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
	public List<WebElement> getErrorAlrt() {
		return errorAlrt;
	}
	public void setErrorAlrt(List<WebElement> errorAlrt) {
		this.errorAlrt = errorAlrt;
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

}
