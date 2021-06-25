package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import controladores.CampoVacioException;
import controladores.MYSQLConnection;
import modelos.Mascota;
import modelos.ModeloTablaMascotas;
import modelos.SpringUtilities;


public class FormularioEditar extends JFrame implements ActionListener
{ 
	private Font fuente = new Font("Arial", Font.BOLD, 15);
	
	private Image logo;
	
	private JLabel etiquetaNombre, etiqueTipo, etiquetaSexo, etiquetaRaza, etiquetaColor, etiquetaEdad, etiquetaTamanio, etiquetaPropietario;
	private JTextField campoTextoNombre, campoTextoColor, campoTextoEdad, campoTextoPropietario;
	private JComboBox<String> tipos, sexos, razas, tamanios;
	
	private JButton guardar, cancelar;
	
	private JPanel panel;
	private JPanel p;
	private Mascota mascota;
	private ModeloTablaMascotas modeloMascotas;
	
	public FormularioEditar(Mascota mascota, ModeloTablaMascotas modeloMascotas)
	{
		this.mascota = mascota;
		this.modeloMascotas = modeloMascotas;
		
		setTitle("Formulario");
		setSize(320,520);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		try {
			logo = ImageIO.read(new File("src/img/icon.png"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		setIconImage(logo);
		
		panel();
		
		setearCampos(mascota);
		
		
		setVisible(true);
	}
	
	
	public void panel()
	{
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		p = new JPanel(new SpringLayout()); 
		
		etiquetaNombre = new JLabel ("Nombre:");
		etiquetaNombre.setFont(fuente);
		p.add(etiquetaNombre);
		
		campoTextoNombre = new JTextField();
		campoTextoNombre.setName("Nombre");
		campoTextoNombre.setFont(fuente);
		p.add(campoTextoNombre);
		
		etiqueTipo = new JLabel ("Tipo:");
		etiqueTipo.setFont(fuente);
		p.add(etiqueTipo);
		
		String[] opcionesTipo = {"Perro", "Gato", "Conejo", "Pez", "Tortuga","Otro"};
		
		tipos = new JComboBox<String>(opcionesTipo);
		tipos.setName("Tipos");
		tipos.setSelectedIndex(-1);
		p.add(tipos);
		
		etiquetaSexo = new JLabel ("Sexo:");
		etiquetaSexo.setFont(fuente);
		p.add(etiquetaSexo);
		
		String[] opcionesSexo = {"Macho", "Hembra"};
		
		sexos = new JComboBox<String>(opcionesSexo);
		sexos.setName("Sexo");
		sexos.setSelectedIndex(-1);
		p.add(sexos);
		
		etiquetaRaza = new JLabel ("Raza:");
		etiquetaRaza.setFont(fuente);
		p.add(etiquetaRaza);
		
		String[] opcionesRaza = {"Mestizo", "Pastor aleman", "Husky siberiano", "San bernardo", "Dalmata", "Chihuahua", "Akita inu", "Labrador", "Bulldog", 
				"Corgi", "Doberman", "Malamute", "Gran danes", "Manx", "Egipcio", "Siames", "Snowshoe", "Muchkin", "Australiano", "Azul ruso", "Persa", "Salchicha", "French poodle", "Otro"};
		
		razas = new JComboBox<String>(opcionesRaza);
		razas.setName("Raza");
		razas.setSelectedIndex(-1);
		p.add(razas);
		
		etiquetaColor = new JLabel ("Color:");
		etiquetaColor.setFont(fuente);
		p.add(etiquetaColor);
		
		campoTextoColor = new JTextField();
		campoTextoColor.setName("Color");
		campoTextoColor.setFont(fuente);
		p.add(campoTextoColor);
		
		etiquetaEdad = new JLabel ("Edad:");
		etiquetaEdad.setFont(fuente);
		p.add(etiquetaEdad);
		
		campoTextoEdad = new JTextField();
		campoTextoEdad.setName("Edad");
		campoTextoEdad.setFont(fuente);
		p.add(campoTextoEdad);
		
		etiquetaTamanio = new JLabel ("Tamaño:");
		etiquetaTamanio.setFont(fuente);
		p.add(etiquetaTamanio);
		
		String[] opcionesTamanio = {"Pequeño", "Mediano", "Grande"};
		
		tamanios = new JComboBox<String>(opcionesTamanio);
		tamanios.setName("Tamaño");
		tamanios.setSelectedIndex(-1);
		p.add(tamanios);
		
		etiquetaPropietario = new JLabel ("Propietario:");
		etiquetaPropietario.setFont(fuente);
		p.add(etiquetaPropietario);
		
		campoTextoPropietario = new JTextField();
		campoTextoPropietario.setName("Propietario");
		campoTextoPropietario.setFont(fuente);
		p.add(campoTextoPropietario);
		
		SpringUtilities.makeCompactGrid(p, //Panel con SpringLayout
				8, 2, //Filas, Columnas
				25, 25, //InicioX, InicioY
				25, 25); //PadX, PadY		
		
		panel.add(p);
		
		JPanel b = new JPanel();
		b.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		guardar = new JButton("Guardar");
		guardar.setFont(fuente);
		guardar.setBackground(new Color(0,171,199));
		guardar.setForeground(new Color(255,255,255));
		guardar.addActionListener(this);
		b.add(guardar);
		
		cancelar = new JButton("Cancelar");
		cancelar.setFont(fuente);
		cancelar.setBackground(new Color(0,171,199));
		cancelar.setForeground(new Color(255,255,255));
		cancelar.addActionListener(this);
		b.add(cancelar);
		
		panel.add(b);
		
		add(panel);
	}
	
	
	private int validarEdad(String edad)
	{
		int resultado = 0;
		
		try {
			if(edad != null) {
				resultado = Integer.parseInt(edad);
			}
		} catch (NumberFormatException e) {
			System.out.println("No es un número");
		}
		
		return resultado;
	}
	
	
	public void setearCampos(Mascota m)
	{
		
		campoTextoNombre.setText(m.getNombre());
		tipos.setSelectedItem(m.getTipo());
		sexos.setSelectedItem(m.getSexo());
		razas.setSelectedItem(m.getRaza());
		campoTextoColor.setText(m.getColor());
		campoTextoEdad.setText(Integer.toString(m.getEdad()));
		tamanios.setSelectedItem(m.getTamanio());
		campoTextoPropietario.setText(m.getPropietario());	
	}
	
	public Mascota obtenerMascota()
	{
		int id = mascota.getId();
		String nombre = campoTextoNombre.getText();
		String tipo = (String) tipos.getSelectedItem();
		String sexo = (String) sexos.getSelectedItem();
		String raza = (String) razas.getSelectedItem();
		String color = campoTextoColor.getText();
		int edad = validarEdad(campoTextoEdad.getText());
		String tamanio = (String) tamanios.getSelectedItem();
		String propietario = campoTextoPropietario.getText();
		
		Mascota m = new Mascota(id, nombre, tipo, sexo, raza, color,  edad, tamanio, propietario);
		
		return m;
		
	}
	
	public void validar() 
	{
		ArrayList<JComponent> vacios = new ArrayList<JComponent>();
		
		if(campoTextoNombre.getText().trim().isEmpty())
			vacios.add(campoTextoNombre);
		if(tipos.getSelectedIndex() == -1)
			vacios.add(tipos);
		if(sexos.getSelectedIndex() == -1)
			vacios.add(sexos);
		if(razas.getSelectedIndex() == -1)
			vacios.add(razas);
		if(campoTextoColor.getText().trim().isEmpty())
			vacios.add(campoTextoColor);
		if(campoTextoEdad.getText().trim().isEmpty())
			vacios.add(campoTextoEdad);
		if(tamanios.getSelectedIndex() == -1)
			vacios.add(tamanios);
		if(campoTextoPropietario.getText().trim().isEmpty())
			vacios.add(campoTextoPropietario);
		
		if(!vacios.isEmpty()) 
			throw new CampoVacioException(vacios);	
	}
	
	
	public void borrarDatos() 
	{
		modeloMascotas.vaciarTabla();
	}
	
	public void cargarTabla() 
	{
		borrarDatos();
		
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		
		Connection con = MYSQLConnection.connect();
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = (Statement) con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY); 
			String consulta = "SELECT * FROM mascotas";
			rs = st.executeQuery(consulta);
			
			while(rs.next()) {
				mascotas.add(new Mascota(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("tipo"),
					rs.getString("sexo"),
					rs.getString("raza"),
					rs.getString("color"),
					rs.getInt("edad"),
					rs.getString("tamanio"),
					rs.getString("propietario")
				));
			}
			
			for (Mascota mascota: mascotas) {
				modeloMascotas.addRow(mascota);
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
		}finally {
			try {
				con.close();
				st.close();
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}

	}
	
	
	public void editar(Mascota m)
	{
		try {
			validar();
			
			PreparedStatement st = null;
			
			try(Connection con = MYSQLConnection.connect()) {
				String consulta = "UPDATE mascotas SET nombre = ?,"
						+ "tipo = ?,"
						+ " sexo = ?,"
						+ " raza = ?,"
						+ " color = ?,"
						+ " edad = ?,"
						+ " tamanio = ?,"
						+ " propietario = ?"
						+ " WHERE id = ?";
				
				st = con.prepareStatement(consulta);
				st.setString(1, m.getNombre());
				st.setString(2, m.getTipo());
				st.setString(3, m.getSexo());
				st.setString(4, m.getRaza());
				st.setString(5, m.getColor());
				st.setInt(6, m.getEdad());
				st.setString(7, m.getTamanio());
				st.setString(8, m.getPropietario());
				st.setInt(9, m.getId());
				
				st.execute();
				
				this.dispose();
				JOptionPane.showMessageDialog(null, "Datos actualizados correctamente");
				
			}catch(SQLException ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(null, "No se pudo cargar la información");
			}finally {
				try {
					st.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			
		} catch (CampoVacioException e) {
			this.marcoRojo(e.getVacios());
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
		
	}
	
	
	public void marcoRojo(ArrayList<JComponent> vacios) 
	{
		for (JComponent c : vacios) 
			c.setBorder(BorderFactory.createLineBorder(Color.RED));
	}

	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getActionCommand().equals("Guardar")) 
		{
			editar(obtenerMascota());
			cargarTabla();
			
		}else if(e.getActionCommand().equals("Cancelar")) 
		{
			this.dispose();	
		}
		
	}

}
