package test.prodavnica.service;

import java.util.List;

import test.prodavnica.model.Pivara;

public interface PivaraService {

	List<Pivara> findAll ();
	Pivara findOne (Long id);
	Pivara save (Pivara pivara);
}
