package test.prodavnica.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.prodavnica.model.Pivara;
import test.prodavnica.model.Pivo;
import test.prodavnica.service.PivaraService;
import test.prodavnica.service.PivoService;
import test.prodavnica.support.PivaraToPivaraDTO;
import test.prodavnica.support.PivoToPivoDTO;
import test.prodavnica.web.dto.PivaraDTO;
import test.prodavnica.web.dto.PivoDTO;


@RestController
@RequestMapping(value = "/api/pivare")
public class ApiPivaraController {

	@Autowired
	private PivaraService pivaraService;

	@Autowired
	private PivoService pivoService;

	@Autowired
	private PivaraToPivaraDTO toDTO;

	@Autowired
	private PivoToPivoDTO pivoToPivoDTO;

	// Uzima sve iz tabele tipnekternine
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PivaraDTO>> getAll() {
		return new ResponseEntity<List<PivaraDTO>>(toDTO.convert(pivaraService.findAll()), HttpStatus.OK);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<PivaraDTO> getById(@PathVariable Long id) 
	{
		Pivara pivara = pivaraService.findOne(id);
		if (pivara == null) {
			return new ResponseEntity<PivaraDTO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PivaraDTO>(toDTO.convert(pivara), HttpStatus.OK);
	}

	
	// Pretraga nekretnine po tipu nekretnine ID 
	@RequestMapping(value = "/{pivaraId}/piva", method = RequestMethod.GET)
	public ResponseEntity<List<PivoDTO>> getFestivalByMestoId(@PathVariable Long pivaraId) {

		List<Pivo> pivoByTip = pivoService.findByPivaraId(pivaraId);
		return new ResponseEntity<List<PivoDTO>>(pivoToPivoDTO.convert(pivoByTip), HttpStatus.OK);

	}
}
