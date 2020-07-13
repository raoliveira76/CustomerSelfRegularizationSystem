package ronaldo_5192_SEproject;

import java.util.ArrayList;

public class DebtManager extends Manager{
	
	private float limitValue;
	private ArrayList<Criteria> criteria;
	
	public DebtManager(String firstName, String lastName, String birthDate, String type, String department,	String lastView, float limitValue) {
		super(firstName, lastName, birthDate, type, department, lastView);
		this.limitValue = limitValue;
		
		this.criteria = new ArrayList<Criteria>();
	}

	public float getLimitValue() {
		return limitValue;
	}

	public void setLimitValue(float limitValue) {
		this.limitValue = limitValue;
	}

	public ArrayList<Criteria> getCriteria() {
		return criteria;
	}

	public void setCriteria(ArrayList<Criteria> criteria) {
		this.criteria = criteria;
	}
}
