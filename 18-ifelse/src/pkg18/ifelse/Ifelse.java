
package pkg18.ifelse;

import javax.swing.JOptionPane;

public class Ifelse {

    public static void main(String[] args) {
        int numero, dato = 5;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Digite un numero: "));
        
        if(numero == dato){
            JOptionPane.showMessageDialog(null, "EL numero es 5.");
        }
        else{
            JOptionPane.showMessageDialog(null, "EL numero es diferente de 5.");
        }
    }
}
