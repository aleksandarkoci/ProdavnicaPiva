package test.prodavnica.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Pivo {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private double procenatAlc;
	@Column
	private double ibu;
	@Column
	private int stanje;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Vrsta vrsta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Pivara pivara;

	public Pivo() {
		super();
	}

	public Pivo(String naziv, double procenatAlc, double ibu, int stanje, Vrsta vrsta, Pivara pivara) {
		super();
		this.naziv = naziv;
		this.procenatAlc = procenatAlc;
		this.ibu = ibu;
		this.stanje = stanje;
		this.vrsta = vrsta;
		this.pivara = pivara;
	}

	public Pivo(Long id, String naziv, double procenatAlc, double ibu, int stanje, Vrsta vrsta, Pivara pivara) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.procenatAlc = procenatAlc;
		this.ibu = ibu;
		this.stanje = stanje;
		this.vrsta = vrsta;
		this.pivara = pivara;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getProcenatAlc() {
		return procenatAlc;
	}

	public void setProcenatAlc(double procenatAlc) {
		this.procenatAlc = procenatAlc;
	}

	public double getIbu() {
		return ibu;
	}

	public void setIbu(double ibu) {
		this.ibu = ibu;
	}

	public int getStanje() {
		return stanje;
	}

	public void setStanje(int stanje) {
		this.stanje = stanje;
	}

	public Vrsta getVrsta() {
		return vrsta;
	}

	public void setVrsta(Vrsta vrsta) {
		this.vrsta = vrsta;
	}

	public Pivara getPivara() {
		return pivara;
	}

	public void setPivara(Pivara pivara) {
		this.pivara = pivara;
	}
}
