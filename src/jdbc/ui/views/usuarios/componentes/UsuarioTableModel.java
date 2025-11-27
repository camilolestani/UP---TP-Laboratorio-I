package jdbc.ui.views.usuarios.componentes;

import jdbc.entidades.Usuario;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class UsuarioTableModel extends AbstractTableModel {

	private static final int COLUMNA_NOMBRE = 0;
	private static final int COLUMNA_DNI = 1;
	private static final int COLUMNA_EMAIL = 2;
	private static final int COLUMNA_PASSWORD = 3;
	private static final int COLUMNA_TIPO = 4;
	private static final int COLUMNA_ACTIONS = 5;

	private String[] nombresColumnas = {"Nombre", "DNI", "Email", "Password", "Tipo de Usuario", "Acciones"};
	private Class[] tiposColumnas = {String.class, Integer.class, String.class, String.class, String.class, Usuario.class};

	private List<Usuario> contenido;

	public UsuarioTableModel() {
        contenido = new ArrayList<Usuario>();
	}

    @Override()
	public int getColumnCount() {
		return nombresColumnas.length;
	}

	@Override()
	public int getRowCount() {
		return contenido.size();
	}

	@Override()
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		Usuario u = contenido.get(rowIndex);
		
		Object result = null;
		switch(columnIndex) {
		case COLUMNA_NOMBRE:
			result = u.getNombreCompleto();
			break;
		case COLUMNA_EMAIL:
			result = u.getEmail();
			break;
        case COLUMNA_PASSWORD:
			result = "********";
			break;
		case COLUMNA_DNI:
			result = u.getDni();
			break;
        case COLUMNA_TIPO:
			result = u.getTipo().toString();
			break;
        case COLUMNA_ACTIONS:
			result = u;
			break;
		default:
			result = "";
		}

		return result;
	}

	public String getColumnName(int col) {
        return nombresColumnas[col];
    }


    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == COLUMNA_ACTIONS; // Only actions column is editable
    }

    public List<Usuario> getContenido() {
    	return contenido;
    }

    public void setContenido(List<Usuario> contenido) {
    	this.contenido = contenido;
    }
}
