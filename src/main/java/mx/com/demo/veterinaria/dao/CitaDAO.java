package mx.com.demo.veterinaria.dao;

import mx.com.demo.veterinaria.model.CitaModel;

public interface CitaDAO {
	
	public int insert(CitaModel cita);
	
	public int update(CitaModel cita);
	
	public int delete(CitaModel cita);
	
	public int select(CitaModel cita);
}
