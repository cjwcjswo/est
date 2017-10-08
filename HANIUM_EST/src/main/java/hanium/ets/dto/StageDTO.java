package hanium.ets.dto;

public class StageDTO {
	private String email;
	private String startDay;
	private String endDay;
	private int stage;
	private String kind;
	
	
	public StageDTO(){}
	
	
	public StageDTO(String email, String startDay, String endDay, int stage, String kind) {
		super();
		this.email = email;
		this.startDay = startDay;
		this.endDay = endDay;
		this.stage = stage;
		this.kind = kind;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public int getStage() {
		return stage;
	}
	public void setStage(int stage) {
		this.stage = stage;
	}


	@Override
	public String toString() {
		return "StageDTO [" + (email != null ? "email=" + email + ", " : "")
				+ (startDay != null ? "startDay=" + startDay + ", " : "")
				+ (endDay != null ? "endDay=" + endDay + ", " : "") + "stage=" + stage + ", "
				+ (kind != null ? "kind=" + kind : "") + "]";
	}
	
	
}
