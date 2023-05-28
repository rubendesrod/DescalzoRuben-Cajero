package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.MovimientoDTO;

/**
 * Clase que implemeta el TableMode y crear el Modelo de la Tabla Movimientos
 * 
 * @version 1.0
 * @author Ruben
 */

public class TablaMovimientos implements TableModel{

	/**
	 * Indica las columnas de la tabla
	 */
	public static int COLUMNAS=5;
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	/**
	 * Metodo que borra un movimiento pasandole la fila en la que se encuentra
	 * @param row Fila
	 */
	
	public void borrarMovimiento(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
	/**
	 * Metodo que añade un clienteDTO
	 * @param mDTO Movimiento DTO
	 */
	
	@SuppressWarnings("unchecked")
	public void anadeMovimiento (MovimientoDTO mDTO) {
		MovimientoDTO m = mDTO;
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
		case 0: return "Fecha";
		case 1: return "Accion";
		case 2: return "Cantidad";
		case 3: return "DNI";
		case 4: return "Numero de Cuenta";
		default: return null;
		}
	}

	/**
	 * Metodo que devuelve de que clase es cada columna
	 * @return Class
	 */
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0: return String.class;
		case 1: return String.class;
		case 2: return Double.class;
		case 3: return String.class;
		case 4: return String.class;
		default: return Object.class;
		}
	}

	/**
	 * Metodo que devuelve un booleano con que columa es editable o fila.
	 * @param rowIndex Indice de la Fila
	 * @param columnIndex Indice de la Columna
	 * @return true, si es editable o false, si no es editable
	 */
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}

	/**
	 * Metodo que devuelve un valor de ClienteDTO
	 * @param rowIndex Indice de la Fila
	 * @param columnIndex Indice de la Columna
	 * @return Object
	 */
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		MovimientoDTO aux = (MovimientoDTO)(datos.get(rowIndex));
		
        switch (columnIndex)
        {
            case 0: return aux.getFecha();
            case 1: return aux.getEstado();
            case 2: return aux.getCantidad();
            case 3: return aux.getDni();
            case 4: return aux.getNumCuenta();
            default: return null;
        }
	}

	/**
	 * Metodo que setea un Valor en una columna o fila
	 * @param valor Objeto
	 * @param rowIndex Indice de la Fila
	 * @param columnIndex Indice de la Columna
	 */
	
	@Override
	public void setValueAt(Object valor, int rowIndex, int columnIndex) {
		MovimientoDTO aux = (MovimientoDTO)(datos.get(rowIndex));
		
		switch(columnIndex) {
			case 0: aux.setFecha((String)valor); break;
			case 1: aux.setEstado((String)valor); break;
			case 2: aux.setCantidad((Double)valor); break;
			case 3: aux.setDni((String)valor); break;
			case 4: aux.setNumCuenta((String)valor); break;
			default: break;
		}
		
	}

	/**
	 * Metodo que añade TableModelistener a una columna o fila
	 * @param l Listener de la tabla
	 */
	
	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo que borra TableModelistener a una columna o fila
	 * @param l Listener de la Tabla
	 */
	
	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Metodo que avisa si se produce algun cambio en la tabla
	 * @param evento Escucha si se activa un listener
	 */
	
	private void avisaEvento(TableModelEvent evento) {
		int i;
		
		for(i=0; i<listener.size();i++) {
			((TableModelListener)listener.get(i)).tableChanged(evento);;
		}
	}

}
