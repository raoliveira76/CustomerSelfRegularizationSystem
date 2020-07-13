package ronaldo_5192_SEproject;

public class FinancialManager extends Manager {
	
	private String forecastType;
	private String target;
	private String[] indicators;

	public FinancialManager(String firstName, String lastName, String birthDate, String type, 
			String department, String lastView, String forecastType) {
		super(firstName, lastName, birthDate, type, department, lastView);
		this.forecastType = forecastType;
	}

	public String getForecastType() {
		return forecastType;
	}

	public void setForecastType(String forecastType) {
		this.forecastType = forecastType;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String[] getIndicators() {
		return indicators;
	}

	public void setIndicators(String[] indicators) {
		this.indicators = indicators;
	}
}
