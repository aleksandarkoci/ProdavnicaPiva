package test.prodavnica.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.prodavnica.model.Pivo;
import test.prodavnica.service.PivaraService;
import test.prodavnica.service.PivoService;
import test.prodavnica.service.VrstaService;
import test.prodavnica.web.dto.PivoDTO;

@Component
public class PivoDTOToPivo implements Converter<PivoDTO, Pivo> {

	@Autowired
	private PivoService pivoService;

	@Autowired
	private PivaraService pivaraService;
	
	@Autowired
	private VrstaService vrstaService;
	
	@Override
	public Pivo convert(PivoDTO dto) {

		Pivo pivo;
		
		if (dto.getId() == null) {
			pivo = new Pivo();
			pivo.setPivara(pivaraService.findOne(dto.getPivaraId()));
			pivo.setVrsta(vrstaService.findOne(dto.getVrstaId()));
		} else {
			pivo = pivoService.findOne(dto.getId());
			pivo.setPivara(pivaraService.findOne(dto.getPivaraId()));
			pivo.setVrsta(vrstaService.findOne(dto.getVrstaId()));
		}
		
		pivo.setId(dto.getId());
		pivo.setNaziv(dto.getNaziv());
		pivo.setProcenatAlc(dto.getProcenatAlc());
		pivo.setIbu(dto.getIbu());
		pivo.setStanje(dto.getStanje());
		
		return pivo;
	}
}
