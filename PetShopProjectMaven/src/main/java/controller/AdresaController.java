package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adresa;

public class AdresaController {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PetShopProjectMaven");
	private static EntityManager em = emf.createEntityManager();;

	public void createAdresa(int zip, String judet, String oras, String strada, int numar) {
		em.getTransaction().begin();
		Adresa adresa = new Adresa(zip, judet, oras, strada, numar);
		em.persist(adresa);
		em.getTransaction().commit();
	}
}
