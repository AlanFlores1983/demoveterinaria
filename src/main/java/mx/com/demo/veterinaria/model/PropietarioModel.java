package mx.com.demo.veterinaria.model;

import java.io.Serializable;
import java.util.List;

public class PropietarioModel implements Serializable{
	

	private static final long serialVersionUID = 3535389129401128953L;

	private String idPropietario;
	private String paterno;
	private String materno;
	private String nombre;
	private List<PacienteModel> paciente;
	
	public String getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
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
	public List<PacienteModel> getPaciente() {
		return paciente;
	}
	public void setPaciente(List<PacienteModel> paciente) {
		this.paciente = paciente;
	}
	
	
	
}
