package ru.job4j.dreamjob.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dreamjob.model.Post;
import ru.job4j.dreamjob.service.PostService;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 11:44
 */
@Controller
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public String posts(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "posts";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model) {
        return "addPost";
    }

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id) {
        model.addAttribute("post", postService.findById(id));
        return "updatePost";
    }

    @GetMapping("/addPost")
    public String addPost(Model model) {
        model.addAttribute("post", new Post(0, "Заполните поле"));
        return "addPost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post) {
        postService.update(post);
        return "redirect:/posts";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Post post) {
        postService.create(post);
        return "redirect:/posts";
    }

    @PostMapping("/savePost")
    public String savePost(@ModelAttribute Post post) {
        postService.add(post);
        return "redirect:/posts";
    }
}