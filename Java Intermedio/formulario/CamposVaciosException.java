package formulario;

public class CamposVaciosException extends RuntimeException{
	
	public CamposVaciosException() {
		super("EL campo esta vacío");
	}
	
}
