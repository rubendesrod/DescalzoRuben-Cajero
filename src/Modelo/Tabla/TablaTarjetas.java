package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.TarjetaDTO;

/**
 * Clase que implemeta el TableMode y crear el Modelo de la Tabla Tarjetas
 * 
 * @version 1.0
 * @author Ruben
 */

public class TablaTarjetas implements TableModel{
	
	public static int COLUMNAS=6;
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	/**
	 * Metodo que borra una tarjeta pasandole la fila en la que se encuentra
	 * @param row
	 */
	
	public void borrarTarjeta(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
	/**
	 * Metodo que añade un TarjetaDTO
	 * @param tDTO
	 */
	
	@SuppressWarnings("unchecked")
	public void anadeTarjeta (TarjetaDTO tDTO) {
		TarjetaDTO m = tDTO;
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
		case 0: return "Numero";
		case 1: return "Pin";
		case 2: return "CVV";
		case 3: return "validez";
		case 4: return "estado";
		case 5: return "numCuenta";
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
	 * Metodo que devuelve un valor de TarjetaDTO
	 * @param rowIndex
	 * @param columnIndex
	 * @return Object
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TarjetaDTO aux = (TarjetaDTO)(datos.get(rowIndex));
		
        switch (columnIndex)
        {
            case 0: return aux.getNumTarjeta();
            case 1: return aux.getPin();
            case 2: return aux.getCvv();
            case 3: return aux.getFechaCaducidad();
            case 4: return aux.getEstado();
            case 5: return aux.getNumCuenta();
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
		TarjetaDTO aux = (TarjetaDTO)(datos.get(rowIndex));
		
		switch(columnIndex) {
			case 0: aux.setNumTarjeta((String)valor); break;
			case 1: aux.setPin((Integer)valor); break;
			case 2: aux.setCvv((Integer)valor); break;
			case 3: aux.setFechaCaducidad((String)valor); break;
			case 4: aux.setEstado((String)valor); break;
			case 5: aux.setNumCuenta((String)valor); break;
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