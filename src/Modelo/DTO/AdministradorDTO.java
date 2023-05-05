package Modelo.DTO;

public class AdministradorDTO {

	private String usu;
	private String pass;
	
	public AdministradorDTO() {
		this.usu = "";
		this.pass = "";
	}
	
	public AdministradorDTO(String usu, String pass) {
		this.usu = usu;
		this.pass = pass;
	}
	
	public String getUsu() {
		return usu;
	}
	
	public void setUsu(String usu) {
		this.usu = usu;
	}
	
	public String getPass() {
		return pass;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
