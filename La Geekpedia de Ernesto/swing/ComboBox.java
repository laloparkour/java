/* JComboBox: Nos va permitir agregar listas desplegables a nuestras 
 * interfaces graficas */

package swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBox extends JPanel implements ItemListener{
	private JComboBox comboBox;
	private JLabel label;
	
	public ComboBox() {
		this.setLayout(null);
		this.setVisible(true);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 10, 80, 20);
		add(comboBox);
	
		comboBox.addItem("Rojo");
		comboBox.addItem("Verde");
		comboBox.addItem("Azul");
		comboBox.addItem("Amarillo");
		comboBox.addItem("Negro");
		comboBox.addItemListener(this);
		
		label = new JLabel("Color: ");
		label.setBounds(10, 50, 100, 200);
		add(label);
	}
	
	//Cada vez que haya una seleccion dentro del componente haremos lo siguiente
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == comboBox) {
			/* Convertimos a string lo que obtenemos al seleccionar una 
			opcion de la lista del combobox */
			String seleccion = comboBox.getSelectedItem().toString();	
			label.setText(seleccion);
		}
	}
}
