package formulario;

import javax.swing.JFrame;

public class MiVentana extends JFrame {
	
	public MiVentana() {
		setSize(400, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Formulario de Registro");

		MiPanel panel = new MiPanel();
		add(panel);
		
		setVisible(true);
	}
}
