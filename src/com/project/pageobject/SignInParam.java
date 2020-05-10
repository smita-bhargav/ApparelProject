package com.project.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

import lombok.Getter;
import lombok.Setter;

public class SignInParam {
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_MAIL_ID)
	private @Getter WebElement emailTextbox;

	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_PWD_ID)
	private @Getter WebElement pwdTextbox;

	@CacheLookup
	@FindBy(className=ObjectRepos.ApparelPage.APPAREL_LGNCLK_CLASS)
	private @Getter @Setter WebElement lgnClickbtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SBMT_XPATH)
	private @Getter @Setter WebElement sbmtBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_ERROR_XPATH)
	private @Getter @Setter List<WebElement> errorAlrt;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_LOGOUT_XPATH)
	private @Getter @Setter WebElement logoutClickbtn;
	
	
	WebDriver driver; //local to this page
	public SignInParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	
	
	public void setEmailTextbox(String emal){
		emailTextbox.clear();
		emailTextbox.sendKeys(emal);
	}
	
		
	public void setpwdTextbox(String pwd){
		pwdTextbox.clear();
		pwdTextbox.sendKeys(pwd);
	}
	
	public void SignInDetails(String email, String passwd){
		
		setEmailTextbox(email);
		setpwdTextbox(passwd);
		
	}

}
