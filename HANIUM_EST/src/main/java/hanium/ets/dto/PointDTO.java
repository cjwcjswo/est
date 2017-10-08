package hanium.ets.dto;

public class PointDTO {
	private String email;
	private String name;
	private int point;
	
	public PointDTO(){}
	public PointDTO(String email, String name, int point) {
		super();
		this.email = email;
		this.name = name;
		this.point = point;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
