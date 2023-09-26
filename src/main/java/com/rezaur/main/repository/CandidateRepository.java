package com.rezaur.main.repository;

import com.rezaur.main.model.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository {

    Optional<Candidate> getById(Integer id);

    List<Candidate> getAll();

    void add(Candidate candidate);
    void update(Candidate candidate, Integer id);
    void delete(Integer id);
}
