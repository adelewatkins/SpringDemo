package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Dog;

//This tells spring this class is a controller 
@RestController
public class DogController {

	private List<Dog> dogs = new ArrayList<>();

	// this will add one at a time and return the newest one
//	@PostMapping("/create")
//	public Dog createDog(@RequestBody Dog newDog) {
//		this.dogs.add(newDog);
//		return this.dogs.get(this.dogs.size() -1);
//	}

	// This is so it can be sent as an array
//	@PostMapping("/create")
//	public String createDogs(@RequestBody List<Dog> newDogs) {
//		this.dogs.addAll(newDogs);
//		return dogs.toString();
//	}

	@PostMapping("/create")
	public ResponseEntity<Dog> createHero(@RequestBody Dog newDog) {
		this.dogs.add(newDog);
		// returns the last element in the list
		Dog body = this.dogs.get(this.dogs.size() - 1);
		return new ResponseEntity<Dog>(body, HttpStatus.CREATED);
	}

	// this returns all
	@GetMapping("/dog")
	public List<Dog> getDogs() {
		return dogs;
	}

	// 'id' is the index for now will return
	// just god at that index
	@GetMapping("/dog/{id}")
	public Dog getDog(@PathVariable int id) {
		return this.dogs.get(id);
	}

	// removes using the id and then shows details of whats been removed
	@DeleteMapping("/remove/{id}")
	public Dog deleteDog(@PathVariable int id) {
		return this.dogs.remove(id);
	}

	// updates using id and returns what you have updated, pre update
	@PutMapping("/update/{id}")
	public Dog updateDog(@PathVariable int id, @RequestBody Dog newDog) {
		return this.dogs.set(id, newDog);
	}

}
