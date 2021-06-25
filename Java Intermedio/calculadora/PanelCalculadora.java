package calculadora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelCalculadora extends JPanel implements ActionListener {
	private JTextField resultado;
	private double num1 = 0;
	private double num2 = 0;
	
	public PanelCalculadora() {
		setLayout(new BorderLayout());
		agregarTextField();
		agregarBotones();
		agregarSur();
		
	}
	
	public void agregarTextField() {
		JPanel panelResultado = new JPanel();
		panelResultado.setLayout(new BoxLayout(panelResultado, BoxLayout.X_AXIS));
		
		resultado = new JTextField();
		
		panelResultado.add(Box.createRigidArea(new Dimension(67, 10)));
		panelResultado.add(resultado);
		panelResultado.add(Box.createRigidArea(new Dimension(68, 10)));
		
		add(panelResultado, BorderLayout.NORTH);
	}
	
	public void agregarBotones() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.X_AXIS));
		
		JPanel panelIzquierda = new JPanel();
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(4, 4, 10, 10));		
		
		JButton btnSumar = new JButton("+");
		panelBotones.add(btnSumar);
		btnSumar.addActionListener(this);
		
		JButton btnRestar = new JButton("-");
		panelBotones.add(btnRestar);
		btnRestar.addActionListener(this);
		
		JButton btnMultiplicar = new JButton("*");
		panelBotones.add(btnMultiplicar);
		btnMultiplicar.addActionListener(this);
		
		JButton btnDividir = new JButton("/");
		panelBotones.add(btnDividir);
		btnDividir.addActionListener(this);
		
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton(i+"");
			panelBotones.add(btn);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Object presionado = e.getSource();
					JButton boton = (JButton)presionado;
					String accion = boton.getActionCommand();
					
				
					
				}
			});
		
		}
		
		JButton btnPunto = new JButton(".");
		panelBotones.add(btnPunto);
		btnPunto.addActionListener(this);
		
		JButton btnIgual = new JButton("=");
		panelBotones.add(btnIgual);
		btnIgual.addActionListener(this);
		
		JPanel panelDerecha = new JPanel();
		
		panelPrincipal.add(panelIzquierda);
		panelPrincipal.add(panelBotones);
		panelPrincipal.add(panelDerecha);
		
		add(panelPrincipal);
		
	}
	
	public void agregarSur() {
		JPanel panelSur = new JPanel();
		panelSur.setLayout(new BoxLayout(panelSur, BoxLayout.X_AXIS));
		
		JButton boton = new JButton("C");
		panelSur.add(Box.createHorizontalGlue());
		panelSur.add(boton);
		boton.addActionListener(this);
		panelSur.add(Box.createHorizontalGlue());
		add(panelSur, BorderLayout.SOUTH);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object presionado = e.getSource();
		JButton boton = (JButton)presionado;
		String accion = boton.getActionCommand();
		
		//resultado.setText(resultado.getText()+accion);
		
		System.out.print(accion);
	}

}
