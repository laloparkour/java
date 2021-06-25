/*
 * Un menu en java se divide en tres partes
 *  	La barra donde iran colocadas las pestañas desplegables
 *  	Las pestañas desplegables
 *  	Los items o opciones
 * 
 * */

package swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu extends JFrame implements ActionListener{
	private JMenuBar menubar; //Solo podemos sutilizar un JMenuBar
	private JMenu menu;
	private JMenuItem item1;
	private JMenuItem item2;
	private JMenuItem item3;
	
	public Menu() {
		this.setLayout(null);
		
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		
		menu = new JMenu("Opciones");
		menubar.add(menu);
		
		item1 = new JMenuItem("Rojo");
		item1.addActionListener(this);
		menu.add(item1);
		
		item2 = new JMenuItem("Verde");
		item2.addActionListener(this);
		menu.add(item2);
		
		item3 = new JMenuItem("Azul");
		item3.addActionListener(this);
		menu.add(item3);
		
		this.setVisible(true); //Es necesario para que se vea la ventana

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Container fondo = this.getContentPane();
		
		if(e.getSource() == item1) {
			fondo.setBackground(new Color(255, 0, 0));
		}else if(e.getSource() == item2) {
			fondo.setBackground(new Color(0, 255, 0));
		}else if(e.getSource() == item3) {
			fondo.setBackground(new Color(0, 0, 255));
		}
	}
	
	
	
}
