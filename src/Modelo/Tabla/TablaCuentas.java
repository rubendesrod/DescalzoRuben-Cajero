package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.CuentaDTO;

/**
 * Clase que implemeta el TableMode y crear el Modelo de la Tabla Cuentas
 * 
 * @version 1.0
 * @author Ruben
 */

public class TablaCuentas implements TableModel{

	public static int COLUMNAS=3;
	
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	/**
	 * Metodo que borra una cuenta pasandole la fila en la que se encuentra
	 * @param row
	 */
	
	public void borrarCuenta(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
	/**
	 * Metodo que añade un CuentaDTO
	 * @param cDTO
	 */
	
	@SuppressWarnings("unchecked")
	public void anadeCuenta (CuentaDTO cDTO) {
		CuentaDTO m = cDTO;
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
		case 0: return "Numero de Cuenta";
		case 1: return "Saldo";
		case 2: return "DNI";
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
		case 1: return Double.class;
		case 2: return String.class;
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
	 * Metodo que devuelve un valor de CuentaDTO
	 * @param rowIndex
	 * @param columnIndex
	 * @return Object
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CuentaDTO aux = (CuentaDTO)(datos.get(rowIndex));
		
        switch (columnIndex)
        {
            case 0: return aux.getNumCuenta();
            case 1: return aux.getSaldo();
            case 2: return aux.getDni();
            default: return null;
        }
	}

	/**
	 * Metodo que setea un Valor en una columna o fila
	 * @param valor
	 * @param rowIndex
	 * @param columnIndez
	 */
	
	@Override
	public void setValueAt(Object valor, int rowIndex, int columnIndex) {
		CuentaDTO aux = (CuentaDTO)(datos.get(rowIndex));
		
		switch(columnIndex) {
			case 0: aux.setNumCuenta((String)valor); break;
			case 1: aux.setSaldo((Double)valor); break;
			case 2: aux.setDni((String)valor); break;
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
