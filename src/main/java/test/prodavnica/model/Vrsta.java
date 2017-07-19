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
public class Vrsta {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	private String naziv;
	
	@OneToMany(mappedBy = "vrsta", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Pivo> piva = new ArrayList<>();

	public Vrsta() {
		super();
	}

	public Vrsta(String naziv, List<Pivo> piva) {
		super();
		this.naziv = naziv;
		this.piva = piva;
	}

	public Vrsta(Long id, String naziv, List<Pivo> piva) {
		super();
		this.id = id;
		this.naziv = naziv;
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

	public List<Pivo> getPiva() {
		return piva;
	}

	public void setPiva(List<Pivo> piva) {
		this.piva = piva;
	}
}
