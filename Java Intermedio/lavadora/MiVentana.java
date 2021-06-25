package lavadora;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MiVentana extends JFrame implements ActionListener{
	
	private Font fuente;
	private JMenuBar menu;
	private JMenu inicio;
	private JMenuItem salir;
	
	public MiVentana() {
		fuente = new Font("Arial", Font.BOLD, 15);
		setSize(500, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Lavadora");
		
		crearMenu();
		
		MiPanel panel = new MiPanel();
		add(panel);
		
		setVisible(true);
		
	}
	
	public void crearMenu(){
		Escucha listener = new Escucha();
		
		menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu inicio = new JMenu("Inicio");
		inicio.setFont(fuente);
		
		JMenuItem salir = new JMenuItem("Salir");
		salir.setFont(fuente);
		salir.addActionListener(listener);
		
		inicio.add(salir);
		menu.add(inicio);		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
