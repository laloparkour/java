package ahorcado;

import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MiVentana extends JFrame implements ActionListener {
	private Font fuente;
	private JMenuBar mb;
	private JMenu opciones;
	private JMenuItem nuevo;
	private JMenuItem solucion;
	private MiPanel panel;
	
	public MiVentana() {
		fuente = new Font("Arial", Font.PLAIN, 20);
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ahorcado");
		
		crearMenu();
		
		panel = new MiPanel();
		add(panel);
		
		setVisible(true);
	}
	
	public void crearMenu() {
		mb = new JMenuBar();
		setJMenuBar(mb);
		
		opciones = new JMenu("Opciones");
		opciones.setFont(fuente);
		mb.add(opciones);
		
		nuevo = new JMenuItem("Nuevo");
		nuevo.setFont(fuente);
		nuevo.addActionListener(this);
		opciones.add(nuevo);
		
		solucion = new JMenuItem("Solucion");
		solucion.setFont(fuente);
		solucion.addActionListener(this);
		opciones.add(solucion);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem accion = (JMenuItem)e.getSource();
		
		switch (accion.getActionCommand()) {
		case "Nuevo":
			remove(panel);
			panel = new MiPanel();
			add(panel);
			
			validate();
			repaint();
			break;
		case "Solucion":
			panel.muestraSolucion();
			break;
		}
		
	}
}
