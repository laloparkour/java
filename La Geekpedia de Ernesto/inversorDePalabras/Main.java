package inversorDePalabras;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        String palabra = "";
        String palabraInvertida = "";
        int longitudPalabra = 0;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Escribe una palabra o frase: ");
        palabra = in.nextLine();
        
        longitudPalabra = palabra.length();
        
        while (longitudPalabra != 0) {            
            palabraInvertida += palabra.substring(longitudPalabra-1, longitudPalabra);
            longitudPalabra--;
        }
        
        System.out.println("Palabra invertidad: " + palabraInvertida);

	}

}
