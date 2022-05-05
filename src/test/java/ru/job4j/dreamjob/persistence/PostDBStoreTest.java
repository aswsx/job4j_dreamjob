package ru.job4j.dreamjob.persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.job4j.dreamjob.Main;
import ru.job4j.dreamjob.models.City;
import ru.job4j.dreamjob.models.Post;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 27/03/2022 - 18:29
 */
class PostDBStoreTest {

    @AfterEach
    void tableCleanup() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        store.clearTable();
    }

    @Test
    void whenAddPostAndThenFoundByID() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post("name", "desc", new City(1, "Москва"), null);
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertEquals(postInDb.getName(), (post.getName()));
    }

    @Test
    void whenAddPost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post("name", "desc", new City(1, "Москва"), null);
        store.add(post);
        Post postInDb = store.findById(post.getId());
        assertEquals(postInDb.getName(), (post.getName()));
    }

    @Test
    void whenUpdatePost() {
        PostDBStore store = new PostDBStore(new Main().loadPool());
        Post post = new Post("Dream Job", "desc", new City(1, "Москва"), null);
        store.add(post);
        Post newPOst = new Post(post.getId(), "Java Dream Job");
        store.update(newPOst);
        Post postInDb = store.findById(post.getId());
        assertEquals(postInDb.getName(), ("Java Dream Job"));
    }
}