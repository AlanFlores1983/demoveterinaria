package mx.com.demo.veterinaria.model;

public class VeterinarioModel implements java.io.Serializable {

	private static final long serialVersionUID = 3535389129401128953L;

	private String paterno;
	private String materno;
	private String nombre;
	private String cedula;
	
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
