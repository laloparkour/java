/*
 * JTextField: Nos permite integrar cajas de texto a nuestras interfaces graficas, 
 * con la finalidad de poder solicitarle datos al usuario desde el teclado y 
 * asi el pueda interactuar con nuestros programas.
 * */

package swing;

import java.awt.event.*;
import javax.swing.*;

public class Formulario extends JPanel implements ActionListener{
	private	JTextField textField;
	private JLabel label;
	private JButton button;
	
	public Formulario() {
		this.setLayout(null);
		this.setVisible(true);
		
		//Label
		label = new JLabel("Usuario: ");
		label.setBounds(10, 10, 100, 30);
		add(label);
		
		//Text Field
		textField = new JTextField();
		textField.setBounds(120, 17, 150, 20);
		add(textField);
		
		//Button
		button = new JButton("Aceptar");
		button.setBounds(10, 80, 100, 30);
		add(button);
		button.addActionListener(this); //Le indicamos que tendra un evento
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			String text = textField.getText();
		}		
	}

}
