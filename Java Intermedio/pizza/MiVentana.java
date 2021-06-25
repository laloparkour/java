package pizza;

import java.awt.Font;

import javax.swing.JFrame;

public class MiVentana extends JFrame{
	private Font fuente;
	
	
	public MiVentana() {
		setSize(500, 500);
		fuente = new Font("Arial", Font.BOLD, 25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setTitle("PizzaUabcs");
		
		FormularioPizza formulario = new FormularioPizza();
		add(formulario);
		
		
		setVisible(true);
	}
}
