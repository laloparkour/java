import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File ruta = new File("ejemplo_archivo");
		
		System.out.println("Ruta: " + ruta.getAbsolutePath());
		
		System.out.println(ruta.exists());
	}

}
