package test.prodavnica.service;

import java.util.List;

import test.prodavnica.model.Vrsta;

public interface VrstaService {

	List<Vrsta> findAll ();
	Vrsta findOne (Long id);
	Vrsta save (Vrsta vrsta);
}
