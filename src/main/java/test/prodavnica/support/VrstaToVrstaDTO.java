package test.prodavnica.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import test.prodavnica.model.Vrsta;
import test.prodavnica.web.dto.VrstaDTO;

@Component
public class VrstaToVrstaDTO implements Converter<Vrsta, VrstaDTO>{

	@Override
	public VrstaDTO convert(Vrsta source) {
		
		VrstaDTO dto = new VrstaDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		
		return dto;
	}

	public List<VrstaDTO> convert(List<Vrsta> vrste){
		List<VrstaDTO> dtos = new ArrayList<VrstaDTO>();
		
		for(Vrsta v : vrste)
			dtos.add(convert(v));
		
		return dtos;
	}
}
