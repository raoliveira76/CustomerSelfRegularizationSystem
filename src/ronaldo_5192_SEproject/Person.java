package ronaldo_5192_SEproject;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private String birthDate;
	private boolean logonStatus;
	
	public Person(String firstName, String lastName, String birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public boolean getLogonStatus() {
		return this.logonStatus;
	}
	
	public void setLogonStatus(boolean logonStatus) {
		this.logonStatus = logonStatus;
	}
}
