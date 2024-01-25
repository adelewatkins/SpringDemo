package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Dog;
import com.lbg.demo.repos.DogRepo;

@Service
public class DogService {

	private DogRepo repo;

	public DogService(DogRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Dog> createDog(Dog newDog) {
		Dog created = this.repo.save(newDog);
		return new ResponseEntity<Dog>(created, HttpStatus.CREATED);
	}

	public List<Dog> getDogs() {
		return this.repo.findAll();
	}

	public ResponseEntity<Dog> getDog(int id) {
		// returns a 'box' that may have a dog in it
		Optional<Dog> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if its found a dog
			return new ResponseEntity<Dog>(HttpStatus.NOT_FOUND);
		}
		// attempts to pull the contents out of the 'box'
		Dog body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Dog> updateDog(int id, Dog newDog) {
		// returns a 'box' that may have a dog in it
		Optional<Dog> found = this.repo.findById(id);

		if (found.isEmpty()) { // checks if its found a dog
			return new ResponseEntity<Dog>(HttpStatus.NOT_FOUND);
		}
		// attempts to pull the contents out of the 'box'
		Dog existing = found.get();
		if (newDog.getName() != null) {
			existing.setName(newDog.getName());
		}
		if (newDog.getBreed() != null) {
			existing.setBreed(newDog.getBreed());
		}

		Dog updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteDog(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}