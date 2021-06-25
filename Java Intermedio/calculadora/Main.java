package calculadora;

import java.awt.Font;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		Font fuente = new Font("Arial", Font.BOLD, 25);
		
		ventana.setSize(400,350);
		ventana.setFont(fuente);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);
		ventana.setResizable(true);
		ventana.setTitle("Calculadora");
		
		PanelCalculadora calculadora = new PanelCalculadora();
		ventana.add(calculadora);
		
		ventana.setVisible(true);
		
		
	}

}
