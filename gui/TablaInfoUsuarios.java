package gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Usuario;

public class TablaInfoUsuarios extends AbstractTableModel {

	private String[] nombresColumnas = {"DNI", "Nombre", "Apellido"};
	private Class[] tiposColumnas = { Integer.class, String.class, String.class};
	private List<Usuario> contenido;

	private static final int COLUMNA_DNI = 0;
	private static final int COLUMNA_NOMBRE = 1;
	private static final int COLUMNA_APELLIDO = 2;

	
	
	public TablaInfoUsuarios() {
		contenido = new ArrayList<Usuario>();
	}
	
	@Override
	public int getRowCount() {
		return contenido.size();
	}

	@Override
	public int getColumnCount() {
		return nombresColumnas.length;
	}
	
	public String getColumnName(int col) {
        return nombresColumnas[col];
    }
	
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }
    
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_DNI:
			result = u.getId();
			break;
		case COLUMNA_NOMBRE:
			result = u.getNombre();
			break;
		case COLUMNA_APELLIDO:
			result = u.getApellido();
			break;
		default:
			result = new String("");
		}
		
		return result;
	}

    
    /**
     * GETTER DE MIS FILAS
     * @return
     */
    public List<Usuario> getContenido() {
    	return contenido;
    }
    /**
     * SETTER DE MIS FILAS 
     * 
     * @param contenido
     */
    public void setContenido(List<Usuario> contenido) {
    	this.contenido = contenido;
    }
	
	
}
