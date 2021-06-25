/* RaddioButton: Es es un conjunto de opciones excluyentes entre si, es decir, 
 * si el usuario selecciona una opcion, todas las demas se van a deseleccionar
 * dejando una unica opcion disponible para el usuario. */

package swing;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Radio extends JFrame implements ChangeListener{
	//Un JRadioButton se divide en dos componentes
	
	//Componentes para las opciones disponibles
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	
	//Componente que agrupa las opciones
	private ButtonGroup bg;
	
	public Radio() {
		this.setLayout(null);
		
		bg = new ButtonGroup();
		
		radio1 = new JRadioButton("640x480");
		radio1.setBounds(10, 10, 100, 30);
		radio1.addChangeListener(this);
		this.add(radio1);
		bg.add(radio1); //Agregamos al grupo de botones
		
		radio2 = new JRadioButton("800x600");
		radio2.setBounds(10, 70, 100, 30);
		radio2.addChangeListener(this);
		this.add(radio2);
		bg.add(radio2); //Agregamos al grupo de botones
		
		radio3 = new JRadioButton("1024x768");
		radio3.setBounds(10, 130, 100, 30);
		radio3.addChangeListener(this);
		this.add(radio3);
		bg.add(radio3); //Agregamos al grupo de botones
		
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if(radio1.isSelected() == true) {
			this.setSize(640, 480);
		}
		
		if(radio2.isSelected() == true) {
			this.setSize(800, 600);
		}
		
		if(radio3.isSelected() == true) {
			this.setSize(1024, 768);
		}
		
	}

}
