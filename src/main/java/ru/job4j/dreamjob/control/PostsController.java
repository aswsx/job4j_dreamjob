package ru.job4j.dreamjob.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.dreamjob.models.Post;
import ru.job4j.dreamjob.models.User;
import ru.job4j.dreamjob.service.CityService;
import ru.job4j.dreamjob.service.PostService;

import javax.servlet.http.HttpSession;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 16/03/2022 - 11:44
 */
@ThreadSafe
@Controller
public class PostsController {
    private static final String REDIRECT = "redirect:/posts";
    private static final String GUEST = "Гость";
    private final PostService postService;
    private final CityService cityService;

    public PostsController(PostService postService, CityService cityService) {
        this.postService = postService;
        this.cityService = cityService;
    }

    @GetMapping("/posts")
    public String posts(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        model.addAttribute("posts", postService.findAll());
        return "post/posts";
    }

    @GetMapping("/formAddPost")
    public String formAddPost(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        model.addAttribute("cities", cityService.getAllCities());
        return "post/addPost";
    }

    @PostMapping("/addPost")
    public String addPost(@ModelAttribute Post post) {
        postService.add(post);
        return REDIRECT;
    }

    @GetMapping("/formUpdatePost/{postId}")
    public String formUpdatePost(Model model, @PathVariable("postId") int id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        model.addAttribute("post", postService.findById(id));
        return "post/updatePost";
    }

    @PostMapping("/updatePost")
    public String updatePost(@ModelAttribute Post post) {
        postService.update(post);
        return REDIRECT;
    }
}
