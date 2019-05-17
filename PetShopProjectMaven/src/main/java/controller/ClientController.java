package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Client;

public class ClientController {

	static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("PetShopProjectMaven");
	private static EntityManager em = emf.createEntityManager();

	public void createClient(int id, String firstName, String lastName, int idPetShop) {
	        em.getTransaction().begin();
	        Client client = new Client(id, firstName, lastName, idPetShop);
	        client.setPetShop(PetShopController.findById(idPetShop));
	        em.persist(client);
	        em.getTransaction().commit();
	   }
}

