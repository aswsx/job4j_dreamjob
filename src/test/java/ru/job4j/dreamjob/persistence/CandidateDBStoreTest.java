package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Candidate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 28/03/2022 - 10:16
 */
class CandidateDBStoreTest {

    @BeforeEach
    void tableCleanup() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        store.clearTable();
    }

    @Test
    void whenCreateCandidateAndThenFoundByID() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate("Ivan");
        store.create(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    void whenAddCandidate() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate(1, "Ivan");
        store.add(candidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    void whenUpdatePost() {
        CandidateDBStore store = new CandidateDBStore(new Main().loadPool());
        Candidate candidate = new Candidate("Ivan");
        store.add(candidate);
        Candidate newCandidate = new Candidate(candidate.getId(), "Sergey");
        store.update(newCandidate);
        Candidate candidateInDb = store.findById(candidate.getId());
        assertThat(candidateInDb.getName(), is("Sergey"));
    }
}