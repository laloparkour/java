/* CheckBox: Nos permite almacenar un cuadro de seleccion donde podemos colocar distintas
 * opciones a elegir */

package swing;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/* Cuando vamos a agregar un evento a un JCheckBox tenemos que hacer uso
 * de la clase ChangeListener, esta nos permite trabajar con los eventos
 * de un JCheckBox */
public class CheckBox extends JFrame implements ChangeListener{
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	
	
	public CheckBox() {
		setLayout(null);
		check1 = new JCheckBox("Inglés");
		check1.setBounds(10, 10, 150, 30);
		check1.addChangeListener(this);
		add(check1);
		
		setLayout(null);
		check2 = new JCheckBox("Francés");
		check2.setBounds(10, 50, 150, 30);
		check2.addChangeListener(this);
		add(check2);
		
		setLayout(null);
		check3 = new JCheckBox("Alemán");
		check3.setBounds(10, 90, 150, 30);
		check3.addChangeListener(this);
		add(check3);
		
	}
	
	public void stateChanged(ChangeEvent e) {
		String cadena = "";
		/* Si el componente es seleccionado es verdadero hara lo siguiente*/
		if(check1.isSelected() == true) {
			cadena = cadena + "Inglés-";
		}
		
		if(check2.isSelected() == true) {
			cadena = cadena + "Francés-";
		}
		
		if(check3.isSelected() == true) {
			cadena = cadena + "Alemán-";
		}
		
		this.setTitle(cadena);
		
		
	}
	
}
