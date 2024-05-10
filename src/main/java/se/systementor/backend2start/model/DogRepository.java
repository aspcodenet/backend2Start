package se.systementor.backend2start.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    //List<Dog> findAll(Pageable pageable);
    //List<Dog> findAllByNameContains(String name, Sort sort);
//    List<Dog> findAllByNameContainsOrBreedContains(String name, String breed, Sort sort);
//    List<Dog> findAll(Sort sort);
    Page<Dog> findAll(Pageable pageable);
    Page<Dog> findAllByNameContainsOrBreedContains(String name, String breed,Pageable pageable);
}
