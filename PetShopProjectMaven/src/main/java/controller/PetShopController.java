package controller;

import java.util.List;

import daoImpl.PetShopDao;
import helper.DatabaseHelper;
import model.PetShop;

/**
 * @author Sandra Util functions for petshop
 */
public class PetShopController {
	private static DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		PetShopDao dao = new PetShopDao(dh);
		List<PetShop> list = dao.getAll();

		for (PetShop p : list) {
			System.out.println(p.toString());
		}
	}

	public void create(int id, String denumire, String email, String numarTelefon) {
		PetShopDao dao = new PetShopDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		PetShop newObj = new PetShop();
		newObj.setIdPetShop(id);
		newObj.setNume(denumire);
		newObj.setEmail(email);
		newObj.setNrTelefon(numarTelefon);

		dao.create(newObj);
	}

	public static PetShop search(int id) {

		PetShopDao petShop = new PetShopDao(dh);
		PetShop toFind = petShop.findById(id);
		return toFind;
	}

	public void update(int id, String denumire, String email, String numarTelefon) {
		PetShopDao dao = new PetShopDao(dh);
		PetShop toFind = dao.findById(id);
		if (toFind == null) {
			System.out.println("Not found.");
		}
		PetShop newObj = new PetShop();
		newObj.setIdPetShop(id);
		newObj.setNume(denumire);
		newObj.setEmail(email);
		newObj.setNrTelefon(numarTelefon);

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		PetShopDao dao = new PetShopDao(dh);
		PetShop toFind = dao.findById(id);
		if (toFind == null) {
			System.out.println("Not found.");
		}
		dao.delete(toFind);
	}
}
