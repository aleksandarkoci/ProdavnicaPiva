package test.prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.prodavnica.model.Vrsta;

@Repository
public interface VrstaRepository extends JpaRepository<Vrsta, Long> {

}
