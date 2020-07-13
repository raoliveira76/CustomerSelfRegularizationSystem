package ronaldo_5192_SEproject;

public class Criteria {
	
	private String typeProgram;
	private String startProgram;
	private String endProgram;
	private String descriptionProgram;
	
	public Criteria(String typeProgram, String startProgram, String endProgram, String descriptionProgram) {
		this.typeProgram = typeProgram;
		this.startProgram = startProgram;
		this.endProgram = endProgram;
		this.descriptionProgram = descriptionProgram;
	}

	public String getTypeProgram() {
		return typeProgram;
	}

	public void setTypeProgram(String typeProgram) {
		this.typeProgram = typeProgram;
	}

	public String getStartProgram() {
		return startProgram;
	}

	public void setStartProgram(String startProgram) {
		this.startProgram = startProgram;
	}

	public String getEndProgram() {
		return endProgram;
	}

	public void setEndProgram(String endProgram) {
		this.endProgram = endProgram;
	}

	public String getDescriptionProgram() {
		return descriptionProgram;
	}

	public void setDescriptionProgram(String descriptionProgram) {
		this.descriptionProgram = descriptionProgram;
	}
	
	public void printCriteria() {
		System.out.println("Program Type: " + this.typeProgram + "\nProgram Start: " + this.startProgram + " | Program End: " + this.endProgram + 
				"\nProgram Description: " + this.descriptionProgram);		
	}
}
