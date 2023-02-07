package jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import business.User;

public class JpaTest {
	
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager=manager;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManager manager = EntityManagerHelper.getEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();


		try {
			test.createUser();

		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();


		manager.close();
		EntityManagerHelper.closeEntityManagerFactory();
		//		factory.close();
	}
	
	private void createUser() {
		User user= new User();
		manager.persist(user);
		
		
	}


}
