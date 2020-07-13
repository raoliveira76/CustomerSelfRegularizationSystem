package ronaldo_5192_SEproject;

import java.util.ArrayList;

public class Installment {
	
	private String dateInstallments;
	private float valueInstallments;
	private String firstPayment;
	private String frequency;
	
	private ArrayList<Criteria> criteria;
	
	public Installment(String dateInstallments, float valueInstallments, String firstPayment, String frequency) {
		this.dateInstallments = dateInstallments;
		this.valueInstallments = valueInstallments;
		this.firstPayment = firstPayment;
		this.frequency = frequency;
		
		this.criteria = new ArrayList<Criteria>();
	}

	public String getDateInstallments() {
		return dateInstallments;
	}

	public void setDateInstallments(String dateInstallments) {
		this.dateInstallments = dateInstallments;
	}

	public float getValueInstallments() {
		return valueInstallments;
	}

	public void setValueInstallments(float valueInstallments) {
		this.valueInstallments = valueInstallments;
	}

	public String getFirstPayment() {
		return firstPayment;
	}

	public void setFirstPayment(String firstPayment) {
		this.firstPayment = firstPayment;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	
	public ArrayList<Criteria> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<Criteria> criteria) {
		this.criteria = criteria;
	}
	
	public void addCriteria(Criteria criteria) {
		this.criteria.add(criteria);
	}
	
	public void generateContract() {
		System.out.println("Contract generated successfully! \n**method not implemented**");
	}

	public void printInstallment() {
		System.out.println("Installment Date: " + this.dateInstallments + " | Installment Value: " + this.valueInstallments + " | Frequency: " + 
				this.frequency + " | First Payment: " + this.firstPayment);
		
		if (criteria.size() == 0)
			System.out.println("Installment has NO criteria");
		else {
			System.out.println("#Criteria: " + criteria.size());
			
			for (int i=0; i<criteria.size(); i++)
				criteria.get(i).printCriteria();		
		}
	}
}
