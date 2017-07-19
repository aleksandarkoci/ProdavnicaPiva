package test.prodavnica.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.prodavnica.model.Vrsta;
import test.prodavnica.service.VrstaService;
import test.prodavnica.support.VrstaToVrstaDTO;
import test.prodavnica.web.dto.VrstaDTO;

@RestController
@RequestMapping(value="/api/vrste_piva")
public class ApiVrstaController {

		
	@Autowired
	VrstaService vrstaService;
	
	@Autowired
	VrstaToVrstaDTO vrstaToVrstaDto;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<VrstaDTO>> getAll(){
		
		List<Vrsta> vrste = vrstaService.findAll();
		
		if(vrste == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<List<VrstaDTO>>(vrstaToVrstaDto.convert(vrste), HttpStatus.OK);
		}
	}
}
