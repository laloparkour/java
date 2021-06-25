
package pkg13.clasemath;

import java.util.Scanner;

public class Clasemath {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        double base, exponente, elevacion, num, random;
        float decimal;
        long resultado;
        //int resultado
        
        /*Es recomendable usar double al sacar la raiz cuadrada de algun numero
|       double raiz = Math.sqrt(9);
        
        Podemos convertir a entero nuestra funcion sqrt de nuestra clase math declarando como entero
        la variable y agregando entre parentesis el tipo int a nuestra clase Math
        int raiz = (int)Math.sqrt(9); */
        
        /*La funcion pow nos permite elevar a una potencia un numero;
        System.out.print("Ingrese la base: ");
        base = entrada.nextDouble();
        System.out.print("Ingrese el exponente: ");
        exponente = entrada.nextInt();
        elevacion = Math.pow(base, exponente);
        System.out.print(elevacion);
        */
        
        /*Redondeo con doouble y devolviendo long
        System.out.println("Ingresa un numero: ");
        num = entrada.nextDouble();
        resultado = Math.round(num);
        System.out.println("El redonde fue:"+resultado);*/
        
        /*Redondeo con float y devolviendo int
        System.out.println("Ingresa un numero decimal: ");
        decimal = entrada.nextFloat();
        resultado = Math.round(decimal);
        System.out.println(resultado);*/
        
        random = Math.random();
        System.out.println(random);
    }
    
}
