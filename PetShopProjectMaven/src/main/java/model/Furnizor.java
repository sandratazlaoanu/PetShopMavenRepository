package model;

import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the furnizor database table.
 * 
 */
@Entity
@Table(name = "furnizor")
public class Furnizor {

	@Id
	@Column(name = "idFurnizor")
	private int idFurnizor;
	@Column(name = "denumire")
	private String denumire;
	@Column(name = "idCont")
	private String idCont;

	// bi-directional many-to-one association to PetShop
	@ManyToOne
	@JoinColumn(name = "idPetShopFurnizor")
	private PetShop petShop;

	// bi-directional many-to-one association to Produs
	@OneToMany(mappedBy = "furnizor")
	private List<Produs> produses;

	public Furnizor() {
	}

	public Furnizor(int id, String denumire, String idCont) {
		this.idFurnizor = id;
		this.denumire = denumire;
		this.idCont = idCont;
	}

	public int getIdFurnizor() {
		return this.idFurnizor;
	}

	public void setIdFurnizor(int idFurnizor) {
		this.idFurnizor = idFurnizor;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getIdCont() {
		return this.idCont;
	}

	public void setIdCont(String idCont) {
		this.idCont = idCont;
	}

	public PetShop getPetShop() {
		return this.petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	public List<Produs> getProduses() {
		return this.produses;
	}

	public void setProduses(List<Produs> produses) {
		this.produses = produses;
	}

	public Produs addProdus(Produs produs) {
		getProduses().add(produs);
		produs.setFurnizor(this);

		return produs;
	}

	public Produs removeProdus(Produs produs) {
		getProduses().remove(produs);
		produs.setFurnizor(null);

		return produs;
	}

	@Override
	public String toString() {
		return "Furnizor " + idFurnizor + " " + denumire + " " + idCont;
	}

}
