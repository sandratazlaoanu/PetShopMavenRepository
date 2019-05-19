package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "produs")
public class Produs {

	@Id
	@Column(name = "idProdus")
	private int idProdus;
	@Column(name = "cantitate")
	private int cantitate;
	@Column(name = "denumire")
	private String denumire;
	@Column(name = "pret")
	private float pret;

	// bi-directional many-to-one association to Bonprodus
	@OneToMany(mappedBy = "produs")
	private List<BonProdus> bonproduses;

	// bi-directional many-to-one association to Furnizor
	@ManyToOne
	@JoinColumn(name = "idFurnizor")
	private Furnizor furnizor;

	public Produs() {
	}

	public Produs(int id, int cantitate, String denumire, float pret) {
		this.idProdus = id;
		this.cantitate = cantitate;
		this.denumire = denumire;
		this.pret = pret;
	}

	public int getIdProdus() {
		return this.idProdus;
	}

	public void setIdProdus(int idProdus) {
		this.idProdus = idProdus;
	}

	public int getCantitate() {
		return this.cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public float getPret() {
		return this.pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	public List<BonProdus> getBonproduses() {
		return this.bonproduses;
	}

	public void setBonproduses(List<BonProdus> bonproduses) {
		this.bonproduses = bonproduses;
	}

	public BonProdus addBonprodus(BonProdus bonProdus) {
		getBonproduses().add(bonProdus);
		bonProdus.setProdus(this);

		return bonProdus;
	}

	public BonProdus removeBonprodus(BonProdus bonProdus) {
		getBonproduses().remove(bonProdus);
		bonProdus.setProdus(null);

		return bonProdus;
	}

	public Furnizor getFurnizor() {
		return this.furnizor;
	}

	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}

}
