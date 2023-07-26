package mx.com.demo.veterinaria.entity;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import mx.com.demo.veterinaria.model.PacienteModel;

import java.sql.Timestamp;
import java.util.List;

@Table(name="t_propietario", schema = "VETERINARIA")
@Entity(name = "Propietario")
public class PropietarioEntity {

	@Id  
	@Column  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPropietario =1;  
	@Column  
	private String paterno;  
	@Column  
	private String materno;  
	@Column  
	private String nombre;
	@Column  
	private int idPaciente;
	

}  