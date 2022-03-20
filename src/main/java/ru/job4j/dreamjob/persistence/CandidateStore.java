package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
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
@ThreadSafe
@Repository
public class CandidateStore {
    private static final AtomicInteger ID = new AtomicInteger();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private CandidateStore() {
        candidates.put(1, new Candidate(1, "Michael", "Junior"));
        candidates.put(2, new Candidate(2, "Bob", "Middle"));
        candidates.put(3, new Candidate(3, "Nick", "Senior"));
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
        candidate.setId(ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }
}
