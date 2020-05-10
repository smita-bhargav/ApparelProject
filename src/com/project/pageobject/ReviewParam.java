package com.project.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.objectMap.ObjectRepos;

import lombok.Getter;
import lombok.Setter;

public class ReviewParam{
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_SR_SEARCHTXT_ID)
	private @Getter WebElement searchTextbox;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CR_SERCHSBMT_XPATH)
	private @Getter @Setter WebElement searchSbmtBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_COMNTFORM_XPATH)
	private @Getter @Setter WebElement clickCommntlnk;
	

	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_RW_COMN_TITLE_ID)
	private @Getter WebElement reviewtitle;
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_RW_CONTENT_ID)
	private @Getter WebElement reviewcontent;
	
	@CacheLookup
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_RW_SUBNEWMSG_ID)
	private @Getter @Setter WebElement reviewmsg;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_REVIEWDRESS1_XPATH)
	private @Getter @Setter WebElement reviewdress1;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_REVIEWDRESS2_XPATH)
	private @Getter @Setter WebElement reviewdress2;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_RW_OK_XPATH)
	private @Getter @Setter WebElement reviewOkBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.PPAREL_RW_CLOSE_XPATH)
	private @Getter @Setter WebElement reviewClosepopUp;
	
	
	WebDriver driver; //local to this page
	public ReviewParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	

	public void setReviewTitleBox(String title){
		reviewtitle.clear();
		reviewtitle.sendKeys(title);
	}	
	public void setContentTxtBox(String revwcnt){
		reviewcontent.clear();
		reviewcontent.sendKeys(revwcnt);
	}
		
	public void setSearchBox(String srch){
		searchTextbox.clear();
		searchTextbox.sendKeys(srch);
	}
   
   public void SearchDetail(String searchapprl,String clickdress){
	   setSearchBox(searchapprl);
   }
   public void ReviewDress(String title,String comnt){
	   setReviewTitleBox(title);
	   setContentTxtBox(comnt);
	 	
	} 

}
