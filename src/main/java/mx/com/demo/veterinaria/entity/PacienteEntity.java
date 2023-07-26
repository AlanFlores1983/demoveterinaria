package mx.com.demo.veterinaria.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  

import java.sql.Timestamp;

@Table(name="t_paciente", schema = "VETERINARIA")
@Entity(name = "Paciente")
public class PacienteEntity {

	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaciente =1;  
	@Column  
	private String nombrePaciente;  
	@Column  
	private String tipoNaciente;  
	@Column  
	private String fechaNacimiento;  
	@Column  
	private String telefono;
	
	public int getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public String getTipoNaciente() {
		return tipoNaciente;
	}
	public void setTipoNaciente(String tipoNaciente) {
		this.tipoNaciente = tipoNaciente;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}  