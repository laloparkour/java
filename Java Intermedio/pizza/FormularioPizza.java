package pizza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class FormularioPizza extends JPanel{
	private Font fuente;
	
	public FormularioPizza() {
		fuente = new Font("Arial", Font.BOLD, 25);
		setLayout(new GridLayout(3,1));
		
		agregarNorte();
		agregarCentro();
		agregarSur();
		
	}
	
	private void agregarNorte() {
		
		SpringLayoutTest panelNorte = new SpringLayoutTest();
		
		add(panelNorte);
		
	}
	
	
	private void agregarCentro() {
		
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.X_AXIS));
		
		/*CONTENEDOR IZQUIERDA*/
		JPanel panelSize = new JPanel();
		panelSize.setLayout(new BoxLayout(panelSize, BoxLayout.Y_AXIS));
		TitledBorder size = new TitledBorder("Tamaño");
		size.setTitleJustification(TitledBorder.RIGHT);
		size.setTitlePosition(TitledBorder.TOP);
		size.setTitleColor(new Color(28, 88, 249));
		panelSize.setBorder(size);
		
		JRadioButton rdChica = new JRadioButton("Chica");
		panelSize.add(rdChica);
		JRadioButton rdMediana = new JRadioButton("Mediana");
		panelSize.add(rdMediana);
		JRadioButton rdGrande = new JRadioButton("Grande");
		panelSize.add(rdGrande);
		
		ButtonGroup grupoRadioSize = new ButtonGroup();
		grupoRadioSize.add(rdChica);
		grupoRadioSize.add(rdMediana);
		grupoRadioSize.add(rdGrande);
		
		/*CONTENEDOR DERECHA*/
		JPanel panelStyle = new JPanel();
		panelStyle.setLayout(new BoxLayout(panelStyle, BoxLayout.Y_AXIS));
		TitledBorder style = new TitledBorder("Tipo");
		style.setTitleJustification(TitledBorder.RIGHT);
		style.setTitlePosition(TitledBorder.TOP);
		style.setTitleColor(new Color(28, 88, 249));
		panelStyle.setBorder(style);
		
		JRadioButton rdDelgada = new JRadioButton("Delgada");
		panelStyle.add(rdDelgada);
		JRadioButton rdGruesa = new JRadioButton("Gruesa");
		panelStyle.add(rdGruesa);
		
		ButtonGroup grupoRadio = new ButtonGroup();
		grupoRadio.add(rdDelgada);
		grupoRadio.add(rdGruesa);
		
		/*CONTENEDOR CENTRO*/
		JPanel panelToppings = new JPanel();
		panelToppings.setLayout(new BoxLayout(panelToppings, BoxLayout.Y_AXIS));
		TitledBorder toppings = new TitledBorder("Ingredientes");
		toppings.setTitleJustification(TitledBorder.RIGHT);
		toppings.setTitlePosition(TitledBorder.TOP);
		toppings.setTitleColor(new Color(28, 88, 249));
		panelToppings.setBorder(toppings);
		
		JRadioButton rdPepperoni = new JRadioButton("Pepperoni");
		panelToppings.add(rdPepperoni);
		JRadioButton rdChampinion = new JRadioButton("Champiñon");
		panelToppings.add(rdChampinion);
		JRadioButton rdMexicana = new JRadioButton("Mexicana");
		panelToppings.add(rdMexicana);
		JRadioButton rdHawaiana = new JRadioButton("Hawaiana");
		panelToppings.add(rdHawaiana);
		
		ButtonGroup grupoRadioIngredientes = new ButtonGroup();
		grupoRadioIngredientes.add(rdPepperoni);
		grupoRadioIngredientes.add(rdChampinion);
		grupoRadioIngredientes.add(rdMexicana);
		grupoRadioIngredientes.add(rdHawaiana);
		
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelSize);
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelStyle);
		panelCentro.add(Box.createHorizontalGlue());
		panelCentro.add(panelToppings);
		panelCentro.add(Box.createHorizontalGlue());
		
		add(panelCentro);
	}
	
	private void agregarSur() {
		JPanel panelSur = new JPanel();
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));
		
		/*CONTENEDOR ACEPTAR*/
		JPanel panelAceptar = new JPanel();
		panelAceptar.setLayout(new BoxLayout(panelAceptar, BoxLayout.X_AXIS));

		JButton btnAceptar = new JButton("Aceptar");
		panelAceptar.add(btnAceptar);
		
		/*CONTENEDOR CANCELAR*/
		JPanel panelCancelar = new JPanel();
		panelCancelar.setLayout(new BoxLayout(panelCancelar, BoxLayout.X_AXIS));
		
		JButton btnCancelar = new JButton("Cancelar");
		panelCancelar.add(btnCancelar);
		
		
		panelSur.add(Box.createHorizontalGlue());
		panelSur.add(panelAceptar);
		panelSur.add(Box.createRigidArea(new Dimension(10, 10)));
		panelSur.add(panelCancelar);
		panelSur.add(Box.createRigidArea(new Dimension(40, 10)));

		add(panelSur);
		
	}
	
}
