package vistas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import controladores.CampoVacioException;
import controladores.MYSQLConnection;
import modelos.SpringUtilities;
import modelos.TextPrompt;
import modelos.Usuario;

public class Login extends JFrame implements ActionListener
{
	private Font fuente = new Font("Arial", Font.BOLD, 15);
	
	private Image logo;
	
	private JTextField usuario;
	private JPasswordField contrasena;

	private JButton ok, cancelar;
	
	public Login() 
	{
		setTitle("Acceso");
		setSize(400,450);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			logo = ImageIO.read(new File("src/img/icon.png"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		setIconImage(logo);
		
		panel();
		
		setVisible(true);
	}
	
	
	public void panel()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		panel.add(new JLabel(cargarImagen("../img/user.png")));
		
		JPanel p = new JPanel(new SpringLayout());
		usuario = new JTextField(20);
		usuario.setName("Usuario");
	    TextPrompt placeholderUsuario = new TextPrompt("Usuario", usuario);
	    placeholderUsuario.changeAlpha(0.75f);
	    placeholderUsuario.changeStyle(Font.PLAIN);
		p.add(usuario);
		
		contrasena = new JPasswordField(20);
		contrasena.setName("Contraseña");
	    TextPrompt placeholderPassword = new TextPrompt("Contraseña", contrasena);
	    placeholderPassword.changeAlpha(0.75f);
	    placeholderPassword.changeStyle(Font.PLAIN);
		p.add(contrasena);
		
		SpringUtilities.makeCompactGrid(p, //Panel con SpringLayout
				2, 1, //Filas, Columnas
				25, 25, //InicioX, InicioY
				25, 25); //PadX, PadY		
		
		panel.add(p);
		

		JPanel b = new JPanel();
		b.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		ok = new JButton("Ok");
		ok.setFont(fuente);
		ok.setBackground(new Color(0,171,199));
		ok.setForeground(new Color(255,255,255));
		ok.addActionListener(this);
		b.add(ok);
		
		cancelar = new JButton("Cancelar");
		cancelar.setFont(fuente);
		cancelar.setBackground(new Color(0,171,199));
		cancelar.setForeground(new Color(255,255,255));
		cancelar.addActionListener(this);
		b.add(cancelar);
		
		panel.add(b);
		
		add(panel);
	}
	
	
	public ImageIcon cargarImagen(String ruta) 
	{
		Image imagen = null; 
		
		try {
			imagen = ImageIO.read(getClass().getResource(ruta));
			imagen = imagen.getScaledInstance(125, 125, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		return new ImageIcon(imagen);
	}
	
	
	private void validar()
	{
		ArrayList<JComponent> vacios = new ArrayList<JComponent>();
		
		if(usuario.getText().trim().isEmpty())
			vacios.add(usuario);
		if(contrasena.getText().trim().isEmpty())
			vacios.add(contrasena);
		
		if(!vacios.isEmpty()) 
			throw new CampoVacioException(vacios);
	}
	
	
	private void marcoRojo(ArrayList<JComponent> vacios) 
	{
		for (JComponent c : vacios) 
			c.setBorder(BorderFactory.createLineBorder(Color.RED));
	}
	
	
	private void login() 
	{
		try {
			validar();
			buscarUsuarioEnBD(usuario.getText(), contrasena.getText());

			
		} catch (CampoVacioException e) {
			marcoRojo(e.getVacios());
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}
	
	public void buscarUsuarioEnBD(String usuario, String contrasena) {
		Connection con = MYSQLConnection.connect();;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			String consulta = "SELECT nombre, contrasena FROM usuarios WHERE nombre = '" + usuario + "' && contrasena = '" + contrasena + "' ";
			st = con.prepareStatement(consulta);
			rs = st.executeQuery();
			
			if(rs.next()) {
				usuario = rs.getString("nombre");
				contrasena = rs.getString("contrasena");
				
				Ventana v = new Ventana();
				this.dispose();
				
			}else {
				JOptionPane.showMessageDialog(null, "Error en el usuario o contraseña ingresado");
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getActionCommand().equals("Ok")) 
		{
			login();
			
		}else if(e.getActionCommand().equals("Cancelar")) 
		{
			this.dispose();
			
		}
		
	}
	
}
