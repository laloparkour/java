/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg9.joptionpane;

import javax.swing.JOptionPane;

public class JOptionPane {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cadena;
        int entero;
        char letra;
        double  decimal;
        
        //Entrada y salida de datos con JOptionPane(Ventanas Emergentes)
        //JOptionPane nos devuelve un string
        cadena = JOptionPane.showInputDialog("Digite una cadena: ");
        //Con la clase Integer.parsInt() podemos convertir a enterno nuestra entrada de datos
        entero = Integer.parseInt(JOptionPane.showInputDialog("Digite un entero: "));
        //Si utilizamos .charAt(0) podemos introducir un caracter
        letra = JOptionPane.showInputDialog("Digite una caracter: ").charAt(0);
        //Con la clase Double.parseDouble() podemos convertir a entero nuestra entrada de datos
        decimal = Double.parseDouble(JOptionPane.showInputDialog("Digite un decimal: "));
        
        //Mostrar datos con JOptionPane
        JOptionPane.showMessageDialog(null, "La cadena es: "+cadena);
        JOptionPane.showMessageDialog(null, "El entero es: "+entero);
        JOptionPane.showMessageDialog(null, "El caracter es: "+letra);
        JOptionPane.showMessageDialog(null, "EL numero decimal es: "+decimal);
        
    }
    
}
