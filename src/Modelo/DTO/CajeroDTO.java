package Modelo.DTO;

public class CajeroDTO {

	private String estado;
	
	public CajeroDTO() {estado = "";}
	
	public CajeroDTO(String s) {this.estado = s;}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
