package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.CuentaDTO;
import Modelo.DTO.MovimientoDTO;


public class TablaCuentas implements TableModel{

	public static int COLUMNAS=3;
	
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	
	public void borrarCuenta(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
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
	
	@Override
	public int getRowCount() {return datos.size();}

	@Override
	public int getColumnCount() {return COLUMNAS;}

	@Override
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case 0: return "Numero de Cuenta";
		case 1: return "Saldo";
		case 2: return "DNI";
		default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch(columnIndex) {
		case 0: return String.class;
		case 1: return Double.class;
		case 2: return String.class;
		default: return Object.class;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 0)
            return true;
        return false;
	}

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
