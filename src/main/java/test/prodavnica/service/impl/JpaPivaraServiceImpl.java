package test.prodavnica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.prodavnica.model.Pivara;
import test.prodavnica.repository.PivaraRepository;
import test.prodavnica.service.PivaraService;

@Service
@Transactional
public class JpaPivaraServiceImpl implements PivaraService {

	@Autowired
	private PivaraRepository pivaraRepository;
	
	@Override
	public List<Pivara> findAll() {
		
		return pivaraRepository.findAll();
	}

	@Override
	public Pivara findOne(Long id) {
		
		return pivaraRepository.findOne(id);
	}

	@Override
	public Pivara save(Pivara pivara) {
		
		return pivaraRepository.save(pivara);
	}

}
