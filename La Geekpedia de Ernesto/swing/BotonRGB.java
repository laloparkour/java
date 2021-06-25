package swing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BotonRGB extends JPanel implements ActionListener{
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JComboBox combo1;
	private JComboBox combo2;
	private JComboBox combo3;
	private JButton boton1;
	
	public BotonRGB() {
		setLayout(null);
		
		//Label 1
		label1 = new JLabel("Rojo");
		label1.setBounds(10, 10, 100, 10);
		add(label1);
		
		combo1 = new JComboBox();
		combo1.setBounds(120, 10, 50, 30);
		
		for (int i = 0; i < 256; i++) {
			/* Cada vez que se ejecute esta linea de codigo, se va tomar el valor 
			de i y se convertira en string */
			combo1.addItem(String.valueOf(i));
		}
		add(combo1);
		
		//Label 2
		label2 = new JLabel("Verde");
		label2.setBounds(10, 50, 100, 10);
		add(label2);
		
		combo2 = new JComboBox();
		combo2.setBounds(120, 50, 50, 30);
		
		for (int i = 0; i < 256; i++) {
			combo2.addItem(String.valueOf(i));
		}
		add(combo2);
		
		//Label 3
		label3 = new JLabel("Azul");
		label3.setBounds(10, 90, 100, 10);
		add(label3);
		
		combo3 = new JComboBox();
		combo3.setBounds(120, 90, 50, 30);
		
		for (int i = 0; i < 256; i++) {
			//Cada vez que se ejecute esta linea de codigo, se va tomar el valor de i y se convertira en string
			combo3.addItem(String.valueOf(i));
		}
		add(combo3);
		
		//Boton
		boton1 = new JButton("Fijar color: ");
		boton1.setBounds(10, 130, 100, 30);
		add(boton1);
		boton1.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			String cadena1 = combo1.getSelectedItem().toString();
			String cadena2 = combo2.getSelectedItem().toString();
			String cadena3 = combo3.getSelectedItem().toString();
			
			//Parsear las cadenas a entero
			int rojo = Integer.parseInt(cadena1);
			int verde = Integer.parseInt(cadena2);
			int azul = Integer.parseInt(cadena3);
			
			Color color1 = new Color(rojo, verde, azul);
			boton1.setBackground(color1);
			
		}
		
	}

}
