package vistas;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import controladores.ControladorMascotas;

public class Ventana extends JFrame
{
	
	private Font fuente = new Font("Arial", Font.PLAIN, 20);
	
	private JMenuBar menu;
	private JMenu opciones;
	private JMenuItem nuevo, cerrar, salir;
	
	private Image logo;
	
	public Ventana() 
	{
		setTitle("Mascotas");
		setSize(900,500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		try {
			logo = ImageIO.read(new File("src/img/icon.png"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		setIconImage(logo);
		
		agregarMenu();
		
		VistaMascotas vista = new VistaMascotas(this);
		
		ControladorMascotas controlador = new ControladorMascotas(vista, this);
		
		add(vista);
		
		setVisible(true);
		
	}
	
	private void agregarMenu()
	{
		
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		opciones = new JMenu("Menú");
		opciones.setFont(fuente);
		
		nuevo = new JMenuItem("Nuevo registro");
		nuevo.setFont(fuente);
	
		cerrar = new JMenuItem("Cerrar sesión");
		cerrar.setFont(fuente);
		
		salir = new JMenuItem("Salir");
		salir.setFont(fuente);
		
		opciones.add(nuevo);
		opciones.add(cerrar);
		opciones.add(salir);
		
		menu.add(opciones);
	}
	
	
	public void agregarListenerMenu(ActionListener listener) 
	{
		nuevo.addActionListener(listener);
		cerrar.addActionListener(listener);
		salir.addActionListener(listener);		
	}
	
}
