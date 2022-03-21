package ru.job4j.dreamjob.persistence;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Repository;
import ru.job4j.dreamjob.model.Post;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Alex Gutorov
 * @version 1.4
 * @created 16/03/2022 - 11:41
 */
@ThreadSafe
@Repository
public class PostStore {
    private static final AtomicInteger ID = new AtomicInteger();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private PostStore() {
        posts.put(1, new Post(1, "Junior Java Job", "Junior"));
        posts.put(2, new Post(2, "Middle Java Job", "Middle"));
        posts.put(3, new Post(3, "Senior Java Job", "Senior"));
    }

    public Collection<Post> findAll() {
        return posts.values();
    }

    public void add(Post post) {
        posts.put(post.getId(), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void update(Post post) {
        posts.put(post.getId(), post);
    }

    public void create(Post post) {
        post.setId(ID.incrementAndGet());
        posts.put(post.getId(), post);
    }
}
