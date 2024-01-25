package com.lbg.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Dog;
import com.lbg.demo.services.DogService;

//This tells spring this class is a controller 
@RestController
public class DogController {

	private DogService service;

	public DogController(DogService service) {
		super();
		this.service = service;
	}

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
	public ResponseEntity<Dog> createDog(@RequestBody Dog newDog) {
		return this.service.createDog(newDog);
	}

	// this returns all
	@GetMapping("/dog")
	public List<Dog> getDogs() {
		return this.service.getDogs();
	}

	// 'id' is the index for now will return
	// just god at that index
	@GetMapping("/dog/{id}")
	public ResponseEntity<Dog> getDog(@PathVariable int id) {
		return this.service.getDog(id);
	}

	// removes using the id and then shows details of whats been removed
	@DeleteMapping("/remove/{id}")
	public boolean deleteDog(@PathVariable int id) {
		return this.service.deleteDog(id);
	}

	// updates using id and returns what you have updated, pre update
	@PatchMapping("/update/{id}")
	public ResponseEntity<Dog> updateDog(@PathVariable int id, @RequestBody Dog newDog) {
		return this.service.updateDog(id, newDog);
	}

}
