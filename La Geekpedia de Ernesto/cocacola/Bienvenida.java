package cocacola;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Bienvenida extends JFrame implements ActionListener{
	private JTextField textField1;
	private JLabel label1, label2, label3, label4;
	private JButton boton1;
	/* Un atributo de clase es una caracteristica propia de la clase,  */
	public static String texto = "";
	
	
	public Bienvenida(){
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Bienvenido");
		getContentPane().setBackground(new Color(255, 0, 0));
		/* getImage() nos permite obtener una imagen de una ruta 
		 * getResource(ruta) nos permite cargar la imagen
		 * getClass() nos trae el nombre de la clase en la que estamos
		 * new ImageIcon creamos un objeto de tipo ImageIcon
		 * setIconImage nos permite colocar una imagen en el icono de nuestra interfaz grafica
		 * */
		setIconImage(new ImageIcon(getClass().getResource("/cocacola/images/icon.png")).getImage());
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("images/logo-coca.png"));
		label1 = new JLabel(imagen);
		label1.setBounds(25, 15, 300, 150);
		add(label1);
		
		label2 = new JLabel("Sistema de Control Vacacional");
		label2.setBounds(35, 135, 300, 30);
		label2.setFont(new Font("Andale Mono", 3, 16));
		label2.setForeground(new Color(255, 255, 255));
		add(label2);
		
		label3 = new JLabel("Ingrese su nombre");
		label3.setBounds(45, 212, 200, 30);
		label3.setFont(new Font("Andale Mono", 1, 12));
		label3.setForeground(new Color(255, 255, 255));
		add(label3);
		
		label4 = new JLabel("©2017 The Coca-Cola Company");
		label4.setBounds(85, 375, 300, 30);
		label4.setFont(new Font("Andale Mono", 1, 12));
		label4.setForeground(new Color(255, 255, 255));
		add(label4);
		
		textField1 = new JTextField();
		textField1.setBounds(45, 240, 255, 25);
		textField1.setBackground(new Color(224, 224, 244));
		textField1.setFont(new Font("Andale Mono", 1, 14));
		textField1.setForeground(new Color(255, 0, 0));
		add(textField1);
		
		boton1 = new JButton("Ingresar");
		boton1.setBounds(125, 280, 100, 30);
		boton1.setBackground(new Color(225, 225, 255));
		boton1.setFont(new Font("Andale Mono", 1, 14));
		boton1.setForeground(new Color(255, 0, 0));
		boton1.addActionListener(this);
		add(boton1);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			/* .trim() nos permite borrar los espacios de una cadena */
			texto = textField1.getText().trim();
			
			if(texto.equals("")) {
				JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre");
			}else {
				Terminos licencia = new Terminos();
				licencia.setBounds(0, 0, 600, 360);
				licencia.setVisible(true);
				licencia.setResizable(false);
				licencia.setLocationRelativeTo(null);
				this.setVisible(false);
			}
		}
		
	}

}
