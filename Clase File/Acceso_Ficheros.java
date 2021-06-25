import java.io.File;

public class Acceso_Ficheros {

	public static void main(String[] args) {
		
		File ruta = new File(File.separator + "home" + File.separator + "elpiruetas"
				+ "Documentos" + File.separator + "java");
		
		System.out.println(ruta.getAbsolutePath());
		
		String[] archivos = ruta.list();
		
		for (int i = 0; i < archivos.length; i++) {
			System.out.println(archivos[i]);
			
			File rutaDirectorio = new File(ruta.getAbsolutePath(), archivos[i]);
			
			if(rutaDirectorio.isDirectory()) {
				String[] archivosSubcarpeta = rutaDirectorio.list();
				
				for (int j = 0; j < archivosSubcarpeta.length; j++) {
					System.out.println(archivosSubcarpeta[j]);
				}
			}	
		}
	}
}
