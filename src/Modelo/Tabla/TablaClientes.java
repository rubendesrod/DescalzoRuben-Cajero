package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.ClienteDTO;

/**
 * Clase que implemeta el TableMode y crear el Modelo de la Tabla clientes
 * 
 * @version 1.0
 * @author Ruben
 */

public class TablaClientes implements TableModel{
public static int COLUMNAS=8;
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	/**
	 * Metodo que borra un cliente pasandole la fila en la que se encuentra
	 * @param row
	 */
	
	public void borrarCliente(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
	/**
	 * Metodo que añade un clienteDTO
	 * @param cDTO
	 */
	
	@SuppressWarnings("unchecked")
	public void anadeCliente (ClienteDTO cDTO) {
		ClienteDTO m = cDTO;
		datos.add(m);
		
		TableModelEvent evento;
		evento = new TableModelEvent (this, this.getRowCount()-1,
				this.getRowCount()-1,TableModelEvent.ALL_COLUMNS,
				TableModelEvent.INSERT);
		
		avisaEvento(evento);
	}
	
	/**
	 * Metodo que devuelve el numero de Filas
	 * @return int
	 */
	
	@Override
	public int getRowCount() {return datos.size();}

	/**
	 * Metodo que devuelve el numero de Columnas
	 * @return int
	 */
	
	@Override
	public int getColumnCount() {return COLUMNAS;}

	/**
	 * Metodo que devuelvo el nombre de cada Columna
	 * @return String
	 */
	
	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0: return "DNI";
		case 1: return "Nombre";
		case 2: return "apell1";
		case 3: return "apell2";
		case 4: return "direccion";
		case 5: return "correo";
		case 6: return "Telefono";
		case 7: return "Fecha-Nacimiento";
		default: return null;
		}
	}

	/**
	 * Metodo que devuelve de que clase es cada columna
	 * @return Class<?>
	 */
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return String.class;
		case 3: return String.class;
		case 4: return String.class;
		case 5: return String.class;
		case 6: return String.class;
		case 7: return String.class;
		default: return Object.class;
		}
	}

	
	/**
	 * Metodo que devuelve un booleano con que columa es editable o fila.
	 * @param rowIndex
	 * @param columnIndex
	 * @return true, si es editable
	 * @return false, si no es editables
	 */
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 0)
            return true;
        return false;
	}

	/**
	 * Metodo que devuelve un valor de ClienteDTO
	 * @param rowIndex
	 * @param columnIndex
	 * @return Object
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ClienteDTO aux = (ClienteDTO)(datos.get(rowIndex));
		
        switch (columnIndex)
        {
            case 0: return aux.getDni();
            case 1: return aux.getNombre();
            case 2: return aux.getApell1();
            case 3: return aux.getApell2();
            case 4: return aux.getDireccion();
            case 5: return aux.getCorreo();
            case 6: return aux.getTelefono();
            case 7: return aux.getFechaNac();
            default: return null;
        }
	}

	/**
	 * Metodo que setea un Valor en una columna o fila
	 * @param valor
	 * @param rowIndex
	 * @param columnIndex
	 */
	
	@Override
	public void setValueAt(Object valor, int rowIndex, int columnIndex) {
		ClienteDTO aux = (ClienteDTO)(datos.get(rowIndex));
		
		switch(columnIndex) {
			case 0: aux.setDni((String)valor); break;
			case 1: aux.setNombre((String)valor); break;
			case 2: aux.setApell1((String)valor); break;
			case 3: aux.setApell2((String)valor); break;
			case 4: aux.setDireccion((String)valor); break;
			case 5: aux.setCorreo((String)valor); break;
			case 6: aux.setTelefono((String)valor); break;
			case 7: aux.setFechaNac((String)valor); break;
			default: break;
		}
		
	}

	/**
	 * Metodo que añade TableModelistener a una columna o fila
	 * @param l
	 */
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo que borra TableModelistener a una columna o fila
	 * @param l
	 */
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo que avisa si se produce algun cambio en la tabla
	 * @param evento
	 */
	
	private void avisaEvento(TableModelEvent evento) {
		int i;
		
		for(i=0; i<listener.size();i++) {
			((TableModelListener)listener.get(i)).tableChanged(evento);;
		}
	}
}
