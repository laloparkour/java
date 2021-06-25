package formulario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

public class MiPanel extends JPanel implements ActionListener {
	private int x = 20, y = 20;
	private Font fuente = new Font("Tahoma", Font.PLAIN, 12);
	
	private JLabel labelTitulo, labelNombre, labelCorreo, labelContraseña, labelGenero, 
	labelNacimiento, labelDireccion;
	private JTextField txtNombre, txtCorreo;
	private JPasswordField password;
	private JRadioButton radioHombre;
	private JRadioButton radioMujer;
	private ButtonGroup bgGenero;
	private JComboBox comboDia;
	private JComboBox comboMes;
	private JComboBox comboAnio;
	
	private JTextArea textArea;;
	private JScrollPane scrollPane;
	
	private JCheckBox cbTerminos;
	
	private JButton btnRegistrarse, btnLimpiar;
	
	public MiPanel() {
		setLayout(null);
		agregarComponentes();
		
	}
	
	private void agregarComponentes() {
		labelTitulo = new JLabel("Regístrate");
		labelTitulo.setBounds(x+95, y+20, 200, 40);
		labelTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(labelTitulo);
		
		labelNombre = new JLabel("Nombre");
		labelNombre.setBounds(x, y+=100, 100, 20);
		labelNombre.setFont(fuente);
		add(labelNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(x, y+20, 345, 35);
		txtNombre.setFont(fuente);
		add(txtNombre);
		
		labelCorreo = new JLabel("Correo");
		labelCorreo.setBounds(x, y+=70, 100, 20);
		labelCorreo.setFont(fuente);
		add(labelCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(x, y+20, 345, 35);
		txtCorreo.setFont(fuente);
		add(txtCorreo);
		
		labelContraseña = new JLabel("Contraseña");
		labelContraseña.setBounds(x, y+=70, 100, 20);
		labelContraseña.setFont(fuente);
		add(labelContraseña);
		
		password = new JPasswordField();
		password.setBounds(x, y+20, 345, 35);
		password.setFont(fuente);
		add(password);
		
		labelGenero = new JLabel("Género");
		labelGenero.setBounds(x, y+=70, 100, 20);
		labelGenero.setFont(fuente);
		add(labelGenero);
		
		radioHombre = new JRadioButton("Hombre");
		radioHombre.setBounds(x+70, y, 100, 20);
		add(radioHombre);
		
		radioMujer = new JRadioButton("Mujer");
		radioMujer.setBounds(x+170, y, 100, 20);
		add(radioMujer);
		
		bgGenero = new ButtonGroup();
		bgGenero.add(radioHombre);
		bgGenero.add(radioMujer);
		
		labelNacimiento = new JLabel("Fecha de nacimiento");
		labelNacimiento.setBounds(x, y+=30, 200, 20);
		labelNacimiento.setFont(fuente);
		add(labelNacimiento);
		
		comboDia = new JComboBox();
		comboDia.setBounds(x, y+=25, 50, 20);
		comboDia.addItem("Día");
		for (int i = 1; i <= 31; i++) {
			comboDia.addItem(String.valueOf(i));
		}
		add(comboDia);
		
		comboMes = new JComboBox();
		comboMes.setBounds(x+60, y, 50, 20);
		comboMes.addItem("Mes");
		for (int i = 1; i <= 12; i++) {
			comboMes.addItem(String.valueOf(i));
		}
		add(comboMes);
		
		comboAnio = new JComboBox();
		comboAnio.setBounds(x+120, y, 50, 20);
		comboAnio.addItem("Año");
		for (int i = 2021; i >= 1900; i--) {
			comboAnio.addItem(String.valueOf(i));
		}
		add(comboAnio);
		
		labelDireccion = new JLabel("Dirección");
		labelDireccion.setBounds(x, y+=30, 200, 20);
		labelDireccion.setFont(fuente);
		add(labelDireccion);
		
		textArea = new JTextArea(5, 30);
		scrollPane = new JScrollPane(textArea);
		textArea.setEditable(true);
		scrollPane.setBounds(x, y+=20, 345, 100);
		add(scrollPane);
		
		cbTerminos = new JCheckBox("Aceptar términos y condiciones.", false);
		cbTerminos.setFont(fuente);
		cbTerminos.setBounds(x, y+=110, 200, 20);
		add(cbTerminos);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(x+30, y+=50, 140, 40);
		btnRegistrarse.setFont(fuente);
		btnRegistrarse.addActionListener(this);
		add(btnRegistrarse);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(x+180, y, 140, 40);
		btnLimpiar.setFont(fuente);
		btnLimpiar.addActionListener(this);
		add(btnLimpiar);
		
		
		
	}
	
	public boolean validarCampos() {
		
		
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton)e.getSource();
		String accion = boton.getActionCommand();
		
		switch (accion) {
		case "Registrarse":
		
//			if(txtNombre.getText().isEmpty()) {
//				System.out.println("EL campo esta vacío");
//			}else {
//				System.out.println("Se ingreso el nombre");
//			}
				
				
			if(txtCorreo.equals("")) {
				System.out.println("El campo correo esta vacío");
			}else if(password.equals("")) {
				System.out.println("El campo esta vacío, ingresa una contraseña");
			} 
				
//			if(radioHombre.isSelected() == false && radioMujer.isSelected() == false) {
//				System.out.println("Debes seleccionar un genero");
//			}else {
//				System.out.println("Se ah seleccionado un genero");
//			}
			
			if(txtNombre.getText().equals("") && txtCorreo.getText().equals("") && password.getText().equals("") && radioHombre.isSelected() == false &&
					radioMujer.isSelected() == false && comboDia.getSelectedIndex() == 0 && comboMes.getSelectedIndex() == 0 && comboAnio.getSelectedIndex() == 0 &&
					textArea.getText().equals("") && cbTerminos.isSelected() == false) {
				JOptionPane.showMessageDialog(null, "campos vacios");
			}
			
			break;
			
		case "Limpiar":
			
			txtNombre.setText("");
			txtCorreo.setText("");
			password.setText("");
			bgGenero.clearSelection();
			comboDia.setSelectedIndex(0);
			comboMes.setSelectedIndex(0);
			comboAnio.setSelectedIndex(0);
			textArea.setText("");
			cbTerminos.setSelected(false);
			break;
		}
		
		
	}
}
