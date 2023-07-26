package mx.com.demo.veterinaria.service;

import mx.com.demo.veterinaria.model.PacienteModel;

public interface PacienteService {
	
	public int insert(PacienteModel model) throws Exception;
	
	public int delete(PacienteModel model) throws Exception;
	
	public int update(PacienteModel model) throws Exception;
	
	public int select(PacienteModel model) throws Exception;
	
}
