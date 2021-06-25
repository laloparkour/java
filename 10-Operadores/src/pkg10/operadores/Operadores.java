
package pkg10.operadores;

import java.util.Scanner;

public class Operadores {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        float numUno, numDos, suma, resta, multiplicacion, division, resto;
     
        System.out.println("Digite el numero #1:");
        numUno = entrada.nextFloat();
        System.out.println("Digite el numero #2:");
        numDos = entrada.nextFloat();
        
        suma = numUno + numDos;
        resta = numUno - numDos;
        multiplicacion = numUno * numDos;
        division = numUno / numDos;
        resto = numUno % numDos;
        
        System.out.println("La suma es: "+suma);
        System.out.println("La resta es: "+resta);
        System.out.println("La multiplicacion es: "+multiplicacion);
        System.out.println("La division es: "+division);
        System.out.println("EL resto es: "+resto);
        
    }
    
}
