package ru.job4j.dreamjob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.store.PostStore;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 11:44
 */
@Controller
public class PostController {
    private final PostStore store = PostStore.instOf();

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", store.findAll());
        return "posts";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post(0, "Заполните поле"));
        return "addPost";
    }
}
