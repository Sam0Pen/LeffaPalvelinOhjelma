package project.leffa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface LeffaRepository extends CrudRepository<Leffa, Long> {
	List<Leffa> findByTitle(String title);

}

