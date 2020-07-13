package ronaldo_5192_SEproject;

import java.util.ArrayList;

public class Dashboard {

	private String owner;
	private String updateInterval;
	private String lastUpdate;
		
	private ArrayList<Customer> customers;
	private ArrayList<Debt> debts;
	private ArrayList<Installment> installments;

	public Dashboard(String owner, String updateInterval, String lastUpdate) {
		this.owner = owner;
		this.updateInterval = updateInterval;
		this.lastUpdate = lastUpdate;
		
		this.customers = new ArrayList<Customer>();
		this.debts = new ArrayList<Debt>();
		this.installments = new ArrayList<Installment>();
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getUpdateInterval() {
		return updateInterval;
	}

	public void setUpdateInterval(String updateInterval) {
		this.updateInterval = updateInterval;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Debt> getDebts() {
		return debts;
	}

	public void setDebts(ArrayList<Debt> debts) {
		this.debts = debts;
	}

	public ArrayList<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(ArrayList<Installment> installments) {
		this.installments = installments;
	}

	public void generateDashboard() {

		System.out.println("------------------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------  DASHBOARD ---------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------------------");
		
		System.out.println("Owner: " + this.owner + "\nInterval Update: " + this.updateInterval + "\nLast Update: " + this.lastUpdate + "\n");
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		if (customers.size() == 0)
			System.out.println("No Customer in the Dashboard");
		else {
			System.out.println("Total Customers: " + customers.size() + "\n");
			
			for (int i=0; i<customers.size(); i++) {
				System.out.println("** Customer #" + (i+1));
				customers.get(i).printCustomer();
				System.out.println();
			}
		}

		System.out.println("------------------------------------------------------------------------------------------------------");
		if (debts.size() == 0)
			System.out.println("No Debts in the Dashboard");
		else {
			System.out.println("Total Debts: " + debts.size() + "\n");
			
			for (int i=0; i<debts.size(); i++){
				System.out.println("** Debt #" + (i+1));
				debts.get(i).printDebt();
				System.out.println();
			}
		}
		
		System.out.println("------------------------------------------------------------------------------------------------------");
		if (installments.size() == 0)
			System.out.println("No Installments in the Dashboard");
		else {
			System.out.println("Total Installments: " + installments.size() + "\n");
			
			for (int i=0; i<installments.size(); i++){
				System.out.println("** Installment #" + (i+1));
				installments.get(i).printInstallment();
				System.out.println();
			}
		}
		
		System.out.println("------------------------------------------------------------------------------------------------------");
	}
	
	public void generateReport() {
		System.out.println("Report successfully created - ** method not implemented **");		
	}

	public void generateProjection() {
		System.out.println("Projection successfully created - ** method not implemented **");				
	}	
}
