package ru.job4j.dreamjob.service;

import ru.job4j.dreamjob.model.Candidate;
import ru.job4j.dreamjob.persistence.CandidateStore;

import java.util.Collection;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 19/03/2022 - 23:50
 */
public class CandidateService {
    private static final CandidateService INST = new CandidateService();

    private final CandidateStore candidateStore;

    public CandidateService() {
        this.candidateStore = CandidateStore.instOf();
    }

    public static CandidateService instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidateStore.findAll();
    }

    public void add(Candidate candidate) {
        candidateStore.add(candidate);
    }

    public Candidate findById(int id) {
        return candidateStore.findById(id);
    }

    public void update(Candidate candidate) {
        candidateStore.update(candidate);
    }

    public void create(Candidate candidate) {
        candidateStore.create(candidate);
    }
}
