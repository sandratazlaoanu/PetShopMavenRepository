package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The persistent class for the bonprodus database table.
 * 
 */
@Entity
@Table(name="bonprodus")
public class BonProdus {
	@Id
	@Column(name="index")
	private int index;

	//bi-directional many-to-one association to BonFiscal
	@ManyToOne
	@JoinColumn(name="idBonFiscal")
	private BonFiscal bonFiscal;

	//bi-directional many-to-one association to Produs
	@ManyToOne
	@JoinColumn(name="idProdus")
	private Produs produs;

	public BonProdus() {
	}

	public int getIndex() {
		return this.index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public BonFiscal getBonFiscal() {
		return this.bonFiscal;
	}

	public void setBonFiscal(BonFiscal bonFiscal) {
		this.bonFiscal = bonFiscal;
	}

	public Produs getProdus() {
		return this.produs;
	}

	public void setProdus(Produs produs) {
		this.produs = produs;
	}
	
	@Override
	public String toString() {
		return "BonProdus " + index + " " + bonFiscal + " " + produs;
	}


}
