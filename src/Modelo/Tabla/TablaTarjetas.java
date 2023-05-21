package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.ClienteDTO;
import Modelo.DTO.TarjetaDTO;

public class TablaTarjetas implements TableModel{
public static int COLUMNAS=6;
	
	
	
	@SuppressWarnings("rawtypes")
	private LinkedList datos = new LinkedList();
	@SuppressWarnings("rawtypes")
	private LinkedList listener = new LinkedList();
	
	
	public void borrarCliente(int row) {
		datos.remove(row);
		
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		
		avisaEvento(evento);
	}
	
	@SuppressWarnings("unchecked")
	public void anadeCliente (TarjetaDTO tDTO) {
		TarjetaDTO m = tDTO;
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
		case 0: return "Numero";
		case 1: return "Pin";
		case 2: return "CVV";
		case 3: return "validez";
		case 4: return "estado";
		case 5: return "numCuenta";
		default: return null;
		}
	}

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

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex == 0)
            return true;
        return false;
	}

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