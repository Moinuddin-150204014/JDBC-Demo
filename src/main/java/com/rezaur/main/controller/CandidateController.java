package com.rezaur.main.controller;

import com.rezaur.main.model.Candidate;
import com.rezaur.main.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @GetMapping("/candidate/all")
    public ResponseEntity<List<Candidate>> getAllCandidate() {
        List<Candidate> candidateList = candidateRepository.getAll();
        return new ResponseEntity<>(candidateList, HttpStatus.OK);
    }

    @GetMapping("/candidate/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Integer id) {
        Candidate candidate = candidateRepository.getById(id).get();
        return new ResponseEntity<>(candidate, HttpStatus.OK);
    }

    @PostMapping("/candidate/add")
    public ResponseEntity<Void> addCandidate(@RequestBody Candidate candidate) {
        candidateRepository.add(candidate);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/candidate/{id}")
    public ResponseEntity<Void> updateCandidate(@RequestBody Candidate candidate, @PathVariable Integer id) {
        candidateRepository.update(candidate, id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @DeleteMapping("/candidate/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Integer id) {
        candidateRepository.delete(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
