package swing;

import javax.swing.JFrame;

public class Ventana extends JFrame {
	public Ventana() {
		this.setLayout(null);
		/* setLayout: Nos permite agregar los componentes atravez de 
		 * coordenadas que nosotros le indiquemos, y evitamos que 
		 * utilice algun tipo de layout. */
		this.setSize(500, 500);
		/* Asigna el tamaño que tendra por defecto el JFrame*/
		//this.setBounds(0,0,500,500); 
		/* Indicamos dimensiones y coordenadas de la ventana (x, y, width, height) */
		this.setTitle("Swing");
		this.setResizable(false); //Nos permite modificar el tamaño de la ventana
		this.setLocationRelativeTo(null);
		/*Coloca la ventana en una posición relativa a un componente 
		 * que le pasemos como parámetro. Pero si le pasamos null como 
		 * parámetro, coloca a la ventana en el centro de la pantalla.*/
		this.setVisible(true); //Es necesario para que se vea la ventana
		
//		#29
//		Formulario formulario = new Formulario();
//		this.add(formulario);	
		
		//#30 & 31 $ 32
//		TextArea areaTexto = new TextArea();
//		this.add(areaTexto);
		
//		#33
//		Parse formulario = new Parse();
//		add(formulario);
		
//		#34
//		ComboBox combo = new ComboBox();
//		add(combo);
		
//		#35
//		BotonRGB boton = new BotonRGB();
//		add(boton);
		
		this.validate();

	}
}
