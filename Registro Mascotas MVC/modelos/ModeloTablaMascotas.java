package modelos;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMascotas extends AbstractTableModel
{
	private Vector<Mascota> datos;
	private String[] nombreColumnas = {"ID", "Nombre", "Tipo", "Sexo", "Raza", "Color", "Edad", "Tamaño", "Propietario"};
	
	public ModeloTablaMascotas() {
		datos = new Vector<Mascota>();
	}
	
	public ModeloTablaMascotas(Vector<Mascota> datos) {
		this.datos = datos;
	}
	
	@Override
	public int getColumnCount() {
		
		return nombreColumnas.length;
	}

	@Override
	public int getRowCount() {
		
		return datos.size();
	}

	@Override
	public Object getValueAt(int fila, int col) 
	{
		Mascota m = datos.elementAt(fila);
		
		switch(col) 
		{
			case 0: 
				return m.getId();
			case 1: 
				return m.getNombre();
			case 2:
				return m.getTipo();
			case 3:
				return m.getSexo();
			case 4: 
				return m.getRaza();
			case 5:
				return m.getColor();
			case 6:
				return m.getEdad();
			case 7:
				return m.getTamanio();
			case 8:
				return m.getPropietario();
		}
		
		return null;
	}

	
	@Override
	public String getColumnName(int col) {
		return nombreColumnas[col];
	}
	
	
	public Class<?> getColumnClass(int col)
	{
		
		switch(col) 
		{		
			case 0:
				return Integer.class;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return String.class;
			case 6:
				return Integer.class;
			case 7:
			case 8:
				return String.class;
		}
		
		return String.class;
		
	}
	
	public Mascota getRow(int fila) {
		return datos.elementAt(fila);
	}
	
	
	public void addRow(Mascota m) 
	{
		datos.add(m);
		fireTableRowsInserted(datos.size()-1, datos.size()-1);
		fireTableRowsInserted(getRowCount(), getColumnCount());
	}
	
	
	public void vaciarTabla() 
	{
		int filas = getRowCount();
		datos.removeAllElements();
		fireTableRowsDeleted(0, filas);
	}
	
	
	public void eliminarFila(int seleccionado) 
	{
		if(seleccionado >= 0) 
		{
			datos.removeElementAt(seleccionado);
			fireTableRowsDeleted(seleccionado, seleccionado);	
			
		}else 
		{
			System.out.println("No seleccionaste ninguna fila");
		}
	}
	
}
