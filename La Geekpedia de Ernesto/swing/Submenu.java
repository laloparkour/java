package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Submenu extends JFrame implements ActionListener{
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu submenu1;
	private JMenu submenu2;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	private JMenuItem item4;
	
	public Submenu() {
		this.setLayout(null);
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar); 
		/* Con este metodo le decimos que vamos a colocar el componente menuBar 
		dentro de la interfaz grafica */
		
		menu = new JMenu("Opciones");
		menuBar.add(menu);
		
		submenu1 = new JMenu("Tamaño de la ventana");
		menu.add(submenu1);
		
		submenu2 = new JMenu("Color de fondo");
		menu.add(submenu2);
		
		item1 = new JMenuItem("300*200");
		submenu1.add(item1);
		item1.addActionListener(this);
		
		item2 = new JMenuItem("640*480");
		submenu1.add(item2);
		item2.addActionListener(this);
		
		item3 = new JMenuItem("Rojo");
		submenu2.add(item3);
		item3.addActionListener(this);
		
		item4 = new JMenuItem("Verde");
		submenu2.add(item4);
		item4.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == item1) {
			this.setSize(300, 200);
		}else if(e.getSource() == item2) {
			this.setSize(640, 480);
		}else if(e.getSource() == item3) {
			this.getContentPane().setBackground(new Color(255, 0, 0));
		}else {
			if(e.getSource() == item4) {
				this.getContentPane().setBackground(new Color(0, 255, 0));
			}
		}
	}

}
