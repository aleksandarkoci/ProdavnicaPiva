package test.prodavnica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.prodavnica.model.Pivo;
import test.prodavnica.repository.PivoRepository;
import test.prodavnica.service.PivoService;

@Service
@Transactional
public class JpaPivoServiceImpl implements PivoService {

	@Autowired
	private PivoRepository pivoRepository;
	
	@Override
	public Page<Pivo> findAll(int pageNum) {
		
		return pivoRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Pivo findOne(Long id) {
		
		return pivoRepository.findOne(id);
	}

	@Override
	public Pivo save(Pivo pivo) {
		
		return pivoRepository.save(pivo);
	}

	@Override
	public void delete(Long id) {

		pivoRepository.delete(id);
	}

	@Override
	public List<Pivo> findByPivaraId(Long pivaraId) {
		
		return pivoRepository.findByPivaraId(pivaraId);
	}

	@Override
	public List<Pivo> findByVrstaId(Long VrstaId) {
		
		return pivoRepository.findByVrstaId(VrstaId);
	}

	@Override
	public Page<Pivo> pretraga(String naziv, Double ibuOd, Double ibuDo, Long idMin, Long idMax, int page) {
		
		if(naziv != null) {
			naziv = "%" + naziv + "%";
		}
		
		return pivoRepository.pretraga(naziv, ibuOd, ibuDo, idMin, idMax, new PageRequest(page, 5));
	}
	

}
