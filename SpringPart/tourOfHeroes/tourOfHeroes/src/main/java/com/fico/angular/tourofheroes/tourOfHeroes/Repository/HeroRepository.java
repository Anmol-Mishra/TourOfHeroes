package com.fico.angular.tourofheroes.tourOfHeroes.Repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.fico.angular.tourofheroes.tourOfHeroes.Model.Hero;


public interface HeroRepository extends CrudRepository<Hero, Integer>{

	List<Hero> findByName(String name);

	boolean existsByName(String name);

	Hero findByIdAndName(int id, String name);

}
