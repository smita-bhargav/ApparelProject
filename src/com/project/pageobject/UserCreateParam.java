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

public class UserCreateParam {

JavascriptExecutor js ;
	
	@CacheLookup
	// @FindBy(id="email")
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_email_id)
	private WebElement emailTextbox;
	
	@CacheLookup
	@FindBy(className=ObjectRepos.ApparelPage.apparel_lgnclk_class)
	private WebElement lgnClickbtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_sbmt_Xpath)
	private WebElement sbmtBtn;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_cr_create_accnt_xpath)
	private WebElement createAcntSbmt;
	
	
	@FindBy(name=ObjectRepos.ApparelPage.apparel_cr_titleList_name)
	private List<WebElement>  titleRadiobtn;
	
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_custfirst_id)
	private WebElement custfirstTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_custlast_id)
	private WebElement custlastTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_pwd_id)
	private WebElement paswrdTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_days_id)
	private WebElement dayDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_months_id)
	private WebElement mnthDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_years_id)
	private WebElement yearDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_firstname_id)
	private WebElement firstnameTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_lastname_id)
	private WebElement lastnameTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_addres_id)
	private WebElement addressTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_addres2_id)
	private WebElement address2Textbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_cmpny_id)
	private WebElement cmpnyTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_city_id)
	private WebElement cityTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_state_id)
	private WebElement stateDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_postcode_id)
	private WebElement postcodeTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_country_id)
	private WebElement cntryDrpdwn;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_info_id)
	private WebElement otherInfoTextArea;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_phone_id)
	private WebElement phoneTextbox;
	
	@FindBy(id=ObjectRepos.ApparelPage.apparel_cr_mobile_id)
	private WebElement mobileTextbox;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_cr_alias_Xpath)
	private WebElement aliasTextbox;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_cr_register_Xpath)
	private WebElement registerSbmt;
	 
	public WebElement getCreateAcntSbmt() {
		return createAcntSbmt;
	}
	public void setCreateAcntSbmt(WebElement createAcntSbmt) {
		this.createAcntSbmt = createAcntSbmt;
	}
	public WebElement getLgnClickbtn() {
		return lgnClickbtn;
	}
	public void setLgnClickbtn(WebElement lgnClickbtn) {
		this.lgnClickbtn = lgnClickbtn;
	}
	public WebElement getRegisterSbmt() {
		return registerSbmt;
	}
	public void setRegisterSbmt(WebElement registerSbmt) {
		this.registerSbmt = registerSbmt;
	}
	public WebElement getLogoutClickbtn() {
		return logoutClickbtn;
	}
	public void setLogoutClickbtn(WebElement logoutClickbtn) {
		this.logoutClickbtn = logoutClickbtn;
	}
	public WebElement getSbmtBtn() {
		return sbmtBtn;
	}
	public void setSbmtBtn(WebElement sbmtBtn) {
		this.sbmtBtn = sbmtBtn;
	}
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
	
	public String getEmail(){
   
		return emailTextbox.getAttribute("value");
	}

	
	
	public void setCustFirstName(String custfirstnm){
		custfirstTextbox.clear();
		custfirstTextbox.sendKeys(custfirstnm);
	}
	
	public String getCustFirstName(){
   
		return custfirstTextbox.getAttribute("value");
	}
	public void setCustLastName(String custlastnm){
		custlastTextbox.clear();
		custlastTextbox.sendKeys(custlastnm);
	}
	
	public String getCustLastName(){
   
		return custlastTextbox.getAttribute("value");
	}
	public void setPwd(String pwd){
		paswrdTextbox.clear();
		paswrdTextbox.sendKeys(pwd);
	}
	
	public String getPwd(){
   
		return paswrdTextbox.getAttribute("value");
	}
	public void setDay(String day){
		dayDrpdwn.clear();
		dayDrpdwn.sendKeys(day);
	}
	
	public String getDay(){
   
		return dayDrpdwn.getAttribute("value");
	}
	public void setMnth(String mnth){
		mnthDrpdwn.clear();
		mnthDrpdwn.sendKeys(mnth);
	}
	
	public String getMnth(){
   
		return mnthDrpdwn.getAttribute("value");
	}
	public void setYear(String yr){
		yearDrpdwn.clear();
		yearDrpdwn.sendKeys(yr);
	}
	
	public String getYear(){
   
		return yearDrpdwn.getAttribute("value");
	}
	public void setFrstName(String fname){
		firstnameTextbox.clear();
		firstnameTextbox.sendKeys(fname);
	}
	
	public String getFrstName(){
   
		return firstnameTextbox.getAttribute("value");
	}
	public void setLastName(String lname){
		lastnameTextbox.clear();
		lastnameTextbox.sendKeys(lname);
	}
	
	public String getLastName(){
   
		return lastnameTextbox.getAttribute("value");
	}
	public void setAddress(String address){
		addressTextbox.clear();
		addressTextbox.sendKeys(address);
	}
	
	public String getAddress(){
   
		return addressTextbox.getAttribute("value");
	}
	public void setAddress2(String address2){
		address2Textbox.clear();
		address2Textbox.sendKeys(address2);
	}
	
	public String getAddress2(){
   
		return address2Textbox.getAttribute("value");
	}
	public void setCmpny(String cmpny){
		cmpnyTextbox.clear();
		cmpnyTextbox.sendKeys(cmpny);
	}
	
	public String getCmpny(){
   
		return cmpnyTextbox.getAttribute("value");
	}
	public void setCity(String city){
		cityTextbox.clear();
		cityTextbox.sendKeys(city);
	}
	
	public String getCity(){
   
		return cityTextbox.getAttribute("value");
	}
	public void setState(String state){
		stateDrpdwn.clear();
		stateDrpdwn.sendKeys(state);
	}
	
	public String getState(){
   
		return stateDrpdwn.getAttribute("value");
	}
	public void setPstCode(String pcode){
		postcodeTextbox.clear();
		postcodeTextbox.sendKeys(pcode);
	}
	
	public String getPstCode(){
   
		return postcodeTextbox.getAttribute("value");
	}
	public void setCntry(String cntry){
		cntryDrpdwn.clear();
		cntryDrpdwn.sendKeys(cntry);
	}
	
	public String getCntry(){
   
		return cntryDrpdwn.getAttribute("value");
	}
	public void setOtherInfo(String info){
		otherInfoTextArea.clear();
		otherInfoTextArea.sendKeys(info);
	}
	
	public String getOtherInfo(){
   
		return otherInfoTextArea.getAttribute("value");
	}
	
	
	public void setPhone(String phone){
		phoneTextbox.clear();
		phoneTextbox.sendKeys(phone);
	}
	
	public String getPhone(){
   
		return phoneTextbox.getAttribute("value");
	}
	public void setMobile(String mobile){
		mobileTextbox.clear();
		mobileTextbox.sendKeys(mobile);
	}
	
	public String getMobile(){
   
		return mobileTextbox.getAttribute("value");
	}
	
	public void setAlias(String alias){
		aliasTextbox.clear();
		aliasTextbox.sendKeys(alias);
	}
	
	public String getAlias(){
   
		return aliasTextbox.getAttribute("value");
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
		setCustLastName(custlastnm);
		setPwd(pwd);
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
		setFrstName(fname);
		setLastName(lname);
		setCmpny(cmpny);
		setAddress(address);
		setAddress2(address2);
		setCity(city);
		 Select cntry_selection = new Select(cntryDrpdwn);
		    
		 cntry_selection.selectByVisibleText(cntry);
		  if(!cntry_selection.getFirstSelectedOption().getText().equals("-"))
		  { Select stata_selection = new Select(stateDrpdwn);
		  //select by value
		   stata_selection.selectByVisibleText(state);
		   
		//setState(state);
		 setPstCode(pcode);
		  }
		//setCntry(cntry);
	    setOtherInfo(info);
		setPhone(phone);
		setMobile(mobile);
		setAlias(alias);
		//setRegister(reg);
		
	}

}	


