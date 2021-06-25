/* JTextArea: Nos permite incluir o escribir multiples lineas de texto dentro de el,
 * dandonos la opcion de poder escribir en diferentes lineas de texto
 * 
 * JScrollPane: Nos permite recorrer el contenido que esta dentro del JTextArea */

package swing;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextArea extends JPanel implements ActionListener{
	private JTextField texto;
	private JButton boton;
	private JTextArea textArea;
	private JScrollPane scroll;
	private String text = "";
	
	public TextArea() {
		this.setLayout(null);
		this.setVisible(true);
		
		texto = new JTextField();
		texto.setBounds(10, 10, 200, 30);
		add(texto);
		
		boton = new JButton("Aceptar");
		boton.setBounds(250, 10, 100, 30);
		add(boton);
		boton.addActionListener(this);
		
		textArea = new JTextArea();
		scroll = new JScrollPane(textArea);
		scroll.setBounds(10, 50, 400, 300);
		add(scroll);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton) {
			text += texto.getText() + "\n";
			textArea.setText(text);
			texto.setText("");
			
		}
	}

}
