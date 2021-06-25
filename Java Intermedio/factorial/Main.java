package factorial;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int numero = 0;
		
		
		System.out.print("Ingresa un número: ");
		numero = in.nextInt();
				
		factorial(numero, 1);
		
		
	}
	
	static void factorial(int numero, int acumulador) {
		acumulador = acumulador * numero;
		
		System.out.println("Factorial: " + acumulador);
		
		if(numero > 1) {
			numero--;
			factorial(numero, acumulador);
		}else {
			System.out.println("\nEl factorial es: " + acumulador);
		} 
	
	}

}
