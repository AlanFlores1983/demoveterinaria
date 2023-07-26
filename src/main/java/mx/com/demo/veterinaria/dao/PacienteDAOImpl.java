package mx.com.demo.veterinaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.com.demo.veterinaria.entity.PacienteEntity;
import mx.com.demo.veterinaria.model.PacienteModel;
import mx.com.demo.veterinaria.util.VeterinariaUtil;

public class PacienteDAOImpl implements PacienteDAO{

	private final VeterinariaUtil util = new VeterinariaUtil();

	public int insert(PacienteModel paiente) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.idPaciente from Paciente s where s.nombrePaciente LIKE :compuesta")
					.setParameter("compuesta", paiente.getNombrePaciente());
			List<PacienteEntity> resultList = q.getResultList();

			if(resultList!=null  && resultList.size()>0) {
				return 1;
			}else {		
				PacienteEntity entity = new PacienteEntity();
				entity.setFechaNacimiento(paiente.getFechaNacimiento());
				entity.setNombrePaciente(paiente.getNombrePaciente());
				entity.setTelefono(paiente.getTelefono());
				entity.setTipoNaciente(paiente.getTipoPaciente());
				entityManager.persist(entity);
				transaction.commit();

				return 0;
			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
			return -1;
		} finally {
			emf.close();
		}
	}

	public int update(PacienteModel paciente){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("update Paciente s set s.nombrePaciente = :now, where s.idPaciente = :compuesta ")
					.setParameter("compuesta", paciente.getNombrePaciente())
					.setParameter("now", paciente.getIdPaciente());

			int res = q.executeUpdate();

			transaction.commit();

			return res;

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			//entityManager.close();
			emf.close();
		}
		return 0;
	}	

	public int select(PacienteModel paciente) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.* from Paciente s where s.idPaciente LIKE :compuesta")
					.setParameter("compuesta", paciente.getIdPaciente());
			List<PacienteEntity> resultList = q.getResultList();

			if(resultList!=null  && resultList.size()>0) {
				return 1;
			}else {		
				return 0;
			}

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
			return -1;
		} finally {
			//entityManager.close();
			emf.close();
		}
	}
	
	public int delete(PacienteModel paciente){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("delete Paciente s where s.idPaciente = :compuesta ")
					.setParameter("compuesta", paciente.getIdPaciente());

			int res = q.executeUpdate();

			transaction.commit();

			return res;

		} catch (Exception e) {
			System.out.println(e);
			transaction.rollback();
		} finally {
			//entityManager.close();
			emf.close();
		}
		return 0;
	}	
}

