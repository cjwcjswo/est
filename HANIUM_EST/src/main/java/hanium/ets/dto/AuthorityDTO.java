package hanium.ets.dto;

public class AuthorityDTO {
	private String email;
	private String role;
	public AuthorityDTO(){}
	public AuthorityDTO(String email, String role) {
		super();
		this.email = email;
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
