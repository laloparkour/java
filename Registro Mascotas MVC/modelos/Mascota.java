package modelos;

public class Mascota
{
	
	private int id;
	private String nombre;
	private String tipo;
	private String sexo;
	private String raza;
	private String color;
	private int edad;
	private String tamanio;
	private String propietario;
		
	
	public Mascota() {
		
	}
	
	public Mascota(int id, String nombre, String tipo, String sexo, String raza, String color, int edad, String tamanio, String propietario) 
	{
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.sexo = sexo;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.tamanio = tamanio;
		this.propietario = propietario;
	}
	
	public Mascota(String nombre, String tipo, String sexo, String raza, String color, int edad, String tamanio, String propietario) 
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.sexo = sexo;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.tamanio = tamanio;
		this.propietario = propietario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", sexo=" + sexo + ", raza=" + raza
				+ ", color=" + color + ", edad=" + edad + ", tamanio=" + tamanio + ", propietario=" + propietario + "]";
	}
	
	
}
