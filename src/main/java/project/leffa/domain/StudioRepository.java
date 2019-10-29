package project.leffa.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface StudioRepository extends CrudRepository<Studio, Long> {
	List<Studio> findByName(String name);

}