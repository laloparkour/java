package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.ModeloTablaMascotas;
import modelos.Mascota;
import vistas.Formulario;
import vistas.FormularioEditar;
import vistas.Login;
import vistas.Ventana;
import vistas.VistaMascotas;

public class ControladorMascotas implements ActionListener
{
	
	ModeloTablaMascotas modeloMascotas;
	VistaMascotas vista;
	Ventana ventana;
	
	public ControladorMascotas(VistaMascotas vista, Ventana ventana) 
	{
		this.vista = vista;
		this.ventana = ventana;
		this.modeloMascotas = vista.modeloMascotas;
		vista.agregarListener(this);
		ventana.agregarListenerMenu(this);
		
	}
	
	public void borrarDatos() 
	{
		modeloMascotas.vaciarTabla();
	}
	
	public Mascota obtenerMascota() 
	{
		Mascota m = new Mascota();
		
		return m = modeloMascotas.getRow(vista.tablaMascotas.getSelectedRow());	
	}
	
	public void cargarTabla() 
	{
		borrarDatos();
		
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		
		Connection con = MYSQLConnection.connect();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			String consulta = "SELECT * FROM mascotas";
			rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				mascotas.add(new Mascota(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("tipo"),
					rs.getString("sexo"),
					rs.getString("raza"),
					rs.getString("color"),
					rs.getInt("edad"),
					rs.getString("tamanio"),
					rs.getString("propietario")
				));
			}
			
			for (Mascota mascota: mascotas) {
				modeloMascotas.addRow(mascota);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo cargar la informaci�n");
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	public void eliminarMascota(int actual, int seleccionado) 
	{
		Connection con = MYSQLConnection.connect();
		Statement st = null;
		
		try {
			
			st = (Statement)con.createStatement();
			
			String consulta = "DELETE FROM mascotas WHERE id = " + actual;
			
			int cant = st.executeUpdate(consulta);
			
			modeloMascotas.eliminarFila(seleccionado);
			
			System.out.println("Datos eliminados: " + cant);
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		int actual;
		int seleccionado;
		
		switch(e.getActionCommand()) 
		{
			case "Agregar":
				System.out.println("Agregar");
				
				Formulario form = new Formulario(modeloMascotas);
				break;
				
			case "Editar":
				System.out.println("Editar");
				
				Mascota m = new Mascota();
				seleccionado = vista.tablaMascotas.getSelectedRow();
				
				if(seleccionado >= 0) 
				{
					m = obtenerMascota();
					FormularioEditar formEditar = new FormularioEditar(m, modeloMascotas);
					
				}else {
					System.out.println("No seleccionaste una mascota");
				}
				
				break;
				
			case "Eliminar":
				System.out.println("Eliminar");
				
				seleccionado = vista.tablaMascotas.getSelectedRow();
				
				if(seleccionado >= 0) 
				{
					actual = obtenerMascota().getId();
					
					int confirmarElimarRegistro = JOptionPane.showConfirmDialog(null,"�Estas seguro de borrar el registro?", "Eliminar registro",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
					if (JOptionPane.OK_OPTION == confirmarElimarRegistro)
					{
						System.out.println("confirmado");
						eliminarMascota(actual, seleccionado);
					}else
					{
						 System.out.println("Denegado");
					}
									
				}else {
					System.out.println("No seleccionaste una mascota");
				}
				
				break;
				
			case "Nuevo registro":
				System.out.println("Nuevo registro desde el menu");
				Formulario f = new Formulario(modeloMascotas);
				break;
				
			case "Cerrar sesión":
				int confirmarCerrarSesion = JOptionPane.showConfirmDialog(null,"�Estas seguro de querer cerrar sesi�n?", "Cerrar sesi�n",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
				if (JOptionPane.OK_OPTION == confirmarCerrarSesion)
				{
					System.out.println("confirmado");
					
					ventana.dispose();
					Login l = new Login();
				}else
				{
					 System.out.println("Denegado");
				}
				
				break;
				
			case "Salir":
				System.out.println("Salir desde el menu");
				
				int confirmarCerrarPrograma = JOptionPane.showConfirmDialog(null,"�Estas seguro de querer cerrar el programa?", "Cerrar programa",  JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
				if (JOptionPane.OK_OPTION == confirmarCerrarPrograma)
				{
					System.out.println("confirmado");
					System.exit(0);
				}else
				{
					 System.out.println("Denegado");
				}
				
				break;
				
			}
		
		
	}
	
	
}
