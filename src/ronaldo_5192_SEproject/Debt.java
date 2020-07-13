package ronaldo_5192_SEproject;

import java.util.ArrayList;

public class Debt {
	
	private String typeDebt;
	private String dateDebt;
	private float valueDebt;
	
	private PaymentMethod paymentMethod;
	private ArrayList<Contestation> contestations;
	private ArrayList<Installment> installments;
	
	public Debt(String typeDebt, String dateDebt, float valueDebt) {
		this.typeDebt = typeDebt;
		this.dateDebt = dateDebt;
		this.valueDebt = valueDebt;
		
		this.paymentMethod = null;
		this.contestations = new ArrayList<Contestation>();
		this.installments = new ArrayList<Installment>();
	}

	public String getTypeDebt() {
		return typeDebt;
	}

	public void setTypeDebt(String typeDebt) {
		this.typeDebt = typeDebt;
	}

	public String getDateDebt() {
		return dateDebt;
	}

	public void setDateDebt(String dateDebt) {
		this.dateDebt = dateDebt;
	}

	public float getValueDebt() {
		return valueDebt;
	}

	public void setValueDebt(float valueDebt) {
		this.valueDebt = valueDebt;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ArrayList<Contestation> getContestations() {
		return contestations;
	}

	public void setContestations(ArrayList<Contestation> contestations) {
		this.contestations = contestations;
	}

	public ArrayList<Installment> getInstallments() {
		return installments;
	}

	public void setInstallments(ArrayList<Installment> installments) {
		this.installments = installments;
	}
	
	public void addInstallment(Installment installment) {
		this.installments.add(installment);
	}
	
	public void addContestation(Contestation contestation) {
		this.contestations.add(contestation);
	}
	
	public void printDebt() {
		System.out.println("Debt Date: " + this.dateDebt + " | Debt Value: " + this.valueDebt + " | Debt Type " + this.typeDebt);
		
		if (paymentMethod == null)
			System.out.println("Debt has NO payment");
		else
			paymentMethod.printPayment();

		if (installments.size() == 0)
			System.out.println("Debt has NO installment");
		else {
			System.out.println("#Installments: " + installments.size());
			
			for (int i=0; i<installments.size(); i++)
				installments.get(i).printInstallment();		
		}
		
		if (contestations.size() == 0)
			System.out.println("Debt has NO contestation");
		else {
			System.out.println("#Contestation: " + contestations.size());			

			for (int i=0; i<contestations.size(); i++)
				contestations.get(i).printContestation();		
		}
	}
}
