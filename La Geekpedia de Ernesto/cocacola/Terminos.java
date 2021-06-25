package cocacola;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Terminos extends JFrame implements ActionListener, ChangeListener{
	private JLabel label1, label2;
	private JCheckBox check1;
	private JButton boton1, boton2;
	private JScrollPane scrollPane1;
	private JTextArea textArea1;
	private String nombre = "";
	
	public Terminos() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Licencia de uso");
		setIconImage(new ImageIcon(getClass().getResource("/cocacola/images/icon.png")).getImage());
		
		Bienvenida ventanabienvenida = new Bienvenida();
		nombre = ventanabienvenida.texto;
		
		label1 = new JLabel("Términos y Condiciones");
		label1.setBounds(215, 5, 200, 30);
		label1.setFont(new Font("Andale Mono", 1, 14));
		label1.setForeground(new Color(0, 0, 0));
		add(label1);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setFont(new Font("Andale Mono", 0, 9));
		textArea1.setText("\n\n\tTérminos y Condiciones" + 
		"\n\n\tA. Prohibida su venta o distribución sin autorización de Desarrollador del Software." +
		"\n\n\tB. Prohibida la alteración del código fuente o diseño de las interfaces gráficas." +
		"\n\n\tC. El Desarrollador del Software no se hace responsable del mal uso de este software." +
		"\n\n\tD. Los acuerdos legales expuestos acontinuación rigen el uso que usted haga de este software." +
		"\n\n\tE. Si usted no acepta terminos, haga clic en (No acepto) y no utilice este software." +
		"\n\n\tPara mayor informacion de nuestros productos o servicios, por favor visite." + 
		"\n\n\thttp://www.elpiruetas.com");
		scrollPane1 = new JScrollPane(textArea1);
		scrollPane1.setBounds(10, 40, 575, 200);
		add(scrollPane1);
		
		check1 = new JCheckBox("Yo " + nombre + " Acepto");
		check1.setBounds(10, 250, 300, 30);
		check1.addChangeListener(this);
		add(check1);
		
		boton1 = new JButton("Continuar");
		boton1.setBounds(10, 290, 110, 30);
		boton1.addActionListener(this);
		boton1.setEnabled(false);
		add(boton1);
		
		boton2 = new JButton("No Acepto");
		boton2.setBounds(130, 290, 110, 30);
		boton2.addActionListener(this);
		boton2.setEnabled(true);
		add(boton2);
		
		ImageIcon imagen = new ImageIcon(getClass().getResource("/cocacola/images/coca-cola.png"));
		label2 = new JLabel(imagen);
		label2.setBounds(315, 135, 300, 300);
		add(label2);
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if(check1.isSelected() == true) {
			boton1.setEnabled(true);
			boton2.setEnabled(false);
		}else {
			boton1.setEnabled(false);
			boton2.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			Principal principal = new Principal();
			principal.setBounds(0, 0, 680, 535);
			principal.setVisible(true);
			principal.setResizable(false);
			principal.setLocationRelativeTo(null);
			this.setVisible(false);
		}else if(e.getSource() == boton2){
			Bienvenida ventanaBienvenida = new Bienvenida();
			ventanaBienvenida.setBounds(0, 0, 350, 450);
			ventanaBienvenida.setVisible(true);
			ventanaBienvenida.setResizable(false);
			ventanaBienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
	}

}
