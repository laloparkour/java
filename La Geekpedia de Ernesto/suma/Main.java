package suma;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Ingresa un primer número: ");
        int n1 = in.nextInt();
        System.out.print("Igresa un segundo número: ");
        int n2 = in.nextInt();
        
        Suma suma = new Suma(n1, n2);
        suma.imprimirResultado();
        
	}

}
