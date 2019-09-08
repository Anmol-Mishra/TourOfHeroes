package com.fico.angular.tourofheroes.tourOfHeroes.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fico.angular.tourofheroes.tourOfHeroes.Model.Hero;
import com.fico.angular.tourofheroes.tourOfHeroes.Service.HeroServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class HeroController {
	
	@Autowired
	HeroServiceImpl service;
	
	@RequestMapping(value = "/addHero", method = RequestMethod.POST)
	public ResponseEntity<Object> createHero(@RequestBody Hero h){
		System.out.println(h.getId());
		service.addHero(h);
		System.out.println("IT REACHED HERE");
		return new ResponseEntity<>("The Hero is created successfully.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteHero/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteHero(@PathVariable("id") int id){
		service.deleteHero(id);
		return new ResponseEntity<>("The Hero is deleted successfully.", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/updateHero/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateHero(@PathVariable("id") int id, @RequestBody Hero h){
		service.updateHero(id, h);
		return new ResponseEntity<>(h, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getHeroByName(@PathVariable("name") String name){
		
		return new ResponseEntity<>(service.getHeroByName(name), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/heroes", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllHeroes(){
		return new ResponseEntity<>(service.getAllHeroes(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/heroes/{id}", method = RequestMethod.GET)
	public ResponseEntity<Object> getHeroById(@PathVariable("id") int id){
		
		return new ResponseEntity<>(service.getHeroById(id), HttpStatus.OK);
	}
	
	
	
	
	@RequestMapping(value = "/search/{id}/{name}", method = RequestMethod.GET)
	public ResponseEntity<Object> getHeroByIdAndName(@PathVariable("id") int id,@PathVariable("name") String name){
		
		return new ResponseEntity<>(service.getHeroByIdAndName(id, name), HttpStatus.OK);
	}

}
