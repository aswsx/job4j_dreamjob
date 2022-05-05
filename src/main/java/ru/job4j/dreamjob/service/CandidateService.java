package ru.job4j.dreamjob.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.models.Candidate;
import ru.job4j.dreamjob.persistence.CandidateDBStore;

import java.util.Collection;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 19/03/2022 - 23:50
 */
@ThreadSafe
@Service
public class CandidateService {

    private final CandidateDBStore candidateDBStore;

    public CandidateService(CandidateDBStore candidateDBStore) {
        this.candidateDBStore = candidateDBStore;
    }

    public void add(Candidate candidate) {
        candidateDBStore.add(candidate);
    }

    public void update(Candidate candidate) {
        candidateDBStore.update(candidate);
    }

    public Collection<Candidate> findAll() {
        return candidateDBStore.findAll();
    }

    public Candidate findById(int id) {
        return candidateDBStore.findById(id);
    }
}
