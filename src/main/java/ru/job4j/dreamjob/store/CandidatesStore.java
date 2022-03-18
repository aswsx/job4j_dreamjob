package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alex Gutorov
 * @version 1.4
 * @created 16/03/2022 - 21:43
 */
public class CandidatesStore {
    private static final AtomicInteger ID = new AtomicInteger();
    private static final CandidatesStore INST = new CandidatesStore(ID);

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidatesStore(AtomicInteger id) {
        candidates.put(1, new Candidate(1, "Michael", "Junior"));
        candidates.put(2, new Candidate(2, "Bob", "Middle"));
        candidates.put(3, new Candidate(3, "Nick", "Senior"));
    }

    public static CandidatesStore instOf() {
        return INST;
    }

    public Collection<Candidate> findAll() {
        return candidates.values();
    }

    public void add(Candidate candidate) {
        candidates.put(candidate.getId(), candidate);
    }

    public Candidate findById(int id) {
        return candidates.get(id);
    }

    public void update(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public void create(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }
}
