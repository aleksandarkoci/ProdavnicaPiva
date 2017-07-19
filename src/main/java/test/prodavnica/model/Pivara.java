package test.prodavnica.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Pivara {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private String naziv;
	@Column
	private String pib;
	@Column
	private String drzava;
	
	@OneToMany(mappedBy = "pivara", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pivo> piva = new ArrayList<>();

	public Pivara() {
		super();
	}

	public Pivara(String naziv, String pib, String drzava, List<Pivo> piva) {
		super();
		this.naziv = naziv;
		this.pib = pib;
		this.drzava = drzava;
		this.piva = piva;
	}

	public Pivara(Long id, String naziv, String pib, String drzava, List<Pivo> piva) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pib = pib;
		this.drzava = drzava;
		this.piva = piva;
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

	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public List<Pivo> getPiva() {
		return piva;
	}

	public void setPiva(List<Pivo> piva) {
		this.piva = piva;
	}
}
