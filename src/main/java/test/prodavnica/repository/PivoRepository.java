package test.prodavnica.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.prodavnica.model.Pivo;

@Repository
public interface PivoRepository extends JpaRepository<Pivo, Long> {
	
	List<Pivo> findByPivaraId (Long pivaraId);
	List<Pivo> findByVrstaId (Long vrstaId);
	
	@Query("SELECT p FROM Pivo p WHERE (:naziv IS NULL or p.naziv like :naziv ) AND "
			+ "(:ibuOd IS NULL or p.ibu >= :ibuOd) AND (:ibuDo IS NULL or p.ibu <= :ibuDo) AND"
			+ "(:pivara IS NULL or p.pivara.id >= :pivara) AND (:pivara IS NULL or p.pivara.id <= :pivara)" )
	Page<Pivo> pretraga (
			@Param("naziv") String naziv,
			@Param("ibuOd") Double ibuOd,
			@Param("ibuDo") Double ibuDo,
			@Param("pivara") Long idMin,
			@Param("pivara") Long idMax,
			Pageable page);


}
