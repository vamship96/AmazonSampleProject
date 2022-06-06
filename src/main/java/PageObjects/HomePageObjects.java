package PageObjects;

import static PageObjects.ObjectLocator.*;

public enum HomePageObjects implements PageObjects {
	
	txt_Username("#nav-link-accountList-nav-line-1",XPATH,"logged username text"),
	txtBx_SearchBox("#twotabsearchtextbox",XPATH,"Search textbox on Home Page"),
	input_drpDwn("select#searchDropdownBox",CSS,"category DropDown"),
	opt_Dropdown("search-alias=electronics",CSS,"Electronics Option"),
	lnk_firstOption("//div.sg-row",XPATH,"item row"),
	lnk_AccountList("//a[@id='nav-link-accountList']",XPATH,"Account and List Link"),
	opt_YourAccount("//span[contains (text(), 'Your Account')]",XPATH,"your account options"),
	lnk_SelectAll("//a[@id='select-all']",XPATH,"Select All link on Cart"),
	
	//Item page
	btn_AddToCart("//input[@id='add-to-cart-button']",XPATH,"Add To Cart button"),
	btn_CartOnOverlay("//form[@id='attach-view-cart-button-form']/span/span/input",XPATH,"Cart button on Cart Frame"),
	
	//Accounts page
	btn_PaymentOptions("//img[@alt='Payment options']",XPATH,"Payment Options on accounts page"),
	hdr_SavedCards("//h3[contains (text(), 'Your saved credit and debit cards')]",XPATH,"Saved Cards header"),
	btn_AddDebitOrCreditCard("//span[@id='apx-add-credit-card-action-test-id']/span/span/input",XPATH,"Add Debit or Credit Card Button"),
	
	
	//credit card debit card pop up
	hdr_CreditDebitCardPopUp("//h4[contains (text(), 'Add a credit or debit card')]",XPATH," Add Debit card and credit card pop up Header"),
	txtBx_CardNumber("//form[@class='apx-add-card-compact-form a-spacing-none']/descendant::input[@name='addCreditCardNumber']",XPATH,"Credit Card Number"),
	txtBX_NameOnCard("//form[@class='apx-add-card-compact-form a-spacing-none']/descendant::input[@name='ppw-accountHolderName']",XPATH," Name on Card Text Box"),
	
	btn_GlobalCart("//a[@id='nav-cart']",XPATH,"Cart Button on Header"),
	lnk_DeselectAll("//a[@id='deselect-all']",XPATH,"Deselect all Items cart Link"),
	
	
	
	;

	String strProperty ="";
	ObjectLocator locatorType = null;
	String strObjName = "";
	
	private HomePageObjects(String strPropertyvalue, ObjectLocator locatorType, String strObjName)
	{
		this.strProperty = strPropertyvalue;
		this.locatorType = locatorType;
		this.strObjName = strObjName;
		
	}

	@Override
	public String getProperty() {
		// TODO Auto-generated method stub
		return strProperty;
	}

	@Override
	public ObjectLocator getLocatorType() {
		// TODO Auto-generated method stub
		return locatorType;
	}

	@Override
	public String getObjectname() {
		// TODO Auto-generated method stub
		return strObjName;
	}


}
