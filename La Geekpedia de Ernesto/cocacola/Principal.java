package cocacola;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Principal extends JFrame implements ActionListener{
	private JMenuBar mb;
	private JMenu menuOpciones, menuCalcular, menuAcercaDe, menuColorFondo;
	private JMenuItem miCalculo, miRojo, miNegro, miMorado, miElCreador, miSalir, miNuevo;
	private JLabel labelLogo, labelBienvenido, labelTitle, labelNombre, labelAPaterno, labelAMaterno,
	labelDepartamento, labelAntiguedad, labelResultado, labelFooter;
	private JTextField txtNombreTrabajador, txtAparternoTrabajador, txtAMaternoTrabajador;
	private JComboBox comboDepartamento, comboAntiguedad;
	private JScrollPane scrollPane1;
	private  JTextArea textArea1;
	private String nombreAdministrador = "";
	
	public Principal() {
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); //Evita que el programa quede en segundo plano
		setTitle("Pantalla Principal");
		getContentPane().setBackground(new Color(255, 0, 0));
		setIconImage(new ImageIcon(getClass().getResource("/cocacola/images/icon.png")).getImage());
		
		Bienvenida ventanabienvenida = new Bienvenida();
		nombreAdministrador = ventanabienvenida.texto;
		
		mb = new JMenuBar();
		mb.setBackground(new Color(255, 0, 0));
		setJMenuBar(mb);
		
		menuOpciones = new JMenu("Opciones");
		menuOpciones.setBackground(new Color(255, 0, 0));
		menuOpciones.setFont(new Font("Andale Mono", 1, 14));
		menuOpciones.setForeground(new Color(255, 255, 255));
		mb.add(menuOpciones);
		 
		menuCalcular = new JMenu("Calcular");
		menuCalcular.setBackground(new Color(255, 0, 0));
		menuCalcular.setFont(new Font("Andale Mono", 1, 14));
		menuCalcular.setForeground(new Color(255, 255, 255));
		mb.add(menuCalcular);
		
		menuAcercaDe = new JMenu("Acerca de");
		menuAcercaDe.setBackground(new Color(255, 0, 0));
		menuAcercaDe.setFont(new Font("Andale Mono", 1, 14));
		menuAcercaDe.setForeground(new Color(255, 255, 255));
		mb.add(menuAcercaDe);
		
		menuColorFondo = new JMenu("Color de fondo");
		menuColorFondo.setFont(new Font("Andale Mono", 1, 14));
		menuColorFondo.setForeground(new Color(255, 0, 0));
		menuOpciones.add(menuColorFondo);

		miCalculo = new JMenuItem("Vacaciones");
		miCalculo.setFont(new Font("Andale Mono", 1, 14));
		miCalculo.setForeground(new Color(255, 0, 0));
		menuCalcular.add(miCalculo);
		miCalculo.addActionListener(this);
		
		miRojo = new JMenuItem("Rojo");
		miRojo.setFont(new Font("Andale Mono", 1, 14));
		miRojo.setForeground(new Color(255, 0, 0));
		menuColorFondo.add(miRojo);
		miRojo.addActionListener(this);
		
		miNegro = new JMenuItem("Negro");
		miNegro.setFont(new Font("Andale Mono", 1, 14));
		miNegro.setForeground(new Color(255, 0, 0));
		menuColorFondo.add(miNegro);
		miNegro.addActionListener(this);
		
		miMorado = new JMenuItem("Morado");
		miMorado.setFont(new Font("Andale Mono", 1, 14));
		miMorado.setForeground(new Color(255, 0, 0));
		menuColorFondo.add(miMorado);
		miMorado.addActionListener(this);

		miNuevo = new JMenuItem("Nuevo");
		miNuevo.setFont(new Font("Andale Mono", 1, 14));
		miNuevo.setForeground(new Color(255, 0, 0));
		menuOpciones.add(miNuevo);
		miNuevo.addActionListener(this);
		
		miElCreador = new JMenuItem("El creador");
		miElCreador.setFont(new Font("Andale Mono", 1, 14));
		miElCreador.setForeground(new Color(255, 0, 0));
		menuAcercaDe.add(miElCreador);
		miElCreador.addActionListener(this);
		
		miSalir = new JMenuItem("Salir");
		miSalir.setFont(new Font("Andale Mono", 1, 14));
		miSalir.setForeground(new Color(255, 0, 0));
		menuOpciones.add(miSalir);
		miSalir.addActionListener(this);
		
		/* Labels */
		ImageIcon imagen = new ImageIcon(getClass().getResource("images/logo-coca.png"));
		labelLogo = new JLabel(imagen);
		labelLogo.setBounds(5, 5, 250, 100);
		add(labelLogo);
		
		labelBienvenido = new JLabel("Bienvenido " + nombreAdministrador);
		labelBienvenido.setBounds(280, 30, 300, 50);
		labelBienvenido.setFont(new Font("Andale Mono", 1, 32));
		labelBienvenido.setForeground(new Color(255, 255, 255));
		add(labelBienvenido);
		
		labelTitle = new JLabel("Datos de trabajador para el calculo de vacaciones");
		labelTitle.setBounds(45, 140, 800, 25);
		labelTitle.setFont(new Font("Andale Mono", 0, 24));
		labelTitle.setForeground(new Color(255, 255, 255));
		add(labelTitle);
		
		labelNombre = new JLabel("Nombre completo:");
		labelNombre.setBounds(25, 188, 180, 25);
		labelNombre.setFont(new Font("Andale Mono", 1, 12));
		labelNombre.setForeground(new Color(255, 255, 255));
		add(labelNombre);
		
		txtNombreTrabajador = new JTextField();
		txtNombreTrabajador.setBounds(25, 213, 150, 25);
		txtNombreTrabajador.setBackground(new java.awt.Color(224, 224, 224));
		txtNombreTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14));
		txtNombreTrabajador.setForeground(new java.awt.Color(255, 0, 0));
		add(txtNombreTrabajador); 
		
		labelAPaterno = new JLabel("Apellido Paterno:");
		labelAPaterno.setBounds(25, 248, 180, 25);
		labelAPaterno.setFont(new Font("Andale Mono", 1, 12));
		labelAPaterno.setForeground(new Color(255, 255, 255));
		add(labelAPaterno);
		
		txtAparternoTrabajador = new JTextField();
		txtAparternoTrabajador.setBounds(25, 273, 150, 25);
		txtAparternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
		txtAparternoTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14));
		txtAparternoTrabajador.setForeground(new java.awt.Color(255, 0, 0));
		add(txtAparternoTrabajador);
		
		labelAMaterno = new JLabel("Apellido Materno:");
		labelAMaterno.setBounds(25, 308, 180, 25);
		labelAMaterno.setFont(new Font("Andale Mono", 1, 12));
		labelAMaterno.setForeground(new Color(255, 255, 255));
		add(labelAMaterno);
		
		txtAMaternoTrabajador = new JTextField();
		txtAMaternoTrabajador.setBounds(25, 334, 150, 25);
		txtAMaternoTrabajador.setBackground(new java.awt.Color(224, 224, 224));
		txtAMaternoTrabajador.setFont(new java.awt.Font("Andale Mono", 1, 14));
		txtAMaternoTrabajador.setForeground(new java.awt.Color(255, 0, 0));
		add(txtAMaternoTrabajador);
			
		labelDepartamento = new JLabel("Selecciona el Departamento:");
		labelDepartamento.setBounds(220, 188, 205, 25);
		labelDepartamento.setFont(new Font("Andale Mono", 1, 12));
		labelDepartamento.setForeground(new Color(255, 255, 255));
		add(labelDepartamento);
		
		comboDepartamento = new JComboBox();
		comboDepartamento.setBounds(220, 213, 220, 25);
		comboDepartamento.setBackground(new java.awt.Color(224, 224, 224));
		comboDepartamento.setFont(new java.awt.Font("Andale Mono", 1, 14));
		comboDepartamento.setForeground(new Color(255, 0, 0));
		add(comboDepartamento);
		comboDepartamento.addItem("");
		comboDepartamento.addItem("Atención al Cliente");
		comboDepartamento.addItem("Departamento de Logística");
		comboDepartamento.addItem("Departamento de Gerencia");
		
		labelAntiguedad = new JLabel("Selecciona la Antiguedad:");
		labelAntiguedad.setBounds(220, 248, 185, 25);
		labelAntiguedad.setFont(new Font("Andale Mono", 1, 12));
		labelAntiguedad.setForeground(new Color(255, 255, 255));
		add(labelAntiguedad);
		
		comboAntiguedad = new JComboBox();
		comboAntiguedad.setBounds(220, 273, 220, 25);
		comboAntiguedad.setBackground(new java.awt.Color(224, 224, 224));
		comboAntiguedad.setFont(new java.awt.Font("Andale Mono", 1, 14));
		comboAntiguedad.setForeground(new Color(255, 0, 0));
		add(comboAntiguedad);
		comboAntiguedad.addItem("");
		comboAntiguedad.addItem("1 año de servicio");
		comboAntiguedad.addItem("2 a 6 años de servicio");
		comboAntiguedad.addItem("7 años o más de servicio");
		
		labelResultado = new JLabel("Resultado del Cálculo:");
		labelResultado.setBounds(220, 307, 180, 25);
		labelResultado.setFont(new Font("Andale Mono", 1, 12));
		labelResultado.setForeground(new Color(255, 255, 255));
		add(labelResultado);
		
		textArea1 = new JTextArea();
		textArea1.setEditable(false);
		textArea1.setBackground(new Color(224, 224, 224));
		textArea1.setFont(new Font("Andale Mono", 1, 12));
		textArea1.setForeground(new Color(255, 0, 0));
		textArea1.setText("\nAquí aparece el resultado del cálculo de las vacaciones.");
		scrollPane1 = new JScrollPane(textArea1);
		scrollPane1	.setBounds(220, 333, 400, 90);
		add(scrollPane1);
		
		labelFooter = new JLabel("The Coca-Cola Company | Todos los derechos reservados");
		labelFooter.setBounds(135, 445, 500, 30);
		labelFooter.setFont(new Font("Andale Mono", 1, 12));
		labelFooter.setForeground(new java.awt.Color(255, 255, 255));
		add(labelFooter);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == miCalculo) {
			String nombreTrabajador = txtNombreTrabajador.getText();
			String ap = txtAparternoTrabajador.getText();
			String am = txtAMaternoTrabajador.getText();
			String departamento = comboDepartamento.getSelectedItem().toString();
			String antiguedad = comboAntiguedad.getSelectedItem().toString();
			
			if(nombreTrabajador.equals("") || ap.equals("") || am.equals("") || 
					departamento.equals("") || antiguedad.equals("")){
				JOptionPane.showMessageDialog(null, "Debes de llenar todos los campos.");
			}else {
				if(departamento.equals("Atención al Cliente")) {
					if(antiguedad.equals("1 año de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 6 días de  vacaciones.");
					}
					
					if(antiguedad.equals("2 a 6 años de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 14 días de  vacaciones.");
					}
					
					if(antiguedad.equals("7 años o más de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 20 días de  vacaciones.");
					}
				}
				
				if(departamento.equals("Departamento de Logística")) {
					if(antiguedad.equals("1 año de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 7 días de  vacaciones.");
					}
					
					if(antiguedad.equals("2 a 6 años de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 15 días de  vacaciones.");
					}
					
					if(antiguedad.equals("7 años o más de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 22 días de  vacaciones.");
					}
				}
				
				if(departamento.equals("Departamento de Gerencia")) {
					
					if(antiguedad.equals("1 año de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 10 días de  vacaciones.");
					}
					
					if(antiguedad.equals("2 a 6 años de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 20 días de  vacaciones.");
					}
					
					if(antiguedad.equals("7 años o más de servicio")) {
						textArea1.setText("\n El trabajador " + nombreTrabajador + " " + ap + " " + am +
								"\n quien labora en " + departamento + " con " + antiguedad + 
								"\n recibe 30 días de  vacaciones.");
					}
				}
			}
		}
		
		if(e.getSource() == miRojo) {
			getContentPane().setBackground(new Color(255, 0, 0));
		}
		
		if(e.getSource() == miNegro) {
			getContentPane().setBackground(new Color(0, 0, 0));
		}
		
		if(e.getSource() == miMorado) {
			getContentPane().setBackground(new Color(51, 0, 51));
		}
		
		if(e.getSource() == miNuevo) {
			txtNombreTrabajador.setText("");
			txtAparternoTrabajador.setText("");
			txtAMaternoTrabajador.setText("");
			comboDepartamento.setSelectedIndex(0);
			comboAntiguedad.setSelectedIndex(0);
			textArea1.setText("\n Aquí aparece el resultado del cácul de las vacaciones.");
		}
		
		if(e.getSource() == miSalir) {
			Bienvenida ventanaBienvenida = new Bienvenida();
			ventanaBienvenida.setBounds(0, 0, 350, 450);
			ventanaBienvenida.setVisible(true);
			ventanaBienvenida.setResizable(false);
			ventanaBienvenida.setLocationRelativeTo(null);
			this.setVisible(false);
		}
		
		if(e.getSource() == miElCreador) {
			JOptionPane.showMessageDialog(null, "Desarrollado por El Piruetas \n" +
					"www.elpiruetas.com");
		}
	}
	
	
}
