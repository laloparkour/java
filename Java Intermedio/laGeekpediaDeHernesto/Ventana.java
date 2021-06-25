package laGeekpediaDeHernesto;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	
	public Ventana() {
		setSize(600, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Ejercicio 1");
		
		Panel p = new Panel();
		add(p);
		
		setVisible(true);
		
	}
	
}
