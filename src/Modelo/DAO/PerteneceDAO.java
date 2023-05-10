package Modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Modelo.Conectar;
import Modelo.DTO.PerteneceDTO;

public class PerteneceDAO {

	private PerteneceDTO pDTO = new PerteneceDTO();
	private PreparedStatement ps = null;
	private Conectar cn = null;
	private ArrayList<PerteneceDTO> cuentas = new ArrayList<PerteneceDTO>();
	private ResultSet rs = null;
	private String msg;
	
	public void crearPertenece(PerteneceDTO pDTO) {
		
	}
	
	public void borrarPertenece(PerteneceDTO pDTO) {
		
	}
	
	public void buscarPertenece(PerteneceDTO pDTO) {
		
	}
	
	public void modificarPertenece(PerteneceDTO pDTO) {
		
	}

	public PerteneceDTO getpDTO() {
		return pDTO;
	}

	public void setpDTO(PerteneceDTO pDTO) {
		this.pDTO = pDTO;
	}

	public PreparedStatement getPs() {
		return ps;
	}

	public void setPs(PreparedStatement ps) {
		this.ps = ps;
	}

	public Conectar getCn() {
		return cn;
	}

	public void setCn(Conectar cn) {
		this.cn = cn;
	}

	public ArrayList<PerteneceDTO> getCuentas() {
		return cuentas;
	}

	public void setCuentas(ArrayList<PerteneceDTO> cuentas) {
		this.cuentas = cuentas;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
