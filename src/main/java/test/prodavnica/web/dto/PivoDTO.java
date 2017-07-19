package test.prodavnica.web.dto;

public class PivoDTO {

	private Long id;
	private String naziv;
	private double procenatAlc;
	private double ibu;
	private int stanje;
	
	private Long vrstaId;
	private String vrstaNaziv;
	
	private Long pivaraId;
	private String pivaraNaziv;
	
//	private VrstaDTO vrstaDto;
//	
//	private PivaraDTO pivaraDto;

//	public PivoDTO() {
//	}
//
//	public PivoDTO(String naziv, double procenatAlc, double ibu, int stanje, VrstaDTO vrstaDto, PivaraDTO pivaraDto) {
//		this.naziv = naziv;
//		this.procenatAlc = procenatAlc;
//		this.ibu = ibu;
//		this.stanje = stanje;
//		this.vrstaDto = vrstaDto;
//		this.pivaraDto = pivaraDto;
//	}
//
//	public PivoDTO(Long id, String naziv, double procenatAlc, double ibu, int stanje, VrstaDTO vrstaDto,
//			PivaraDTO pivaraDto) {
//		this.id = id;
//		this.naziv = naziv;
//		this.procenatAlc = procenatAlc;
//		this.ibu = ibu;
//		this.stanje = stanje;
//		this.vrstaDto = vrstaDto;
//		this.pivaraDto = pivaraDto;
//	}

	public Long getVrstaId() {
		return vrstaId;
	}

	public void setVrstaId(Long vrstaId) {
		this.vrstaId = vrstaId;
	}

	public String getVrstaNaziv() {
		return vrstaNaziv;
	}

	public void setVrstaNaziv(String vrstaNaziv) {
		this.vrstaNaziv = vrstaNaziv;
	}

	public Long getPivaraId() {
		return pivaraId;
	}

	public void setPivaraId(Long pivaraId) {
		this.pivaraId = pivaraId;
	}

	public String getPivaraNaziv() {
		return pivaraNaziv;
	}

	public void setPivaraNaziv(String pivaraNaziv) {
		this.pivaraNaziv = pivaraNaziv;
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

//	public VrstaDTO getVrstaDto() {
//		return vrstaDto;
//	}
//
//	public void setVrstaDto(VrstaDTO vrstaDto) {
//		this.vrstaDto = vrstaDto;
//	}
//
//	public PivaraDTO getPivaraDto() {
//		return pivaraDto;
//	}
//
//	public void setPivaraDto(PivaraDTO pivaraDto) {
//		this.pivaraDto = pivaraDto;
//	}
}
