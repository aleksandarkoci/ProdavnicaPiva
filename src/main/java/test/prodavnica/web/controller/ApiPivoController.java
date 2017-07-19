package test.prodavnica.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import test.prodavnica.model.Pivo;
import test.prodavnica.service.PivoService;
import test.prodavnica.support.PivoDTOToPivo;
import test.prodavnica.support.PivoToPivoDTO;
import test.prodavnica.web.dto.PivoDTO;

@RestController
@RequestMapping("/api/piva")
public class ApiPivoController {

	@Autowired
	private PivoService pivoService;
	
	@Autowired
	private PivoToPivoDTO toDTO;
	
	@Autowired
	private PivoDTOToPivo toPivo;
	
	// Pretraga sa filterom
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PivoDTO>> get(@RequestParam(required = false) String naziv,
											 @RequestParam(required = false) Double ibuOd,
											 @RequestParam(required = false) Double ibuDo,
											 @RequestParam(required = false) Long pivara,
											 @RequestParam(defaultValue = "0") int pageNum){
		
		Long idMin = pivara;
		Long idMax = pivara;
		
		Page<Pivo> pivo;
		
		if(naziv != null || ibuOd != null || ibuDo != null || idMin != null || idMax != null) {
			pivo = pivoService.pretraga(naziv, ibuOd, ibuDo, idMin, idMax, pageNum);
		} else {
			pivo = pivoService.findAll(pageNum);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(pivo.getTotalPages()));
		return new ResponseEntity<>(toDTO.convert(pivo.getContent()), headers, HttpStatus.OK);
	}

	// Pretraga po ID
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<PivoDTO> getById(@PathVariable Long id) {
		Pivo pivo = pivoService.findOne(id);
			
		if (pivo == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);
	}
	
	// Dodavanje novog reda
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<PivoDTO> add(@RequestBody PivoDTO pivoNew) {
	
		Pivo pivo = toPivo.convert(pivoNew);
		pivoService.save(pivo);
		
		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);
	}
	
	// Edit reda
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<PivoDTO> edit(@PathVariable Long id, @RequestBody PivoDTO izmenjen) {
		
		if (!id.equals(izmenjen.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Pivo pivo = toPivo.convert(izmenjen);
		pivoService.save(pivo);

		return new ResponseEntity<>(toDTO.convert(pivo), HttpStatus.OK);
	}
	
	// Brisanje reda
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<PivoDTO> delete(@PathVariable Long id) {
		pivoService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
//	Kupi (dodatni zadatak)
	@RequestMapping(method = RequestMethod.PUT, value = "/kupi/{id}")
	public ResponseEntity<PivoDTO> kupi (@PathVariable Long id) {
		
		Pivo kupiPivo = pivoService.findOne(id);
		
		if (kupiPivo.getStanje() > 0) {
			kupiPivo.setStanje(kupiPivo.getStanje() - 1);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		pivoService.save(kupiPivo);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
