package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.MovimientoDTO;


public class TablaMovimientos implements TableModel{

	public static int COLUMNAS=5;
	
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	
	public void borrarMovimiento(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
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
	
	@Override
	public int getRowCount() {return datos.size();}

	@Override
	public int getColumnCount() {return COLUMNAS;}

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

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {return false;}

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

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}
	private void avisaEvento(TableModelEvent evento) {
		int i;
		
		for(i=0; i<listener.size();i++) {
			((TableModelListener)listener.get(i)).tableChanged(evento);;
		}
	}

}
