/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg11;

import java.util.Scanner;

/**
 *
 * @author debianredes
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado =  new Scanner (System.in);
        int contador = 0;
        int n = 2;
        int[] numeros = new int[20];
        int numero = 0;
        
        while(n<72){
            
            contador = 0;
            
            for (int i = 1; i <= n; i++) {
                if(n % i == 0){
                    contador++;
                }
            }
            
            if(contador == 2){
                numeros[numero] = n;
                numero++;
            }
            
            n++;
        }
        
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i] + " ");
        }
        
    }
    
}
