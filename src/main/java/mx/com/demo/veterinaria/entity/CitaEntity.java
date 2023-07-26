package mx.com.demo.veterinaria.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.com.demo.veterinaria.model.PropietarioModel;
import mx.com.demo.veterinaria.model.VeterinarioModel;

import java.sql.Timestamp;

@Table(name="t_cita", schema = "VETERINARIA")
@Entity(name = "Cita")
public class CitaEntity {

	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCita =1;  
	@Column  
	private String nombrePaciente;  
	@Column  
	private int idPropietario;  
	@Column  
	private String cedula;  
	@Column  
	private String fechaCita;
	
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public String getNombrePaciente() {
		return nombrePaciente;
	}
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(String fechaCita) {
		this.fechaCita = fechaCita;
	}
	

}  