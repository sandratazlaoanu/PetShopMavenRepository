package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Angajat;

public class AngajatController {
	
	static EntityManagerFactory emf = Persistence
             .createEntityManagerFactory("PetShopProjectMaven");
	private static EntityManager em = emf.createEntityManager();

	public void createAngajat(int id, String firstName, String lastName, float salariu) {
	        em.getTransaction().begin();
	        Angajat newAngajat = new Angajat(id, firstName, lastName, salariu);
	        em.persist(newAngajat);
	        em.getTransaction().commit();
	   }
}
