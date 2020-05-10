package com.project.objectMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjectRepos {

	public static class ApparelPage {

		// Sign In
		public static final String APPAREL_LGNCLK_CLASS = "login";
		public static final String APPAREL_MAIL_ID = "email";
		public static final String APPAREL_PWD_ID = "passwd";
		public static final String APPAREL_SBMT_XPATH = "//p[@class='submit']//span[1]";
		public static final String APPAREL_ERROR_XPATH = "//body[@id='authentication']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[1]";
		public static final String APPAREL_LOGOUT_XPATH = "//a[@class='logout']";

		// Login creation
		public static final String APPAREL_CR_EMAIL_ID = "email_create";

		public static final String APPAREL_CR_CREATE_ACCNT_XPATH = "//form[@id='create-account_form']//span[1]";
		public static final String APPAREL_CR_TITLELIST_NAME = "id_gender";

		public static final String APPAREL_CR_CUSTFIRST_ID = "customer_firstname";
		public static final String APPAREL_CR_CUSTLAST_ID = "customer_lastname";
		public static final String APPAREL_CR_PWD_ID = "passwd";
		public static final String APPAREL_CR_DAYS_ID = "days";
		public static final String APPAREL_CR_MONTHS_ID = "months";
		public static final String APPAREL_CR_YEARS_ID = "years";
		public static final String APPREL_CR_FIRSTNAME_ID = "firstname";
		public static final String APPAREL_CR_LASTNAME_ID = "lastname";
		public static final String APPAREL_CR_CMPNY_ID = "company";
		public static final String APPAREL_CR_ADRESS_ID = "address1";
		public static final String APPAREL_CR_ADRESS2_ID = "address2";
		public static final String APPAREL_CR_CITY_ID = "city";
		public static final String APPAREL_CR_STATE_ID = "id_state";
		public static final String APPAREL_CR_POSTCODE_ID = "postcode";
		public static final String APPAREL_CR_COUNTRY_ID = "id_country";
		public static final String APPAREL_CR_INFO_ID = "other";
		public static final String APPAREL_CR_PHN_ID = "phone";
		public static final String APPAREL_CR_MOBILE_ID = "phone_mobile";

		public static final String APPREL_CR_ALIAS_XPATH = "//input[@id='alias']";
		public static final String APPAREL_CR_REGISTER_XPATH = "//span[contains(text(),'Register')]";
		public static final String APPAREL_CR_ERROR_XPATH = "//div[@class='alert alert-danger']";
		// Search Apparel
		public static final String APPAREL_SR_SEARCHTXT_ID = "search_query_top";

		public static String getApparelCheckoutXpath() {
			return APPAREL_CHECKOUT_XPATH;
		}

		public static String getApparelAgreecondXpath() {
			return APPAREL_AGREEECOND_XPATH;
		}

		public static String getApparelCarrprocessXpath() {
			return APPAREL_CARRPROCESS_XPATH;
		}

		public static String getApparelBankpayXpath() {
			return APPAREL_BANKPAY_XPATH;
		}

		public static String getApparelConfrmorderXpath() {
			return APPAREL_CONFIRMORDER_XPATH;
		}

		public static final String APPAREL_CR_SERCHSBMT_XPATH = "//button[@name='submit_search']";
		public static final String APPAREL_SERCH_DRESS_XPATH = "//span[@class='heading-counter']";

		// Review Apparel
		public static final String APPAREL_RW_COMNTFORM_XPATH = "//a[@class='open-comment-form']";
		public static final String APPAREL_RW_COMN_TITLE_ID = "comment_title";
		public static final String APPAREL_RW_CONTENT_ID = "content";
		public static final String APPAREL_RW_SUBNEWMSG_ID = "submitNewMessage";
		public static final String APPAREL_RW_OK_XPATH = "//span[contains(text(),'OK')]";
		public static final String PPAREL_RW_CLOSE_XPATH = "//a[@class='fancybox-item fancybox-close']";

		public static final String APPAREL_RW_REVIEWDRESS1_XPATH = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]";
		public static final String APPAREL_RW_REVIEWDRESS2_XPATH = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Faded Short Sleeve T-shirts')]";

		// SharedProduct
		public static final String APPAREL_SHR_PIN_XPATH = "//button[@class='btn btn-default btn-pinterest']";
		public static final String APPAREL_SHR_PINLGN_XPATH = "//div[@class='tBJ dyH iFc yTZ erh tg7 mWe']";
		public static final String APPAREL_SHR_PINLGNID_XPATH = "//input[@id='email']";
		public static final String APPAREL_SHR_PINLGNPASSWD_XPATH = "//input[@id='password']";
		public static final String APPAREL_SHR_PINLGNSBMT_XPATH = "//div[contains(text(),'Log in')]";
		public static final String APPAREL_SHR_PINLGNOUTID_XPATH = "";

		public static final String APPAREL_SHR_FACEBOOK_XPATH = "//button[@class='btn btn-default btn-facebook']";
		public static final String APPAREL_SHR_FACEBKLGN_XPATH = "//input[@id='email']";
		public static final String APPAREL_SHR_FACEBKPSWRD_XPATH = "//input[@id='pass']";
		public static final String APPAREL_SHR_FACEBKSBMT_XPATH = "//input[@id='u_0_0']";
		public static final String APPAREL_SHR_FACEBHKCANCEL_XPATH = "//button[@id='u_0_26']";

		public static final String APPAREL_SHR_GOOGLE_XPATH = "//button[@class='btn btn-default btn-google-plus']";
		// public static final String
		// apparel_shr_googlelgn_Xpath="//*[@id='identifierId']";
		// public static final String
		// apparel_shr_googlenxtbtn_Xpath="//*[@id='identifierNext']/span/span";

		// Placing Order
		public static final String APPAREL_RW_MANIMENU_XPATH = "//*[@id='block_top_menu']/ul/li/a[@title='Dresses']";
		public static final String APPAREL_RW_SUBMENU1_XPATH = "//a[@class='subcategory-name'][contains(text(),'Casual Dresses')]";
		public static final String APPAREL_RW_SUBMENU2_XPATH = "//a[@class='subcategory-name'][contains(text(),'Evening Dresses')]";
		public static final String APPAREL_RW_SUBMENU3_XPATH = "//a[@class='subcategory-name'][contains(text(),'Summer Dresses')]";
		public static final String APPAREL_ADDCART_XPATH = "//span[contains(text(),'Add to cart')]";
		public static final String APPAREL_INSTOCK_XPATH = "//span[@class='available-now']";
		public static final String APPAREL_CHECKOUT_XPATH = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
		public static final String APPAREL_ADDRESSCHECKOUT_XPATH = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]";
		public static final String APPAREL_AGREEECOND_XPATH = "//input[@id='cgv']";
		public static final String APPAREL_CARRPROCESS_XPATH = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]";
		public static final String APPAREL_BANKPAY_XPATH = "//a[@class='bankwire']";
		public static final String APPAREL_CONFIRMORDER_XPATH = "//span[contains(text(),'I confirm my order')]";

		public static final String APPAREL_SUMMERCOL_XPATH = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 last-line last-item-of-tablet-line last-mobile-line']//a[@class='product-name'][contains(text(),'Printed Summer Dress')]";
		public static final String APPAREL_RW_SELECTDRESS_XPATH = "//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Dress')]";

		public static final String APPAREL_RW_CONTINUE_XPATH = "//span[@class='continue btn btn-default button exclusive-medium']//span[1]";
		public static final String APPAREL_RW_PROCEED_XPATH = "//span[contains(text(),'Proceed to checkout')]";

		// Manufacturer
		public static final String APPAREL_MANUFACT_SELECT_XPATH = "//input[@id='layered_manufacturer_1']";
		public static final String APPAREL_MANUFACT_COUNT_XPATH = "//div[@class='top-pagination-content clearfix']//div[@class='product-count']";

	}

}
