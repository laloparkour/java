/* Boton Terminos y doncidiones
 * Este boton no esta activo a menos que estemos de acuerdo de los terminos
 * y condiciones ya sea de una licencia o un programa que queramos utilizar */

package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Terminos extends JFrame implements ActionListener, ChangeListener{
	private JLabel label;
	private JCheckBox checkBox;
	private JButton button;
	
	public Terminos() {
		setLayout(null);
		
		label = new JLabel("Aceptar terminos y condiciones");
		label.setBounds(10, 10, 400, 30);
		this.add(label);
		
		checkBox = new JCheckBox("Aceptar");
		checkBox.setBounds(10, 50, 100, 30);
		checkBox.addChangeListener(this);
		this.add(checkBox);
		
		button = new JButton("Continuar");
		button.setBounds(10, 100, 110, 30);
		button.addActionListener(this);
		this.add(button);
		button.setEnabled(false);
		
	}
	
	public void stateChanged(ChangeEvent e) {
		if(checkBox.isSelected() == true) {
			button.setEnabled(true);
		}else {
			button.setEnabled(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			System.exit(0);
		}
	}
	
}
