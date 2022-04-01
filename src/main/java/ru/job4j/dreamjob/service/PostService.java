package ru.job4j.dreamjob.service;

import org.springframework.stereotype.Service;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.persistence.PostDBStore;

import java.util.Collection;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 19/03/2022 - 23:49
 */
@Service
public class PostService {

    private final PostDBStore postDBStore;

    public PostService(PostDBStore postDBStore) {
        this.postDBStore = postDBStore;
    }

    public void add(Post post) {
        postDBStore.add(post);
    }

    public void update(Post post) {
        postDBStore.update(post);
    }

    public Collection<Post> findAll() {
        return postDBStore.findAll();
    }

    public Post findById(int id) {
        return postDBStore.findById(id);
    }
}
