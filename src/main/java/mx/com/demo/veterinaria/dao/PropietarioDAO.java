package mx.com.demo.veterinaria.dao;

import mx.com.demo.veterinaria.model.PropietarioModel;

public interface PropietarioDAO {
	
	public int insert(PropietarioModel prop);
	
	public int update(PropietarioModel prop);
	
	public int delete(PropietarioModel prop);
	
	public int select(PropietarioModel prop);
}
