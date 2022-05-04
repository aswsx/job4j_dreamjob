package ru.job4j.dreamjob.controller;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import ru.job4j.dreamjob.control.PostController;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.service.CityService;
import ru.job4j.dreamjob.service.PostService;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 04/04/2022 - 22:49
 */
class PostControllerTest {

    @Test
    void whenAddPost() {
        HttpSession session = mock(HttpSession.class);
        Model model = mock(Model.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);

        List<Post> posts = Arrays.asList(
                new Post(1, "New post"),
                new Post(2, "New post")
        );

        when(postService.findAll()).thenReturn(posts);
        PostController postController = new PostController(
                postService,
                cityService
        );
        String page = postController.posts(model, session);

        verify(model).addAttribute("posts", posts);
        assertThat(page, is("post/posts"));
    }

    @Test
    void whenUpdatePost() {
        HttpSession session = mock(HttpSession.class);
        Model model = mock(Model.class);
        PostService postService = mock(PostService.class);
        CityService cityService = mock(CityService.class);

        Post post = new Post(1, "New post");
        Post modPost = new Post(1, "Modified post");

        when(postService.findById(1)).thenReturn(modPost);
        PostController postController = new PostController(
                postService,
                cityService
        );
        String page = postController.formUpdatePost(model, 1, session);

        verify(model).addAttribute("post", modPost);
        assertThat(page, is("post/updatePost"));
    }
}
