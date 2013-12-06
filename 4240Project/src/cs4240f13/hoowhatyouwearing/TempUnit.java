package cs4240f13.hoowhatyouwearing;

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
	
	public static TempUnit convert(String temp) {
		if (temp.toLowerCase().equals("fahrenheit"))
			return TempUnit.FAHRENHEIT;
		else {
			return TempUnit.CELCIUS;
		}
	}
}
