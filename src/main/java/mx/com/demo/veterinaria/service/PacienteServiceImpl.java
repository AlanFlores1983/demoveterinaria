package mx.com.demo.veterinaria.service;

import mx.com.demo.veterinaria.dao.PacienteDAO;
import mx.com.demo.veterinaria.dao.PacienteDAOImpl;
import mx.com.demo.veterinaria.model.PacienteModel;

public class PacienteServiceImpl implements PacienteService{

	PacienteDAO dao;


	public int insert(PacienteModel model) throws Exception {
		int res = 0;
		
		try {
			dao =  new PacienteDAOImpl();

			res = dao.insert(model);

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		return res;
	}	

	public int delete(PacienteModel model) throws Exception {

		try {
			dao =  new PacienteDAOImpl();

			return dao.delete(model);

		}catch(Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int update(PacienteModel model) throws Exception {

		int fresh = 0;
		try {
			dao =  new PacienteDAOImpl();
			fresh = dao.update(model);
			

		}catch(Exception e) {
			e.printStackTrace();
		}

		return fresh;
	}


	public int select(PacienteModel model) throws Exception {
		int nuevo=0;
		try {

			dao =  new PacienteDAOImpl();
			nuevo = dao.select(model);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		return nuevo;

	}

}
