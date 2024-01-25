package com.lbg.demo.services;

//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import com.lbg.demo.domain.Dog;
//
//@Service
//public class DogServiceOld {
//
//	private List<Dog> dogs = new ArrayList<>();
//
//	// this will add one at a time and return the newest one
//
////	public Dog createDog(Dog newDog) {
////		this.dogs.add(newDog);
////		return this.dogs.get(this.dogs.size() -1);
////	}
//
//	// This is so it can be sent as an array
////	public String createDogs(List<Dog> newDogs) {
////		this.dogs.addAll(newDogs);
////		return dogs.toString();
////	}
//
//	public ResponseEntity<Dog> createDog(Dog newDog) {
//		this.dogs.add(newDog);
//		// returns the last element in the list
//		Dog body = this.dogs.get(this.dogs.size() - 1);
//		return new ResponseEntity<Dog>(body, HttpStatus.CREATED);
//	}
//
//	// this returns all
//	public List<Dog> getDogs() {
//		return dogs;
//	}
//
//	// 'id' is the index for now will return
//	// just god at that index
//
//	public ResponseEntity<Dog> getDog(int id) {
//		if (id < 0 || id >= this.dogs.size()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		Dog found = this.dogs.get(id);
//		return ResponseEntity.ok(found);
//	}
//
//	// removes using the id and then shows details of whats been removed
//
//	public Dog deleteDog(int id) {
//		return this.dogs.remove(id);
//	}
//
//	// updates using id and returns what you have updated, pre update
//
//	public Dog updateDog(int id, Dog newDog) {
//		return this.dogs.set(id, newDog);
//	}
//
//}
