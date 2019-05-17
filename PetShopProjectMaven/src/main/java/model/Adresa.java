package model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the adresa database table.
 * 
 */
@Entity
@Table(name = "adresa")
public class Adresa {
	
	@Id
	@Column(name ="zip")
	private int zip;

	@Column(name="judet")
	private String judet;
	
	@Column(name="numar")
	private int numar;

	@Column(name="oras")
	private String oras;

	@Column(name="strada")
	private String strada;

	@OneToMany(mappedBy = "adresa")
	private List<PetShop> petShops;

	public Adresa() {
	}

	public Adresa(int zip, String judet, String oras, String strada, int numar) {
		this.zip = zip;
		this.judet = judet;
		this.oras = oras;
		this.strada = strada;
		this.numar = numar;
	}

	public int getZip() {
		return this.zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getJudet() {
		return this.judet;
	}

	public void setJudet(String judet) {
		this.judet = judet;
	}

	public int getNumar() {
		return this.numar;
	}

	public void setNumar(int numar) {
		this.numar = numar;
	}

	public String getOras() {
		return this.oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public String getStrada() {
		return this.strada;
	}

	public void setStrada(String strada) {
		this.strada = strada;
	}

	public List<PetShop> getPetshops() {
		return this.petShops;
	}

	public void setPetshops(List<PetShop> petShops) {
		this.petShops = petShops;
	}

	public PetShop addPetshop(PetShop petShop) {
		getPetshops().add(petShop);
		petShop.setAdresa(this);

		return petShop;
	}

	public PetShop removePetshop(PetShop petShop) {
		getPetshops().remove(petShop);
		petShop.setAdresa(null);

		return petShop;
	}

	@Override
	public String toString() {
		return "Adresa " + zip + " " + judet + " " + numar + " " + oras + " " + strada;
	}

}