package ronaldo_5192_SEproject;

public abstract class PaymentMethod {
	
	private double valuePayment;
	private String typePayment;
	private String datePayment;
	private boolean recurrent;

	public PaymentMethod(double valuePayment, String typePayment, String datePayment, boolean recurrent) {
		this.valuePayment = valuePayment;
		this.typePayment = typePayment;
		this.datePayment = datePayment;
		this.recurrent = recurrent;
	}

	public String getTypePayment() {
		return typePayment;
	}

	public void setTypePayment(String typePayment) {
		this.typePayment = typePayment;
	}

	public String getDatePayment() {
		return datePayment;
	}

	public void setDatePayment(String datePayment) {
		this.datePayment = datePayment;
	}

	public boolean isRecurrent() {
		return recurrent;
	}

	public void setRecurrent(boolean recurrent) {
		this.recurrent = recurrent;
	}
	
	public double getValuePayment() {
		return valuePayment;
	}

	public void setValuePayment(double valuePayment) {
		this.valuePayment = valuePayment;
	}

	abstract void printPayment();
}
