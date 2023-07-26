package mx.com.demo.veterinaria.dao;

import mx.com.demo.veterinaria.model.VeterinarioModel;

public interface VeterinarioDAO {
	
	public int insert(VeterinarioModel veterinario);
	
	public int update(VeterinarioModel veterinario);
	
	public int delete(VeterinarioModel veterinario);
	
	public int select(VeterinarioModel veterinario);
}
