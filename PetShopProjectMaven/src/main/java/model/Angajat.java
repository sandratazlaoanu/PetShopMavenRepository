package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the angajat database table.
 * 
 */
@Entity
@Table(name="angajat")
public class Angajat {

	@Id
	@Column(name="idAngajat")
	private int idAngajat;
	@Column(name="nume")
	private String nume;
	@Column(name="prenume")
	private String prenume;
	@Column(name="salariu")
	private float salariu;

	// bi-directional many-to-one association to PetShop
	@ManyToOne
	@JoinColumn(name = "idPetShop")
	private PetShop petShop;

	// bi-directional many-to-one association to AngajatDepartament
	@OneToMany(mappedBy = "angajat", fetch = FetchType.EAGER)
	private List<AngajatDepartament> angajatDepartaments;

	public Angajat() {
	}

	public Angajat(int id, String nume, String prenume, float salariu) {
		this.idAngajat = id;
		this.nume = nume;
		this.prenume = prenume;
		this.salariu = salariu;
	}

	public int getIdAngajat() {
		return this.idAngajat;
	}

	public void setIdAngajat(int idAngajat) {
		this.idAngajat = idAngajat;
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

	public float getSalariu() {
		return this.salariu;
	}

	public void setSalariu(float salariu) {
		this.salariu = salariu;
	}

	public PetShop getPetShop() {
		return this.petShop;
	}

	public void setPetShop(PetShop petShop) {
		this.petShop = petShop;
	}

	public List<AngajatDepartament> getAngajatDepartaments() {
		return this.angajatDepartaments;
	}

	public void setAngajatDepartaments(List<AngajatDepartament> angajatDepartaments) {
		this.angajatDepartaments = angajatDepartaments;
	}

	public AngajatDepartament addAngajatDepartament(AngajatDepartament angajatDepartament) {
		getAngajatDepartaments().add(angajatDepartament);
		angajatDepartament.setAngajat(this);

		return angajatDepartament;
	}

	public AngajatDepartament removeAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatDepartaments().remove(angajatDepartament);
		angajatDepartament.setAngajat(null);

		return angajatDepartament;
	}

	@Override
	public String toString() {
		return "Angajat " + idAngajat + " " + nume + " " + prenume + " " + salariu + " " + petShop;
	}

}
