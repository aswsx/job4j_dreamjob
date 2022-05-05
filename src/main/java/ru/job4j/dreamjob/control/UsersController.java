package ru.job4j.dreamjob.control;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.dreamjob.models.User;
import ru.job4j.dreamjob.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * @author Alex Gutorov
 * @version 1.0
 * @created 28/03/2022 - 9:40
 */
@ThreadSafe
@Controller
public class UsersController {
    private final UserService userService;
    private static final String GUEST = "Гость";

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/formAddUser")
    public String formAddUser(Model model, @RequestParam(name = "fail", required = false) Boolean fail,
                              HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        model.addAttribute("fail", fail != null);
        return "user/addUser";
    }

    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute User user) {
        Optional<User> regUser = userService.addUser(user);
        if (regUser.isEmpty()) {
            model.addAttribute("message", "Пользователь с такой почтой уже существует");
            return "redirect:/formAddUser?fail=true";
        }
        return "redirect:/user/success";
    }

    @GetMapping("/formUpdateUser")
    public String formUpdateUser(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        return "user/updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(Model model, @ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String success(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        return "user/success";
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail,
                            HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setName(GUEST);
        }
        model.addAttribute("user", user);
        model.addAttribute("fail", fail != null);
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletRequest request) {
        Optional<User> userDb = userService.findUserByEmailAndPwd(
                user.getEmail(), user.getPassword()
        );
        if (userDb.isEmpty()) {
            return "redirect:/loginPage?fail=true";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", userDb.get());
        return "redirect:/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index";
    }
}
