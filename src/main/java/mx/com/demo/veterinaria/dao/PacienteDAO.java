package mx.com.demo.veterinaria.dao;

import mx.com.demo.veterinaria.model.PacienteModel;

public interface PacienteDAO {
	
	public int insert(PacienteModel paciente);
	
	public int update(PacienteModel paciente);
	
	public int delete(PacienteModel paciente);
	
	public int select(PacienteModel paciente);
}
