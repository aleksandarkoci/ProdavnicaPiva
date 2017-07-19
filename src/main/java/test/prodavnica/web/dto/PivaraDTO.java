package test.prodavnica.web.dto;

public class PivaraDTO {

	private Long id;
	private String naziv;
	private String pib;
	private String drzava;
	
//	public PivaraDTO() {
//	}
//
//	public PivaraDTO(String naziv, String pib, String drzava) {
//		this.naziv = naziv;
//		this.pib = pib;
//		this.drzava = drzava;
//	}
//
//	public PivaraDTO(Long id, String naziv, String pib, String drzava) {
//		this.id = id;
//		this.naziv = naziv;
//		this.pib = pib;
//		this.drzava = drzava;
//	}

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
}
