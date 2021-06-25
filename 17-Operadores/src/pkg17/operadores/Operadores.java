/*
Ejercicio 7: Construir un programa que, dado un número total de horas, devuelve el número de semanas, días y horas  equivalentes. 
Por ejemplo, dado un total de 1000 horas debe mostrar 5 semanas, 6 días y 16 horas.
*/

package pkg17.operadores;

import java.util.Scanner;

public class Operadores {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeroHoras, numSemanas, numDias, horasEquivalentes;
        
        System.out.println("Ingrese el numero de horas? ");
        numeroHoras = entrada.nextInt();
        
        numSemanas = numeroHoras / 168;
        numDias = numeroHoras%168 / 24;
        horasEquivalentes = numeroHoras%24;
        
        System.out.println("Semanas: "+numSemanas);
        System.out.println("Dias: "+numDias);
        System.out.println("Horas: "+horasEquivalentes);
    }   
}
