package ru.job4j.dreamjob.store;

import ru.job4j.dreamjob.model.Candidate;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 21:43
 */
public class CandidatesStore {
    private static final CandidatesStore INST = new CandidatesStore();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidatesStore() {
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
}
