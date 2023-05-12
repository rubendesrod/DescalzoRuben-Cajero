package Modelo.DTO;

public class AdminDTO {

	private String usuario;
	private String contra;
	
	public AdminDTO() {
		this.usuario = "";
		this.contra = "";
	}
	
	public AdminDTO(String u, String con) {
		this.usuario = u;
		this.contra = con;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}
	
	
	
}
