package Controlador.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modelo.Validador;
import Modelo.DAO.ClientesDAO;
import Modelo.DAO.CuentaDAO;
import Modelo.DAO.TarjetaDAO;
import Modelo.DTO.ClienteDTO;
import Modelo.DTO.CuentaDTO;
import Modelo.DTO.TarjetaDTO;
import Vista.Admin.Vistas.Administrar.FrameCrear;

public class GestorCrearAdm implements ActionListener{

	private String objeto;
	private FrameCrear fc;
	private ClienteDTO cliDTO;
	private ClientesDAO cliDAO;
	private TarjetaDTO tDTO;
	private TarjetaDAO tDAO;
	private CuentaDTO cDTO;
	private CuentaDAO cDAO;
	private Validador v;
	
	public GestorCrearAdm(String objeto, FrameCrear fc) {
		
		this.objeto = objeto;
		this.fc = fc;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		v = new Validador();
		
		if(objeto.equalsIgnoreCase("cliente")) {
			if (fc.getTxt1().getText().isEmpty()||fc.getTxt2().getText().isEmpty() || fc.getTxt3().getText().isEmpty() || fc.getTxt5().getText().isEmpty()
				|| fc.getTxt7().getText().isEmpty() || fc.getTxt8().getText().isEmpty() ){	
				
				fc.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");
				
			}else {
				if (v.validarDni(fc.getTxt1().getText()) && v.validarNombreApellDir(fc.getTxt2().getText()) && v.validarNombreApellDir(fc.getTxt3().getText())
						&& v.validarNombreApellDir(fc.getTxt4().getText()) && v.validarNombreApellDir(fc.getTxt5().getText())&& v.validarCorreo(fc.getTxt6().getText())
						&& v.validarTelefono(fc.getTxt7().getText())&& v.validarFechaNac(fc.getTxt8().getText())) {
					
					cliDTO = new ClienteDTO();
					cliDAO = new ClientesDAO();
					cliDTO.setDni(fc.getTxt1().getText());
					cliDAO.buscarCliente(cliDTO);
					if(cliDAO.getCli().getDni().equalsIgnoreCase(cliDTO.getDni())) {
						fc.getErrores().setText("Este DNI ya existe en la base de datos");
					}else {
						cliDTO.setNombre(fc.getTxt2().getText());
						cliDTO.setApell1(fc.getTxt3().getText());
						cliDTO.setApell2(fc.getTxt4().getText());
						cliDTO.setDireccion(fc.getTxt5().getText());
						cliDTO.setCorreo(fc.getTxt6().getText());
						cliDTO.setTelefono(fc.getTxt7().getText());
						cliDTO.setFechaNac(fc.getTxt8().getText());
						cliDAO.crearCliente(cliDTO);
						fc.getErrores().setForeground(Color.blue);
						fc.getErrores().setText(cliDAO.getMsg());
					}
				}else {
					fc.getErrores().setText(v.getMsg());
				}
			}	
		
		}else if (objeto.equalsIgnoreCase("tarjeta")) {
			
			if(fc.getTxt1().getText().isEmpty()||fc.getTxt2().getText().isEmpty() || fc.getTxt3().getText().isEmpty()||fc.getTxt4().getText().isEmpty() ){
				fc.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");	
			}else {
				if (v.validarNumTarjeta(fc.getTxt1().getText()) && v.validarPin(fc.getTxt2().getText())&& v.validarCvv(fc.getTxt3().getText()) 
						&& v.validarFechaTarjeta(fc.getTxt4().getText())) {
					
					tDTO = new TarjetaDTO();
					tDAO = new TarjetaDAO();
					tDTO.setNumTarjeta(fc.getTxt1().getText());
					tDAO.buscarTarjeta(tDTO);
					if(tDAO.gettDTO().getNumTarjeta().equalsIgnoreCase(tDTO.getNumTarjeta())) {
						fc.getErrores().setText("Esta Tarjeta ya existe en la base de datos");
					}else {
						tDTO.setPin(Integer.parseInt(fc.getTxt2().getText()));
						tDTO.setCvv(Integer.parseInt(fc.getTxt3().getText()));
						tDTO.setFechaCaducidad(fc.getTxt4().getText());
						tDTO.setEstado(fc.getC().getSelectedItem());
						tDAO.crearTarjeta(tDTO);
						fc.getErrores().setForeground(Color.blue);
						fc.getErrores().setText(tDAO.getMsg());
					}
				}else {
					fc.getErrores().setText(v.getMsg());
				}
			}
			
		}else if (objeto.equalsIgnoreCase("cuenta")) {
			
			if(fc.getTxt1().getText().isEmpty()||fc.getTxt2().getText().isEmpty()) {
				fc.getErrores().setText("FALTAN CAMPOS OBLIGATORIOS [*]");
			}else {
				if (v.validarNumCuenta(fc.getTxt1().getText()) && v.validarSaldo(fc.getTxt2().getText())) {
					cDTO = new CuentaDTO();
					cDAO = new CuentaDAO();	
					cDTO.setNumCuenta(fc.getTxt1().getText());
					cDAO.buscarCuenta(cDTO);
					if(cDAO.getcDTO().getNumCuenta().equalsIgnoreCase(cDTO.getNumCuenta())) {
						fc.getErrores().setText("El Numero de cuenta ya existe");
					}else {
						cDTO.setSaldo(Double.parseDouble(fc.getTxt2().getText()));
						cDAO.crearCuenta(cDTO);
						fc.getErrores().setForeground(Color.blue);
						fc.getErrores().setText(cDAO.getMsg());
					}
				}else {
					fc.getErrores().setText(v.getMsg());
				}
			}
		}
	}


	public String getObjeto() {
		return objeto;
	}


	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}


	public FrameCrear getFc() {
		return fc;
	}


	public void setFc(FrameCrear fc) {
		this.fc = fc;
	}


	public ClienteDTO getCliDTO() {
		return cliDTO;
	}


	public void setCliDTO(ClienteDTO cliDTO) {
		this.cliDTO = cliDTO;
	}


	public ClientesDAO getCliDAO() {
		return cliDAO;
	}


	public void setCliDAO(ClientesDAO cliDAO) {
		this.cliDAO = cliDAO;
	}


	public TarjetaDTO gettDTO() {
		return tDTO;
	}


	public void settDTO(TarjetaDTO tDTO) {
		this.tDTO = tDTO;
	}


	public TarjetaDAO gettDAO() {
		return tDAO;
	}


	public void settDAO(TarjetaDAO tDAO) {
		this.tDAO = tDAO;
	}


	public CuentaDTO getcDTO() {
		return cDTO;
	}


	public void setcDTO(CuentaDTO cDTO) {
		this.cDTO = cDTO;
	}


	public CuentaDAO getcDAO() {
		return cDAO;
	}


	public void setcDAO(CuentaDAO cDAO) {
		this.cDAO = cDAO;
	}
	
	
	
}
