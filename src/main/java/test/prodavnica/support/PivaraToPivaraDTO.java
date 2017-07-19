package test.prodavnica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.prodavnica.model.Pivara;
import test.prodavnica.web.dto.PivaraDTO;

@Component
public class PivaraToPivaraDTO implements Converter<Pivara, PivaraDTO> {

	@Override
	public PivaraDTO convert(Pivara source) {
		
		PivaraDTO dto = new PivaraDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setPib(source.getPib());
		dto.setDrzava(source.getDrzava());
		
		return dto;
	}

	public List<PivaraDTO> convert(List<Pivara> pivare) 
	{
		List<PivaraDTO> ret = new ArrayList<>();
		
		for(Pivara p: pivare){
			ret.add(convert(p));
		}
		
		return ret;
	}
}
