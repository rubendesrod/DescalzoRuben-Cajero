package Modelo.Tabla;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Modelo.DTO.ClienteDTO;

public class TablaClientes implements TableModel{
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
	public void anadeCliente (ClienteDTO cDTO) {
		ClienteDTO m = cDTO;
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
		case 0: return "DNI";
		case 1: return "Nombre";
		case 2: return "apell1";
		case 3: return "apell2";
		case 4: return "direccion";
		case 5: return "correo";
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
		ClienteDTO aux = (ClienteDTO)(datos.get(rowIndex));
		
        switch (columnIndex)
        {
            case 0: return aux.getDni();
            case 1: return aux.getNombre();
            case 2: return aux.getApell1();
            case 3: return aux.getApell2();
            case 4: return aux.getDireccion();
            case 5: return aux.getCorreo();
            default: return null;
        }
	}

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
