package mx.com.demo.veterinaria.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  

import java.sql.Timestamp;

@Table(name="t_veterinario", schema = "VETERINARIA")
@Entity(name = "Veterinario")
public class VeterinarioEntity {

	@Id  
	@Column  
	private String cedula;  
	@Column  
	private String paterno;  
	@Column  
	private String materno;  
	@Column  
	private String nombre;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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

	
}  