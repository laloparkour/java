package lavadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MiPanel extends JPanel implements ActionListener {
	private Font fuente;
	private JLabel fotoLavadora;
	private JLabel titulo;
	
	private JLabel agua;
	private JLabel ropa;
	private JLabel jabon;
	
	private JButton on;
	private JButton off;
	
	private JButton chica;
	private JButton mediana;
	private JButton grande;
	
	private JButton fria;
	private JButton tibia;
	private JButton caliente;
	
	private JButton lavar;
	private JButton secar;
	private JButton enjuagar;
	private JButton drenar;
	
	private boolean ch = false;
	private boolean md = false;
	private boolean gde = false;
	private boolean fri = false;
	private boolean tib = false;
	private boolean cal = false;
	private boolean lav = false;
	private boolean sec = false;
	private boolean enj = false;
	private boolean dre = false;
	
	private JPanel panelImagen;
	
	public MiPanel() {
		fuente = new Font("Arial", Font.BOLD, 40);
		setLayout(new GridLayout(2, 1));
		
		agregarBotones();
		
		
		agregarImagen();
		
	}
	
	public void agregarBotones() {
		
		JPanel panelBotones = new JPanel(new BorderLayout());
		
		JPanel panelTitulo = new JPanel();
		titulo = new JLabel("Whirlpool");
		titulo.setFont(fuente);
		panelTitulo.add(titulo);
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.X_AXIS));
		
		/*PANEL ESTADO*/
		JPanel panelEstado = new JPanel();
		panelEstado.setLayout(new BoxLayout(panelEstado, BoxLayout.X_AXIS));
		TitledBorder estado = new TitledBorder("Estado");
		estado.setTitleJustification(TitledBorder.LEFT);
		estado.setTitlePosition(TitledBorder.TOP);
		estado.setTitleColor(new Color(28, 88, 249));
		panelEstado.setBorder(estado);
		
		on = new JButton("On");
		on.setEnabled(true);
		on.addActionListener(this);
		panelEstado.add(on);
		
		off = new JButton("Off");
		off.addActionListener(this);
		panelEstado.add(off);
		
		/*PANEL TAMAÑO*/
		JPanel panelSize = new JPanel();
		panelSize.setLayout(new BoxLayout(panelSize, BoxLayout.Y_AXIS));
		TitledBorder size = new TitledBorder("Tamaño");
		size.setTitleJustification(TitledBorder.LEFT);
		size.setTitlePosition(TitledBorder.TOP);
		size.setTitleColor(new Color(28, 88, 249));
		panelSize.setBorder(size);
		
		chica = new JButton("Chica");
		chica.addActionListener(this);
		panelSize.add(chica);
		
		mediana = new JButton("Mediana");
		mediana.addActionListener(this);
		panelSize.add(mediana);

		grande = new JButton("Grande");
		grande.addActionListener(this);
		panelSize.add(grande);
		
		/*PANEL TEMPERATURA*/
		JPanel panelTemperatura = new JPanel();
		panelTemperatura.setLayout(new BoxLayout(panelTemperatura, BoxLayout.Y_AXIS));
		TitledBorder temperatura = new TitledBorder("Temp");
		temperatura.setTitleJustification(TitledBorder.LEFT);
		temperatura.setTitlePosition(TitledBorder.TOP);
		temperatura.setTitleColor(new Color(28, 88, 249));
		panelTemperatura.setBorder(temperatura);
		
		fria = new JButton("Fria");
		fria.addActionListener(this);
		panelTemperatura.add(fria);
		
		tibia = new JButton("Tibia");
		tibia.addActionListener(this);
		panelTemperatura.add(tibia);
		
		caliente = new JButton("Caliente");
		caliente.addActionListener(this);
		panelTemperatura.add(caliente);
		
		/*PANEL MODO*/
		JPanel panelModos = new JPanel();
		panelModos.setLayout(new BoxLayout(panelModos, BoxLayout.Y_AXIS));
		TitledBorder modos = new TitledBorder("Modos");
		modos.setTitleJustification(TitledBorder.LEFT);
		modos.setTitlePosition(TitledBorder.TOP);
		modos.setTitleColor(new Color(28, 88, 249));
		panelModos.setBorder(modos);
		
		lavar = new JButton("Lavar");
		lavar.setEnabled(false);
		lavar.addActionListener(this);
		panelModos.add(lavar);
		
		drenar = new JButton("Drenar");
		drenar.setEnabled(false);
		drenar.addActionListener(this);
		panelModos.add(drenar);
		
		secar = new JButton("Secar");
		secar.setEnabled(false);
		secar.addActionListener(this);
		panelModos.add(secar);
		
		enjuagar = new JButton("Enjuagar");
		enjuagar.setEnabled(false);
		enjuagar.addActionListener(this);
		panelModos.add(enjuagar);
		
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelEstado);
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelSize);
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelTemperatura);
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelModos);
		panelCentro.add(Box.createHorizontalGlue());
		
		panelBotones.add(panelTitulo, BorderLayout.NORTH);
		panelBotones.add(panelCentro, BorderLayout.CENTER);
		
		add(panelBotones);
		
	}
	
	public void agregarImagen() {
		panelImagen = new JPanel(new BorderLayout());
		fotoLavadora = new JLabel(cargarImagen("../img/off.jpeg"));
		fotoLavadora.setPreferredSize(new Dimension(200, 200));
		panelImagen.add(fotoLavadora);
		add(panelImagen, BorderLayout.CENTER);
	}
	
	public ImageIcon cargarImagen(String ruta) {
		Image imagen = null; 
		
		try {
			imagen = ImageIO.read(getClass().getResource(ruta));
			imagen = imagen.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		return new ImageIcon(imagen);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		
		//Seleccionar tamaño de carga
		if(boton == chica) {
			mediana.setEnabled(false);
			grande.setEnabled(false);
			ch = true;
			System.out.println("Seleccionaste un tamaño de carga");
		}else if(boton == mediana) {
			chica.setEnabled(false);
			grande.setEnabled(false);
			md = true;
			System.out.println("Seleccionaste un tamaño de carga");
		}else if(boton == grande) {
			chica.setEnabled(false);
			mediana.setEnabled(false);
			gde = true;
			System.out.println("Seleccionaste un tamaño de carga");
		}
		
		//Seleccionar temperatura del agua
		if(boton == fria) {
			tibia.setEnabled(false);
			caliente.setEnabled(false);
			fri = true;
			System.out.println("Seleccionaste la tempertura del agua");
		}else if(boton == tibia) {
			fria.setEnabled(false);
			caliente.setEnabled(false);
			tib = true;
			System.out.println("Seleccionaste la tempertura del agua");
		}else if(boton == caliente) {
			fria.setEnabled(false);
			tibia.setEnabled(false);
			cal = true;
			System.out.println("Seleccionaste la tempertura del agua");
		}
		
		//Seleccionar modo
		if(boton == lavar) {
			drenar.setEnabled(false);
			secar.setEnabled(false);
			enjuagar.setEnabled(false);
			System.out.println("Lavando");
		}else if(boton == drenar) {
			lavar.setEnabled(false);
			secar.setEnabled(false);
			enjuagar.setEnabled(false);
			System.out.println("Drenando");
		}else if(boton == secar) {
			lavar.setEnabled(false);
			drenar.setEnabled(false);
			enjuagar.setEnabled(false);
			System.out.println("Secando");
		}else if(boton == enjuagar) {
			lavar.setEnabled(false);
			drenar.setEnabled(false);
			secar.setEnabled(false);
			System.out.println("Enjuagando");
		}
		
		//Carga chica
		if(ch && fri) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(ch && tib) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(ch && cal) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}
		
		//Carga mediana
		if(md && fri) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(md && tib) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(md && cal) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}
		
		//Carga grande
		if(gde && fri) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(gde && tib) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}else if(gde && cal) {
			lav = true;
			lavar.setEnabled(true);
			System.out.println(lav);
			on.setEnabled(true);
		}
		
		if(lav && boton == on) {
			fotoLavadora.setIcon(cargarImagen("../img/lavar.jpeg"));
		}
			
		if(boton == on) {
			off.setEnabled(false);
		}

		if(boton == off) {
			System.out.println("Se ha apagado la lavadora.");
			fotoLavadora.setIcon(cargarImagen("../img/off.jpeg"));
			
			chica.setEnabled(true);
			mediana.setEnabled(true);
			grande.setEnabled(true);
			
			fria.setEnabled(true);
			tibia.setEnabled(true);
			caliente.setEnabled(true);
			
		}
		
	}

}
