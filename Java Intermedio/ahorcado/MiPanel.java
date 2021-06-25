package ahorcado;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MiPanel extends JPanel implements ActionListener, KeyListener{
	
	private Font fuente;
	private int vidas = 6;	
	private int contador = 0;
	
	private String[] palabras = {"PERRO", "GATO", "GALLO", "CELULAR", "COMPUTADORA", "PLUMA", "BORRADOR", "PROGRAMAR", "AZUL", "ROJO", 
			"AMARILLO", "VERDE", "MANZANA", "NARANJA", "UVA", "TORTILLA", "COLOR", "ESTRELLA", "CIELO", "NUBE"};
	private String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "�", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	
	private char[] oculta; //Se le van a ir agregando letras de la palabra solucion
	private String hidden;
	
	private Random rand;
	private boolean juego = true;
	private boolean flag = true;
	
	private String solucion;
	
	private JLabel fotoAhorcado;
	private JLabel palabraOculta;
	private JLabel intentos;
	private JButton botonLetra;
	
	private JPanel panelNorte;
	private JPanel panelSur;
		
	public MiPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		fuente = new Font("Arial", Font.BOLD, 20);
		setFocusable(true);
		addKeyListener(this);
		
		rand = new Random();
		int n = rand.nextInt(20);

		solucion = palabras[n];		
		
		oculta = new char[solucion.length()];
		
		for (int i = 0; i < oculta.length; i++) {
			oculta[i] = '_';
		}
		
		agregarPanelNorte();
		agregarPanelSur();
		
	}

	public void agregarPanelNorte(){
		panelNorte = new JPanel();
		panelNorte.setLayout(new BorderLayout());
		panelNorte.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20));	
		
		fotoAhorcado = new JLabel(cargarImagen("../img/ahorcado_0.jpeg"));
		panelNorte.add(fotoAhorcado, BorderLayout.CENTER);
		
		JPanel panelPalabra = new JPanel();
		
		palabraOculta = new JLabel();
		palabraOculta.setFont(fuente);
		palabraOculta.setAlignmentX(CENTER_ALIGNMENT);
		panelPalabra.add(palabraOculta);
		
		panelNorte.add(panelPalabra, BorderLayout.SOUTH);
		
		add(panelNorte);
	}
	
	public void muestraSolucion() {
		palabraOculta.setText(solucion);
	}
	
	public void agregarPanelSur() {
		panelSur = new JPanel();
		panelSur.setLayout(new BorderLayout());
		panelSur.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20));
		
		agregarLetras();
		
		intentos = new JLabel("Intentos restantes: " + vidas);
		intentos.setFont(fuente);
		panelSur.add(intentos, BorderLayout.SOUTH);
		
		add(panelSur);
	}
	
	public void agregarLetras() {
		JPanel panelLetras = new JPanel();
		panelLetras.setLayout(new GridLayout(3,9,5,5));
		panelLetras.setBorder(BorderFactory.createEmptyBorder(2, 20, 20, 20));
		for (int i = 0; i < letras.length; i++) {
			botonLetra = new JButton(letras[i]);
			botonLetra.setFont(fuente);
			botonLetra.addActionListener(this);
			panelLetras.add(botonLetra);
		}
		
		panelSur.add(panelLetras, BorderLayout.CENTER);
		
	}
	
	public ImageIcon cargarImagen(String ruta) {
		Image imagen = null; 
		
		try {
			imagen = ImageIO.read(getClass().getResource(ruta));
			imagen = imagen.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		return new ImageIcon(imagen);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		String accion = boton.getActionCommand();
		
		char letra = accion.charAt(0);
		
		flag = true;
		
		for (int i = 0; i < solucion.length(); i++) {
			if(solucion.charAt(i) == letra) {
				oculta[i] = letra;
				
				hidden = String.valueOf(oculta);
				palabraOculta.setText(hidden);
				contador++;
				
				flag = false;
				boton.setEnabled(false);	
			}
		}

		if(flag) {
			vidas--;
			intentos.setText("Intentos restantes: " + vidas);
			
			if(vidas == 5) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_1.jpeg"));
			}else if(vidas == 4) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_2.jpeg"));
			}else if(vidas == 3) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_3.jpeg"));
			}else if(vidas == 2) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_4.jpeg"));
			}else if(vidas == 1) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_5.jpeg"));
			}else if(vidas == 0) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_6.jpeg"));
				juego = false;
			}
			
			if(juego == false) {
				JOptionPane.showMessageDialog(null, "Perdiste");
			}
		}
		
		if(contador == solucion.length()) {
			JOptionPane.showMessageDialog(null, "Ganaste");
		}
		
		requestFocus();
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
		char letra = e.getKeyChar();
		
		System.out.println(letra);
		
		flag = true;
		
		for (int i = 0; i < solucion.length(); i++) {
			if(solucion.charAt(i) == letra) {
				oculta[i] = letra;
				
				hidden = String.valueOf(oculta);
				palabraOculta.setText(hidden);
				contador++;
				
				flag = false;
			}
		}

		if(flag) {
			vidas--;
			intentos.setText("Intentos restantes: " + vidas);
			
			if(vidas == 5) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_1.jpeg"));
			}else if(vidas == 4) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_2.jpeg"));
			}else if(vidas == 3) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_3.jpeg"));
			}else if(vidas == 2) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_4.jpeg"));
			}else if(vidas == 1) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_5.jpeg"));
			}else if(vidas == 0) {
				fotoAhorcado.setIcon(cargarImagen("../img/ahorcado_6.jpeg"));
				juego = false;
			}
			
			if(juego == false) {
				JOptionPane.showMessageDialog(null, "Perdiste");
			}
		}
		
		if(contador == solucion.length()) {
			JOptionPane.showMessageDialog(null, "Ganaste");
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
