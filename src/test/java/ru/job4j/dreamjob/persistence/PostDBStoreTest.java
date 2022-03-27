package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.model.Post;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 27/03/2022 - 18:29
 */
class PostDBStoreTest {

    @BeforeEach
    void tableCleanup() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        store.clearTable();
    }

    @Test
    void whenCreatePostAndThenFoundByID() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post("Java Job");
        store.create(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    void whenAddPost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post(1, "Java Job");
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post("Java Job");
        store.add(post);
        Post newPOst = new Post(post.getId(), "Java Dream Job");
        store.update(newPOst);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is("Java Dream Job"));
    }
}