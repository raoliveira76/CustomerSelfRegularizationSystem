package ronaldo_5192_SEproject;

public abstract class Manager extends Person {
	
	private String type;
	private String department;
	private String lastView;
	
	public Manager(String firstName, String lastName, String birthDate, String type, String department,	String lastView) {
		super(firstName, lastName, birthDate);
		this.type = type;
		this.department = department;
		this.lastView = lastView;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLastView() {
		return lastView;
	}

	public void setLastView(String lastView) {
		this.lastView = lastView;
	}
}
