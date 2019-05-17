package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name = "client")
public class Client {

	@Id
	@Column(name="idClient")
	private int idClient;
	@Column(name="nume")
	private String nume;
	@Column(name="prenume")
	private String prenume;

	// bi-directional many-to-one association to BonFiscal
	@OneToMany(mappedBy = "client")
	private List<BonFiscal> bonFiscals;

	// bi-directional many-to-one association to PetShop
	@ManyToOne
	@JoinColumn(name = "idPetShopClient")
	private PetShop petShop;

	public Client() {
	}
	public Client(int id, String nume, String prenume, int idPetShop) {
		this.idClient = id;
		this.nume = nume;
		this.prenume = prenume;
	}
	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNume() {
		return this.nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return this.prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public List<BonFiscal> getBonFiscals() {
		return this.bonFiscals;
	}

	public void setBonFiscals(List<BonFiscal> bonFiscals) {
		this.bonFiscals = bonFiscals;
	}

	public BonFiscal addBonFiscal(BonFiscal bonFiscal) {
		getBonFiscals().add(bonFiscal);
		bonFiscal.setClient(this);

		return bonFiscal;
	}

	public BonFiscal removeBonfiscal(BonFiscal bonFiscal) {
		getBonFiscals().remove(bonFiscal);
		bonFiscal.setClient(null);

		return bonFiscal;
	}

	public PetShop getPetShop() {
		return this.petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	@Override
	public String toString() {
		return "Client " + idClient + " " + nume + " " + prenume + " " + petShop;

	}
}

