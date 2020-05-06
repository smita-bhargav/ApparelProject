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

public class PlaceOrdParam {
	
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
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_mainMenu_Xpath)
	private WebElement mainMenu;
	
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_SubMenu1_Xpath)
	private WebElement submenu1;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_SubMenu2_Xpath)
	private WebElement submenu2;
	
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_SubMenu3_Xpath)
	private WebElement submenu3;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_selectDress_Xpath)
	private WebElement selectDress;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_addCart_Xpath)
	private WebElement addtoCartbtn;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_summercol_Xpath)
	private WebElement summercolDress;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_continue_Xpath)
	private WebElement continuShoping;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_rw_proceed_Xpath)
	private WebElement proceedShoping;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_instock_Xpath)
	private WebElement instockBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_checkout_Xpath)
	private WebElement checkoutBtn;

	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_addrscheckout_Xpath)
	private WebElement addrescheckBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_agreecond_Xpath)
	private WebElement agrCondBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_carrProcess_Xpath)
	private WebElement carrProcBtn;
	
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_bankpay_Xpath)
	private WebElement bankPayBtn;
	
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_confrmOrder_Xpath)
	private WebElement confrmOrdBtn;
	//Manufacturer Elements
    @CacheLookup
    @FindBy(xpath=ObjectRepos.ApparelPage.apparel_manufact_selct_Xpath)
    private WebElement manufactRadio;
    
    @FindBy(xpath=ObjectRepos.ApparelPage.apparel_manufact_count_Xpath)
    private WebElement manufactCount;
	
	@CacheLookup
	@FindBy(xpath=ObjectRepos.ApparelPage.apparel_logout_Xpath)
	private WebElement logoutClickbtn;
	

	WebDriver driver; //local to this page
	public PlaceOrdParam(WebDriver driver) {
		this.driver = driver; //this drive is passed from my testcase - getting assigned to my local driver
		//in the page and connection is established
		PageFactory.initElements(driver, this);
	}
	public WebElement getAddrescheckBtn() {
		return addrescheckBtn;
	}

	public void setAddrescheckBtn(WebElement addrescheckBtn) {
		this.addrescheckBtn = addrescheckBtn;
	}

	public WebElement getAgrCondBtn() {
		return agrCondBtn;
	}

	public void setAgrCondBtn(WebElement agrCondBtn) {
		this.agrCondBtn = agrCondBtn;
	}

	public WebElement getCarrProcBtn() {
		return carrProcBtn;
	}

	public void setCarrProcBtn(WebElement carrProcBtn) {
		this.carrProcBtn = carrProcBtn;
	}

	public WebElement getBankPayBtn() {
		return bankPayBtn;
	}

	public void setBankPayBtn(WebElement bankPayBtn) {
		this.bankPayBtn = bankPayBtn;
	}

	public WebElement getConfrmOrdBtn() {
		return confrmOrdBtn;
	}

	public void setConfrmOrdBtn(WebElement confrmOrdBtn) {
		this.confrmOrdBtn = confrmOrdBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public void setCheckoutBtn(WebElement checkoutBtn) {
		this.checkoutBtn = checkoutBtn;
	}
	public WebElement getInstockBtn() {
		return instockBtn;
	}
	public void setInstockBtn(WebElement instockBtn) {
		this.instockBtn = instockBtn;
	}
	public WebElement getLogoutClickbtn() {
		return logoutClickbtn;
	}

	public void setLogoutClickbtn(WebElement logoutClickbtn) {
		this.logoutClickbtn = logoutClickbtn;
	}
	
	public WebElement getManufactCount() {
		return manufactCount;
	}

	public void setManufactCount(WebElement manufactCount) {
		this.manufactCount = manufactCount;
	}
	public WebElement getManufactRadio() {
		return manufactRadio;
	}
	public void setManufactRadio(WebElement manufactRadio) {
		this.manufactRadio = manufactRadio;
	}
	public WebElement getProceedShoping() {
		return proceedShoping;
	}

	public void setProceedShoping(WebElement proceedShoping) {
		this.proceedShoping = proceedShoping;
	}
	public WebElement getContinuShoping() {
		return continuShoping;
	}

	public void setContinuShoping(WebElement continuShoping) {
		this.continuShoping = continuShoping;
	}
	public WebElement getMainMenu() {
		return mainMenu;
	}
	public void setMainMenu(WebElement mainMenu) {
		this.mainMenu = mainMenu;
	}
	public WebElement getSubmenu1() {
		return submenu1;
	}
	public void setSubmenu(WebElement submenu1) {
		
	
		this.submenu1 = submenu1;
	}
	public WebElement getSubmenu2() {
		return submenu2;
	}

	public void setSubmenu2(WebElement submenu2) {
		this.submenu2 = submenu2;
	}

	public WebElement getSubmenu3() {
		return submenu3;
	}

	public void setSubmenu3(WebElement submenu3) {
		this.submenu3 = submenu3;
	}
	
	public WebElement getAddtoCartbtn() {
		return addtoCartbtn;
	}

	public void setAddtoCartbtn(WebElement addtoCartbtn) {
		this.addtoCartbtn = addtoCartbtn;
	}
	public WebElement getSummercolDress() {
		return summercolDress;
	}

	public void setSummercolDress(WebElement summercolDress) {
		this.summercolDress = summercolDress;
	}
	public WebElement getSelectDress() {
		return selectDress;
	}
	public void setSelectDress(WebElement selectDress) {
		this.selectDress = selectDress;
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

