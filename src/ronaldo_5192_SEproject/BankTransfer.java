package ronaldo_5192_SEproject;

public class BankTransfer extends PaymentMethod {
	
	private String name;
	private String branch;
	private String bank;
	private String number;
	private String codeBranch;
	
	public BankTransfer(double valuePayment, String typePayment, String datePayment, boolean recurrent, String name, String branch, String bank, String number, String codeBranch) {
		super(valuePayment, typePayment, datePayment, recurrent);
		this.name = name;
		this.branch = branch;
		this.bank = bank;
		this.number = number;
		this.codeBranch = codeBranch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	};
	
	public String getCodeBranch() {
		return codeBranch;
	}

	public void setCodeBranch(String codeBranch) {
		this.codeBranch = codeBranch;
	}

	public void printPayment() {
		System.out.println("Account Name: " + this.name + 
				"\nAccount Number: " + this.number + 
				"\nAccount Branch: " + this.branch + " - code: " + this.codeBranch + 
				"\nAccount Bank: " + this.bank);	
	}
}
