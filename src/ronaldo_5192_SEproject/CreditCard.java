package ronaldo_5192_SEproject;

public class CreditCard extends PaymentMethod {
	
	private String number;
	private String name;
	private String expireDate;
	private String cvc;
	private String brand;
	
	public CreditCard(double valuePayment, String typePayment, String datePayment, boolean recurrent, String number, String name, String expireDate, String cvc, String brand) {
		super(valuePayment, typePayment, datePayment, recurrent);
		this.number = number;
		this.name = name;
		this.expireDate = expireDate;
		this.cvc = cvc;
		this.brand = brand;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void printPayment() {		
		System.out.println("Credit Card Name: " + this.name +
				"\nCredit Card Number: " + this.number + 
				"\nBrand: " + this.brand + " | Expire Date: " + this.expireDate + " | CVC: " + this.cvc);
	}
}
