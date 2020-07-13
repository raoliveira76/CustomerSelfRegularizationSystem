package ronaldo_5192_SEproject;

public class Contestation {
	
	private String issue;
	private String dateStart;
	private String dateEnd;
	private String content;
	private String conclusion;
	
	public Contestation(String issue, String dateStart, String dateEnd, String content, String conclusion) {
		this.issue = issue;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.content = content;
		this.conclusion = conclusion;
	}

	public String getIssue() {
		return issue;
	}
	
	public void setIssue(String issue) {
		this.issue = issue;
	}
	
	public String getDateStart() {
		return dateStart;
	}
	
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	
	public String getDateEnd() {
		return dateEnd;
	}
	
	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getConclusion() {
		return conclusion;
	}
	
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	
	public void printContestation() {
		System.out.println("Contestation Issue: " + this.issue + 
				"\nStart Date: " + this.dateStart + " | End Date: " + this.dateEnd + 
				"\nContent: " + this.content + 
				"\nConclusion: " + this.conclusion);		
	}
}
