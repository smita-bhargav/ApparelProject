package com.project.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.project.objectMap.ObjectRepos;

import lombok.Getter;
import lombok.Setter;

public class UserCreateParam {

JavascriptExecutor js ;
	
	@CacheLookup
	// @FindBy(id="email")
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_EMAIL_ID)
	private @Getter @Setter WebElement emailTextbox;
	
	@CacheLookup
	@FindBy(className=ObjectRepos.ApparelPage.APPAREL_LGNCLK_CLASS)
	private  @Getter @Setter WebElement lgnClickbtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_SBMT_XPATH)
	private  @Getter @Setter WebElement sbmtBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_LOGOUT_XPATH)
	private  @Getter @Setter WebElement logoutClickbtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CR_CREATE_ACCNT_XPATH)
	private @Getter @Setter WebElement createAcntSbmt;
	
	
	@FindBy(name=ObjectRepos.ApparelPage.APPAREL_CR_TITLELIST_NAME)
	private @Getter List<WebElement>  titleRadiobtn;
	
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_CUSTFIRST_ID)
	private @Getter WebElement custfirstTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_CUSTLAST_ID)
	private @Getter WebElement custlastTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_PWD_ID)
	private @Getter WebElement paswrdTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_DAYS_ID)
	private @Getter WebElement dayDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_MONTHS_ID)
	private @Getter WebElement mnthDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_YEARS_ID)
	private @Getter WebElement yearDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPREL_CR_FIRSTNAME_ID)
	private @Getter WebElement firstnameTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_LASTNAME_ID)
	private @Getter WebElement lastnameTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_ADRESS_ID)
	private @Getter WebElement addressTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_ADRESS2_ID)
	private @Getter WebElement address2Textbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_CMPNY_ID)
	private @Getter WebElement cmpnyTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_CITY_ID)
	private @Getter WebElement cityTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_STATE_ID)
	private @Getter WebElement stateDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_POSTCODE_ID)
	private @Getter WebElement postcodeTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_COUNTRY_ID)
	private @Getter WebElement cntryDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_INFO_ID)
	private @Getter WebElement otherInfoTextArea;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_PHN_ID)
	private @Getter WebElement phoneTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.APPAREL_CR_MOBILE_ID)
	private @Getter WebElement mobileTextbox;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPREL_CR_ALIAS_XPATH)
	private @Getter WebElement aliasTextbox;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.APPAREL_CR_REGISTER_XPATH)
	private @Getter @Setter WebElement registerSbmt;
	 
	
	WebDriver driver; //local to this page
	public UserCreateParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	public void setEmail(String email){
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
	}
	
	
	
	public void setCustFirstName(String custfirstnm){
		custfirstTextbox.clear();
		custfirstTextbox.sendKeys(custfirstnm);
	}
	
	public void setcustlastTextbox(String custlastnm){
		custlastTextbox.clear();
		custlastTextbox.sendKeys(custlastnm);
	}
	
	public void setpaswrdTextbox(String pwd){
		paswrdTextbox.clear();
		paswrdTextbox.sendKeys(pwd);
	}
	
	public void setdayDrpdwn(String day){
		dayDrpdwn.clear();
		dayDrpdwn.sendKeys(day);
	}
	
	public void setmnthDrpdwn(String mnth){
		mnthDrpdwn.clear();
		mnthDrpdwn.sendKeys(mnth);
	}
	
	public void setyearDrpdwn(String yr){
		yearDrpdwn.clear();
		yearDrpdwn.sendKeys(yr);
	}
	
	public void setfirstnameTextbox(String fname){
		firstnameTextbox.clear();
		firstnameTextbox.sendKeys(fname);
	}
	
	public void setlastnameTextbox(String lname){
		lastnameTextbox.clear();
		lastnameTextbox.sendKeys(lname);
	}
	
	public void setaddressTextbox(String address){
		addressTextbox.clear();
		addressTextbox.sendKeys(address);
	}
	
	public void setaddress2Textbox(String address2){
		address2Textbox.clear();
		address2Textbox.sendKeys(address2);
	}
	
	public void setcmpnyTextbox(String cmpny){
		cmpnyTextbox.clear();
		cmpnyTextbox.sendKeys(cmpny);
	}
	
	public void setcityTextbox(String city){
		cityTextbox.clear();
		cityTextbox.sendKeys(city);
	}
	
	public void setstateDrpdwn(String state){
		stateDrpdwn.clear();
		stateDrpdwn.sendKeys(state);
	}
	
	public void setpostcodeTextbox(String pcode){
		postcodeTextbox.clear();
		postcodeTextbox.sendKeys(pcode);
	}
	
	public void setcntryDrpdwn(String cntry){
		cntryDrpdwn.clear();
		cntryDrpdwn.sendKeys(cntry);
	}
	
	public void setotherInfoTextArea(String info){
		otherInfoTextArea.clear();
		otherInfoTextArea.sendKeys(info);
	}
	
	
	public void setphoneTextbox(String phone){
		phoneTextbox.clear();
		phoneTextbox.sendKeys(phone);
	}
	
	public void setmobileTextbox(String mobile){
		mobileTextbox.clear();
		mobileTextbox.sendKeys(mobile);
	}
	
	
	public void setaliasTextbox(String alias){
		aliasTextbox.clear();
		aliasTextbox.sendKeys(alias);
	}
	
	public void accountDetail(String email){
		setEmail(email);
	}
	public void createAccount(String title,String custfirstnm,String custlastnm,String pwd,String day,String mnth,String yr, String fname, String lname,String cmpny,String address,String address2,String city,String state, String pcode ,String cntry,String info,String phone,String mobile,String alias)
	{
		
		//setCreateAccnt(craccount);
		//setTitle(title);
		if(titleRadiobtn.size()>0){
			for(WebElement gender:titleRadiobtn){
				if(gender.getAttribute("value").equals(title)){
					if(!gender.isSelected()){
						gender.click();
						break;
					}
				}
			}
		}
		setCustFirstName(custfirstnm);
		setcustlastTextbox(custlastnm);
		setpaswrdTextbox(pwd);
		//setDay(day);
		 Select day_selection = new Select(dayDrpdwn);
		 day_selection.selectByValue(day);
		 
		 Select mnth_selection = new Select(mnthDrpdwn);
		 mnth_selection.selectByVisibleText(mnth+" ");
	    
	     Select year_selection = new Select(yearDrpdwn);
	     year_selection.selectByValue(yr);
		 		
		   
		//setMnth(mnth);
		//setYear(yr);
		  js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,250)", ""); //scroll down
		setfirstnameTextbox(fname);
		setlastnameTextbox(lname);
		setcmpnyTextbox(cmpny);
		setaddressTextbox(address);
		setaddress2Textbox(address2);
		setcityTextbox(city);
		 Select cntry_selection = new Select(cntryDrpdwn);
		    
		 cntry_selection.selectByVisibleText(cntry);
		  if(!cntry_selection.getFirstSelectedOption().getText().equals("-"))
		  { Select stata_selection = new Select(stateDrpdwn);
		  //select by value
		   stata_selection.selectByVisibleText(state);
		   
		//setState(state);
		  setpostcodeTextbox(pcode);
		  }
		//setCntry(cntry);
		setotherInfoTextArea(info);
	    setphoneTextbox(phone);
	    setmobileTextbox(mobile);
		setaliasTextbox(alias);
		//setRegister(reg);
		
	}

}	


