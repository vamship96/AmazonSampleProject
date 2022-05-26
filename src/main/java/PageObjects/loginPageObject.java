package PageObjects;

import static PageObjects.ObjectLocator.*;

public enum loginPageObject implements PageObjects{
	
	btn_SignIn("text = Hello, Sign in",XPATH,"Sign In button"),
	txtBx_UserName("//input[@id='ap_email']",XPATH,"User name Text box"),
	btn_Continue("//input[@id = 'continue']", XPATH, "Continue button on Sign in Screen"),
	txtBx_Password("#ap_password",CSS,"Password textbox"),
	btn_Submit("#signInSubmit",CSS,"Submit Button"),
	
	
	
	
	;
	
	
	String strProperty ="";
	ObjectLocator locatorType = null;
	String strObjName = "";
	
	private loginPageObject(String strPropertyvalue, ObjectLocator locatorType, String strObjName)
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
