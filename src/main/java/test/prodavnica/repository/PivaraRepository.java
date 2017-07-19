package test.prodavnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.prodavnica.model.Pivara;

@Repository
public interface PivaraRepository extends JpaRepository<Pivara, Long> {

}
