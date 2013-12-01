package cs4240f13.hoowhatyouwearing.objects;

import cs4240f13.hoowhatyouwearing.utility.XmlBuilder;

public class User {
	private static final User CONTEXT = new User();
	
	
	private User() {
		
	}
	
	public static User getContext() {
		return CONTEXT;
	}
	
	private static void populate() {
		XmlBuilder.createIfMissing();
		// still building.
	}
	
	
}
