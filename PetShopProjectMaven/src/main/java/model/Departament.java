package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the departament database table.
 * 
 */
@Entity
@Table(name = "departament")
public class Departament {

	@Id
	@Column(name = "idDepartament")
	private int idDepartament;
	@Column(name = "denumire")
	private String denumire;
	@Column(name = "nrRaioane")
	private int nrRaioane;

	// bi-directional many-to-one association to Angajatdepartament
	@OneToMany(mappedBy = "departament")
	private List<AngajatDepartament> angajatDepartaments;

	public Departament() {
	}

	public Departament(int id, String denumire, int nrRaioane) {
		this.idDepartament = id;
		this.denumire = denumire;
		this.nrRaioane = nrRaioane;
	}

	public int getIdDepartament() {
		return this.idDepartament;
	}

	public void setIdDepartament(int idDepartament) {
		this.idDepartament = idDepartament;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public int getNrRaioane() {
		return this.nrRaioane;
	}

	public void setNrRaioane(int nrRaioane) {
		this.nrRaioane = nrRaioane;
	}

	public List<AngajatDepartament> getAngajatdepartaments() {
		return this.angajatDepartaments;
	}

	public void setAngajatdepartaments(List<AngajatDepartament> angajatDepartaments) {
		this.angajatDepartaments = angajatDepartaments;
	}

	public AngajatDepartament addAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatdepartaments().add(angajatDepartament);
		angajatDepartament.setDepartament(this);

		return angajatDepartament;
	}

	public AngajatDepartament removeAngajatdepartament(AngajatDepartament angajatDepartament) {
		getAngajatdepartaments().remove(angajatDepartament);
		angajatDepartament.setDepartament(null);

		return angajatDepartament;
	}

	@Override
	public String toString() {
		return "Departament " + idDepartament + " " + denumire + " " + nrRaioane;
	}

}
