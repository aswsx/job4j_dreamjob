package ru.job4j.dreamjob.service;

import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.persistence.PostStore;

import java.util.Collection;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 19/03/2022 - 23:49
 */
public class PostService {
    private static final PostService INST = new PostService();

    private final PostStore postStore;

    public PostService() {
        this.postStore = PostStore.instOf();
    }

    public static PostService instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return postStore.findAll();
    }

    public void add(Post post) {
        postStore.add(post);
    }

    public Post findById(int id) {
        return postStore.findById(id);
    }

    public void update(Post post) {
        postStore.update(post);
    }

    public void create(Post post) {
        postStore.create(post);
    }
}
