package mx.com.demo.veterinaria.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mx.com.demo.veterinaria.entity.PropietarioEntity;
import mx.com.demo.veterinaria.model.PropietarioModel;
import mx.com.demo.veterinaria.util.VeterinariaUtil;

public class PropietarioDAOImpl implements PropietarioDAO{

	private final VeterinariaUtil util = new VeterinariaUtil();

	public int insert(PropietarioModel prop) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.idPropietario from Propietario s where s.nombrePropietario LIKE :compuesta")
					.setParameter("compuesta", prop.getIdPropietario());
			List<PropietarioEntity> resultList = q.getResultList();

			if(resultList!=null  && resultList.size()>0) {
				return 1;
			}else {		
				PropietarioEntity entity = new PropietarioEntity();

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

	public int update(PropietarioModel prop){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("update Propietario s set s.nombre = :now, where s.nombre = :compuesta ")
					.setParameter("compuesta", prop.getNombre())
					.setParameter("now", prop.getIdPropietario());

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

	public int select(PropietarioModel prop) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query q = entityManager.createQuery("select s.* from Propietario s where s.idPropietario LIKE :compuesta")
					.setParameter("compuesta", prop.getIdPropietario());
			List<PropietarioEntity> resultList = q.getResultList();

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
	
	public int delete(PropietarioModel prop){
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			emf = Persistence.createEntityManagerFactory("veterinaria-conexion");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();

			Query q = entityManager.createQuery("delete Propietario s where s.idPropietario = :compuesta ")
					.setParameter("compuesta", prop.getIdPropietario());

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

