package com.fico.angular.tourofheroes.tourOfHeroes.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HeroNotFoundExceptionController {

	@ExceptionHandler(value = HeroNotFoundException.class)
	public ResponseEntity<Object> exception(HeroNotFoundException e){
		return new ResponseEntity<>("Hero Not Found.", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = HeroAlreadyExistException.class)
	public ResponseEntity<Object> exceptiono(HeroAlreadyExistException e){
		return new ResponseEntity<>("Hero Already Exists.", HttpStatus.BAD_REQUEST);
	}
}
