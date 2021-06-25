/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg12;

import java.util.Scanner;

/**
 *
 * @author debianredes
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        String copia;
        
        System.out.println("Ingrese una cadena: ");
        cadena = teclado.nextLine();
       
        System.out.println(cadena);
        
        for (int i = cadena.length()-1; i >= 0; i--) {
            cadena[i] = copia[i];
        }
        
        System.out.print(copia);
        
        
    }
    
}
