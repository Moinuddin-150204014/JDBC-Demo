package com.rezaur.main.repository;

import com.rezaur.main.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CandidateRepositoryImpl implements CandidateRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Optional<Candidate> getById(Integer id) {
        String query = "select * from candidate where id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                Optional.of(
                        new Candidate(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                        )
                )
        );
    }

    @Override
    public List<Candidate> getAll() {
        String query = "select * from candidate";
        return jdbcTemplate
                .query(query, (resultSet, rowNum) ->
                        new Candidate(
                                resultSet.getInt("id"),
                                resultSet.getString("name")
                        )
                );
    }

    @Override
    public void add(Candidate candidate) {
        String query = "insert into candidate (id, name) values (?, ?)";
        jdbcTemplate.update(query, candidate.getId(), candidate.getName());
    }
    @Override
    public void update(Candidate candidate, Integer id) {
        String query = "UPDATE candidate SET name = ? WHERE id = ?";
        jdbcTemplate.update(query, candidate.getName(), id);
    }

    @Override
    public void delete(Integer id) {
        String query = "DELETE FROM candidate WHERE id = ?";
        jdbcTemplate.update(query, id);
    }
}
