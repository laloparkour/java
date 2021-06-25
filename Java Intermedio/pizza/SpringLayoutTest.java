package pizza;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import springUtilities.SpringUtilities;

public class SpringLayoutTest extends JPanel{
	
	public SpringLayoutTest(){
		setLayout(new BorderLayout());
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new SpringLayout());
		
		String[] labels = {"Nombre: ", "Telefono: ", "Dirección: "};
		int pairs = labels.length;
		
		for (int i = 0; i < pairs; i++) {
			JLabel etiqueta = new JLabel(labels[i]);
			panelCentro.add(etiqueta);
			JTextField texto = new JTextField(10);
			panelCentro.add(texto);
		}
		
		SpringUtilities.makeCompactGrid(panelCentro,//Panel con SpringLayout
				3, 2, //Filas, Columnas
				25, 25, //InicioX, InicioY
				25, 25); //PadX, PadY
		
		add(panelCentro, BorderLayout.NORTH);
		
	}
}
