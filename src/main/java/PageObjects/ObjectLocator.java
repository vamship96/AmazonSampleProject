package PageObjects;

public enum ObjectLocator {
	
	CSS("CSS"),
	LINKTEXT("LINKTEXT"),
	XPATH("XPATH"),
	ID("ID"),
	PARTIALLINKTEXT("PARTIALLINKTEXT"),
	CLASS("CLASS"),
	CLASSNAME("CLASSNAME"),
	NAME("NAME"),
	TAG("TAG");

	String strLocator = "";
	
	private ObjectLocator(String strLocator) {
		
		this.strLocator = this.strLocator;
	}
	
	@Override
	public String toString()
	{
		return strLocator;
	}
	
	

}
