package controller;

import java.util.List;

import daoImpl.ClientDao;
import daoImpl.PetShopDao;
import helper.DatabaseHelper;
import model.BonFiscal;
import model.Client;

/**
 * @author Sandra Util functions for Client
 */
public class ClientController {

	private static DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		ClientDao dao = new ClientDao(dh);
		List<Client> list = dao.getAll();

		for (Client c : list) {
			System.out.println(c.toString());
		}
	}

	public void create(int id, String nume, String prenume, int idPetShop) {
		ClientDao dao = new ClientDao(dh);
		PetShopDao psDao = new PetShopDao(dh);

		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		Client newObj = new Client();
		newObj.setIdClient(id);
		newObj.setNume(nume);
		newObj.setPrenume(prenume);

		newObj.setPetShop(psDao.findById(idPetShop));

		dao.create(newObj);
	}

	public static Client search(int id) {

		ClientDao client = new ClientDao(dh);
		Client toFind = client.findById(id);
		return toFind;
	}

	public void update(int id, String nume, String prenume, int idPetShop) {
		ClientDao dao = new ClientDao(dh);
		Client toFind = dao.findById(id);
		if (toFind == null) {
			System.out.println("Not found.");
		}
		Client newObj = new Client();
		newObj.setIdClient(id);
		newObj.setNume(nume);
		newObj.setPrenume(prenume);
		newObj.setPetShop(PetShopController.search(idPetShop));
		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		ClientDao dao = new ClientDao(dh);
		Client toFind = dao.findById(id);
		BonFiscalController bfC = new BonFiscalController();

		if (toFind == null) {
			System.out.println("Client not found!");

		}

		else {

			for (BonFiscal b : toFind.getBonFiscals()) {

				if (b == null)
					break;
				bfC.delete(b.getIdBonFiscal());
				dao.delete(toFind);
			}
		}

	}
}
