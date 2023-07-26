package mx.com.demo.veterinaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.com.demo.veterinaria.entity.CitaEntity;
import mx.com.demo.veterinaria.model.CitaModel;
import mx.com.demo.veterinaria.util.VeterinariaUtil;

public class CitaDAOImpl implements CitaDAO{

	private final VeterinariaUtil util = new VeterinariaUtil();

	public int insert(CitaModel cita) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.idCita from Cita s where s.nombreCita LIKE :compuesta")
					.setParameter("compuesta", cita.getIdCita());
			List<CitaEntity> resultList = q.getResultList();

			if(resultList!=null  && resultList.size()>0) {
				return 1;
			}else {		
				CitaEntity entity = new CitaEntity();

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

	public int update(CitaModel cita){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("update Cita s set s.fechaCita = :now, where s.idCita = :compuesta ")
					.setParameter("compuesta", cita.getFechaCita())
					.setParameter("now", cita.getIdCita());

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

	public int select(CitaModel cita) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.* from Cita s where s.idCita LIKE :compuesta")
					.setParameter("compuesta", cita.getIdCita());
			List<CitaEntity> resultList = q.getResultList();

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
	
	public int delete(CitaModel cita){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("delete Cita s where s.idCita = :compuesta ")
					.setParameter("compuesta", cita.getIdCita());

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

