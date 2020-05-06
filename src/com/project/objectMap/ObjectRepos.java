package com.project.objectMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepos {
	
	public static class ApparelPage{
		
		//Sign In
		public static final String apparel_lgnclk_class = "login";
		public static final String apparel_mail_id = "email";
		public static final String apparel_pwd_id = "passwd";
		public static final String apparel_sbmt_Xpath = "//p[@class='submit']//span[1]";
		public static final String apparel_error_Xpath = "//body[@id='authentication']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]";
		public static final String apparel_logout_Xpath = "//a[@class='logout']";
		
		//Login creation
		public static final String apparel_cr_email_id = "email_create";
		
		public static final String apparel_cr_create_accnt_xpath ="//form[@id='create-account_form']//span[1]";
		public static final String apparel_cr_titleList_name = "id_gender";
		
		public static final String apparel_cr_custfirst_id = "customer_firstname";
		public static final String apparel_cr_custlast_id = "customer_lastname";
		public static final String apparel_cr_pwd_id = "passwd";
		public static final String apparel_cr_days_id = "days";
		public static final String apparel_cr_months_id="months";
		public static final String apparel_cr_years_id ="years";
		public static final String apparel_cr_firstname_id="firstname";
		public static final String apparel_cr_lastname_id="lastname";
		public static final String apparel_cr_cmpny_id="company";
		public static final String apparel_cr_addres_id="address1";
		public static final String apparel_cr_addres2_id="address2";
		public static final String apparel_cr_city_id="city";
		public static final String apparel_cr_state_id="id_state";
		public static final String apparel_cr_postcode_id="postcode";
		public static final String apparel_cr_country_id="id_country";
		public static final String apparel_cr_info_id="other";
		public static final String apparel_cr_phone_id="phone";
		public static final String apparel_cr_mobile_id="phone_mobile";
		
		public static final String apparel_cr_alias_Xpath="//input[@id='alias']";
		public static final String apparel_cr_register_Xpath="//span[contains(text(),'Register')]";
		public static final String apparel_cr_error="//div[@class='alert alert-danger']";
		//Search Apparel
		public static final String apparel_sr_serchtxt_id="search_query_top";
		public static String getApparelCheckoutXpath() {
			return apparel_checkout_Xpath;
		}
		public static String getApparelAgreecondXpath() {
			return apparel_agreecond_Xpath;
		}
		public static String getApparelCarrprocessXpath() {
			return apparel_carrProcess_Xpath;
		}
		public static String getApparelBankpayXpath() {
			return apparel_bankpay_Xpath;
		}
		public static String getApparelConfrmorderXpath() {
			return apparel_confrmOrder_Xpath;
		}
		public static final String apparel_sr_serchsbmt_Xpath="//button[@name='submit_search']";
		public static final String apparel_sr_dresscount_Xpath="//span[@class='heading-counter']";
		
		//Review Apparel
		public static final String apparel_rw_commntform_Xpath="//a[@class='open-comment-form']";
		public static final String apparel_rw_commnttitle_id="comment_title";
		public static final String apparel_rw_content_id="content";
		public static final String apparel_rw_subnewmsg_id="submitNewMessage";
		public static final String apparel_rw_ok_Xpath="//span[contains(text(),'OK')]";
		public static final String apparel_rw_close_Xpath="//a[@class='fancybox-item fancybox-close']";
		
		public static final String apparel_rw_reviewDress1_Xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]";
		public static final String apparel_rw_reviewDress2_Xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Faded Short Sleeve T-shirts')]";
		
		//SharedProduct									
		public static final String apparel_shr_pin_Xpath="//button[@class='btn btn-default btn-pinterest']";
		public static final String apparel_shr_pinlgn_Xpath="//div[@class='tBJ dyH iFc yTZ erh tg7 mWe']";
		public static final String apparel_shr_pinlgnid_Xpath="//input[@id='email']";
		public static final String apparel_shr_pinlgnpsswd_Xpath="//input[@id='password']";
		public static final String apparel_shr_pinlgnsbmt_Xpath="//div[contains(text(),'Log in')]";
		public static final String apparel_shr_pinlgnoutid_Xpath="";
		
		public static final String apparel_shr_facebook_Xpath="//button[@class='btn btn-default btn-facebook']";
		public static final String apparel_shr_facebklgn_Xpath="//input[@id='email']";
		public static final String apparel_shr_facebkpswrd_Xpath="//input[@id='pass']";
		public static final String apparel_shr_facebkSbmt_Xpath="//input[@id='u_0_0']";
		public static final String apparel_shr_facebkCancel_Xpath="//button[@id='u_0_26']";
		
		public static final String apparel_shr_google_Xpath="//button[@class='btn btn-default btn-google-plus']";
		//public static final String apparel_shr_googlelgn_Xpath="//*[@id='identifierId']";
		//public static final String apparel_shr_googlenxtbtn_Xpath="//*[@id='identifierNext']/span/span";
		
		//Placing Order  									  
		public static final String apparel_rw_mainMenu_Xpath="//*[@id='block_top_menu']/ul/li/a[@title='Dresses']";
		public static final String apparel_rw_SubMenu1_Xpath="//a[@class='subcategory-name'][contains(text(),'Casual Dresses')]";
		public static final String apparel_rw_SubMenu2_Xpath="//a[@class='subcategory-name'][contains(text(),'Evening Dresses')]";
		public static final String apparel_rw_SubMenu3_Xpath="//a[@class='subcategory-name'][contains(text(),'Summer Dresses')]";
		public static final String apparel_addCart_Xpath="//span[contains(text(),'Add to cart')]";
		public static final String apparel_instock_Xpath="//span[@class='available-now']";
		public static final String apparel_checkout_Xpath="//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
		public static final String apparel_addrscheckout_Xpath="//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]";
		public static final String apparel_agreecond_Xpath="//input[@id='cgv']";
		public static final String apparel_carrProcess_Xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]";
		public static final String apparel_bankpay_Xpath="//a[@class='bankwire']";
		public static final String apparel_confrmOrder_Xpath="//span[contains(text(),'I confirm my order')]";
		
		public static final String apparel_summercol_Xpath="//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";
		public static final String apparel_rw_selectDress_Xpath="//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Dress')]";
		
		public static final String apparel_rw_continue_Xpath="//span[@class='continue btn btn-default button exclusive-medium']//span[1]";		
		public static final String apparel_rw_proceed_Xpath="//span[contains(text(),'Proceed to checkout')]";
			    
	    //Manufacturer
		public static final String apparel_manufact_selct_Xpath="//input[@id='layered_manufacturer_1']";
		public static final String apparel_manufact_count_Xpath="//div[@class='top-pagination-content clearfix']//div[@class='product-count']";
		
	}

}
