package laGeekpediaDeHernesto;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Panel extends JPanel{
	private Lamina_Botones lamina_tipo, lamina_tipo_mensajes, lamina_mensaje, lamina_tipo_opcion, lamina_opciones, lamina_entrada;
	

	public Panel() {
		
		setLayout(new BorderLayout());
		
		agregarNorte();
		agregarSur();
		
	}
	
	public void agregarNorte() {
		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new GridLayout(2,3));
		
		lamina_tipo = new Lamina_Botones("Tipo", new String[] {"Mensaje", "Confirmar", "Opción", "Entrada"});
		lamina_tipo_mensajes = new Lamina_Botones("Tipo de Mensaje", new String[] {"ERROR_MESSAGE", "INFORMATION_MESSAGE", "QUESTION MESSAGE", "PLAIN_,MESSAGE"});
		lamina_mensaje = new Lamina_Botones("Tipo", new String[] {"Cadena", "Icono", "Componente", "Otros", "Object[]"});
		lamina_tipo_opcion = new Lamina_Botones("Confirmar", new String[] {"DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION"});
		lamina_opciones = new Lamina_Botones("Opción", new String[] {"String[]", "Icon[]", "Object[]"});
		lamina_entrada = new Lamina_Botones("Entrada", new String[] {"Campo de texto", "Combo"	});
		
		panelNorte.add(lamina_tipo);
		panelNorte.add(lamina_tipo_mensajes);
		panelNorte.add(lamina_mensaje);
		panelNorte.add(lamina_tipo_opcion);
		panelNorte.add(lamina_opciones);
		panelNorte.add(lamina_entrada);
		
		add(panelNorte, BorderLayout.CENTER);
	}
	
	public void agregarSur() {
		JPanel panelSur = new JPanel();;
		
		JButton mostrar = new JButton("Mostrar");
		panelSur.add(mostrar);
		
		
		add(panelSur, BorderLayout.SOUTH);
		
	}
	
}
