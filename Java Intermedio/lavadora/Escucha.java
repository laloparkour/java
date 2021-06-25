package lavadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Escucha implements ActionListener{
	
	private JFrame ventana;
	private JPanel panelLavadora;
	
	public Escucha() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem seleccionado = (JMenuItem)e.getSource();
		
		switch (seleccionado.getActionCommand()) {
		case "Salir": 
			System.exit(0);
			break;
		default:
			break;
		}
		
	}

}
