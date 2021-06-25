package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import controladores.ControladorMascotas;
import controladores.MYSQLConnection;
import modelos.Mascota;
import modelos.ModeloTablaMascotas;


public class VistaMascotas extends JPanel
{
	Font fuente = new Font("Arial", Font.PLAIN, 15);
	private JButton agregar, editar, eliminar;
	
	public JTable tablaMascotas;
	public ModeloTablaMascotas modeloMascotas;
	public ControladorMascotas controlador;
	
	public VistaMascotas(Ventana v)
	{
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
		
		inicializarTabla();
		agregarBotones();
		
		controlador = new ControladorMascotas(this, v);
		controlador.cargarTabla();
		
		
		
	}

	
	private void inicializarTabla() 
	{
		modeloMascotas = new ModeloTablaMascotas();

		tablaMascotas = new JTable(modeloMascotas){
			@Override
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component component = super.prepareRenderer(renderer, row, column);
				int rendererWidth = component.getPreferredSize().width;
				TableColumn tableColumn = getColumnModel().getColumn(column);
				tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
				return component;
		    } 
		};
		
		tablaMascotas.setFont(fuente);
		tablaMascotas.setRowHeight(30);
		tablaMascotas.getSelectedRow();
		JScrollPane scroll = new JScrollPane(tablaMascotas);
		
		add(scroll, BorderLayout.CENTER);
		
	}
	
	
	private void agregarBotones() 
	{
		JPanel botones = new JPanel();

		agregar = new JButton("Agregar");
		agregar.setFont(fuente);
		agregar.setBackground(new Color(0,171,199));
		agregar.setForeground(new Color(255,255,255));
		botones.add(agregar);
		
		editar = new JButton("Editar");
		editar.setFont(fuente);
		editar.setBackground(new Color(0,171,199));
		editar.setForeground(new Color(255,255,255));
		botones.add(editar);
		
		eliminar = new JButton("Eliminar");
		eliminar.setFont(fuente);
		eliminar.setBackground(new Color(0,171,199));
		eliminar.setForeground(new Color(255,255,255));
		botones.add(eliminar);
		
		add(botones, BorderLayout.SOUTH);
	}
	
	
	public void borrarDatos() 
	{
		modeloMascotas.vaciarTabla();
	}
	
	public void agregarListener(ActionListener listener) 
	{
		agregar.addActionListener(listener);
		editar.addActionListener(listener);
		eliminar.addActionListener(listener);
	}
	
}