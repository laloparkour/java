
package pkg14.operaciones;

import java.util.Scanner;

public class Operaciones {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        float n1, n2, n3, suma;
        
        //Guardamos las 3 notas
        System.out.println("Ingresa tres calificaciones: ");
        n1 = entrada.nextFloat();
        n2 = entrada.nextFloat();
        n3 = entrada.nextFloat();
        
        //Sumamos las 3 notas
        suma = n1 + n2 + n3;
        
        System.out.println("\n");
        System.out.println("La suma de las calificaciones es: "+suma);
    }
    
}
