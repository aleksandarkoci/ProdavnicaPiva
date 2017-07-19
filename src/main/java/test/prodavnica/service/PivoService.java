package test.prodavnica.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import test.prodavnica.model.Pivo;

public interface PivoService {

	Page<Pivo> findAll (int pageNum);
	Pivo findOne (Long id);
	Pivo save (Pivo pivo);
	void delete (Long id);
	List<Pivo> findByPivaraId (Long pivaraId);
	List<Pivo> findByVrstaId (Long vrstaId);
	Page<Pivo> pretraga (
			@Param("naziv") String naziv,
			@Param("ibuOd") Double ibuOd,
			@Param("ibuDo") Double ibuDo,
			@Param("pivara") Long idMin,
			@Param("pivara") Long idMax,
			int page);
}
