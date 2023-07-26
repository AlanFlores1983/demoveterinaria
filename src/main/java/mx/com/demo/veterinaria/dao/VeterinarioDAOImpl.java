package mx.com.demo.veterinaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.com.demo.veterinaria.entity.VeterinarioEntity;
import mx.com.demo.veterinaria.model.VeterinarioModel;
import mx.com.demo.veterinaria.util.VeterinariaUtil;

public class VeterinarioDAOImpl implements VeterinarioDAO{

	private final VeterinariaUtil util = new VeterinariaUtil();

	public int insert(VeterinarioModel vet) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.idVeterinario from Veterinario s where s.nombreVeterinario LIKE :compuesta")
					.setParameter("compuesta", vet.getNombre());
			List<VeterinarioEntity> resultList = q.getResultList();

			if(resultList!=null  && resultList.size()>0) {
				return 1;
			}else {		
				VeterinarioEntity entity = new VeterinarioEntity();

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

	public int update(VeterinarioModel vet){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("update Veterinario s set s.nombre = :now, where s.cedula = :compuesta ")
					.setParameter("compuesta", vet.getCedula())
					.setParameter("now", vet.getNombre());

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

	public int select(VeterinarioModel vet) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.* from Veterinario s where s.cedula LIKE :compuesta")
					.setParameter("compuesta", vet.getCedula());
			List<VeterinarioEntity> resultList = q.getResultList();

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
	
	public int delete(VeterinarioModel vet){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("delete Veterinario s where s.cedula = :compuesta ")
					.setParameter("compuesta", vet.getCedula());

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

