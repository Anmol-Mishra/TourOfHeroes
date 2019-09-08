package com.fico.angular.tourofheroes.tourOfHeroes.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fico.angular.tourofheroes.tourOfHeroes.Exception.HeroAlreadyExistException;
import com.fico.angular.tourofheroes.tourOfHeroes.Exception.HeroNotFoundException;
import com.fico.angular.tourofheroes.tourOfHeroes.Model.Hero;
import com.fico.angular.tourofheroes.tourOfHeroes.Repository.HeroRepository;

@Service
public class HeroServiceImpl implements HeroService{

	@Autowired
	HeroRepository repo;

	public void addHero(Hero h) {
		
		if(repo.existsById(h.getId()))
			throw new HeroAlreadyExistException();
		
		else
			repo.save(h);

	}

	public void deleteHero(int id) {
		if(!repo.existsById(id))
			throw new HeroNotFoundException();
		else
			repo.deleteById(id);
		
	}

	public void updateHero(int id, Hero h) {
		deleteHero(id);
		h.setId(id);
		addHero(h);
	}

	public List<Hero> getHeroByName(String name) {
		if(repo.existsByName(name))
				return repo.findByName(name);
		else
			throw new HeroNotFoundException();
		
	}

	public List<Hero> getAllHeroes() {

		return (List<Hero>) repo.findAll();
	}
	
	
	public Optional<Hero> getHeroById(int id) {
		if(repo.existsById(id))
			return repo.findById(id);
		else
			throw new HeroNotFoundException();
		
	}

	public Hero getHeroByIdAndName(int id, String name) {

		return (Hero) repo.findByIdAndName(id, name);


	}
	
}
