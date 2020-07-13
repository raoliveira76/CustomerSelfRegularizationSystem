package ronaldo_5192_SEproject;

import java.util.ArrayList;

public class Customer extends Person {

	private String firstPurchase;
	private String lastPurchase;
	private int numPurchases;
	private String city;
	private String state;
	
	private ArrayList<Debt> debts;
	
	public Customer(String firstName, String lastName, String birthDate, String firstPurchase, String lastPurchase, int numPurchases, String city, String state) {
		
		super(firstName, lastName, birthDate);
		
		this.firstPurchase = firstPurchase;
		this.lastPurchase = lastPurchase;
		this.numPurchases = numPurchases;
		this.city = city;
		this.state = state;
		
		this.debts = new ArrayList<Debt>();
	}

	public String getFirstPurchase() {
		return firstPurchase;
	}

	public void setFirstPurchase(String firstPurchase) {
		this.firstPurchase = firstPurchase;
	}

	public String getLastPurchase() {
		return lastPurchase;
	}

	public void setLastPurchase(String lastPurchase) {
		this.lastPurchase = lastPurchase;
	}

	public int getNumPurchases() {
		return numPurchases;
	}

	public void setNumPurchases(int numPurchases) {
		this.numPurchases = numPurchases;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public ArrayList<Debt> getDebts() {
		return debts;
	}

	public void setDebts(ArrayList<Debt> debts) {
		this.debts = debts;
	}
	
	public void addDebt(Debt debt) {
		this.debts.add(debt);
	}
	
	public void printCustomer() {
		System.out.println("Customer: " + super.getFirstName() + " " + super.getLastName() + " | BirthDate: " + super.getBirthDate() + " | City: " + this.city);
		System.out.println("Number of purchases: " + this.numPurchases + " | First Purchase: " + this.firstPurchase + " | Last Purchase: " + this.lastPurchase);
		
		if (debts.size() == 0)
			System.out.println("Customer has NO debts");
		else {
			System.out.println("#Debts: " + debts.size());
			
			for (int i=0; i<debts.size(); i++)
				debts.get(i).printDebt();
		}
	}
}
