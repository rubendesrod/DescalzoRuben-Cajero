package Controlador.Cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Modelo.DAO.CuentaDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Cliente.RetirarIngresar;

public class GestorRI implements ActionListener{

	private RetirarIngresar r;
	private String msg;
	private String numTarjeta;
	private CuentaDAO cDAO;
	private CuentaDTO cDTO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private Double dinero;
	
	public GestorRI(RetirarIngresar r, String msg, String tar) {
		this.r = r;
		this.msg = msg;
		this.numTarjeta = tar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!r.getCant().getText().isEmpty()) {
			dinero = Double.parseDouble(r.getCant().getText());
		}else {
			JOptionPane.showMessageDialog(null,"No se ha podido leer los datos","ERROR",JOptionPane.ERROR_MESSAGE);
			dinero = 0.0;
		}
		
		cDTO = new CuentaDTO();
		cDAO = new CuentaDAO();
		tDTO = new TarjetaDTO();
		tDAO = new TarjetaDAO();
		tDTO.setNumTarjeta(numTarjeta);
		tDAO.buscarTarjeta(tDTO);
		cDTO.setNumCuenta(tDAO.gettDTO().getNumCuenta());
		cDAO.buscarCuenta(cDTO);
		
		//Primero compruebo desde que clase estoy llamando al action listener
		// ya que ingresar y retirar comparten el mismo procedimiento
		
		if(msg.equalsIgnoreCase("ingresar")) {
			cDTO.setSaldo(cDAO.getcDTO().getSaldo()+dinero);
			cDAO.modificarCuenta(cDTO);
			JOptionPane.showMessageDialog(null,"El dinero se ha ingresado correctamente");
			
		}else {
		//Retirar
			if(cDAO.getcDTO().getSaldo()>dinero) {
				cDTO.setSaldo(cDAO.getcDTO().getSaldo()-dinero);
				cDAO.modificarCuenta(cDTO);
				JOptionPane.showMessageDialog(null,"Se ha retirado correctamen la cantidad introducida");
			}else {
				JOptionPane.showMessageDialog(null,"No dispone de tanta cantidad a retirar","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}

	public RetirarIngresar getCant() {
		return r;
	}

	public void setCant(RetirarIngresar r) {
		this.r = r;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public Double getDinero() {
		return dinero;
	}	
	
	public void setDinero(Double dinero) {
		this.dinero = dinero;
	}
}
