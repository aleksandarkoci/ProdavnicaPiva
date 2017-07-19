package test.prodavnica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.prodavnica.model.Vrsta;
import test.prodavnica.repository.VrstaRepository;
import test.prodavnica.service.VrstaService;

@Service
@Transactional
public class JpaVrstaServiceImpl implements VrstaService {

	@Autowired
	private VrstaRepository vrstaRepository;
	
	@Override
	public List<Vrsta> findAll() {
		
		return vrstaRepository.findAll();
	}

	@Override
	public Vrsta findOne(Long id) {
		
		return vrstaRepository.findOne(id);
	}

	@Override
	public Vrsta save(Vrsta vrsta) {
		
		return vrstaRepository.save(vrsta);
	}

}
