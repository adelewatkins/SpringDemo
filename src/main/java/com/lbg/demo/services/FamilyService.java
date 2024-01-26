package com.lbg.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.demo.domain.Family;
import com.lbg.demo.repos.FamilyRepo;

@Service
public class FamilyService {

	private FamilyRepo repo;

	public FamilyService(FamilyRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Family> createFamily(Family newFamily) {
		Family created = this.repo.save(newFamily);
		return new ResponseEntity<Family>(created, HttpStatus.CREATED);
	}

	public List<Family> getFamilies() {
		return this.repo.findAll();
	}

	public ResponseEntity<Family> getFamily(int id) {
		Optional<Family> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
		Family body = found.get();
		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Family> updateFamily(int id, Family newFamily) {
		Optional<Family> found = this.repo.findById(id);
		if (found.isEmpty()) {
			return new ResponseEntity<Family>(HttpStatus.NOT_FOUND);
		}
		Family existing = found.get();
		if (newFamily.getName() != null) {
			existing.setName(newFamily.getName());
		}
		if (newFamily.getLocation() != null) {
			existing.setLocation(newFamily.getLocation());
		}

		Family updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteFamily(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
