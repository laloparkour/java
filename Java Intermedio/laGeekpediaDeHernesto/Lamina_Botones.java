package laGeekpediaDeHernesto;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class Lamina_Botones extends JPanel{
	
	public Lamina_Botones(String titulo, String[] opciones) {
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		ButtonGroup grupo = new ButtonGroup();
		
		for (int i = 0; i < opciones.length; i++) {
			JRadioButton rdBtn = new JRadioButton(opciones[i]);
			add(rdBtn);
			grupo.add(rdBtn);
			rdBtn.setSelected(i == 0);
		}

		
		
		
	}
	
}
