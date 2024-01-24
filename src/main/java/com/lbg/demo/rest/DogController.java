package com.lbg.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.demo.domain.Dog;

//This tells spring this class is a controller 
@RestController
public class DogController {

	private List<Dog> dogs = new ArrayList<>();

//	// this will add one
//	@PostMapping("/create")
//	public String createDog(@RequestBody Dog newDog) {
//		this.dogs.add(newDog);
//		return dogs.toString();
//	}

	// This is so it can be sent as an array
	@PostMapping("/create")
	public String createDogs(@RequestBody List<Dog> newDogs) {
		this.dogs.addAll(newDogs);
		return dogs.toString();
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

	@DeleteMapping("/dog/{id}")
	public String deleteDog(@PathVariable int id) {
		this.dogs.remove(id);
		return "Dog Succesfully Deleted";

	}

}
