package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Consite en cambiar datos de tipo string a cualquier tipo de dato(int, double, float) */

public class Parse extends JPanel implements ActionListener{
	private JTextField textField1;
	private JTextField textField2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JButton boton;
	
	public Parse() {
		this.setLayout(null);
		this.setVisible(true);
		
		label1 = new JLabel("Valor 1: ");
		label1.setBounds(50, 5, 100, 30);
		add(label1);
		
		label2 = new JLabel("Valor 2: ");
		label2.setBounds(50, 35, 100, 30);
		add(label2);
		
		label3 = new JLabel("Resultado: ");
		label3.setBounds(120, 80, 100, 30);
		add(label3);
		
		textField1 = new JTextField();
		textField1.setBounds(120, 10, 150, 20);
		add(textField1);
		
		textField2 = new JTextField();
		textField2.setBounds(120, 40, 150, 20);
		add(textField2);
		
		boton = new JButton("Sumar");
		boton.setBounds(10, 80, 100, 30);
		add(boton);
		boton.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton) {
			int valor1 = 0;
			int valor2 = 0;
			int resultado = 0;
			
			valor1 = Integer.parseInt(textField1.getText());
			valor2 = Integer.parseInt(textField2.getText());
			
			resultado = valor1 + valor2;
			
			label3.setText("Resultado: " + resultado);
			
		}
	}
	
	
	
	
}
