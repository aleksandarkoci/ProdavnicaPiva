package test.prodavnica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.prodavnica.model.Pivo;
import test.prodavnica.web.dto.PivoDTO;

@Component
public class PivoToPivoDTO implements Converter<Pivo, PivoDTO> {

//	@Autowired
//	private VrstaToVrstaDTO vrstaToVrstaDto;
//	
//	@Autowired
//	private PivaraToPivaraDTO pivaraToPivaraDto;
	
	@Override
	public PivoDTO convert(Pivo source) {

		PivoDTO dto = new PivoDTO();
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setProcenatAlc(source.getProcenatAlc());
		dto.setIbu(source.getIbu());
		dto.setStanje(source.getStanje());
		dto.setVrstaId(source.getVrsta().getId());
		dto.setVrstaNaziv(source.getVrsta().getNaziv());
		dto.setPivaraId(source.getPivara().getId());
		dto.setPivaraNaziv(source.getPivara().getNaziv());
		
		return dto;
	}

	public List<PivoDTO> convert(List<Pivo> piva) {
		List<PivoDTO> dtos = new ArrayList<>();
		
		for(Pivo p : piva)
			dtos.add(convert(p));
		
		return dtos;
	}
}
