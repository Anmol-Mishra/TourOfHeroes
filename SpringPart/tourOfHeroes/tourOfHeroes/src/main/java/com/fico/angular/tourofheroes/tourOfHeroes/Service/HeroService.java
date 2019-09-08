package com.fico.angular.tourofheroes.tourOfHeroes.Service;

import java.util.List;
import java.util.Optional;

import com.fico.angular.tourofheroes.tourOfHeroes.Model.Hero;

public interface HeroService {
	
	public void addHero(Hero h);
	public void deleteHero(int id);
	public void updateHero(int id, Hero h);
	public List<Hero> getHeroByName(String name);
	public List<Hero> getAllHeroes();
	public Optional<Hero> getHeroById(int id);
}
