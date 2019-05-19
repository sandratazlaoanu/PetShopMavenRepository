package controller;

import java.sql.Date;
import java.util.List;

import daoImpl.BonFiscalDao;
import daoImpl.ClientDao;
import helper.DatabaseHelper;
import model.BonFiscal;

/**
 * @author Sandra Util functions for BonFiscal
 */
public class BonFiscalController {
	private DatabaseHelper dh = DatabaseHelper.getInstance();

	public void printList() {

		BonFiscalDao dao = new BonFiscalDao(dh);
		List<BonFiscal> list = dao.getAll();

		for (BonFiscal b : list) {
			System.out.println(b.toString());
		}
	}

	public void create(int id, Date data, float suma, int idClient) {
		BonFiscalDao dao = new BonFiscalDao(dh);
		ClientDao clientDao = new ClientDao(dh);
		if (dao.get(id).isPresent() == true) {
			System.out.println("Already exists..");
		}
		BonFiscal newObj = new BonFiscal();
		newObj.setIdBonFiscal(id);
		newObj.setData(data);
		newObj.setSuma(suma);

		newObj.setClient(clientDao.findById(idClient));

		dao.create(newObj);
	}

	public BonFiscal search(int id) {

		BonFiscalDao bonFiscal = new BonFiscalDao(dh);
		BonFiscal toFind = bonFiscal.findById(id);
		return toFind;
	}

	public void update(int id, Date data, float suma, int idClient) {
		BonFiscalDao dao = new BonFiscalDao(dh);
		BonFiscal toFind = dao.findById(id);
		ClientDao clientDao = new ClientDao(dh);

		if (toFind == null) {
			System.out.println("Not found.");
		}
		BonFiscal newObj = new BonFiscal();
		newObj.setIdBonFiscal(id);
		newObj.setData(data);
		newObj.setSuma(suma);
		newObj.setClient(clientDao.findById(idClient));

		dao.update(toFind, newObj);

	}

	public void delete(int id) {

		BonFiscalDao dao = new BonFiscalDao(dh);
		BonFiscal toFind = dao.findById(id);

		if (toFind == null) {
			System.out.println("Bon fiscal not found.");
		}
		dao.delete(toFind);
	}

}
