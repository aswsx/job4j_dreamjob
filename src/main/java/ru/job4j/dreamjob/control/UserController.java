package ru.job4j.dreamjob.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.dreamjob.model.User;
import ru.job4j.dreamjob.service.UserService;

import java.util.Optional;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 28/03/2022 - 9:40
 */
@ThreadSafe
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/formAddUser")
    public String formAddUser(Model model, @RequestParam(name = "fail", required = false) Boolean fail) {
        model.addAttribute("fail", fail != null);
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute User user) {
        Optional<User> regUser = userService.addUser(user);
        if (regUser.isEmpty()) {
            model.addAttribute("message", "Пользователь с такой почтой уже существует");
            return "redirect:/formAddUser?fail=true";
        }
        return "redirect:/success";
    }

    @GetMapping("/formUpdateUser")
    public String formUpdateUser(Model model) {
        return "updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(Model model, @ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(Model model) {
        return "success";
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail) {
        model.addAttribute("fail", fail != null);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        Optional<User> userDb = userService.findUserByEmailAndPwd(
                user.getEmail(), user.getPassword()
        );
        if (userDb.isEmpty()) {
            return "redirect:/loginPage?fail=true";
        }
        return "redirect:/index";
    }
}
