package cs4240f13.hoowhatyouwearing.utility;

public enum TempUnit {
	FAHRENHEIT("imperial"),
	CELCIUS("metric");
	
	private final String apiKeyword;
	
	TempUnit(String apiKeyword) {
		this.apiKeyword = apiKeyword;
	}
	
	public String getApiKeyword() {
		return apiKeyword;
	}
}
