package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the angajatdepartament database table.
 * 
 */
@Entity
@Table(name="angajatdepartament")
public class AngajatDepartament implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="index")
	private int index;

	//bi-directional many-to-one association to Angajat
	@ManyToOne
	@JoinColumn(name="idAngajat")
	private Angajat angajat;

	//bi-directional many-to-one association to Departament
	@ManyToOne
	@JoinColumn(name="idDepartament")
	private Departament departament;

	public AngajatDepartament() {
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Angajat getAngajat() {
		return this.angajat;
	}

	public void setAngajat(Angajat angajat) {
		this.angajat = angajat;
	}

	public Departament getDepartament() {
		return this.departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}
	
	@Override
	public String toString() {
		return "AngajatDepartament " + index + " " + angajat + " " + departament;
	}

}
