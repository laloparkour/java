package controladores;

import java.util.ArrayList;
import javax.swing.JComponent;

public class CampoVacioException extends RuntimeException 
{
	
	private ArrayList<JComponent> vacios;
	private String mensaje;
	
	public CampoVacioException(ArrayList<JComponent> vacios) 
	{
		this.vacios = vacios;
		
		mensaje =  "Hay campos vacíos, favor de verificar los datos: \n";
		
		for (JComponent c : vacios)
			mensaje += "- " + c.getName() + "\n";
		
	}
	
	public String getMessage() {
		return mensaje;
	}
	
	public ArrayList<JComponent> getVacios(){
		return vacios;
	}
	
}
